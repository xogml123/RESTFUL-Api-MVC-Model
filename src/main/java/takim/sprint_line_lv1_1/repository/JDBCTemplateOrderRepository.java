package takim.sprint_line_lv1_1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import takim.sprint_line_lv1_1.domain.Order;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JDBCTemplateOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCTemplateOrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Order save(Order order) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("orders").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", order.getName());
        parameters.put("order_content_index", order.getOrderContentIndex());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        order.setId(key.longValue());
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jdbcTemplate.query("select * from orders where id=?", orderRowMapper(), id).stream().findAny();
    }

    @Override
    public Optional<Order> findByName(String name) {
        return jdbcTemplate.query("select * from orders where name=?", orderRowMapper(), name).stream().findAny();

    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query("select * from orders", orderRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from orders where id=?", id);
    }

    @Override
    public void updateOrderContentIndexById(Long id, int orderContentIndex) {
        jdbcTemplate.update("update orders set order_content_index=? where id=?", orderContentIndex, id);
    }

    private RowMapper<Order> orderRowMapper() {
        return (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setName(rs.getString("name"));
            order.setOrderContentIndex(rs.getInt("order_content_index"));
            return order;
        }; }
}

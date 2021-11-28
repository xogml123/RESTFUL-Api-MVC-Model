package takim.sprint_line_lv1_1.domain;

public class Order {
    private long id;
    private String name;
    private int orderContentIndex;

    public Order() {

    }

    public Order(long id, String name, int orderContentIndex) {
        this.id = id;
        this.name = name;
        this.orderContentIndex = orderContentIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderContentIndex() {
        return orderContentIndex;
    }

    public void setOrderContentIndex(int orderContentIndex) {
        this.orderContentIndex = orderContentIndex;
    }
}

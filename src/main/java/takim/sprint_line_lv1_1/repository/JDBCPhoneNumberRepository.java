package takim.sprint_line_lv1_1.repository;

import takim.sprint_line_lv1_1.domain.PhoneNumber;

import java.util.List;
import java.util.Optional;

public class JDBCPhoneNumberRepository implements PhoneNumberRepository {

    @Override
    public PhoneNumber save(PhoneNumber order) {
        return null;
    }

    @Override
    public Optional<PhoneNumber> findById(Long Id) {
        return Optional.empty();
    }

    @Override
    public Optional<PhoneNumber> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<PhoneNumber> findAll() {
        return null;
    }
}

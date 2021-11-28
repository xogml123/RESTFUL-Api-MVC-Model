package takim.sprint_line_lv1_1.repository;

import takim.sprint_line_lv1_1.domain.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PhoneNumberRepository {
    PhoneNumber save(PhoneNumber order);
    Optional<PhoneNumber> findById(Long Id);
    Optional<PhoneNumber> findByName(String name);
    List<PhoneNumber> findAll();
}

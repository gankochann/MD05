package ra.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.com.model.entity.Bus;

public interface Ibus extends JpaRepository<Bus, Integer> {
    boolean existsByBusName(String busName);
    boolean existsByRegistrationNumber(String registrationNumber);
}

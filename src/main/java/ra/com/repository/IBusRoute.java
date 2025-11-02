package ra.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.com.model.entity.BusRoute;

public interface IBusRoute extends JpaRepository<BusRoute,Integer> {
}

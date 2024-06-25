package OnlineBookStore.OnlineBookStore.Repository;

import OnlineBookStore.OnlineBookStore.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Long> {
}

package OnlineBookStore.OnlineBookStore.Repository;

import OnlineBookStore.OnlineBookStore.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart,Long> {
}

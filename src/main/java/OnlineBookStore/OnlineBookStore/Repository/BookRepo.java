package OnlineBookStore.OnlineBookStore.Repository;

import OnlineBookStore.OnlineBookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}

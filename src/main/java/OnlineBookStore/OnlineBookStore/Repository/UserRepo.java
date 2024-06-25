package OnlineBookStore.OnlineBookStore.Repository;

import OnlineBookStore.OnlineBookStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail (String email);
    User findByUserName(String username);
    User findByFirstName(String firstname);

    @Query("Select u from User u where u.email=?1")
    User getUserByEmail(String email);

    @Query("Select u from User u where u.firstName=?1")
    public User getUserByFirstName(String firstname);

    @Query("Select u from User u where u.user_id=?1")
    public User getUserByUserId(Long id);

    @Query("Select u from User u where u.user_id=?1 And userName=?2")
    public User getUserByUserId(Long id,String username);

}

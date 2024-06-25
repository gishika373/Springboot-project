package OnlineBookStore.OnlineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table   //(name="user-data") this is how we change the name of table for database.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    @Column(name="firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
//    private ShoppingCart shoppingCart;
//
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
//    private Set<Orders> orders = new HashSet<>();

}

//2)User:
//        -> (One-to-One) relationship with 'ShoppingCart' (one user has one shopping cart).
//        -> (One-to-Many) relationship with 'Order' (one user can place many orders).

package OnlineBookStore.OnlineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    @UpdateTimestamp
    private Date date;
    @Column(name = "expected_delivery")
    private Date expectedDelivery;
    @Column(name = "payment_type")
    private String paymentType;

//    @ManyToOne
//    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
//    private User user;

}

//5)Order:
//        -> (Many-to-One) relationship with 'User' (many orders can belong to one user).
//        -> (One-to-Many) relationship with 'CartItem' (one order can contain many cart items).
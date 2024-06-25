package OnlineBookStore.OnlineBookStore.Entity;

import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.BookServiceImplementor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ShoppingCart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long cart_id;
//    @Column
//    private Long total_price;
//    @Column
//    private int quantity;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id" , referencedColumnName = "user_id")
//    private User user;
//
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Book> books = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;
    @Column
    private Long total_price;
    @Column
    private int quantity;

    @OneToMany
    @JoinTable(name = "shoppingCart_books", joinColumns = @JoinColumn(name = "shoppingCart_id"),inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    public Set<Book> allBooks(){
        return books;
    }


}

//3)ShoppingCart:
//        -> (One-to-One) relationship with 'User' (one shopping cart belongs to one user).
//        -> (One-to-Many) relationship with 'CartItem' (one shopping cart can contain many cart items).

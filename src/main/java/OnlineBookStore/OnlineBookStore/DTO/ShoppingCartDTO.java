package OnlineBookStore.OnlineBookStore.DTO;


import OnlineBookStore.OnlineBookStore.Entity.Book;
import OnlineBookStore.OnlineBookStore.Entity.User;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ShoppingCartDTO {
    private Long cart_id;
    private Long total_price;
    private int quantity;
    private Set<Book> books = new HashSet<>();

//    public void addBook(Book book){
//        books.add(book);
//    }
//    public void removeBook(Book book){
//        books.remove(book);
//    }
//    public Set<Book> allBooks(){
//        return books;
//    }
}

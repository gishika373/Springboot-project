package OnlineBookStore.OnlineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private Long price;
    @Column
    private String genre;
    @Column
    private String book_url;
    @Column
    private String rating;


}

//Book is an independent entity and it will not contain the reference of any entity.


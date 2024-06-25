package OnlineBookStore.OnlineBookStore.DTO;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookDTO {
    private Long book_id;
    private String title;
    private String author;
    private Long price;
    private String genre;
    private String book_url;
    private String rating;

}

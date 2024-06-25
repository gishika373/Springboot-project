package OnlineBookStore.OnlineBookStore.Controller;

import OnlineBookStore.OnlineBookStore.DTO.BookDTO;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.BookServiceImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImplementor bookServiceImplementor;

    @GetMapping("/get-books")
    public List<BookDTO> getAllBooks(){
        return bookServiceImplementor.getAllBooks();
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        BookDTO bookDTO = bookServiceImplementor.getBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    @PostMapping("/add-book")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO){
        BookDTO bookDTO1 =  bookServiceImplementor.addBook(bookDTO);
        return new ResponseEntity<>(bookDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/update-book/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO,@PathVariable Long id){
        BookDTO bookDTO11 =  bookServiceImplementor.updateBook(bookDTO,id);
        return ResponseEntity.ok(bookDTO11);
    }

    @DeleteMapping("/delete-book")
    public BookDTO deleteBook(@RequestBody BookDTO bookDTO){
        return bookServiceImplementor.deteteBook(bookDTO);
    }

    @DeleteMapping("/delete-all-books")
    public BookDTO deleteAllBooks(){
        return bookServiceImplementor.deteteAllBooks();
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookServiceImplementor.deteteBookById(id);
        return ResponseEntity.ok("Deleted");
    }
}

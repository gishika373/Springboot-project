package OnlineBookStore.OnlineBookStore.Service.ServiceInterface;


import OnlineBookStore.OnlineBookStore.DTO.BookDTO;
import OnlineBookStore.OnlineBookStore.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO addBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO,Long id);
    BookDTO deteteBook(BookDTO bookDTO);
    BookDTO deteteAllBooks();
    BookDTO deteteBookById(Long id);
}


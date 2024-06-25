package OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl;

import OnlineBookStore.OnlineBookStore.DTO.BookDTO;
import OnlineBookStore.OnlineBookStore.Entity.Book;
import OnlineBookStore.OnlineBookStore.ExceptionHandler.ResourceNotFoundException;
import OnlineBookStore.OnlineBookStore.Mapper.BookMapper;
import OnlineBookStore.OnlineBookStore.Repository.BookRepo;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterface.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImplementor implements BookServiceInterface {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return books.stream().map((book)->bookMapper.bookToBookDto(book)).collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book1 = bookRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with the given id "+id));
        return bookMapper.bookToBookDto(book1);
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDtoToBook(bookDTO);
        bookRepo.save(book);
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long id) {
        Book book = bookRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with the given id "+id));
        book.setBook_id(bookDTO.getBook_id());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setGenre(bookDTO.getGenre());
        book.setBook_url(bookDTO.getBook_url());
        book.setRating(bookDTO.getRating());
        bookRepo.save(book);
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public BookDTO deteteBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDtoToBook(bookDTO);
        bookRepo.delete(book);
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public BookDTO deteteAllBooks() {
        bookRepo.deleteAll();
        return null;
    }

    @Override
    public BookDTO deteteBookById(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with the given id "+id));
        bookRepo.delete(book);
        return bookMapper.bookToBookDto(book);
    }
}

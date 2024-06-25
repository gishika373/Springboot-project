package OnlineBookStore.OnlineBookStore.Mapper;

import OnlineBookStore.OnlineBookStore.DTO.BookDTO;
import OnlineBookStore.OnlineBookStore.Entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BookDTO bookToBookDto(Book book){
        BookDTO bookDTO = modelMapper.map(book,BookDTO.class);
        return bookDTO;
    }

    public Book bookDtoToBook(BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO,Book.class);
        return book;
    }

}

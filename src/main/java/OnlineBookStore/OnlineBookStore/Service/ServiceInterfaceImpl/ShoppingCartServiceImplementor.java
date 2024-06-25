package OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl;

import OnlineBookStore.OnlineBookStore.DTO.ShoppingCartDTO;
import OnlineBookStore.OnlineBookStore.Entity.Book;
import OnlineBookStore.OnlineBookStore.Entity.ShoppingCart;
import OnlineBookStore.OnlineBookStore.ExceptionHandler.ResourceNotFoundException;
import OnlineBookStore.OnlineBookStore.Mapper.ShoppingCartMapper;
import OnlineBookStore.OnlineBookStore.Repository.BookRepo;
import OnlineBookStore.OnlineBookStore.Repository.ShoppingCartRepo;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterface.ShoppingCartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShoppingCartServiceImplementor implements ShoppingCartServiceInterface {
    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    //--------------------------------------------------------------------------------------------

    @Autowired
    private BookRepo bookRepo;

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepo.save(shoppingCart);
    }

    public Optional<ShoppingCart> getShoppingCartById(Long id){
        return shoppingCartRepo.findById(id);
    }

    public void addBookToCart(Long shoppingCartId , Long bookId){
        ShoppingCart shoppingCart = shoppingCartRepo.findById(shoppingCartId).orElseThrow(()-> new RuntimeException("ShoppingCart not found"));
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
        shoppingCart.addBook(book);
        shoppingCartRepo.save(shoppingCart);
    }

    public void removeBookFromCart(Long shoppingCartId,Long bookId){
        ShoppingCart shoppingCart = shoppingCartRepo.findById(shoppingCartId).orElseThrow(()-> new RuntimeException("ShoppingCart not found"));
        Book book = bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
        shoppingCart.removeBook(book);
        shoppingCartRepo.save(shoppingCart);
    }

    public ShoppingCart updateShoppingCart(Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepo.findById(shoppingCartId).orElseThrow(() -> new ResourceNotFoundException("Shopping Cart not Found"));
        Long sum = 0L;
        for(Book b : shoppingCart.allBooks()){
            sum = sum + b.getPrice();
        }
        shoppingCart.setTotal_price(sum);
        shoppingCartRepo.save(shoppingCart);
        return shoppingCart;
    }

    //----------------------------------------------------------------------------------------------------------

//    @Override
//    public List<ShoppingCartDTO> getAllItems() {
//        List<ShoppingCart> items = shoppingCartRepo.findAll();
//        return items.stream().map((item)->shoppingCartMapper.shoppingToShoppingDTO(item)).collect(Collectors.toList());
//    }
//
//    @Override
//    public ShoppingCartDTO getItemById(Long id) {
//        ShoppingCart item = shoppingCartRepo.findById(id).orElseThrow(()->
//                new ResourceNotFoundException("Item does not exist for given id "+ id));
//        return shoppingCartMapper.shoppingToShoppingDTO(item);
//    }
//
//    @Override
//    public ShoppingCartDTO addToCart(ShoppingCartDTO shoppingCartDTO) {
//
//        ShoppingCart item = shoppingCartMapper.shoppingDtoToShopping(shoppingCartDTO);
//        shoppingCartRepo.save(item);
//        return shoppingCartMapper.shoppingToShoppingDTO(item);
//    }
//
//    @Override
//    public ShoppingCartDTO updateCart(ShoppingCartDTO shoppingCartDTO, Long id) {
//        ShoppingCart item = shoppingCartRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Item does not exist for given id "+ id));
////        item.setCart_id(shoppingCartDTO.getCart_id());
//        item.setQuantity(shoppingCartDTO.getQuantity());
//        item.setTotal_price(shoppingCartDTO.getTotal_price());
//        shoppingCartRepo.save(item);
//        return shoppingCartMapper.shoppingToShoppingDTO(item);
//    }
//
//    @Override
//    public ShoppingCartDTO deteteItem(ShoppingCartDTO shoppingDTO) {
//        ShoppingCart item = shoppingCartMapper.shoppingDtoToShopping(shoppingDTO);
//        shoppingCartRepo.delete(item);
//        return shoppingCartMapper.shoppingToShoppingDTO(item);
//    }
//
//    @Override
//    public ShoppingCartDTO deteteAllItems() {
//        shoppingCartRepo.deleteAll();
//        return null;
//    }
//
//    @Override
//    public ShoppingCartDTO deteteItemById(Long id) {
//        ShoppingCart item = shoppingCartRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Item does not exist for given id "+id));
//        shoppingCartRepo.delete(item);
//        return shoppingCartMapper.shoppingToShoppingDTO(item);
//    }
}

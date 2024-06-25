package OnlineBookStore.OnlineBookStore.Service.ServiceInterface;

import OnlineBookStore.OnlineBookStore.DTO.ShoppingCartDTO;
import OnlineBookStore.OnlineBookStore.Entity.Book;
import OnlineBookStore.OnlineBookStore.Entity.ShoppingCart;
import OnlineBookStore.OnlineBookStore.ExceptionHandler.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartServiceInterface {

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);
    Optional<ShoppingCart> getShoppingCartById(Long id);
    void addBookToCart(Long shoppingCartId , Long bookId);
    void removeBookFromCart(Long shoppingCartId,Long bookId);
    ShoppingCart updateShoppingCart(Long shoppingCartId) ;

//    List<ShoppingCartDTO> getAllItems();
//    ShoppingCartDTO getItemById(Long id);
//    ShoppingCartDTO addToCart(ShoppingCartDTO shoppingCartDTO);
//    ShoppingCartDTO updateCart(ShoppingCartDTO shoppingCartDTO, Long id);
//    ShoppingCartDTO deteteItem(ShoppingCartDTO shoppingCartDTO);
//    ShoppingCartDTO deteteAllItems();
//    ShoppingCartDTO deteteItemById(Long id);
}

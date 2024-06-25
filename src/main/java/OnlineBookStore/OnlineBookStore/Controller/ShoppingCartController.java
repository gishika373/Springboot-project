package OnlineBookStore.OnlineBookStore.Controller;

import OnlineBookStore.OnlineBookStore.DTO.ShoppingCartDTO;
import OnlineBookStore.OnlineBookStore.Entity.ShoppingCart;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.ShoppingCartServiceImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImplementor shoppingCartServiceImplementor;

    @PostMapping("/create-shoppingCart")
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        ShoppingCart createdShoppingCart =  shoppingCartServiceImplementor.createShoppingCart(shoppingCart);
        return ResponseEntity.ok(createdShoppingCart);
    }

    @GetMapping("/get-shoppingCart/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id){
        Optional<ShoppingCart> shoppingCart = shoppingCartServiceImplementor.getShoppingCartById(id);
        shoppingCartServiceImplementor.updateShoppingCart(id);
        return shoppingCart.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-bookToCart/{shoppingCartId}/books/{bookId}")
    public ResponseEntity<Void> addBookToCart(@PathVariable Long shoppingCartId , @PathVariable Long bookId){
        shoppingCartServiceImplementor.addBookToCart(shoppingCartId,bookId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-bookFromCart/{shoppingCartId}/books/{bookId}")
    public ResponseEntity<Void> removeBookFromCart(@PathVariable Long shoppingCartId , @PathVariable Long bookId){
        shoppingCartServiceImplementor.removeBookFromCart(shoppingCartId,bookId);
        return ResponseEntity.ok().build();
    }


//    @GetMapping("/get-cartItems")
//    public List<ShoppingCartDTO> getAllItems(){
//        return shoppingCartServiceImplementor.getAllItems();
//    }
//
//    @GetMapping("/get-cartItem-by-id/{id}")
//    public ResponseEntity<ShoppingCartDTO> getItemById(@PathVariable Long id){
//        ShoppingCartDTO item = shoppingCartServiceImplementor.getItemById(id);
//        return ResponseEntity.ok(item);
//    }
//
//    @PostMapping("/add-to-cart")
//    public ResponseEntity<ShoppingCartDTO> addToCart(@RequestBody ShoppingCartDTO shoppingDTO){
//        ShoppingCartDTO shoppingDTO1 =  shoppingCartServiceImplementor.addToCart(shoppingDTO);
//        return new ResponseEntity<>(shoppingDTO1, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update-cart/{id}")
//    public ResponseEntity<ShoppingCartDTO> updateItem(@RequestBody ShoppingCartDTO shoppingDTO, @PathVariable Long id){
//        ShoppingCartDTO shoppingDTO1 =  shoppingCartServiceImplementor.updateCart(shoppingDTO,id);
//        return ResponseEntity.ok(shoppingDTO1);
//    }
//
//    @DeleteMapping("/delete-cartItem")
//    public ShoppingCartDTO deleteBook(@RequestBody ShoppingCartDTO shoppingDTO){
//        return shoppingCartServiceImplementor.deteteItem(shoppingDTO);
//    }
//
//    @DeleteMapping("/delete-all-items")
//    public ShoppingCartDTO deleteAllItems(){
//        return shoppingCartServiceImplementor.deteteAllItems();
//    }
//
//    @DeleteMapping("/delete-item-by-id/{id}")
//    public ResponseEntity<String> deleteItemById(@PathVariable Long id){
//        shoppingCartServiceImplementor.deteteItemById(id);
//        return ResponseEntity.ok("Deleted");
//    }


}

package OnlineBookStore.OnlineBookStore.Controller;

import OnlineBookStore.OnlineBookStore.DTO.OrderDTO;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.OrderServiceImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImplementor orderServiceImplementor;

    @GetMapping("/get-orders")
    public List<OrderDTO> getAllOrders(){
        return orderServiceImplementor.getAllOrders();
    }

    @GetMapping("/get-order-by-id/{id}")
    public ResponseEntity<OrderDTO> getBookById(@PathVariable Long id){
        OrderDTO orderDTO = orderServiceImplementor.getOrderById(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping("/place-order")
    public ResponseEntity<OrderDTO> addBook(@RequestBody OrderDTO orderDTO){
        OrderDTO orderDTO1 =  orderServiceImplementor.placeOrder(orderDTO);
        return new ResponseEntity<>(orderDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/update-order/{id}")
    public ResponseEntity<OrderDTO> updateBook(@RequestBody OrderDTO orderDTO,@PathVariable Long id){
        OrderDTO orderDTO1 =  orderServiceImplementor.updateOrder(orderDTO,id);
        return ResponseEntity.ok(orderDTO1);
    }

    @DeleteMapping("/delete-order")
    public OrderDTO deleteBook(@RequestBody OrderDTO orderDTO){
        return orderServiceImplementor.deteteOrder(orderDTO);
    }

    @DeleteMapping("/delete-all-orders")
    public OrderDTO deleteAllBooks(){
        return orderServiceImplementor.deteteAllOrders();
    }

    @DeleteMapping("/delete-order-by-id/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id){
        orderServiceImplementor.deteteOrderById(id);
        return ResponseEntity.ok("Deleted");
    }
}

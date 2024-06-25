package OnlineBookStore.OnlineBookStore.Service.ServiceInterface;

import OnlineBookStore.OnlineBookStore.DTO.OrderDTO;

import java.util.List;

public interface OrderServiceInterface {

    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    OrderDTO placeOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO orderDTO, Long id);
    OrderDTO deteteOrder(OrderDTO orderDTO);
    OrderDTO deteteAllOrders();
    OrderDTO deteteOrderById(Long id);
}

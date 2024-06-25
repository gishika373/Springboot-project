package OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl;

import OnlineBookStore.OnlineBookStore.DTO.OrderDTO;
import OnlineBookStore.OnlineBookStore.Entity.Orders;
import OnlineBookStore.OnlineBookStore.ExceptionHandler.ResourceNotFoundException;
import OnlineBookStore.OnlineBookStore.Mapper.OrderMapper;
import OnlineBookStore.OnlineBookStore.Repository.OrderRepo;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterface.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImplementor implements OrderServiceInterface {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderRepo orderRepo;


    @Override
    public List<OrderDTO> getAllOrders() {
        List<Orders> orders = orderRepo.findAll();
        return orders.stream().map((order)->orderMapper.orderToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Orders order = orderRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Order does not exist for given id "+ id));
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Orders order = orderMapper.orderDtoToOrder(orderDTO);
        orderRepo.save(order);
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, Long id) {
        Orders order = orderRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order does not exist for given id "+ id));
        order.setOrderId(orderDTO.getOrderId());
        order.setDate(orderDTO.getDate());
        order.setExpectedDelivery(orderDTO.getExpectedDelivery());
        order.setPaymentType(orderDTO.getPaymentType());
        orderRepo.save(order);
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDTO deteteOrder(OrderDTO orderDTO) {
        Orders order = orderMapper.orderDtoToOrder(orderDTO);
        orderRepo.delete(order);
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public OrderDTO deteteAllOrders() {
        orderRepo.deleteAll();
        return null;
    }

    @Override
    public OrderDTO deteteOrderById(Long id) {
        Orders order = orderRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order does not exist for given id "+id));
        orderRepo.delete(order);
        return orderMapper.orderToOrderDto(order);
    }
}

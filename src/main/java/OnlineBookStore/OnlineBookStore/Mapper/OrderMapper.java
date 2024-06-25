package OnlineBookStore.OnlineBookStore.Mapper;

import OnlineBookStore.OnlineBookStore.DTO.OrderDTO;
import OnlineBookStore.OnlineBookStore.Entity.Orders;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO orderToOrderDto(Orders order){
        OrderDTO orderDTO = modelMapper.map(order,OrderDTO.class);
        return orderDTO;
    }
    public Orders orderDtoToOrder(OrderDTO orderDTO){
        Orders order = modelMapper.map(orderDTO, Orders.class);
        return order;
    }
}

package OnlineBookStore.OnlineBookStore.Mapper;

import OnlineBookStore.OnlineBookStore.DTO.ShoppingCartDTO;
import OnlineBookStore.OnlineBookStore.Entity.ShoppingCart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCartDTO shoppingToShoppingDTO(ShoppingCart shoppingCart){
        ShoppingCartDTO shoppingCartDTO = modelMapper.map(shoppingCart, ShoppingCartDTO.class);
        return shoppingCartDTO;
    }
    public ShoppingCart shoppingDtoToShopping(ShoppingCartDTO shoppingCartDTO){
        ShoppingCart shoppingCart = modelMapper.map(shoppingCartDTO,ShoppingCart.class);
        return shoppingCart;
    }
}

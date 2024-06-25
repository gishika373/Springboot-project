package OnlineBookStore.OnlineBookStore.Configurations;

import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfigs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UserServiceImplementor userServiceImplementor(){
        return new UserServiceImplementor();
    }

    @Bean
    public BookServiceImplementor bookServiceImplementor(){
        return new BookServiceImplementor();
    }

    @Bean
    public ShoppingCartServiceImplementor shoppingServiceImplementor(){
        return new ShoppingCartServiceImplementor();
    }

    @Bean
    public OrderServiceImplementor orderServiceImplementor(){
        return new OrderServiceImplementor();
    }

}

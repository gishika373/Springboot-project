package OnlineBookStore.OnlineBookStore.Mapper;

import OnlineBookStore.OnlineBookStore.DTO.UserDTO;
import OnlineBookStore.OnlineBookStore.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User userDtoToUser(UserDTO userDTO){
        //modelMapper.map(takenObject , return type class) this convert the object to the other class bytes stream.
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
    public UserDTO userToUserDto(User user){
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return  userDTO;
    }


}

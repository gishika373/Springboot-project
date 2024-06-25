package OnlineBookStore.OnlineBookStore.Service.ServiceInterface;

import OnlineBookStore.OnlineBookStore.DTO.UserDTO;

import java.util.List;

public interface UserServiceInterface {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO,Long id);
    UserDTO deteteUser(UserDTO userDTO);
    UserDTO deteteAllUsers();
    UserDTO deteteUserById(Long id);
}

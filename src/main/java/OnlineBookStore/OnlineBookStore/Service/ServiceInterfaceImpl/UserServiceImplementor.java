package OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl;

import OnlineBookStore.OnlineBookStore.DTO.UserDTO;
import OnlineBookStore.OnlineBookStore.Entity.User;
import OnlineBookStore.OnlineBookStore.ExceptionHandler.ResourceNotFoundException;
import OnlineBookStore.OnlineBookStore.Mapper.UserMapper;
import OnlineBookStore.OnlineBookStore.Repository.UserRepo;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImplementor implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map((user)->userMapper.userToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user1 = userRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User does not exist for given id "+ id));
        return userMapper.userToUserDto(user1);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        userRepo.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        User user1 = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exist for given id "+ id));
//        user1.setUser_id(userDTO.getUser_id());
        user1.setFirstName(userDTO.getFirstName());
        user1.setLastName(userDTO.getLastName());
        user1.setEmail(userDTO.getEmail());
        user1.setUserName(userDTO.getUserName());
        user1.setPassword(userDTO.getPassword());
        userRepo.save(user1);
        return userMapper.userToUserDto(user1);
    }

    @Override
    public UserDTO deteteUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        userRepo.delete(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDTO deteteAllUsers() {
        userRepo.deleteAll();
        return null;
    }

    @Override
    public UserDTO deteteUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exist for given id "+id));
        userRepo.delete(user);
        return userMapper.userToUserDto(user);
    }

    public UserDTO getUserByUserName(String userName){
        List<User> users = userRepo.findAll();
        for(User u : users){
            if(u.getUserName().equals(userName)){
                return userMapper.userToUserDto(u);
            }
        }
        return null;
    }
}

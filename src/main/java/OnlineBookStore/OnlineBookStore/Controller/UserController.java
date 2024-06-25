package OnlineBookStore.OnlineBookStore.Controller;

import OnlineBookStore.OnlineBookStore.DTO.UserDTO;
import OnlineBookStore.OnlineBookStore.Entity.User;
import OnlineBookStore.OnlineBookStore.Service.ServiceInterfaceImpl.UserServiceImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImplementor userServiceImplementor;

    @GetMapping("/get-users")
    public List<UserDTO> getAllUsers(){
        return userServiceImplementor.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userServiceImplementor.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO userDTO1 = userServiceImplementor.createUser(userDTO);
        return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable Long id){
        UserDTO userDTO1 = userServiceImplementor.updateUser(userDTO,id);
        return ResponseEntity.ok(userDTO1);
    }

    @DeleteMapping("/delete-user")
    public UserDTO deleteUser(@RequestBody UserDTO userDTO){
        return userServiceImplementor.deteteUser(userDTO);
    }

    @DeleteMapping("/delete-all-users")
    public UserDTO deleteAllUsers(){
        return userServiceImplementor.deteteAllUsers();
    }

    @DeleteMapping("/delete-user-by-id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userServiceImplementor.deteteUserById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/get-user-by-username/{username}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable("username") String username){
        UserDTO userDTO = userServiceImplementor.getUserByUserName(username);
        return ResponseEntity.ok(userDTO);
    }

}

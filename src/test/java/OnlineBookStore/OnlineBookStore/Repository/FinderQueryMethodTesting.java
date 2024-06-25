package OnlineBookStore.OnlineBookStore.Repository;

import OnlineBookStore.OnlineBookStore.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FinderQueryMethodTesting {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void getUserByEmailMethod(){
        User user = userRepo.findByEmail("gishi@gmail.com");
        System.out.println("-------------Getting By Email--------------");
        System.out.println(user.getUserName());
        System.out.println(user.getUser_id());
    }

    @Test
    public void getUserByUserNameMethod(){
        User user = userRepo.findByUserName("ishi45@");
        System.out.println("-----------Getting By User Name-------------");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getUser_id());
    }

    @Test
    public void getUserByFirstNameMethod(){
        User user = userRepo.findByFirstName("Ishika");
        System.out.println("--------Getting By first Name-----------");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getUser_id());
    }


    @Test
    void getUserByEmailJPQL(){
        User user = userRepo.getUserByEmail("gishi@gmail.com");
        System.out.println("-------- Getting User By Email -----------");
        System.out.println(user.getUser_id());
        System.out.println(user.getUserName());
        System.out.println(user.getFirstName());
    }

    @Test
    public void getUserByNameJPQL(){
        User user = userRepo.getUserByFirstName("Neha");
        System.out.println("-------- Getting User By First Name -----------");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getUser_id());
    }

    @Test
    public void getUserByUserIdJPQL(){
        User user = userRepo.getUserByUserId(55L);
        System.out.println("-------- Getting User By User Id -----------");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getUser_id());
    }

    @Test
    public void getUserByUserIdAndUserNameJPQL(){
        User user = userRepo.getUserByUserId(56L,"Bhavya45@");
        System.out.println("-------- Getting User By User Id and userName -----------");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getUser_id());
    }




}

package OnlineBookStore.OnlineBookStore.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private Long user_id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

}

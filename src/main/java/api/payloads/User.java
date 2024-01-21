package api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
@Getter
@Setter
@NoArgsConstructor
public class User {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus = 0;

}

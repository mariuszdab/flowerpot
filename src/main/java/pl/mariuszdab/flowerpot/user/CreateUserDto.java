package pl.mariuszdab.flowerpot.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mariuszdab.flowerpot.role.Role;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
    private String password;
    private String email;
    private Boolean newsletter;
    private Boolean active;
    private Set<Role> roles;


}

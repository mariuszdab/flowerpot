package pl.mariuszdab.flowerpot.user;

import org.springframework.stereotype.Component;

@Component
public class UserMappper {

    public UserDto EntityToDto(User user){

        return new UserDto().builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .nick(user.getNick())
                .build();
    }

}

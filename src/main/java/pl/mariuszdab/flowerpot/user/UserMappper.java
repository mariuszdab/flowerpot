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

    /*public CreateUserDto EntityToSaveInDb(User user){

        return new User().builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .nick(user.getNick())
                .email(user.getEmail())
                .newsletter(user.getNewsletter())
                .active(user.getActive())
                .build();
    }*/


}

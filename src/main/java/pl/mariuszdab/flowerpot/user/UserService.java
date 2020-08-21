package pl.mariuszdab.flowerpot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.exception.UserExistException;
import pl.mariuszdab.flowerpot.role.Role;
import pl.mariuszdab.flowerpot.role.RoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMappper userMappper;

    public void save(User user){
        Optional<User> tempUser = userRepository.findByEmail(user.getEmail());
        Optional<User> tempUserWithNick = userRepository.findByNick(user.getNick());
        if(tempUser.isPresent() || tempUserWithNick.isPresent()){
            throw new UserExistException();
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Role userRole = roleRepository.findByRole("ROLE_USER");
            user.setActive(true);
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }
    }

    public User findByUserEamil(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<UserDto> findAll(){
        return userRepository.findAll().stream()
                .map(userMappper::EntityToDto)
                .collect(Collectors.toList());
    }

    public List<UserDto> findRandomTenUsers(){
        List<UserDto> userListDto = findAll();
        userListDto.remove(0);
        Collections.shuffle(userListDto, new Random());

        return userListDto.stream()
                .limit(5L)
                .collect(Collectors.toList());
    }

}

package pl.mariuszdab.flowerpot.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.exception.UserExistException;
import pl.mariuszdab.flowerpot.fruit.FruitDto;
import pl.mariuszdab.flowerpot.role.Role;
import pl.mariuszdab.flowerpot.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMappper userMappper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserMappper userMappper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMappper = userMappper;
    }

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
        List<UserDto> userListDto = userRepository.findAll().stream()
                .map(userMappper::EntityToDto)
                .collect(Collectors.toList());

        return userListDto;
    }



}

package pl.mariuszdab.flowerpot.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.exception.UserExistException;
import pl.mariuszdab.flowerpot.role.Role;
import pl.mariuszdab.flowerpot.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMappper userMappper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMappper userMappper, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMappper = userMappper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        Optional<User> tempUser = userRepository.findByEmail(user.getEmail());
        if(tempUser.isPresent()){
            throw new UserExistException();
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role userRole = roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }
    }

    public User findByUserName(String username){
        return userRepository.findByFirstName(username);
    }



}

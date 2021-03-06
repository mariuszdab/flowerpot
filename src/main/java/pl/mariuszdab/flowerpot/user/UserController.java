package pl.mariuszdab.flowerpot.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "user/userRegistration";
    }

    @PostMapping("/add")
    public String addUserToDataBase(@ModelAttribute @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "user/userRegistration";
        }
        userService.save(user);
        return "user/successAdd";
    }

    @GetMapping("/errorAdd")
    public String errorAdd(){
        return "user/errorAdd";
    }

    @GetMapping("/listUsers")
    public String listOfUsers(Model model){
        model.addAttribute("users", userService.findRandomTenUsers());
        model.addAttribute("allUsers", userService.findAll().size());
        return "user/listUsers";
    }

}
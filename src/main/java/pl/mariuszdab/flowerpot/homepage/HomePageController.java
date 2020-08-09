package pl.mariuszdab.flowerpot.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mariuszdab.flowerpot.user.User;
import pl.mariuszdab.flowerpot.user.UserRepository;
import pl.mariuszdab.flowerpot.user.UserService;

@Controller
public class HomePageController {


    @RequestMapping("/")
    public String homePage(){

        return "index";
    }


}

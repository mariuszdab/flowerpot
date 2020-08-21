package pl.mariuszdab.flowerpot.accessDenied;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/accessDenied")
    public String accessDenied2(){
        return "accessDenied/accessDenied";
    }

}

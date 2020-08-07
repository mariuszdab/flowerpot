package pl.mariuszdab.flowerpot.flower;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/flower")
@Secured("ROLE_ADMIN")
public class FlowerController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test udany !";
    }

}

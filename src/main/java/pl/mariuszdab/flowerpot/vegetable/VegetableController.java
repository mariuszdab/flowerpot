package pl.mariuszdab.flowerpot.vegetable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VegetableController {

    @GetMapping("/vegetable")
    public String inProgress(){
        return "inProgress/inProgress";
    }

}

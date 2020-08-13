package pl.mariuszdab.flowerpot.chooseWhatToAdd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChooseController {

    @GetMapping("/chooseAdd")
    public String choose(){
        return "choose/choose";
    }

    @GetMapping("/chooseShow")
    public String chooseBase(){
        return "choose/chooseBase";
    }

}

package pl.mariuszdab.flowerpot.fruit;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/add")
    public String addNewFruit(Model model){
        model.addAttribute("newFruit", new Fruit());
        model.addAttribute("listOfMonths", fruitService.listOfMonths());
        return "fruit/addFruit";
    }

    @PostMapping("/add")
    public String addNewFruitToDB(@ModelAttribute("newFruit") @Valid Fruit newFruit, BindingResult result, Model model){
        if (result.hasErrors() ){
            model.addAttribute("listOfMonths", fruitService.listOfMonths());
            return "fruit/addFruit";
        }
        fruitService.save(newFruit);
        return "redirect:listFruits";
    }

    @GetMapping("/listFruits")
    public String listOfFruits(Model model){
        model.addAttribute("fruits", fruitService.findAll());
        return "fruit/listFruits";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        fruitService.delete(id);
        return "redirect:../listFruits";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/update/{id}")
    public String updateFruit(@PathVariable Long id, Model model){
        model.addAttribute("newFruit", fruitService.findUpdateFruitByUserId(id));
        model.addAttribute("listOfMonths", fruitService.listOfMonths());
        return "fruit/addFruit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update/{id}")
    public String saveUpdateFruit(@ModelAttribute("newFruit") @Valid Fruit newFruit, BindingResult result, @PathVariable Long id, Model model){
        if (result.hasErrors() ){
            model.addAttribute("listOfMonths", fruitService.listOfMonths());
            return "fruit/addFruit";
        }
        fruitService.update(id, newFruit);
        return "redirect:../listFruits";
    }

    @GetMapping("/errorAdd")
    public String errorAdd(){
        return "fruit/errorAdd";
    }

    @GetMapping("/errorUpdate")
    public String errorUpdate(){
        return "fruit/errorUpdate";
    }

}

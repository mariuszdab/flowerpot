package pl.mariuszdab.flowerpot.fruit;

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
        model.addAttribute("fruit", new Fruit());
        model.addAttribute("listOfMonths", fruitService.listOfMonths());
        return "fruit/addFruit";
    }

    @PostMapping("/add")
    public String addNewFruitToDB(@ModelAttribute @Valid Fruit fruit, BindingResult result){
        if (result.hasErrors() ){
            return "fruit/addFruit";
        }
        fruitService.save(fruit);
        return "redirect:listFruits";
    }

    @GetMapping("/listFruits")
    public String listOfFruits(Model model){
        model.addAttribute("fruits", fruitService.findAll());
        return "fruit/listFruits";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        fruitService.delete(id);
        return "redirect:../listFruits";
    }

    @GetMapping("/update/{id}")
    public String updateFruit(@PathVariable Long id, Model model){
        model.addAttribute("fruit", fruitService.findUpdateFruitByUserId(id));
        model.addAttribute("listOfMonths", fruitService.listOfMonths());
        return "fruit/addFruit";
    }

    @PostMapping("/update/{id}")
    public String saveUpdateFruit(@ModelAttribute @Valid Fruit fruit, BindingResult result, @PathVariable Long id){
        if (result.hasErrors() ){
            return "fruit/addFruit";
        }
        fruitService.update(id, fruit);
        return "redirect:../listFruits";
    }

    @GetMapping("/error")
    public String errorAdd(){
        return "fruit/errorAdd";
    }

    @GetMapping("/errorUpdate")
    public String errorUpdate(){
        return "fruit/errorUpdate";
    }



}

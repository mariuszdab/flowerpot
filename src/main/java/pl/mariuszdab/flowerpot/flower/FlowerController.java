package pl.mariuszdab.flowerpot.flower;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/flower")
public class FlowerController {

    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("/add")
    public String addNewFlower(Model model){
        model.addAttribute("newFlower", new Flower());
        model.addAttribute("listOfMonths", flowerService.listOfMonths());
        return "flower/addFlower";
    }

    @PostMapping("/add")
    public String addNewFlowerToDb(@ModelAttribute("newFlower") @Valid Flower newFlower, BindingResult result, Model model){
        if (result.hasErrors() ){
            model.addAttribute("listOfMonths", flowerService.listOfMonths());
            return "flower/addFlower";
        }
        flowerService.save(newFlower);
        return "redirect:listFlowers";
    }

    @GetMapping("/listFlowers")
    public String listOfFlowers(Model model){
        model.addAttribute("flowers", flowerService.findAll());
        return "flower/listFlowers";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        flowerService.delete(id);
        return "redirect:../listFlowers";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/update/{id}")
    public String updateFlower(@PathVariable Long id, Model model){
        model.addAttribute("newFlower", flowerService.findUpdateFlowerByUserId(id));
        model.addAttribute("listOfMonths", flowerService.listOfMonths());
        return "flower/addFlower";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update/{id}")
    public String saveUpdateFlower(@ModelAttribute("newFlower") @Valid Flower newFlower, BindingResult result, @PathVariable Long id, Model model){
        if (result.hasErrors() ){
            model.addAttribute("listOfMonths", flowerService.listOfMonths());
            return "flower/addFlower";
        }
        flowerService.update(id, newFlower);
        return "redirect:../listFlowers";
    }

    @GetMapping("/errorAdd")
    public String errorAdd(){
        return "flower/errorAdd";
    }

    @GetMapping("/errorUpdate")
    public String errorUpdate(){
        return "flower/errorUpdate";
    }


}

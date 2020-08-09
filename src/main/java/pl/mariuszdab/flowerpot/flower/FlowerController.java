package pl.mariuszdab.flowerpot.flower;


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
        model.addAttribute("flower", new Flower());
        model.addAttribute("listOfMonths", flowerService.listOfMonths());
        return "flower/addFlower";
    }

    @PostMapping("/add")
    public String addNewFlowerToDb(@ModelAttribute @Valid Flower flower, BindingResult result){
        if (result.hasErrors() ){
            return "flower/addFlower";
        }
        flowerService.save(flower);
        return "redirect:listFlowers";
    }

    @GetMapping("/listFlowers")
    public String listOfFlowers(Model model){
        model.addAttribute("flowers", flowerService.findAll());
        return "flower/listFlowers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        flowerService.delete(id);
        return "redirect:../listFlowers";
    }

    @GetMapping("/update/{id}")
    public String updateFlower(@PathVariable Long id, Model model){
        model.addAttribute("flower", flowerService.findUpdateFlowerByUserId(id));
        model.addAttribute("listOfMonths", flowerService.listOfMonths());
        return "flower/addFlower";
    }

    @PostMapping("/update/{id}")
    public String saveUpdateFlower(@ModelAttribute @Valid Flower flower, BindingResult result, @PathVariable Long id){
        if (result.hasErrors() ){
            return "flower/addFlower";
        }
        flowerService.update(id, flower);
        return "redirect:../listFlowers";
    }

    @GetMapping("/error")
    public String errorAdd(){
        return "flower/errorAdd";
    }

    @GetMapping("/errorUpdate")
    public String errorUpdate(){
        return "flower/errorUpdate";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test udany !";
    }

}

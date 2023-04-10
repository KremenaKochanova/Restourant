package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Repositories.DishRepository;
import ProjectSystems.Restourant.Services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }


    @GetMapping
    public String getAllDishes(Model m){
        Iterable<Dish> dishes = dishRepository.findAll();
        m.addAttribute("dish",dishes);
        return "/Menu";
    }

    @GetMapping("/create")
    private String createDish(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dishes", dish);
        return "DishAddMenu";
    }

    @PostMapping("/submit")
    private ModelAndView saveDish(@Valid Dish dish, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("/DishAddMenu");
        }else{
            dishRepository.save(dish);
            return new ModelAndView("redirect:/DishAddMenu");
        }}



    @GetMapping("/edit/{dishId}")
    public String editDish(@PathVariable(name = "dishId") Integer dishId, Model model) {

        model.addAttribute("dish", dishRepository.findById(Long.valueOf(dishId)));
        return "DishUpdateMenu";
    }

    @PostMapping("/update")
    private ModelAndView updateDish(Dish dish) {
        dishRepository.save(dish);
        return new ModelAndView("DishUpdateMenu");
    }

    @PostMapping("/delete")
    private ModelAndView deleteDish(@PathVariable(name = "dishId") Integer dishId) {
        dishRepository.deleteById(Long.valueOf(dishId));
        return new ModelAndView("DishDeleteMenu");

    }

}



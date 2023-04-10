package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Repositories.DishRepository;
import ProjectSystems.Restourant.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    private DishRepository dishRepository;


    @GetMapping("")
    public String getMenu(Model model) {
        List<Dish> dishes = menuService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "menu";
    }

       @GetMapping("/add-dish")
    public String showAddDishForm(@RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("price") double price, Model model) {
        Dish dish = new Dish(name, type, price);
        model.addAttribute("dish", dish);
        return "add-dish-form";
    }

    @PostMapping("/add-dish")
    public String addDish(@ModelAttribute("dish") Dish dish) {
        menuService.addDish(dish);
        return "redirect:/menu";
    }

    @GetMapping("/edit-dish/{id}")
    public String showEditDishForm(@PathVariable("id") long id, Model model) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("dish", dish);
        return "edit-dish-form";
    }

    @PostMapping("/edit-dish/{id}")
    public String editDish(@PathVariable("id") long id, @ModelAttribute("dish") Dish dish) {
        menuService.updateDish(id, dish);
        return "redirect:/menu";
    }

    @GetMapping("/delete-dish/{id}")
    public String deleteDish(@PathVariable("id") long id) {
        menuService.deleteDish(id);
        return "redirect:/menu";
    }
}

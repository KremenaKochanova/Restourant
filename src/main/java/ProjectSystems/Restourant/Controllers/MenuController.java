package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public List<Dish> getMenu() {
        return menuService.getAllDishes();
    }

    @PostMapping("/menu")
    public void addDish(@RequestBody Dish dish) {
        menuService.addDish(dish);
    }

    @PutMapping("/menu/{id}")
    public void updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        menuService.updateDish(id, dish);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteDish(@PathVariable Long id) {
        menuService.deleteDish(id);
    }
}


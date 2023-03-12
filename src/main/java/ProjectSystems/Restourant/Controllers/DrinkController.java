package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Drink;
import ProjectSystems.Restourant.Repositories.DrinkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @GetMapping
    public String showDrinks(Model model) {
        List<Drink> drinks = drinkRepository.findAll();
        model.addAttribute("drinks", drinks);
        return "drinks";
    }
}


package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Entitis.Drink;
import ProjectSystems.Restourant.Repositories.DishRepository;
import ProjectSystems.Restourant.Repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    public void updateDish(Long id, Dish dish) {
        Dish existingDish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        existingDish.setName(dish.getName());
        existingDish.setPrice(dish.getPrice());
        existingDish.setType(dish.getType());
        dishRepository.save(existingDish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    public void addDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public void updateDrink(Long id, Drink drink) {
        Drink existingDrink = drinkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Drink not found"));
        existingDrink.setName(drink.getName());
        existingDrink.setPrice(drink.getPrice());
        drinkRepository.save(existingDrink);
    }

    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }
}

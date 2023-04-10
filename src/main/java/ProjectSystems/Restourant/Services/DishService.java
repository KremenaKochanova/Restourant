package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class DishService {
    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getDishesByType(String type) {
        return dishRepository.findAllByType(type);
    }

    public void saveDish(Dish dish, BindingResult bindingResult, String s) {
        dishRepository.save(dish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    public Dish getDishById(Long id) {

        return null;
    }


    public Dish updateDish(Long id, Dish dish) {
        return null;
    }
}

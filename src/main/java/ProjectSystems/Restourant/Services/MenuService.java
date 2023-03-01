package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Repositories.DishRepository;
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
}

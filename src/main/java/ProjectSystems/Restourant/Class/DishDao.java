package ProjectSystems.Restourant.Class;

import ProjectSystems.Restourant.Entitis.Dish;

import java.util.List;

public interface DishDao {
    List<Dish> getAllDishes();
    Dish getDishById(int id);
    void createDish(Dish dish);
    void updateDish(Dish dish);
    void deleteDish(int id);
}


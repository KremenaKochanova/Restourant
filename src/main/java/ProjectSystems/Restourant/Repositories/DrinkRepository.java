package ProjectSystems.Restourant.Repositories;

import ProjectSystems.Restourant.Entitis.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {

    List<Drink> findAll();
}


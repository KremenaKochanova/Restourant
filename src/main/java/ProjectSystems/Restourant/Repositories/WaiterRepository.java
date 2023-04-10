package ProjectSystems.Restourant.Repositories;

import ProjectSystems.Restourant.Entitis.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WaiterRepository extends JpaRepository<Waiter, Long> {

    @Query("SELECT * FROM Waiter WHERE name = name AND password = password")
    Waiter findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    Waiter findByName(String name);



}


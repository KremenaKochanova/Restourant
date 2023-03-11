package ProjectSystems.Restourant.Repositories;

import ProjectSystems.Restourant.Entitis.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface CookRepository extends JpaRepository<Cook, Long> {
        Cook findByUsernameAndPassword(String username, String password);
         static Cook findByUsername(String username);
        }





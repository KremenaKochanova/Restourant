package ProjectSystems.Restourant.Repositories;

import ProjectSystems.Restourant.Entitis.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface CookRepository extends JpaRepository<Cook, Long> {
        Cook findByNameAndPassword(String name, String password);

        static Cook findByName(String name) {
            return null;
        }
    }





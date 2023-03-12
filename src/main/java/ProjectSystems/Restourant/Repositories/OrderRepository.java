package ProjectSystems.Restourant.Repositories;

import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Entitis.Table;
import ProjectSystems.Restourant.Enum.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByTableAndStatusNot(Table table, String status);
        List<Order> findByStatusNotOrderByCreationDateTimeDesc(String status);
        List<Order> findByTableNumberAndStatusNotOrderByCreationDateTimeDesc(String tableNumber, String status);

    Order findByStatus(ProjectSystems.Restourant.Enum.OrderStatus aNew);

    List<Order> findByTableAndStatus(Table table, OrderStatus status);

}

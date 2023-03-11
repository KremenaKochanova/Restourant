package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Dish;
import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getActiveOrders() {
        return orderRepository.findByStatusNotOrderByCreationDateTimeDesc("paid");
    }

    public List<Order> getActiveOrdersByTable(String tableNumber) {
        return orderRepository.findByTableNumberAndStatusNotOrderByCreationDateTimeDesc(tableNumber, "paid");
    }

    public void createOrder(Order order) {
        if (orderRepository.findByTableAndStatusNot(order.getTable(), "paid").isPresent()) {
            throw new OrderAlreadyExistsException("An order already exists for this table");
        }
        order.setCreationDateTime(LocalDateTime.now());
        order.setStatus("new");
        orderRepository.save(order);
    }

    public void updateOrderStatus(Long id, String status)    {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.setStatus(status); orderRepository.save(order); }

    public void updateOrderDishes(Long id, List<Dish> dishes) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.setDishes(dishes);
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);
    }


}


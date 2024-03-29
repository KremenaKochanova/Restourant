package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Cook;
import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Enum.OrderStatus;
import ProjectSystems.Restourant.Repositories.CookRepository;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookService {


    public static Cook authenticateCook(String name, String password) {
        Cook cook = CookRepository.findByName(name);
        if (cook != null && cook.getPassword().equals(password)) {
            return cook;
        } else {
            return null;
        }
    }

    private final OrderRepository orderRepository;

    public CookService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public List<Order> getNewOrders() {
        return (List<Order>)(orderRepository.findByStatus(ProjectSystems.Restourant.Enum.OrderStatus.NEW));
    }

    public void startCooking(Long orderId) {
        Order order = getOrderById(orderId);
        order.setStatus(String.valueOf(ProjectSystems.Restourant.Enum.OrderStatus.COOKING));
        orderRepository.save(order);
    }

    public void finishCooking(Long orderId) {
        Order order = getOrderById(orderId);
        order.setStatus(String.valueOf(OrderStatus.PREPARED));
        orderRepository.save(order);
    }

    private Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order ID"));
    }

    public boolean authenticate(String username, String password) {
        return false;
    }
}

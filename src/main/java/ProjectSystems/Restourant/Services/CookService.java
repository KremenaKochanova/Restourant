package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.OrderStatus;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookService {

    private final OrderRepository orderRepository;

    public CookService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getNewOrders() {
        return (List<Order>) orderRepository.findByStatus(OrderStatus.NEW);
    }

    public void startCooking(Long orderId) {
        Order order = getOrderById(orderId);
        order.setStatus(String.valueOf(OrderStatus.COOKING));
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
}

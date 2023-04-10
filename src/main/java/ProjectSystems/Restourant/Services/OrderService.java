package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.MenuItem;
import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Entitis.OrderItem;
import ProjectSystems.Restourant.Enum.OrderStatus;
import ProjectSystems.Restourant.Repositories.MenuItemRepository;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import ProjectSystems.Restourant.Services.InvalidOrderStatusException;
import ProjectSystems.Restourant.Services.OrderNotFoundException;
import ProjectSystems.Restourant.Services.OrderNotModifiableException;
import ProjectSystems.Restourant.Services.Receipt;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getActiveOrders() {
        return orderRepository.findByStatusIn(Arrays.asList(OrderStatus.CREATED, OrderStatus.IN_PROGRESS));
    }

    public Order createOrder(Integer tableNumber) {
        Order order = new Order(tableNumber);
        return orderRepository.save(order);
    }

    public Order addItemToOrder(Long orderId, Long menuItemId, Integer quantity) throws OrderNotModifiableException, MenuItemNotFoundException {
        Order order = getOrderById(orderId);
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item not found with id " + menuItemId));

        OrderItem orderItem = new OrderItem(menuItem, quantity);
        order.addOrderItem(orderItem);

        return orderRepository.save(order);
    }

    public Order removeItemFromOrder(Long orderId, Long menuItemId, Integer quantity) throws OrderNotModifiableException, MenuItemNotFoundException {
        Order order = getOrderById(orderId);
        OrderItem orderItem = new OrderItem(menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item not found with id " + menuItemId)),
                quantity);
        order.removeOrderItem(orderItem);
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) throws InvalidOrderStatusException {
        Order order = getOrderById(orderId);
        return order;
    }


    public Receipt generateReceipt(Long orderId) {
        Order order = getOrderById(orderId);
        Receipt receipt = new Receipt(order);
        return receipt;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + orderId));
    }

    public Order addItemremoveItemFromOrderToOrder(Long orderId, Long menuItemId, Integer quantity) {
        return null;
    }

    public Order updateOrderStatus(Long orderId, Object status, Object tableNumber) {
        return null;
    }
}

package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Entitis.Table;
import ProjectSystems.Restourant.Entitis.Waiter;
import ProjectSystems.Restourant.OrderStatus;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import ProjectSystems.Restourant.Repositories.TableRepository;
import ProjectSystems.Restourant.Repositories.WaiterRepository;
import ProjectSystems.Restourant.Services.OrderNotModifiableException;
import ProjectSystems.Restourant.Services.TableOccupiedException;
import ProjectSystems.Restourant.Services.TableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaiterService {

    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;
    private final WaiterRepository waiterRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WaiterService(TableRepository tableRepository, OrderRepository orderRepository, WaiterRepository waiterRepository, PasswordEncoder passwordEncoder) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
        this.waiterRepository = waiterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Table> getTables() {
        return tableRepository.findAll();
    }

    public Table getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new TableNotFoundException("Table with id " + id + " not found."));
    }

    public List<Order> getActiveOrders() {
        return (List<Order>) orderRepository.findByStatus(OrderStatus.ACTIVE);
    }

    public Order createOrder(Order order) {
        // Check if there is already an active order for the table
        List<Order> activeOrders = orderRepository.findByTableAndStatus(order.getTable(), OrderStatus.ACTIVE);
        if (!activeOrders.isEmpty()) {
            throw new TableOccupiedException("Table " + order.getTable().getNumber() + " is already occupied.");
        }
        order.setStatus(OrderStatus.ACTIVE);
        order.setCreationTime(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) throws OrderNotModifiableException {
        Order order = getOrderById(id);
        if (!order.getStatus().equals(OrderStatus.ACTIVE)) {
            throw new OrderNotModifiableException("Order with id " + id + " cannot be modified.");
        }
        order.setTable(updatedOrder.getTable());
        return orderRepository.save(order);
    }

    private Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + id + " not found."));
    }

    public Waiter authenticateWaiter(String username, String password) throws InvalidPasswordException {
        Waiter waiter = waiterRepository.findByUsername(username);
        if (waiter == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        if (!passwordEncoder.matches(password, waiter.getPassword())) {
            throw new InvalidPasswordException("Invalid password.");
        }
        return waiter;
    }
}

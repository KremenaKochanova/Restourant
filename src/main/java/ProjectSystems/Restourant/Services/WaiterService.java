package ProjectSystems.Restourant.Services;

import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Entitis.OrderItem;
import ProjectSystems.Restourant.Entitis.Table;
import ProjectSystems.Restourant.OrderStatus;
import ProjectSystems.Restourant.Repositories.OrderRepository;
import ProjectSystems.Restourant.Repositories.TableRepository;
import ProjectSystems.Restourant.Services.OrderNotModifiableException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaiterService {

    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;


    public WaiterService(TableRepository tableRepository, OrderRepository orderRepository) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;

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
    }
}

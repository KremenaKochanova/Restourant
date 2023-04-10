package ProjectSystems.Restourant.Class;

import ProjectSystems.Restourant.Entitis.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    List<Order> getOrdersByTableNumber(int tableNumber);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int id);
}



package ProjectSystems.Restourant.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getActiveOrders() {
        return orderService.getActiveOrders();
    }

    @GetMapping("/orders/{tableNumber}")
    public List<Order> getActiveOrdersByTable(@PathVariable String tableNumber) {
        return orderService.getActiveOrdersByTable(tableNumber);
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}/status")
    public void updateOrderStatus(@PathVariable Long id, @RequestBody String status) {
        orderService.updateOrderStatus(id, status);
    }

    @PutMapping("/orders/{id}/dishes")
    public void updateOrderDishes(@PathVariable Long id, @RequestBody List<Dish> dishes) {
        orderService.updateOrderDishes(id, dishes);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}


package ProjectSystems.Restourant.Controllers;

import ProjectSystems.Restourant.Entitis.Order;
import ProjectSystems.Restourant.Enum.OrderCreateRequest;
import ProjectSystems.Restourant.Enum.OrderStatus;
import ProjectSystems.Restourant.Services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public record OrderController(OrderService orderService) {

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestBody OrderCreateRequest request) {
        Order order = orderService.createOrder(request.getTableNumber());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateRequest request) throws OrderNotFoundException {
        Order order = orderService.updateOrderStatus(orderId, request.getStatus(), request.getTableNumber());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Order> addItemToOrder(@PathVariable Long orderId, @RequestBody OrderItemRequest request) throws OrderNotFoundException, MenuItemNotFoundException {
        Order order = orderService.addItemremoveItemFromOrderToOrder(orderId, request.getMenuItemId(), request.getQuantity());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/items")
    public ResponseEntity<Order> removeItemFromOrder(@PathVariable Long orderId, @RequestBody OrderItemRequest request) throws OrderNotFoundException, MenuItemNotFoundException, OrderItemNotFoundException, OrderNotModifiableException {
        Order order = orderService.removeItemFromOrder(orderId, request.getMenuItemId(), request.getQuantity());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/{orderId}/serve")
    public ResponseEntity<Order> serveOrder(@PathVariable Long orderId) throws OrderNotFoundException, InvalidOrderStatusException {
        Order order = orderService.updateOrderStatus(orderId, OrderStatus.SERVED);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/{orderId}/pay")
    public ResponseEntity<Receipt> payOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        Receipt receipt = orderService.generateReceipt(orderId);
        return new ResponseEntity<>(receipt, HttpStatus.OK);
    }
}

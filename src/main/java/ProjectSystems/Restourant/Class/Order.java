//package ProjectSystems.Restourant.Class;
//
//import ProjectSystems.Restourant.Entitis.Dish;
//import ProjectSystems.Restourant.Enum.OrderStatus;
//
//import java.awt.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Order {
//    private int tableNumber;
//    private LocalDateTime dateTime;
//    private List items;
//    private Map<MenuItem, Integer> quantities;
//    private OrderStatus status;
//    private BigDecimal total;
//
//    public Order(int tableNumber) {
//        this.tableNumber = tableNumber;
//        this.dateTime = LocalDateTime.now();
//        this.status = OrderStatus.NEW;
//        this.items = new List();
//        this.quantities = new HashMap<>();
//        this.total = BigDecimal.ZERO;
//    }
//
//    public int getTableNumber() {
//        return tableNumber;
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public List<MenuItem> getItems() {
//        return items;
//    }
//
//    public void addItem(MenuItem item) {
//        items.add(item);
//        quantities.merge(item, 1, Integer::sum);
//        total = total.add(item.getPrice());
//    }
//
//    public void removeItem(MenuItem item) {
//        items.remove(item);
//        quantities.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
//        total = total.subtract(item.getPrice());
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//
//    public BigDecimal getTotal() {
//        return total;
//    }
//
//    public Map<MenuItem, Integer> getQuantities() {
//        return quantities;
//    }
//
//    private int id;
//    private int tableNumber;
//    private String status;
//    private ArrayList<Menu> items;
//
//    public Order(int id, int tableNumber, String status, ArrayList<Menu> items) {
//        this.id = id;
//        this.tableNumber = tableNumber;
//        this.status = status;
//        this.items = items;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getTableNumber() {
//        return tableNumber;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public ArrayList<Menu> getItems() {
//        return items;
//    }
//
//
//    private LocalDateTime dateCreated;
//    private List<Dish> dishes;
//
//    // constructors, getters, setters
//    private Date creationDate;
//
//    private double totalPrice;
//
//    // Constructor
//    public Order(int tableNumber) {
//        this.tableNumber = tableNumber;
//        this.creationDate = new Date();
//        this.items = new ArrayList<>();
//        this.status = OrderStatus.NEW;
//    }
//
//    // Getters and setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public int getTableNumber() {
//        return tableNumber;
//    }
//
//    public void setTableNumber(int tableNumber) {
//        this.tableNumber = tableNumber;
//    }
//
//    public List<MenuItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<MenuItem> items) {
//        this.items = items;
//        calculateTotalPrice();
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    // Helper methods
//    public void addItem(MenuItem item) {
//        this.items.add(item);
//        calculateTotalPrice();
//    }
//
//    public void removeItem(MenuItem item) {
//        this.items.remove(item);
//        calculateTotalPrice();
//    }
//
//    private void calculateTotalPrice() {
//        this.totalPrice = 0;
//        for (MenuItem item : this.items) {
//            this.totalPrice += item.getPrice();
//        }
//    }
//
//    public Order(int tableNumber) {
//        this.tableNumber = tableNumber;
//        this.dateTime = LocalDateTime.now();
//        this.status = OrderStatus.NEW;
//        this.items = new ArrayList<>();
//        this.quantities = new HashMap<>();
//        this.total = BigDecimal.ZERO;
//    }
//
//    public int getTableNumber() {
//        return tableNumber;
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public List<MenuItem> getItems() {
//        return items;
//    }
//
//    public void addItem(MenuItem item) {
//        items.add(item);
//        quantities.merge(item, 1, Integer::sum);
//        total = total.add(item.getPrice());
//    }
//
//    public void removeItem(MenuItem item) {
//        items.remove(item);
//        quantities.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
//        total = total.subtract(item.getPrice());
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//
//    public BigDecimal getTotal() {
//        return total;
//    }
//
//    public Map<MenuItem, Integer> getQuantities() {
//        return quantities;
//    }
//}

package ProjectSystems.Restourant.Entitis;

import ProjectSystems.Restourant.Enum.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@javax.persistence.Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime creationDateTime;
    private String status;

    @ManyToOne
    private Table table;

    @ManyToOne
    private Waiter waiter;

    @ManyToMany
    private List<Dish> dishes;
    private Object tableNumber;
    private LocalDateTime orderTime;
    private Date createdDate;

    public Order() {
    }

    public Order(Integer tableNumber) {
    }

    public Order(Long id, LocalDateTime creationDateTime, String status, Table table, Waiter waiter, List<Dish> dishes) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.status = status;
        this.table = table;
        this.waiter = waiter;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setCreationTime(LocalDateTime now) {

    }

    public void setStatus(OrderStatus active) {
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cook_id")
    private User cook;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Object getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Object tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<OrderItem> getOrderItems() {
        return null;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
                this.orderItems = orderItems;
    }

    public void setLastModifiedDate(Date date) {
    }

    public void addOrderItem(OrderItem orderItem) {

    }

    public void removeOrderItem(OrderItem orderItem) {
    }
}

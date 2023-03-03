package ProjectSystems.Restourant.Entitis;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDateTime;
    private String status;

    @ManyToOne
    private Table table;

    @ManyToOne
    private Waiter waiter;

    @ManyToMany
    private List<Dish> dishes;

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
}

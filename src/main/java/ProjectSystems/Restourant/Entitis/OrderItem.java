package ProjectSystems.Restourant.Entitis;

import javax.persistence.*;
import javax.persistence.Table;
import java.awt.MenuItem;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    public OrderItem() {
    }

    public OrderItem(ProjectSystems.Restourant.Entitis.MenuItem menuItem, Integer quantity) {
    }

    public OrderItem(MenuItem menuItem, int quantity) {
    }

    public OrderItem(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;


    @JoinColumn(name = "order_id", nullable = false)


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    @Column(nullable = false)

//element na Order


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")

    public long getDishId() {
        return 0;
    }

    public void setDish(Dish dish) {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

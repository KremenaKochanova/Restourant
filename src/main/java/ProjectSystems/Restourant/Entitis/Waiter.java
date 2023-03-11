package ProjectSystems.Restourant.Entitis;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "Waiter", indexes = {
        @Index(name = "idx_waiter_id", columnList = "id")
})
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "waiter")
    private List<Order> orders;

    @ManyToMany
    private List<Table> tables;

    public Waiter() {
    }

    public Waiter(Long id, String name, String password, List<Order> orders, List<Table> tables) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.orders = orders;
        this.tables = tables;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}

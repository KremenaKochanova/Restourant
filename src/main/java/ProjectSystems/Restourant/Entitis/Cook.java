package ProjectSystems.Restourant.Entitis;

import ProjectSystems.Restourant.Enum.Role;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="Cook")
public class Cook {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Role role;


    public Cook() {
    }

    public Cook(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

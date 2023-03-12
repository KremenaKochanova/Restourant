package ProjectSystems.Restourant.Entitis;


import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "tables")

public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String number;

    public Table() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Table(Long id_table, Long id, String number) {
        this.id = id;
        this.number = number;
    }
}
package ProjectSystems.Restourant.Entitis;


import javax.persistence.*;

@Entity
@javax.persistence.Table
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
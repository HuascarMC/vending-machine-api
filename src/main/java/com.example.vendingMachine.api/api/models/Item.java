package api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "quantity")
    @OneToMany(mappedBy = "name")
    Integer quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
      return this.quantity;
    }

    public void setQuantity(Integer quantity) {
      this.quantity = quantity;
    }
}

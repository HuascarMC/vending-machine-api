package api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

@Entity
@Table(name="DBItem")
public class DBItem {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;

  @Column(name = "name")
  String name;

  @Column(name = "quantity")
  Integer quantity;

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

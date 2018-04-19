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
@Table(name="DBCoin")
public class DBCoin {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;

  @Column(name = "name")
  String name;

  @Column(name = "quantity")
  Integer quantity;

  @Column(name = "value")
  double value;

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
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public double getValue() {
    return value;
  }

  public void setValue() {
    this.value = value;
  }

}

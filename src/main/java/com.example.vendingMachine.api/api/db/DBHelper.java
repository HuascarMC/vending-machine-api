package api.models;

import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import vendingMachine.Objects.Coin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DBHelper {

  private SessionFactory sf;
  private EntityManager session;

  public void DBHelper() {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    EntityManager session = sf.createEntityManager();
  }

  public double getCoinTotal(String params) {
    double result = 0.00;
    List<Coin> coins = session.createQuery("FROM " + params).getResultList();
    for(Coin coin : coins) {
      result += coin.getValue();
    }
    return result;
  }

  public boolean hasItem(String itemName) {
    String query = String.format("FROM DBCoin WHERE name = '%s'", itemName);
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    return (item.getQuantity() > 0);
  }

  public void removeOneItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    Integer currentQuantity = item.getQuantity();
    item.setQuantity(currentQuantity - 1);
    session.getTransaction().begin();
    session.merge(item);
    session.getTransaction().commit();
  }

}

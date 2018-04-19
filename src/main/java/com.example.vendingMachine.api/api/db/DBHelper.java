package api.db;

import javax.persistence.EntityManager;

import vendingMachine.Objects.Coin;

import api.models.DBCoin;
import api.models.DBItem;

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

  public double getCoinTotal() {
    double result = 0.00;
    List<Coin> coins = session.createQuery("FROM DBCoin").getResultList();
    for(Coin coin : coins) {
      result += coin.getValue();
    }
    return result;
  }

  public boolean hasItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    return (item.getQuantity() > 0);
  }

  public void removeOneItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    Integer currentQuantity = item.getQuantity();
    if(currentQuantity > 0) {
      item.setQuantity(currentQuantity - 1);
      session.getTransaction().begin();
      session.merge(item);
      session.getTransaction().commit();
    }
  }

  public void removeOneCoin(String coinName) {
    String query = String.format("FROM DBCoin WHERE name = '%s'", coinName);
    DBCoin coin = (DBCoin) session.createQuery(query).getSingleResult();
    Integer currentQuantity = coin.getQuantity();
    if(currentQuantity > 0) {
      coin.setQuantity(currentQuantity - 1);
      session.getTransaction().begin();
      session.merge(coin);
      session.getTransaction().commit();
    }
  }

  public void removeCoins(List<Coin> coins) {
    for(Coin coin : coins) {
      removeOneCoin(coin.getName());
    }
  }
}

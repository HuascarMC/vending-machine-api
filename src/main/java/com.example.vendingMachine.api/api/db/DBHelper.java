package api.db;

import javax.persistence.EntityManager;

import vendingMachine.Objects.Coin;

import api.models.DBCoin;
import api.models.DBItem;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.MultipartConfigElement;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import java.util.List;

public class DBHelper {

  private SessionFactory sf = new Configuration().configure().buildSessionFactory();;

  public double getCoinTotal() {
    double result = 0.00;
    EntityManager session = sf.createEntityManager();
    List<DBCoin> coins = session.createQuery("FROM DBCoin").getResultList();
    for(DBCoin coin : coins) {
      result += coin.getValue();
    }
    return result;
  }

  public boolean hasItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    System.out.println(query);
    EntityManager session = sf.createEntityManager();
    System.out.println(query);
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    System.out.println(item);
    return (item.getQuantity() > 0);
  }

  public void removeOneItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    EntityManager session = sf.createEntityManager();
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    Integer currentQuantity = item.getQuantity();
    if(currentQuantity > 0) {
      item.setQuantity(currentQuantity - 1);
      session.getTransaction().begin();
      session.merge(item);
      session.getTransaction().commit();
    }
  }

  public void addOneItem(String itemName) {
    String query = String.format("FROM DBItem WHERE name = '%s'", itemName);
    EntityManager session = sf.createEntityManager();
    DBItem item = (DBItem) session.createQuery(query).getSingleResult();
    Integer currentQuantity = item.getQuantity();
    if(currentQuantity >= 0) {
      item.setQuantity(currentQuantity + 1);
      session.getTransaction().begin();
      session.merge(item);
      session.getTransaction().commit();
    }
  }

  public void addOneCoin(String coinName) {
    String query = String.format("FROM DBCoin WHERE name = '%s'", coinName);
    EntityManager session = sf.createEntityManager();
    DBCoin item = (DBCoin) session.createQuery(query).getSingleResult();
    Integer currentQuantity = item.getQuantity();
    if(currentQuantity >= 0) {
      item.setQuantity(currentQuantity + 1);
      session.getTransaction().begin();
      session.merge(item);
      session.getTransaction().commit();
    }
  }

  public void removeOneCoin(String coinName) {
    String query = String.format("FROM DBCoin WHERE name = '%s'", coinName);
    EntityManager session = sf.createEntityManager();
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

  public List<DBCoin> getCoins() {
    EntityManager session = sf.createEntityManager();
    List<DBCoin> coins = session.createQuery("FROM DBCoin").getResultList();
    return coins;
  }

  public List<DBItem> getItems() {
    EntityManager session = sf.createEntityManager();
    List<DBItem> items = session.createQuery("FROM DBItem").getResultList();
    return items;
  }

}

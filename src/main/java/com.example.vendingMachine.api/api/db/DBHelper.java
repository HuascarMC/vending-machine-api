package api.models;

import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import vendingMachine.Objects.Coin;

public class DBHelper {


  public void DBHelper() {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    EntityManager session = sf.createEntityManager();
  }

  public double getCoinTotal() {
       double result = 0.00;
       List<Coin> coins = session.createQuery("FROM " + request.params("DBCoin")).getResultList();
       for(Coin coin : coins) {
         result += coin.value;¿
       }
       return result;
  }

}

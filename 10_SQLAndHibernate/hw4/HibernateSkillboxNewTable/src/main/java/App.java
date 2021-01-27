import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory fact = cfg.buildSessionFactory();
        Session sess = fact.openSession();
        sess.beginTransaction();
        LinkedPurchaseList id1 = new LinkedPurchaseList(10, 10);
        Account acc = new Account();
        acc.setlinkedPurchaseList(id1);
        acc.setAcc_bal(8100);
        LinkedPurchaseList id2 = new LinkedPurchaseList(11, 11);
        Account acc2 = new Account();
        acc2.setlinkedPurchaseList(id2);
        acc2.setAcc_bal(7200);
        sess.save(acc);
        sess.save(acc2);
        sess.getTransaction().commit();
        System.out.println("created");
        sess.close();
    }
}

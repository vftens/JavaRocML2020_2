import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        AtomicReference<SessionFactory> sf;
        try (
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();
        ) {

            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            try (
                    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                    Session session = sessionFactory.openSession();
                    //
                    // sf = sessionFactory;
            ) {
                //Transaction transaction1 = session.beginTransaction();

                /*
                List<Purchase> purchases = session.createQuery("From " + Purchase.class.getSimpleName()).getResultList();
                purchases.forEach(e -> {
                    System.out.println(e.getId().getCourse().getName() + "\t" + e.getId().getStudent().getName() + "\t" + e.getPrice() + "\t" + e.getSubscriptionDate());
                });
                 */

                Transaction transaction = session.beginTransaction();
                /*
                List<Subscription> subscriptions = session.createQuery(
                        " from Subscription sub" +
                                " join fetch sub.course c" +
                                " join fetch sub.student s",
                        Subscription.class).getResultList();


                 */
                List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(
                        " from LinkedPurchaseList pl" +
                                " join fetch pl.course c" +
                                " join fetch pl.student s",
                        LinkedPurchaseList.class).getResultList();

                List<Purchase> purchaseList = new ArrayList<>();
                //subscriptions.forEach(subscription -> {
                linkedPurchaseLists.forEach(subscription -> {
                    purchaseList.add(new Purchase(
                            subscription.getStudent(),
                            subscription.getCourse(),
                            subscription.getCourse().getPrice(),
                            subscription.getSubscriptionsDate()
                    ));
                });

                System.out.println("Начинаем транзакцию...");
                //Transaction transaction1 = session.beginTransaction();
                //linkedPurchaseLists.forEach(p -> {
                purchaseList.forEach(p -> {
                    try {
                        session.save(p);
                    } catch (Exception e) {
                        System.out.println("Saving fail.");
                    }
                });
                transaction.commit();
                System.out.println("Изменения внесены");
                sessionFactory.close();
            } catch (Exception e) {
                System.out.println("Ошибка доступа к Базе Данных");
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        /* 5.4.27.Final
        System.out.println("");
        App pp = new App();
        App.main("");


        System.out.println("");
        Program p = new Program();
        Program.main("");

         */
        //transaction.commit();

    }
}

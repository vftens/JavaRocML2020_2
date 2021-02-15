import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();
        ) {
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            try (
                    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                    Session session = sessionFactory.openSession();
            ) {
                Transaction transaction = session.beginTransaction();

                List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(
                        " from LinkedPurchaseList pl" +
                                " join fetch pl.course c" +
                                " join fetch pl.student s",
                        LinkedPurchaseList.class).getResultList();

                List<Purchase> purchaseList = new ArrayList<>();

                linkedPurchaseLists.forEach(subscription -> {
                    purchaseList.add(new Purchase(
                            subscription.getStudent(),
                            subscription.getCourse(),
                            subscription.getCourse().getPrice(),
                            subscription.getSubscriptionsDate()
                    ));
                });

                System.out.println("Начинаем транзакцию...");

                linkedPurchaseLists.forEach(p -> {
                    try {
                        session.save(p);
                    } catch (Exception e) {
                        System.out.println("Saving fail.");
                    }
                });
                transaction.commit();
                System.out.println("Изменения внесены");

            } catch (Exception e) {
                System.out.println("Ошибка доступа к Базе Данных");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

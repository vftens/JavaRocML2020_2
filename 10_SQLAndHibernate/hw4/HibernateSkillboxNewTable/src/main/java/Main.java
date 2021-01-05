import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Purchase> purchases = session.createQuery("From " + Purchase.class.getSimpleName()).getResultList();
		purchases.forEach(e -> {
			System.out.println(e.getId().getCourse().getName() + "\t" + e.getId().getStudent().getName() + "\t" + e.getPrice() + "\t" + e.getSubscriptionDate());
		});

		transaction.commit();
		sessionFactory.close();
	}
}

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		//реализация синглтона. Если объекта нет - создаем, если есть просто возвращаем
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				//стандартные настройки для хибернат
				//для тех, кто использует другую базу данных нужно заметить поле DRIVER, DIALECT и кусок URL
				// легко гуглятся под любую базу
				Map<String, String> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate_tutorial");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "postgres");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

				registryBuilder.applySettings(settings);

				registry = registryBuilder.build();
				
				MetadataSources sources = new MetadataSources(registry);
				sources.addAnnotatedClass(Users.class);

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

}

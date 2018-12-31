package webdemo1;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserDao {
	
	public static int register(User u) {
		int i=0;
		
		
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sessionFactory=metaData.getSessionFactoryBuilder().build();	
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			i=(Integer)session.save(u);
			tx.commit();
			session.close();

		return i;
	}

}

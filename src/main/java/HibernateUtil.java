import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by mseidel on 30/06/2017.
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed. " + e.toString());
            throw new ExceptionInInitializerError(e);
        }
    }

}

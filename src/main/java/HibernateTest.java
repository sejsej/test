import org.hibernate.Session;

/**
 * Created by mseidel on 21/07/2017.
 */
public class HibernateTest {

    public static void main (String ... args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Course course = new Course("Java");

        session.save(course);
        session.getTransaction().commit();

    }
}

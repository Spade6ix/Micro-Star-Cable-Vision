package microStar.factory;

import microStar.model.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SessionFactoryBuilder {
    private static SessionFactory session = null;
    private static final Logger logger = LogManager.getLogger(SessionFactoryBuilder.class);

    public static SessionFactory getSessionFactory(){
        //session = null;
        if(session == null){
            try{
                session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Complaint.class)
                        .addAnnotatedClass(Payment.class)
                        .addAnnotatedClass(Response.class)
                        .buildSessionFactory();
                logger.info("Session established");
            }
            catch(HibernateException h){
                h.printStackTrace();
                logger.error("Hibernate Exception Occurred");
            }
            catch(RuntimeException r){
                r.printStackTrace();
                logger.error("Runtime Exception Occurred");
            }
            catch(Exception e){
                e.printStackTrace();
                logger.error("Exception Occurred");
            }
        }
        return session;
    }

    public static void closeSessionFactory(){
        if(session != null){
            try{
                session.close();
                logger.info("Session Closed");
            }
            catch(HibernateException h){
                h.printStackTrace();
                logger.error("Hibernate Exception Occurred");
            }
            catch(RuntimeException r){
                r.printStackTrace();
                logger.error("Runtime Exception Occurred");
            }
            catch(Exception e){
                e.printStackTrace();
                logger.error("Exception Occurred");
            }
        }
    }
}

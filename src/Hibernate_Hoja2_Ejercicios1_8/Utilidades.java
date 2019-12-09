package Hibernate_Hoja2_Ejercicios1_8;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 

public class Utilidades {
	
	 
	    //Factoria de sesion para crear objeto sesi�n a partir de XML
	    private static SessionFactory sessionFactory;
	     
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Creamos una factor�a de sesiones con los datos de hibernate.cfg.xml
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate1.cfg.xml");
	            System.out.println("Configuracion de Hibernate Cargada");
	             
	            //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            //System.out.println("Servicio de registro de Hibernate Realizado");
	             
	            SessionFactory sessionFactory = configuration.buildSessionFactory();
	             
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Fallo la creacion de la factoria de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    /*
	     * M�todo est�tico (Fachada) para crear la factor�a de sesiones
	     */
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }

}
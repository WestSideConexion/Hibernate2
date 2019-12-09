package Hibernate_Hoja2_Ejercicios1_8;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Pruebas {

	
	public void InsertaProfesor(Profesor seg) {
		
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			
			tx = session.beginTransaction();
			
			session.save(seg);
			
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			session.close();
		}

	}

	
	public Profesor MuestraProfesor(int id) {
		
		Session session = Utilidades.getSessionFactory().openSession();
		Profesor prof2 = new Profesor();

		
		session.beginTransaction();
		
		prof2 = (Profesor) session.load(Profesor.class, id);
		System.out.println("Seguro tras ser recuperado:"
				+ prof2.toString());
		
		session.getTransaction().commit();
		
		return prof2;
	}


	public static void main(String[] args) {
		Profesor prof = new Profesor();
		Profesor profD = new Profesor();
		Profesor profb;
		
		prof.setDireccion(new Direccion());
		prof.setModulo(new Modulo());
		prof.setNombre("Carl");
		prof.setApe1("Lopez");
		prof.setApe2("Martinez");
		

		Pruebas prueba = new Pruebas();
		prueba.InsertaProfesor(prof);
		System.out.println("Profesor almacenado:" + prof.toString());
		profb = prueba.MuestraProfesor(prof.getId());
		System.out.println("Profesor recuperado:" + profb.toString());
		
	}

}

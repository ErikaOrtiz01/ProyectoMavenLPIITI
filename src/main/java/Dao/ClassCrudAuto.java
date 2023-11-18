package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iautoable;
import model.TblAuto;

public class ClassCrudAuto implements Iautoable {

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
				//de persistencia...
				EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
				
				//gestionar las entidades
				EntityManager emanager = em.createEntityManager();
				
				//iniciamos la transaccion
				emanager .getTransaction().begin();
				//registramosn
				emanager.persist(tblauto);
				//emitimo mensaje
				System.out.println("auto registrado en la BD");
				//confirmamo
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}  //fin del metodo registrar

	@Override
	public void ActuslizarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//actualizar
		emanager.merge(tblauto);
		//emitimo mensaje
		System.out.println("auto actualizar en la BD");
		//confirmamo
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//recuperamos el codigo eliminar 
		TblAuto elim=emanager.merge(tblauto);
		//registramosn
		emanager.remove(elim);
		//emitimo mensaje
		System.out.println("auto eliminado de la BD");
		//confirmamo
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		// TODO Auto-generated method stub
		
	}

	@Override
	public TblAuto BuscarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//registramosn
		TblAuto buscar=emanager.find(TblAuto.class, tblauto.getIdauto());
		//confirmamo
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return buscar;
		
	}

	@Override
	public List<TblAuto> Listado() {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//recuperamos codigo a eliminar
		List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//confirmamo
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return listado;
	}
	

}

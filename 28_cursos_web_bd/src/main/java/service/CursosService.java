package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosService {


	//Creamos método para crear factory y conectarnos a la base de datos
	private EntityManager getEntityManager() {
		
		//Por defecto el motor de persistencia suele ser el nombre del proyecto
		//Pero se suele cambiar por otro más corto --> cursoswebPU
		//Se cambia en persistence.xml pestaña general, ver captura 32
		
		//creamos una factoría, que es un objeto para crear otros objetos
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursoswebPU");
		return factory.createEntityManager();
		
		
	}
	
	
	//a partir del nombre del curso, me devuelve el objeto Curso
	private Curso buscarPorDenominacion(String nombre) {
		//se necesita una select
		String jpql="select c from Curso c where c.nombre=?1";
		//al objeto typedQuery le damos la query(jpql y el tipo de objeto en el que se convertirá el resultado
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter(1, nombre);
		
				
		//El método getSingleResult() puede dar problemas. 
		//Si no hay resultado, no devuelve null, da una excepción
		try {
			return query.getSingleResult(); 
		}catch(NoResultException ex) {
			return null;
		}
		
		/*
		//OTRA FORMA
		//return (Curso) query.getResultList();
		List<Curso> cursos=query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
		*/
	}
	
	
	//Método nuevo curso
	//si hay un curso con el mismo nombre, no se añade y devolverá falso
	public boolean nuevo(String nombre, int duracion, double precio) {
		
			
		if(buscarPorDenominacion(nombre)==null){
			//declaro variable tipo curso
			Curso curso= new Curso(0,nombre, duracion, precio);
			EntityManager em=getEntityManager();
			//Las operaciones de acción se deben englobar en una transacción obligatoriamente. 
			//Si hacemos un alta y no se produce en la base de datos, es que no tenemos hecha la transacción
			//En las operaciones select no hay que hacerla
			//la operación de transacción tiene que estar entre un begin y un commit
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(curso);
			tx.commit();
			return true;
		}
		
		return false;
	
		
		
	}
	
	
	//Método precios curso precio máximo
	public List<Curso> preciosCursoMax(double precioMax) {
		
		//se necesita una select
		String jpql="select c from Curso c where c.precio<=?1";
		//al objeto typedQuery le damos la query(jpql y el tipo de objeto en el que se convertirá el resultado
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
		
	}
	
	
	//Método eliminar curso
	public void eliminarCurso(String nombre) {
		
		//"Curso" no es nombre de tabla, es nombre de la entidadentidad
		String jpql="delete from Curso c where c.nombre=?1";
		EntityManager em = getEntityManager();
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
		
	}
	
	
	//Método modificar duración
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		
		if(buscarPorDenominacion(nombre)!=null){
			//el curso existe por ese nombre, luego modificamos su duración
			//executeUpdate()
			//"Curso" no es nombre de tabla, es nombre de la entidadentidad
			String jpql="update Curso c SET c.duracion=?1 where c.nombre=?2";
			EntityManager em = getEntityManager();
			Query query=em.createQuery(jpql);
			query.setParameter(1, nuevaDuracion);
			query.setParameter(2, nombre);
			EntityTransaction tx= em.getTransaction();
			tx.begin();
			query.executeUpdate();
			tx.commit();
		}
		
		
	
		
		
	}
	
	
	
}

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
	
		
		//Método precios curso precio máximo
		public List<Curso> preciosCursoMax(double precioMax) {
			
			//se necesita una select
			String jpql="select c from Curso c where c.precio<=?1";
			//al objeto typedQuery le damos la query(jpql y el tipo de objeto en el que se convertirá el resultado
			TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
			query.setParameter(1, precioMax);
			return query.getResultList();
			
		}

		
		//Método para buscar por duración min y max
		public List<Curso> duracionCurso(int duracionMin, int duracionMax) {
					
			//se necesita una select
			//SELECT * FROM escuela.cursos where duracion>=150 and duracion<=500;
			String jpql="select c from Curso c where c.duracion>=?1 and c.duracion<=?2";
			//al objeto typedQuery le damos la query(jpql y el tipo de objeto en el que se convertirá el resultado
			TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
			query.setParameter(1, duracionMin);
			query.setParameter(2, duracionMax);
			return query.getResultList();
					
		}
		
}

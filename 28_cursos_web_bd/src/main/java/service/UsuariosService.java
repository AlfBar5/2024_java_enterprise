package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import model.Usuario;

public class UsuariosService {
	
	
	
	private EntityManager getEntityManager() {
		
		//Por defecto el motor de persistencia suele ser el nombre del proyecto
		//Pero se suele cambiar por otro más corto --> cursoswebPU
		//Se cambia en persistence.xml pestaña general, ver captura 32
		
		//creamos una factoría, que es un objeto para crear otros objetos
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursoswebPU");
		return factory.createEntityManager();
		
		
	}
	

	public boolean autenticar(String usuario, String pwd) {
		
		
		
		// Creamos la query parametrizada por posición. Usuario es un objeto usuario no el nombre de la tabla
		String jpql="select us from Usuario us where us.usuario=?1 and us.password=?2";
		
		//typedquery
		TypedQuery<Usuario> query=getEntityManager().createQuery(jpql, Usuario.class);
		// le pasamos el valor al parámetro de la query
		query.setParameter(1, usuario);
		query.setParameter(2, pwd);
		
		//guardamos el resultado de la query
		//Usuario user = query.getSingleResult();
		//pedimos la lista de resultados que nos da la query
		
		/*
		//UNA FORMA
		if (query.getResultList().size()==0) {
			return false;
		}else {
			return true;
		}
		*/	
		//OTRA FORMA
		return query.getResultList().size()>0;
		
		//OTRA FORMA, pero para no usar. El método getSingleResult() puede dar problemas. 
		//Si no hay resultado, no devuelve null, da una excepción
		//return query.getSingleResult()!=null;
		
	}
	
}

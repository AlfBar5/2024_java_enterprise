package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;

public class ProductosService {

	
	
	private EntityManager getEntityManager() {
		
		//Por defecto el motor de persistencia suele ser el nombre del proyecto
		//Pero se suele cambiar por otro más corto --> productosPU
		//Se cambia en persistence.xml pestaña general, ver captura 32
		
		//creamos una factoría, que es un objeto para crear otros objetos
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("productosPU");
		return factory.createEntityManager();
		
		
	}
	
	
	//El EntityManager es un objeto que tenemos que llamar para hacer cualquier CRUD
	//método alta
	public void agregarProducto(String nombre, String categoria, double precio) {
		//Creo objeto producto
		//Se le pone el valor 0 al idProducto, el motor de persistencia no lo usa a la hora de hacer el insert
		Producto pr=new Producto(0, nombre, categoria, precio);
		EntityManager em=getEntityManager();
		
		//Las operaciones de acción se deben englobar en una transacción obligatoriamente. 
		//Si hacemos un alta y no se produce en la base de datos, es que no tenemos hecha la transacción
		//En las operaciones select no hay que hacerla
		//la operación de transacción tiene que estar entre un begin y un commit
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(pr);
		tx.commit();
		
		
	}
	
	
	//método. Busca o hace la select por idProducto
	public Producto buscarProducto(int idProducto) {
		
		return getEntityManager().find(Producto.class, idProducto);
		
	}
	
	//método ELIMINAR -busco por idProducto si el producto existe con el método buscarProducto
	public void eliminarProducto(int idProducto) {
		
		Producto pr=buscarProducto(idProducto);
		//si existe lo borro. Obligatorio crear la transacción
		if(pr!=null) {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(pr);
			tx.commit();
			
		}
		
	}
	
	
	public List<Producto> buscarPorCategoria(String categoria){
		
		//1 opción--> consulta sin parámetro
		//String jpql="select p from Producto p where p.categoria='"+categoria+"'";
		
		//2 opción--> Creamos la query parametrizada por posición
		String jpql="select p from Producto p where p.categoria=?1";
		
		//3 opción--> Creamos la query parametrizada por nombre
		//String jpql="select p from Producto p where p.categoria=:cat";
		
		//typedquery
		TypedQuery<Producto> query=getEntityManager().createQuery(jpql, Producto.class);
		// 2 opción--> le pasamos el valor al parámetro de la query
		query.setParameter(1, categoria);
		
		// 3 opción--> parametro por posición
		//query.setParameter("cat", categoria);
		
		//pedimos la lista de resultados que nos da la query
		return query.getResultList();
	}
	
	
	
	public void eliminarPorNombre(String nombre) {
		//"Producto" no es monbre de tabla, es nombre de entidad
		String jpql="delete from Producto p where p.nombre=?1";
		EntityManager em = getEntityManager();
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
	}
	
}

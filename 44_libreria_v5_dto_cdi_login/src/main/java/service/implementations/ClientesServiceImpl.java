package service.implementations;

import java.util.ArrayList;
import java.util.List;

import dtos.ClienteDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import model.Cliente;
import service.interfaces.ClientesService;
import service.mappers.Mapeador;

public class ClientesServiceImpl implements ClientesService {
	
	
	
	private EntityManager getEntityManager() {
		
		//Por defecto el motor de persistencia suele ser el nombre del proyecto
		//Pero se suele cambiar por otro más corto --> cursoswebPU
		//Se cambia en persistence.xml pestaña general, ver captura 32
		
		//creamos una factoría, que es un objeto para crear otros objetos
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
		
		
	}
	

	@Override
	public ClienteDto autenticarCliente(String usuario, String pwd) {
		
		
		
		// Creamos la query parametrizada por posición. Usuario es un objeto usuario no el nombre de la tabla
		String jpql="select us from Cliente us where us.usuario=?1 and us.password=?2";
		
		//typedquery
		TypedQuery<Cliente> query=getEntityManager().createQuery(jpql, Cliente.class);
		// le pasamos el valor al parámetro de la query
		query.setParameter(1, usuario);
		query.setParameter(2, pwd);
		
		//una forma
		/*
		List<Cliente> clientes=query.getResultList();
		return clientes.size()>0?Mapeador.clienteEntityToDto(clientes.get(0)):null;
		*/
		
		try {
			return Mapeador.clienteEntityToDto(query.getSingleResult());
		}
		catch(Exception ex) {
			return null;
		}
		
		
		
		
		
	}
	
	
	@Override
	public void altaCliente(ClienteDto cliente) {
		EntityManager em=getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(Mapeador.clienteDtoToEntity(cliente));
		tx.commit();
		
	}
	
}

package service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpSession;
import model.Libro;
import model.Tema;
import service.interfaces.LibroService;
import service.mappers.Mapeador;

public class LibrosServiceImpl implements LibroService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	
	
	
	//devolvemos Dtos, y dentro del service trabajamos con los javabean del model (entidades)
	@Override
	public List<TemaDto> getTemas(){
		String jpql="select t from Tema t";
		TypedQuery<Tema> query=getEntityManager().createQuery(jpql,Tema.class);
		
		/*
		//una forma válida
		List<Tema> temas=query.getResultList();
		List<TemaDto> temasDto=new ArrayList<>();
		
		//hay que devolver una lista de dtos Tema
		Mapeador map=new Mapeador();
		for(Tema t:temas) {
			TemaDto temaDto=Mapeador.temaEntityToDto(t);
			temasDto.add(temaDto);
		}
		return temasDto; 
		*/
		
		//con programación funcional convertimos la lista de la bd proporcionada por la query
		//a una listadto usando el mapeador
		return query.getResultList()
				.stream()
				.map(t->Mapeador.temaEntityToDto(t))
				.toList();
		
		
	}
	
	
	//AQUÍ SE PUEDE PAGINAR MANDANDO LA PÁGINA como otro parámetro, Y CAMBIANDO LA QUERY
	//SELECT * FROM libros.clientes LIMIT 3 OFFSET 4;
	@Override
	public List<LibroDto> librosTema(int idTema){
		String jpql="select l from Libro l";
		TypedQuery<Libro> query;
		if(idTema!=0) {
			jpql+=" where l.idTema=?1";
			query=getEntityManager().createQuery(jpql,Libro.class);
			query.setParameter(1, idTema);
		}else{
			query=getEntityManager().createQuery(jpql,Libro.class);
		}
		
		//cogemos stream de objetos libros y lo convertimos en dtos
		return query.getResultList()
				.stream()
				.map(l->Mapeador.libroEntityToDto(l))
				.toList();
		
	}
	
	
	//a partir del isbn que se devuelva un libro
	@Override
	public LibroDto getLibro(int isbn) {
		//búsqueda por clave primario, se puede utilizar find
		return Mapeador.libroEntityToDto(getEntityManager().find(Libro.class, isbn));
	
		
	}
	
	
	//devuelve el objeto Tema si le pasamos el idTema. Para conseguir el nombre de la categoría
	@Override
	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(getEntityManager().find(Tema.class, idTema));
	}
		

	
}


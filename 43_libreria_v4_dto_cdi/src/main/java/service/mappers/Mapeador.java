package service.mappers;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;
import service.LibrosServiceImpl;

public class Mapeador {
	
	//método que una entidad tema del model, la transforma en un Dto
	public static TemaDto temaEntityToDto(Tema tema) {
		//al objeto temaDto le pasamos todos los atributos de Tema del model
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}

	
	public static LibroDto libroEntityToDto(Libro libro) {
		//tiene un campo de más que es temaDto, para tener el nombre de la categoría
		LibrosServiceImpl service=new LibrosServiceImpl();
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				service.getTema(libro.getIdTema()));
		
		
		
	}
	
}

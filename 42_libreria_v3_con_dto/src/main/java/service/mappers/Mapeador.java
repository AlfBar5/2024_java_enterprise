package service.mappers;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;
import service.LibrosService;

public class Mapeador {
	
	//método que una entidad tema del model, la transforma en un Dto
	public static TemaDto temaEntityToDto(Tema tema) {
		//al objeto temaDto le pasamos todos los atributos de Tema del model
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}

	
	public static LibroDto libroEntityToDto(Libro libro) {
		//tiene un campo de más que es temaDto, para tener el nombre de la categoría
		LibrosService service=new LibrosService();
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				service.getTema(libro.getIdTema()));
		
		
		
	}
	
}

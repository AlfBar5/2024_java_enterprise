package service.interfaces;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;

public interface LibroService {

	//devolvemos Dtos, y dentro del service trabajamos con los javabean del model (entidades)
	List<TemaDto> getTemas();

	List<LibroDto> librosTema(int idTema);

	//a partir del isbn que se devuelva un libro
	LibroDto getLibro(int isbn);

	//devuelve el objeto Tema si le pasamos el idTema. Para conseguir el nombre de la categoría
	TemaDto getTema(int idTema);

}
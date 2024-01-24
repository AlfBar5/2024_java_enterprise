package service.mappers;

import dtos.LibroDto;
import dtos.TemaDto;
import dtos.ClienteDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import service.implementations.ClientesServiceImpl;
import service.implementations.LibrosServiceImpl;

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
	
	
	public static ClienteDto clienteEntityToDto(Cliente cliente) {
		//no hace falta idCliente
		ClientesServiceImpl service=new ClientesServiceImpl();
		return new ClienteDto(
				//cliente.getIdCliente(),
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono()
				);
		
		
	}
	
	public static Cliente clienteDtoToEntity(ClienteDto cliente) {
		return new Cliente(0,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
	
}

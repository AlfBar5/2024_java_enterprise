package dtos;



//lombok
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//colocamos antes de la clase lo que queremos que haga la librería LOMBOK
//Coloca el código durante la compilación del código
//@Data agrupa al setter y al getter y tiene más cosas

@NoArgsConstructor
@AllArgsConstructor
@Data

//quitar atributo idTema y ponemos TemaDto para tener el nombre de la categoria 8que está en otra tabla)
public class LibroDto {
	
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	//creamos un objeto de otra clase. Para conseguir el nombre de la categoría (que está en otra tabla)
	private TemaDto temaDto;
	
	

}

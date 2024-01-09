package service;

import java.util.ArrayList;

import model.Curso;

public class CursosService {

	//static, se comparte entre todas las instancias de la clase
	//obligatorio para que no se pierdan los cursos entre instancias del CursosService
	private static ArrayList<Curso> cursos =new ArrayList<>();
	
	
	//Método nuevo curso
	//si hay un curso con el mismo nombre, no se añade y devolverá falso
	public boolean nuevo(String nombre, int duracion, double precio) {
		//declaro variable tipo curso
		Curso curso= new Curso(nombre, duracion, precio);
		
		for(Curso c:cursos) {
			if (c.getNombre().equals(nombre)){
				//si hay un curso igual nos salimos
				return false;
			}
		
		}
		
		//guardamos objeto entero curso en el ArrayList cursos
		cursos.add(curso);
		return true;
		
	}
	
	
	//Método precios curso precio máximo
	public ArrayList<Curso> preciosCursoMax(double precioMax) {
		//creamos ArrayList auxiliar de objetos Curso
		ArrayList<Curso> auxiliar = new ArrayList<>();
		
		//usamos un for para recorrer arraylist principal y si cada curso igual 
		//o inferior al max, será guardado en el arraylist auxiliar
		for(Curso c:cursos) {
			if(c.getPrecio() <=precioMax) {
				auxiliar.add(c);
			}
		}
		
		//devolvemos el arraylist de objetos cursos que cumplen la condición
		return auxiliar;
		
	}
	
	
	//Método eliminar curso
	public void eliminarCurso(String nombre) {
		
		//recorro con for normal porque necesito índices
		for(int i=0; i<cursos.size();i++) {			
			if (cursos.get(i).getNombre().equals(nombre)){
				cursos.remove(i);
				//en cuanto ya hemos encontrado el curso, nos salimos
				break;
			}
		}
		
		
	}
	
	
	//Método modificar duración
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		
		//no necesito índices ahora, usamos el foreach enhanced
		for(Curso c:cursos) {
			if (c.getNombre().equals(nombre)){
				
				c.setDuracion(nuevaDuracion);
				break;
				
			}
		}
		
	}
	
	
	
}

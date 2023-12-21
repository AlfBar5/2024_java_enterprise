package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {

	//static para que la lista esté disponible para todo el proyecto
	//su valor es compartido por todas las instancias que existan
	static List<Producto> productos = new ArrayList<>();
	
	//método alta productos
	public void altaProductos(String nombre, double precio, String categoria) {
		
		productos.add(new Producto(nombre,precio,categoria));
		
	}
	
	
	//método todos los productos
	public List<Producto> todosProductos(){
		
		return
				productos.stream()
				.toList();
	}
	
	
	//método buscar por categoria
	public List<Producto> buscarProductos(String categoria){
		
		
		
		return
				productos.stream()
				.filter(p->p.getCategoria().equals(categoria))
				.toList();
				
		
	}
	
	
	//eliminar producto por nombre
	public void eliminarProducto(String nombre) {
		
		productos.removeIf(p->p.getNombre().equals(nombre));
		
	}
	
	
	
	
}

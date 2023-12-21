package service;

import java.util.ArrayList;
import java.util.List;

import model.Ficha;
import model.Usuario;

public class UsuariosService {
	
	//Lista de usuarios para el login
	List<Usuario> usuarios= new ArrayList<>(List.of(
			new Usuario("user1", "pass1"),
			new Usuario("user2", "pass2"),
			new Usuario("user3", "pass3"),
			new Usuario("user4", "pass4"),
			new Usuario("user5", "pass6"),
			new Usuario("user6", "pass6")
			));
	
	//Lista de fichas de usarios
	List<Ficha> fichas=new ArrayList<>(List.of(
			new Ficha("user1",65,"user1@gmail.com"),
			new Ficha("user2",33,"user2@gmail.com"),
			new Ficha("user3",29,"user3@gmail.com"),
			new Ficha("user4",44,"user4@gmail.com")
			));
	

	public boolean autenticar(String usuario, String pwd) {
		
		/*
		//Solución clásica
		for(Usuario u:usuarios) {
			if(u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd)) {
				return true;
			}
		}
		
		return false;
		*/
		
		//solución programación funcional
		return 
				usuarios.stream()
				.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd));
		
				
		
		
	}
	
	
	//Método que a partir de un usuario devuelva su ficha
	public Ficha fichaUsuario(String usuario) {
		
		for(Ficha f:fichas) {
			if(f.getUsuario().equals(usuario)){
				return f;
			}
		}
		return null;
		
		
		
	}
	
}

package service;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuariosService {
	
	List<Usuario> usuarios= new ArrayList<>(List.of(
			new Usuario("user1", "pass1"),
			new Usuario("user2", "pass2"),
			new Usuario("user3", "pass3"),
			new Usuario("user4", "pass4"),
			new Usuario("user5", "pass6"),
			new Usuario("user6", "pass6")
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
	
}

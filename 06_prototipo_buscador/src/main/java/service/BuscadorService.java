package service;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class BuscadorService {


			List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","musica","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			)); 
	

			//método buscar todos los resultados de la misma temática
			public ArrayList<Resultado> devolresultados(String tematica){
				
				//creo lista de datos tipo arraylist
				ArrayList<Resultado> datos = new ArrayList<>();
				
				for(Resultado s:resultados) {
					if(s.getTematica().equals(tematica)) {
						datos.add(s);
					}
				}
				
				//Programación funcional
				/*
				return 
						(ArrayList<Resultado>) resultados.stream()
					.filter(r->r.getTematica().equals(tematica))
					.toList(); 
				*/
				
				return datos;
			}

	
}

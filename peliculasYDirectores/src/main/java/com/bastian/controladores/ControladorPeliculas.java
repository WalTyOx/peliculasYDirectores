package com.bastian.controladores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class ControladorPeliculas {
	
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	
	
	 @GetMapping
	    public String obtenerTodasLasPeliculas() {
	       
	        List<String> peliculas = new ArrayList<>();

	        
	        for (String pelicula : listaPeliculas.keySet()) {
	            peliculas.add(pelicula);
	        }

	        return String.join(" ", peliculas);
	    }
	 
	 @GetMapping("/{nombre}")
	 public String buscarPorNombre(@PathVariable String nombre) {
		 if (listaPeliculas.containsKey(nombre)) {
			 return "Película: " + nombre + ", Director: " + listaPeliculas.get(nombre);
		 } else {
	            return "La película no se encuentra en nuestra lista.";
	        }
	 }
	 
	 @GetMapping("/director/{nombre}")
	    public String buscarPorDirector(@PathVariable String nombre) {
	        List<String> peliculasDirector = new ArrayList<>();
	        for (HashMap.Entry<String, String> entrada : listaPeliculas.entrySet()) {
	            if (entrada.getValue().equals(nombre)) {
	                peliculasDirector.add(entrada.getKey());
	            }
	        }
	        if (!peliculasDirector.isEmpty()) {
	            return "Películas de " + nombre + ": " + String.join(", ", peliculasDirector);
	        } else {
	            return "No contamos con películas con ese director en nuestra lista.";
	        }
	    }
}

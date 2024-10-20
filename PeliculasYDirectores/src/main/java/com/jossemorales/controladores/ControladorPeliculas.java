package com.jossemorales.controladores;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
	
    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
        return "Winnie the Pooh, El zorro y el sabueso, Tarzán, Mulán, Oliver, Big Hero 6";
    }
	
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
        String director = listaPeliculas.get(nombre);
        if (director != null) {
            return "La película que buscas es " + nombre + " y fue dirigida por " + director;
        } else {
            return "La película no se encuentra en nuestra lista";
        }
    }
	
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
	    String resultado = "Películas de " + nombre + ": ";
	    boolean hayPeliculas = false;


	    for (String pelicula : listaPeliculas.keySet()) {
	        if (listaPeliculas.get(pelicula).equalsIgnoreCase(nombre)) {
	            resultado += pelicula + "; ";
	            hayPeliculas = true;
	        }
	    }

	    if (!hayPeliculas) {
	        return "No contamos con películas con ese director en nuestra lista.";
	    }

	    return resultado;
	}	
}
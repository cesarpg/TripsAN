package com.trips.controllers;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String mostrarHome (Model model) {
		
		model.addAttribute("mensaje", "Hola mundo");

		return "home";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<String>();
		lista.add("En la Montaña");
		lista.add("En la Ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		
		model.addAttribute("listadoTrips", lista);
		
		return "listado";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		List<Trip> lista = getTrips();
		model.addAttribute("trips", lista);
		
		return "trip/tabla";
	}
	

	
	
	private List<Trip> getTrips(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		List<Trip> lista = new LinkedList<>();
		
		try {
			Trip trip1 = new Trip();
			trip1.setId(1);
			trip1.setNomTrip("Rapel En Volcatenando");
			trip1.setDescripcion("Hacer Rapel en curcuitos....");
			trip1.setFecha(sdf.parse("10-05-2026"));
			trip1.setCosto(10.0);
			trip1.setDestacado(0);
			trip1.setImagen("trip01.png");
			
			Trip trip2 = new Trip();
			trip2.setId(2);
			trip2.setNomTrip("Caminatas en Chalatenando");
			trip2.setDescripcion("Bonitas y exigentes caminatas en las montañas de Chalatenango");
			trip2.setFecha(sdf.parse("10-05-2026"));
			trip2.setCosto(10.0);
			trip2.setDestacado(1);
			trip2.setImagen("trip03.png");
			
			lista.add(trip1);
			lista.add(trip2);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		return lista;
	}
	
}

package com.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.models.Trip;
import com.trips.services.ITripServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripServices servicTrip;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		
		Trip trip = servicTrip.buscarPorId(idTrip);
		System.err.println("Trip: " + trip);
		model.addAttribute("trip", trip.getId());
		
		return "detalle";
	}
	
	
}

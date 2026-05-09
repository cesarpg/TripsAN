package com.trips.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Trip;

@Service
public class TripServiceImpl implements ITripServices{

	List<Trip> lista = null;
	
	public TripServiceImpl() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		lista = new LinkedList<>();
		
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
			
			Trip trip3 = new Trip();
			trip3.setId(3);
			trip3.setNomTrip("Volcanes");
			trip3.setDescripcion("Bonitas y exigentes caminatas en las montañas de Chalatenango");
			trip3.setFecha(sdf.parse("10-05-2026"));
			trip3.setCosto(10.0);
			trip3.setDestacado(1);
			trip3.setImagen("trip05.png");
			
			lista.add(trip1);
			lista.add(trip2);
			lista.add(trip3);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	

	@Override
	public List<Trip> buscarTodo() {
		
		return lista;
	}

	@Override
	public Trip buscarPorId(Integer idTrip) {
		for (Trip trip : lista)
			if (trip.getId() == idTrip)
				return trip;
		
		return null;
	}

}

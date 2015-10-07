package tn.esprit.thewalkingdev.services.gestionVenue;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Venue;

@Local
public interface GestionVenueLocal {

	Boolean addVenue(Venue venue);

	Boolean updateVenue(Venue venue);

	Boolean deleteVenue(Venue venue);

	Venue findVenueById(Integer idVenue);

	List<Venue> findAllVenue();
}

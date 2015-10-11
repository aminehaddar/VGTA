package tn.esprit.thewalkingdev.services.gestionEvent;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Event;

/**
 * Session Bean implementation class GestionEvent
 */
@Stateless
public class GestionEvent implements GestionEventRemote, GestionEventLocal {
	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public GestionEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEvent(Event event) {
		try {
			entityManager.persist(event);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean updateEvent(Event event) {
		try {
			entityManager.merge(event);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEvent(Event event) {
		try {
			entityManager.remove(event);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Event findEventbyId(Integer idEvent) {
		Event event = null;
		try {
			event = entityManager.find(Event.class, idEvent);

		} catch (Exception e) {

		}
		return event;
	}

	@Override
	public List<Event> findAllEvents() {
		Query query = entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}

}

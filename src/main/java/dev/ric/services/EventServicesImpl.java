package dev.ric.services;

import java.util.List;

import dev.ric.models.Event;
import dev.ric.repositories.EventRepository;
import dev.ric.repositories.EventRepositoryImpl;

public class EventServicesImpl implements EventRepository{
	public static EventRepository erep = new EventRepositoryImpl();
	public Event getEvent(int id) {
		return erep.getEvent(id);
	};
	public List<Event> getAllEvents(){
		return erep.getAllEvents();
	};
}

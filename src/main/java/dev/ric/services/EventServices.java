package dev.ric.services;

import java.util.List;

import dev.ric.models.Event;

public interface EventServices {
	public Event getEvent(int id);
	public List<Event> getAllEvents();
}

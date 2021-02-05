package dev.ric.repositories;

import java.util.List;

import dev.ric.models.Event;

public interface EventRepository {
public Event getEvent(int id);
public List<Event> getAllEvents();
}

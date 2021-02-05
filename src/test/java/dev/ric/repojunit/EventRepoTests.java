package dev.ric.repojunit;

import org.junit.Test;

import dev.ric.repositories.EventRepository;
import dev.ric.repositories.EventRepositoryImpl;

public class EventRepoTests {

	private static EventRepository erep = new EventRepositoryImpl();

	@Test
	public void test() {

		for (int e = 0; e < erep.getAllEvents().size(); e++) {
			System.out.println(erep.getAllEvents().get(e));
		}
	}
}

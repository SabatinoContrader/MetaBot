package com.contrader.react;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.contrader.react.model.Event;
import com.contrader.react.model.Group;
import com.contrader.react.repository.GroupRepository;

@Component
class Initializer implements CommandLineRunner {

	private final GroupRepository repository;

	public Initializer(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) {
		Stream.of("Denver JUG", "Utah JUG", "Seattle JUG", "Richmond JUG")
				.forEach(name -> repository.save(new Group(name)));

		final Group djug = repository.findByName("Denver JUG");
		final Event e = Event.builder().title("Full Stack Reactive").description("Reactive with Spring Boot + React")
				.date(Instant.parse("2018-12-12T18:00:00.000Z")).build();
		djug.setEvents(Collections.singleton(e));
		repository.save(djug);

		repository.findAll().forEach(System.out::println);
	}
}
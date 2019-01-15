package com.contrader.react.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contrader.react.model.Group;
import com.contrader.react.repository.GroupRepository;

@RestController
@RequestMapping("/api")
public class GroupController {

	private final Logger log = LoggerFactory.getLogger(GroupController.class);
	private final GroupRepository groupRepository;

	public GroupController(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}

	@GetMapping("/groups")
	Collection<Group> groups() {
		return groupRepository.findAll();
	}

	@GetMapping("/group/{id}")
	ResponseEntity<?> getGroup(@PathVariable Long id) {
		final Optional<Group> group = groupRepository.findById(id);
		return group.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/group")
	ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {
		log.info("Request to create group: {}", group);
		final Group result = groupRepository.save(group);
		return ResponseEntity.created(new URI("/api/group/" + result.getId())).body(result);
	}

	@PutMapping("/group")
	ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) {
		log.info("Request to update group: {}", group);
		final Group result = groupRepository.save(group);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/group/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
		log.info("Request to delete group: {}", id);
		groupRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
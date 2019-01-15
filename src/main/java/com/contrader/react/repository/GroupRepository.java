package com.contrader.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contrader.react.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
	Group findByName(String name);
}
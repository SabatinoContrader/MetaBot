package com.pCarpet.dao;

import com.pCarpet.model.Badge;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BadgeRepository extends CrudRepository<Badge, Long> 
{

   	
   }

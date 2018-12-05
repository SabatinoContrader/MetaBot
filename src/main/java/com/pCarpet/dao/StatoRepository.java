package com.pCarpet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pCarpet.model.Stato;

@Repository
public interface StatoRepository extends CrudRepository<Stato, Long>{

}

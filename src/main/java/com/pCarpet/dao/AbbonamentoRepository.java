package com.pCarpet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pCarpet.model.Abbonamento;

@Repository
public interface AbbonamentoRepository extends CrudRepository<Abbonamento, Long>{

	
	
}

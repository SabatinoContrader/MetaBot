package com.pCarpet.dao;

import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface AssegnaRepository extends CrudRepository<Assegnazione, Long> {
	
	//Assegnazione findByIdbadgeAndFlag(long idbadge,long flag);
	
	List<Assegnazione> findAllBybadge(Badge idbadge);
	
//	@Modifying
//	@Query(value= "insert into assegnazione (iduser,idbadge,dataassegnazione,nome,cognome,flag) values (?1,?2,?3,?4,?5,?6)",nativeQuery=true)
//	public void insert(long iduser, long idbadge,String dataassegnazione, String nome, String cognome,  long flag);
//	
	
	
}

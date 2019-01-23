package com.contrader.react.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contrader.react.model.Nodo;

@Repository
public interface NodoRepository extends CrudRepository<Nodo, Integer> {

	public List<Nodo> findAllByOrderByIdNodoAsc();

	public List<Nodo> findByNodoPadreIsNull();

	public Nodo findByIdNodo(Integer idNodo);

	@Query(value = "select * from nodo n where n.id_nodo_padre is null and n.id_nodo not in (select c.id_nodo from chatbot c ); ", nativeQuery = true)
	public List<Nodo> nodiSenzaPadreDisponibili();

	public List<Nodo> findAllByNodoPadre(Nodo nodoPadre);

	@Modifying
	@Transactional
	@Query(value = "update nodo n set n.contatore_nodo = n.contatore_nodo+1 where n.id_nodo = :idNodo", nativeQuery = true)
	public void updateContatore(@Param("idNodo") Integer idNodo);

}

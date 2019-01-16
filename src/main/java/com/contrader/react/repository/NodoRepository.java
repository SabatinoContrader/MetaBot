package com.contrader.react.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contrader.react.model.Nodo;
@Repository
public interface NodoRepository extends CrudRepository<Nodo, Integer> {

	public List<Nodo> findAllByOrderByIdNodoAsc();

	public List<Nodo> findByNodoPadreIsNull();

	public Nodo findByIdNodo(Integer idNodo);

	@Query(value = "select * from nodo n where n.id_nodo_padre is null and n.id_nodo not in (select c.id_nodo from chatbot c ); ", nativeQuery = true)
	public List<Nodo> nodiSenzaPadreDisponibili();

	
	@Query(value = "select 1 from nodo n where n.id_nodo_padre = ?1", nativeQuery = true)
	public Integer findUserByIdNodoPadre(Integer id);
	
	public List<Nodo> findAllByNodoPadre (Nodo nodoPadre);
}

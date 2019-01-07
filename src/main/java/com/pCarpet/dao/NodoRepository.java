package com.pCarpet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pCarpet.model.Nodo;

public interface NodoRepository extends CrudRepository<Nodo, Integer> {

	public List<Nodo> findAllByOrderByIdNodoAsc();

	public List<Nodo> findByNodoPadreIsNull();

	public Nodo findByIdNodo(Integer idNodo);

	@Query(value = "select * from nodo n where n.id_nodo_padre is null and n.id_nodo not in (select c.id_nodo from chatbot c ); ", nativeQuery = true)
	public List<Nodo> nodiSenzaPadreDisponibili();

}

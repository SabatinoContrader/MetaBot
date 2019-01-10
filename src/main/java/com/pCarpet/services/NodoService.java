package com.pCarpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.ConverterNodo;
import com.pCarpet.dao.NodoRepository;
import com.pCarpet.dto.NodoDTO;
import com.pCarpet.model.Nodo;

@Service
public class NodoService {

	private final NodoRepository nodoRepository;

	@Autowired
	public NodoService(NodoRepository nodoRepository) {
		this.nodoRepository = nodoRepository;
	}

	public List<NodoDTO> findByNodoPadreIsNull() {
		final List<Nodo> list = nodoRepository.findByNodoPadreIsNull();

		final List<NodoDTO> listDTO = new ArrayList<>();
		for (final Nodo nodo : list) {
			listDTO.add(ConverterNodo.toDTO(nodo));
		}
		return listDTO;
	}

	public List<NodoDTO> findAllNodesDTO() {

		final List<Nodo> list = nodoRepository.findAllByOrderByIdNodoAsc();

		final List<NodoDTO> listDTO = new ArrayList<>();
		for (final Nodo nodo : list) {
			listDTO.add(ConverterNodo.toDTO(nodo));
		}
		return listDTO;
	}

	public void deleteById(Integer idNodo) {
		nodoRepository.deleteById(idNodo);
	}

	public NodoDTO findByIdNodoDTO(Integer idNodo) {
		return ConverterNodo.toDTO(nodoRepository.findById(idNodo).get());
	}

	public List<Nodo> trovaNodiSenzaPadreDisponibili() {
		return nodoRepository.nodiSenzaPadreDisponibili();
	}

	public Nodo update(NodoDTO nodoFiglio) {
		return nodoRepository.save(ConverterNodo.toEntity(nodoFiglio));

	}

	public Nodo save(NodoDTO nodo) {
		return nodoRepository.save(ConverterNodo.toEntity(nodo));

	}

	public Integer findUserByIdNodoPadre(Integer idNodoPadre) {
		if (nodoRepository.findUserByIdNodoPadre(idNodoPadre) == null) {
			return 0;
		} else {
			return 1;
		}
	}

}

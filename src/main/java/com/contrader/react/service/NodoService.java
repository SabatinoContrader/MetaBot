package com.contrader.react.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrader.react.converter.ConverterNodo;
import com.contrader.react.dto.NodoDTO;
import com.contrader.react.model.Nodo;
import com.contrader.react.repository.NodoRepository;

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

	public NodoDTO save(NodoDTO nodo) {
		return ConverterNodo.toDTO(nodoRepository.save(ConverterNodo.toEntity(nodo)));

	}

	public List<NodoDTO> findAllByNodoPadre(NodoDTO nodopadre) {
		return ConverterNodo.toListNodoDTO(nodoRepository.findAllByNodoPadre(ConverterNodo.toEntity(nodopadre)));
	}

	public void updateContatore(Integer idNodoScelto) {
		nodoRepository.updateContatore(idNodoScelto);
	}

}
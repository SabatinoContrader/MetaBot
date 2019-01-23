package com.contrader.react.converter;

import java.util.ArrayList;
import java.util.List;

import com.contrader.react.dto.NodoDTO;
import com.contrader.react.model.Nodo;

public class ConverterNodo {
	public static NodoDTO toDTO(Nodo nodo) {
		NodoDTO nodoDTO = null;
		if (nodo != null) {
			nodoDTO = new NodoDTO();
			nodoDTO.setIdNodo(nodo.getIdNodo());
			nodoDTO.setText(nodo.getText());
			nodoDTO.setPath(nodo.getPath());
			nodoDTO.setNodoPadre(ConverterNodo.toDTO(nodo.getNodoPadre()));
			nodoDTO.setTipoNodo(nodo.getTipoNodo());
		}
		return nodoDTO;
	}

	public static Nodo toEntity(NodoDTO nodoDTO) {
		Nodo nodo = null;
		if (nodoDTO != null) {
			nodo = new Nodo();
			nodo.setIdNodo(nodoDTO.getIdNodo());
			nodo.setTipoNodo(nodoDTO.getTipoNodo());
			nodo.setText(nodoDTO.getText());
			nodo.setPath(nodoDTO.getPath());
			if (nodoDTO.getNodoPadre() != null) {
				nodo.setNodoPadre(ConverterNodo.toEntity(nodoDTO.getNodoPadre()));
			}
		}
		return nodo;
	}

	public static List<NodoDTO> toListNodoDTO(List<Nodo> list) {
		final List<NodoDTO> nodoDTOs = new ArrayList<>();
		for (final Nodo nodo : list) {
			final NodoDTO nuovoNodoDaConvertire = ConverterNodo.toDTO(nodo);
			nodoDTOs.add(nuovoNodoDaConvertire);
		}
		return nodoDTOs;
	}

	public static List<Nodo> toListNodoEntity(List<NodoDTO> listDTO) {

		final List<Nodo> nodos = new ArrayList<>();
		for (final NodoDTO nodoDTO : listDTO) {
			final Nodo nuovoNodoDaConvertire = ConverterNodo.toEntity(nodoDTO);
			nodos.add(nuovoNodoDaConvertire);
		}
		return nodos;
	}
}

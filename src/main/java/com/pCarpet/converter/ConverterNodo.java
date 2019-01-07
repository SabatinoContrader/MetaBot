package com.pCarpet.converter;

import com.pCarpet.dto.NodoDTO;
import com.pCarpet.model.Nodo;

public class ConverterNodo {
	public static NodoDTO toDTO(Nodo nodo) {
		NodoDTO nodoDTO = null;
		if (nodo != null) {
			nodoDTO = new NodoDTO();
			nodoDTO.setIdNodo(nodo.getIdNodo());
			nodoDTO.setText(nodo.getText());
			nodoDTO.setNodoPadre(ConverterNodo.toDTO(nodo.getNodoPadre()));
		}
		return nodoDTO;
	}

	public static Nodo toEntity(NodoDTO nodoDTO) {
		Nodo nodo = null;
		if (nodoDTO != null) {
			nodo = new Nodo();
			nodo.setIdNodo(nodoDTO.getIdNodo());
			nodo.setText(nodoDTO.getText());
			if (nodo.getNodoPadre() != null) {
				nodo.setNodoPadre(ConverterNodo.toEntity(nodoDTO.getNodoPadre()));
			}
		}
		return nodo;
	}

}

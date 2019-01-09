package com.pCarpet.converter;

import java.util.ArrayList;
import java.util.List;

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
			if (nodoDTO.getNodoPadre() != null) {
				nodo.setNodoPadre(ConverterNodo.toEntity(nodoDTO.getNodoPadre()));
			}
		}
		return nodo;
	}

	
	public static List<NodoDTO> toListNodoDTO(List<Nodo> list){

		List<NodoDTO> nodoDTOs = new ArrayList<>();
		
		for (Nodo nodo : list) {
		
			NodoDTO nuovoNodoDaConvertire = ConverterNodo.toDTO(nodo);
			nodoDTOs.add(nuovoNodoDaConvertire);
								
		}
			
		return nodoDTOs;
	}
	
	public static List<Nodo> toListNodoEntity(List<NodoDTO> listDTO){

		List<Nodo> nodos = new ArrayList<>();
		
		for (NodoDTO nodoDTO : listDTO) {
		
			Nodo nuovoNodoDaConvertire = ConverterNodo.toEntity(nodoDTO);
			nodos.add(nuovoNodoDaConvertire);
								
		}
			
		return nodos;
	}
}

package com.pCarpet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodoDTO {

	private Integer idNodo;
	private String text;
	private NodoDTO nodoPadre;
	private String tipoNodo;
	private String path;
}

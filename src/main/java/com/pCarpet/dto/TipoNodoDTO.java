package com.pCarpet.dto;

import java.util.ArrayList;
import java.util.List;

import com.pCarpet.model.Nodo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoNodoDTO {

	private Integer idTipoNodo;
	private String label;
}

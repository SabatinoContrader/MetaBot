package com.pCarpet.converter;

import com.pCarpet.dto.AssetDTO;
import com.pCarpet.model.Asset;

public class AssetNoIdConverter {

	public static Asset converToEntity(AssetDTO assetDTO) {

		Asset a=new Asset();
		a.setDescrizione(assetDTO.getDescrizione());
		a.setPrezzo(assetDTO.getPrezzo());
		a.setTipo(assetDTO.getTipo());
		
		
		return a;
	}
	
	
	public static AssetDTO convertToDTO(Asset a) {
		
		AssetDTO aDTO=new AssetDTO();
		aDTO.setDescrizione(a.getDescrizione());
		aDTO.setTipo(a.getTipo());
		aDTO.setPrezzo(a.getPrezzo());
		
		return aDTO;
		
	}
	
}

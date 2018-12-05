package com.pCarpet.converter;

import com.pCarpet.dto.AssetDTO;
import com.pCarpet.model.Asset;

public class AssetConverter{

	public static Asset converToEntity(AssetDTO assetDTO) {

		Asset a=new Asset();
		a.setIdasset(assetDTO.getIdAsset());
		a.setDescrizione(assetDTO.getDescrizione());
		a.setPrezzo(assetDTO.getPrezzo());
		a.setTipo(assetDTO.getTipo());
		a.setFlag(assetDTO.getFlag());
		
		
		return a;
	}
	
	
	public static AssetDTO convertToDTO(Asset a) {
		
		AssetDTO aDTO=new AssetDTO();
		aDTO.setIdAsset(a.getIdasset());
		aDTO.setDescrizione(a.getDescrizione());
		aDTO.setTipo(a.getTipo());
		aDTO.setPrezzo(a.getPrezzo());
		aDTO.setFlag(a.getFlag());
		
		return aDTO;
		
	}
	
	
	
}

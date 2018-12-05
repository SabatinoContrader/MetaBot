package com.virtualpairprogrammers.service;

import javax.servlet.http.HttpServletRequest;
import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.model.Asset;

import java.util.List;

public class AssetService {

    private AssetDAO assetDAO;

    public AssetService() {
        this.assetDAO = new AssetDAO();
    }

    public List<Asset> getAllAssets () {
        return this.assetDAO.getAllAssets();
    }
    
    public List<Asset> getAsset (int id) {
        return this.assetDAO.getAsset(id);
    }
    
    public List<Asset> getAllAssetsN () {
        return this.assetDAO.getAllAssetsN();
    }

    public boolean insertAsset (Asset asset) {
        return this.assetDAO.insertAsset(asset);
    }
    public boolean deleteAsset (int idasset) {
    	return this.assetDAO.DeleteAsset(idasset);
    }
    
    public boolean updateAsset(HttpServletRequest request) {
    	return this.assetDAO.updateAsset(request);
    }
      	
}



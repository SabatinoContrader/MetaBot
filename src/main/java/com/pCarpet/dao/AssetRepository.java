package com.pCarpet.dao;
import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;
import com.pCarpet.model.Asset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssetRepository extends CrudRepository<Asset, Long>{
//	String param="";
//	
//	private final String QUERY_ALL = "select * from asset";
//    private final String QUERY_INSERT = "insert into asset (tipo,descrizione,prezzo) values (?,?,?)";
//    private final String QUERY_DEL = "delete from asset where idasset = ?";
//    private final String QUERY_ASSETN ="SELECT asset.idasset,asset.tipo,asset.prezzo,asset.descrizione FROM asset where asset.idasset not in(select a.idasset from asset as a,badgereader as b where a.idasset=b.idasset)";
//   // private final String QUERY_UPDATE="update asset set "+param+"=? where idasset=?";
//    /* query ALL_BADGE_SSN da modificare in base alla relazione movimento
//   // private final String QUERY_ALLBADGEASSN = "select b.idbadge,tipologia,descrizione from userasset as o right join asset as b on o.idasset=b.idasset where o.idasset is null";
//	*/
//    public AssetRepository() {
//    	
//    }
//	
//    public List<Asset> getAllAssets () {
//        List<Asset> assets = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
//           while (resultSet.next()) {
//        	   int idAsset = resultSet.getInt("idasset");
//        	   String tipo = resultSet.getString("tipo");
//               String descrizione = resultSet.getString("descrizione");
//               double prezzo = resultSet.getDouble("prezzo");
//               assets.add(new Asset(idAsset,tipo,descrizione,prezzo));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assets;
//    }
//    
//    public List<Asset> getAllAssetsN () {
//        List<Asset> assets = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_ASSETN);
//           while (resultSet.next()) {
//        	   int idAsset = resultSet.getInt("idasset");
//        	   String tipo = resultSet.getString("tipo");
//               String descrizione = resultSet.getString("descrizione");
//               double prezzo = resultSet.getDouble("prezzo");
//               assets.add(new Asset(idAsset,tipo,descrizione,prezzo));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assets;
//    }
//    
//    public Asset getAsset (int id) {
//        Asset assets=null;
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery("select * from asset where idasset="+id);
//           while (resultSet.next()) {
//        	   int idAsset = resultSet.getInt("idasset");
//        	   String tipo = resultSet.getString("tipo");
//               String descrizione = resultSet.getString("descrizione");
//               double prezzo = resultSet.getDouble("prezzo");
//               assets =new Asset(idAsset,tipo,descrizione,prezzo);
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assets;
//    }
//    /*
//    //query ALLBADGEASSN da verificare in base a movimento
//    public List<Badge> getAllBadgesN () {
//        List<Badge> badges = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_ALLBADGEASSN);
//           while (resultSet.next()) {
//        	   int idBadge = resultSet.getInt("idbadge");
//        	   String tipologia = resultSet.getString("tipologia");
//               String descrizione = resultSet.getString("descrizione");
//               badges.add(new Badge(idBadge,tipologia,descrizione));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return badges;
//    }
//    */
//    public boolean insertAsset(Asset asset) {
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
//            preparedStatement.setString(1, asset.getTipo());
//            preparedStatement.setString(2, asset.getDescrizione());
//            preparedStatement.setDouble(3, asset.getPrezzo());
//            preparedStatement.execute();
//            return true;
//        }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//
//    }
//    
//    public boolean deleteAsset(int idAsset) {
//    	Connection connection = ConnectionSingleton.getInstance();
//    	try {
//    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DEL);
//            preparedStatement.setInt(1,idAsset);
//            preparedStatement.execute();
//            return true;
//    }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }	
//    }
//    
//    public boolean updateAsset(HttpServletRequest request) {
//   	 Connection connection = ConnectionSingleton.getInstance();
//        try {
//        	String param="";
//        	param=(String)request.getParameter("campo");
//        	
//       	 int id=Integer.parseInt(request.getParameter("id"));
//       	//System.out.println(id);
//        	PreparedStatement preparedStatement = connection.prepareStatement("update asset set "+param+"=? where idasset=?");
//            
//        	String prezzoS=request.getParameter("nuovoCampo");
//        	if(param.equals("prezzo")) {
//        		prezzoS=prezzoS.replace(',', '.');
//        	}
//        	
//        	preparedStatement.setString(1, prezzoS);
//        	preparedStatement.setInt(2,id);
//       //     preparedStatement.setInt(2, Integer.parseInt(request.getParameter("id")));
//            preparedStatement.execute();
//            return true;
//        }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//   	
//   }
}

package com.pCarpet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pCarpet.dto.ExportDTO;
import com.pCarpet.model.Badge;
import com.pCarpet.model.BadgeReader;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.User;

@Repository
@Transactional
public interface MovimentoRepository extends CrudRepository<Movimento,Long>{

	Movimento findByBadgereaderAndBadgeAndOrainizio(BadgeReader badgereader, Badge idbadge, String orainizio);
	
	Movimento findByBadgereaderAndBadgeAndOrafine(BadgeReader badgereader, Badge idbadge, String orafine);
	//FAI L'ENTITY EXPORT E INSERISCILA AL POSTO DI EXPORTDTO
	
//	//@Modifying
//	@Query(value="select new com.pCarpet.dto.ExportDTO(u.iduser, u.ragioneSociale, a.nome, a.cognome, m.datainizio, m.datafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione) from user as u, movimento as m, assegnazione as a, badgereader as b, asset as ass where a.iduser=u.iduser and a.idbadge=m.idbadge and m.idbadgereader=b.idbadgereader and b.idasset=ass.idasset", nativeQuery=true)
//	public List<ExportDTO> findAllExportMov();
//	
//	//@Modifying
//	@Query(value="select u.iduser,u.ragioneSociale, a.nome, a.cognome, m.datainizio, m.datafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione from user as u, movimento as m, assegnazione as a, badgereader as b, asset as ass where a.iduser=u.iduser and a.idbadge=m.idbadge and m.idbadgereader=b.idbadgereader and b.idasset=ass.idasset and u.iduser=?1", nativeQuery=true)
//	public List<ExportDTO> findAllExportMov(String iduser);
	
//    private final String QUERY_ALLMOV = "select * from movimento";
//    private final String QUERY_ALLUSERMOV = "SELECT * from movimento as m,assegnazione as a where m.idbadge=a.idbadge and a.iduser=?";
//    private final String QUERY_SELIDB = "select ";
//    private final String QUERY_INSMOV = "insert into movimento(idbadgereader,idbadge,datainizio,datafine) values (?,?,?,?) ";
//    private final String QUERY_DELMOV = "delete from movimento where idbadgereader=? and idbadge=? and datainizio=?";
//    private final String EXPORT_ALLUSER = "select u.iduser,u.ragioneSociale, a.nome, a.cognome, m.datainizio, m.datafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione from user as u, movimento as m, assegnazione as a, badgereader as b, asset as ass where a.iduser=u.iduser and a.idbadge=m.idbadge and m.idbadgereader=b.idbadgereader and b.idasset=ass.idasset";
//    private final String EXPORT_USER = "select u.iduser,u.ragioneSociale, a.nome, a.cognome, m.datainizio, m.datafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione from user as u, movimento as m, assegnazione as a, badgereader as b, asset as ass where a.iduser=u.iduser and a.idbadge=m.idbadge and m.idbadgereader=b.idbadgereader and b.idasset=ass.idasset and u.iduser=?";
//
//    public boolean assMovimento(int idBadgeReader, int idBadge, String datainizio, String datafine) {
//    	 Connection connection = ConnectionSingleton.getInstance();
//         try {
//             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELIDB);
//             
//             preparedStatement.setInt(2, idBadgeReader);
//             preparedStatement.setInt(1, idBadge);
//             preparedStatement.setString(3, datainizio);
//             preparedStatement.setString(3, datafine);
//             preparedStatement.execute();
//             return true;
//         }
//         catch (SQLException e) {
//             GestoreEccezioni.getInstance().gestisciEccezione(e);
//             return false;
//         }
//    }
//    
//    
//    public List<Movimento> getAllMovimenti() {
//        List<Movimento> movimenti = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery(QUERY_ALLMOV);
//           while (resultSet.next()) {
//        	   int idBadgeReader = resultSet.getInt("idbadgereader");
//        	   int idbadge = resultSet.getInt("idbadge");
//        	   String datainizio = resultSet.getString("datainizio");
//        	   String datafine = resultSet.getString("datafine");
//        	   
//               movimenti.add(new Movimento(idBadgeReader,idbadge,datainizio,datafine));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return movimenti;
//    }
//    
//    public List<Movimento> getAllUserMovimenti(String iduser) {
//        List<Movimento> movimenti = new ArrayList<>();
//        Connection connection = ConnectionSingleton.getInstance();
//        try {
//           Statement statement = connection.createStatement();
//           ResultSet resultSet = statement.executeQuery("SELECT * from movimento as m,assegnazione as a where m.idbadge=a.idbadge and a.iduser="+iduser);
//           while (resultSet.next()) {
//        	   int idBadgeReader = resultSet.getInt("idbadgereader");
//        	   int idbadge = resultSet.getInt("idbadge");
//        	   String datainizio = resultSet.getString("datainizio");
//        	   String datafine = resultSet.getString("datafine");
//        	   
//               movimenti.add(new Movimento(idBadgeReader,idbadge,datainizio,datafine));
//           }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return movimenti;
//    }
//    public boolean deleteMovimento(int idbadgereader, int idbadge, String datainizio) {
//   	 Connection connection = ConnectionSingleton.getInstance();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELMOV);
//            
//            preparedStatement.setInt(1, idbadgereader);
//            preparedStatement.setInt(2, idbadge);
//            preparedStatement.setString(3, datainizio);
//            preparedStatement.execute();
//            System.out.println("OKOKOK");
//            return true;
//        }
//        catch (SQLException e) {
//            GestoreEccezioni.getInstance().gestisciEccezione(e);
//            return false;
//        }
//   }
//public boolean insertMovimento(Movimento movimento) {
//    Connection connection = ConnectionSingleton.getInstance();
//    try {
//        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSMOV);
//        preparedStatement.setLong(1, movimento.getIdbadgereader());
//        preparedStatement.setLong(2, movimento.getIdbadge());
//        preparedStatement.setString(3, movimento.getOrainizio());
//        preparedStatement.setString(4, movimento.getOrafine());
//        preparedStatement.execute();
//        return true;
//    }
//    catch (SQLException e) {
//        GestoreEccezioni.getInstance().gestisciEccezione(e);
//        return false;
//    }
//
//}
//
//
//public List getAllExportMovimenti() {
//    List list = new ArrayList();
//    Connection connection = ConnectionSingleton.getInstance();
//    try {
//       Statement statement = connection.createStatement();
//       ResultSet resultSet = statement.executeQuery(EXPORT_ALLUSER);
//       while (resultSet.next()) {
//    	   int iduser = resultSet.getInt("iduser");
//    	   
//    	   String ragioneSociale = resultSet.getString("ragioneSociale");
//    	   String nome = resultSet.getString("nome");
//    	   String cognome = resultSet.getString("cognome");
//    	   
//    	   int idasset = resultSet.getInt("idasset");
//    	   String tipo = resultSet.getString("tipo");
//    	   double prezzo = resultSet.getDouble("prezzo");
//    	   String descrizione = resultSet.getString("descrizione");
//    	   
//    	   String datainizio = resultSet.getString("datainizio");
//    	   String datafine = resultSet.getString("datafine");
//    	   
//    	   
//    	   
//           list.add(iduser);
//           list.add(ragioneSociale);
//           list.add(nome);
//           list.add(cognome);
//           
//           list.add(idasset);
//           list.add(tipo);
//           list.add(prezzo);
//           list.add(descrizione);
//           
//           list.add(datainizio);
//           list.add(datafine);
//           
//       }
//    }
//    catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return list;
//}
//
//public List getExportMovimento(String iduser1) {
//    List list = new ArrayList();
//    Connection connection = ConnectionSingleton.getInstance();
//    try {
//       Statement statement = connection.createStatement();
//       ResultSet resultSet = statement.executeQuery("select u.iduser,u.ragioneSociale, a.nome, a.cognome, m.datainizio, m.datafine, ass.idasset, ass.tipo, ass.prezzo, ass.descrizione from user as u, movimento as m, assegnazione as a, badgereader as b, asset as ass where a.iduser=u.iduser and a.idbadge=m.idbadge and m.idbadgereader=b.idbadgereader and b.idasset=ass.idasset and u.iduser="+iduser1);
//       while (resultSet.next()) {
//    	   int iduser = resultSet.getInt("iduser");
//    	   
//    	   String ragioneSociale = resultSet.getString("ragioneSociale");
//    	   String nome = resultSet.getString("nome");
//    	   String cognome = resultSet.getString("cognome");
//    	   
//    	   int idasset = resultSet.getInt("idasset");
//    	   String tipo = resultSet.getString("tipo");
//    	   double prezzo = resultSet.getDouble("prezzo");
//    	   String descrizione = resultSet.getString("descrizione");
//    	   
//    	   String datainizio = resultSet.getString("datainizio");
//    	   String datafine = resultSet.getString("datafine");
//    	   
//    	   
//    	   
//           list.add(iduser);
//           list.add(ragioneSociale);
//           list.add(nome);
//           list.add(cognome);
//           
//           list.add(idasset);
//           list.add(tipo);
//           list.add(prezzo);
//           list.add(descrizione);
//           
//           list.add(datainizio);
//           list.add(datafine);
//           
//       }
//    }
//    catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return list;
//}

}

    /*
    public List<UserAsset> getAllUsersAssets () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASS);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public List<UserAsset> getAllStorico () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLSTORICO);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public boolean insertUserAsset(UserAsset userAsset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASS);
            preparedStatement.setInt(1, userAsset.getIduser());
            preparedStatement.setInt(2, userAsset.getIdasset());
            preparedStatement.setString(3, userAsset.getOrainizio());
            preparedStatement.setString(4, userAsset.getOrafine());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean insertStorico(UserAsset userasset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASSS);
            preparedStatement.setInt(1, userasset.getIduser());
            preparedStatement.setInt(2, userasset.getIdasset());
            preparedStatement.setString(3, userasset.getOrainizio());
            preparedStatement.setString(4, userasset.getOrafine());   
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
*/
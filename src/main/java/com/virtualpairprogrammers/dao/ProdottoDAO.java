package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.model.ProdottoFornitore;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

        private final String QUERY_INSERT_PRODOTTO = "INSERT INTO prodotto " +
                "(ean," +
                "category," +
                "model," +
                "manufacturer," +
                "description," +
                "long_description," +
                "sell_price) " +
                "VALUES " +
                "(" +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?" +
                ")";

        private final String QUERY_SELECT_PRODOTTO_EAN = "SELECT * FROM prodotto WHERE EAN = ?";

        private final String QUERY_INSERT_PRODOTTO_FORNITORE = "INSERT INTO prodotto_fornitore " +
                "(id_prodotto," +
                "id_fornitore," +
                "codice_prodotto_su_fornitore," +
                "quantita," +
                "data_inizio," +
                "data_fine," +
                "prezzo_acquisto) " +
                "VALUES " +
                "(?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?)";

        private final String QUERY_DELETE_PRODOTTO_FORNITORE = "DELETE FROM prodotto_fornitore " +
                "WHERE " +
                "id_prodotto = ? AND " +
                "id_fornitore = ? AND " +
                "data_inizio = ?";

        private final String QUERY_DELETE_PRODOTTO_FORNITORE_ID_PRODOTTO = "DELETE FROM prodotto_fornitore " +
                "WHERE " +
                "id_prodotto = ?";

        private final String QUERY_GET= "SELECT * FROM prodotto " +
                "WHERE " +
                "id = ?";

        private final String QUERY_GET_BY_EAN= "SELECT * FROM prodotto " +
                "WHERE " +
                "ean = ?";

        private final String QUERY_GET_ALL= "SELECT * FROM prodotto";

        private final String QUERY_GET_PRODOTTI_FORNITORE= "SELECT * FROM prodotto_fornitore " +
                "WHERE " +
                "id_prodotto = ?";

        private final String QUERY_UPDATE="UPDATE prodotto\n" +
                "SET\n" +
                "ean = ?, " +
                "category = ?, " +
                "model = ?, " +
                "manufacturer = ?, " +
                "description = ?, " +
                "long_description = ?, " +
                "sell_price = ? " +
                "WHERE id = ?";

        private final String QUERY_DELETE = "DELETE FROM prodotto\n" +
                "WHERE id = ?";

        public Prodotto get(int id){
            Connection connection = ConnectionSingleton.getInstance();
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                Prodotto prodotto = new Prodotto();
                prodotto.setId(id);
                if (resultSet.next()) {
                    prodotto.setEan(resultSet.getString("ean"));
                    prodotto.setCategory(resultSet.getString("category"));
                    prodotto.setModel(resultSet.getString("model"));
                    prodotto.setManufacturer(resultSet.getString("manufacturer"));
                    prodotto.setDescrizione(resultSet.getString("description"));
                    prodotto.setDescrizioneLunga(resultSet.getString("long_description"));
                    prodotto.setPrezzoVendita(resultSet.getDouble("sell_price"));

                    PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_GET_PRODOTTI_FORNITORE);
                    preparedStatement1.setInt(1, id);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        ProdottoFornitore prodottoFornitore = new ProdottoFornitore();
                        prodottoFornitore.setIdFornitore(resultSet1.getInt("id_fornitore"));
                        prodottoFornitore.setCodiceProdottoFornitore(resultSet1.getString("codice_prodotto_su_fornitore"));
                        prodottoFornitore.setQuantita(resultSet1.getDouble("quantita"));
                        prodottoFornitore.setDataInizio(resultSet1.getDate("data_inizio"));
                        prodottoFornitore.setDataFine(resultSet1.getDate("data_fine"));
                        prodottoFornitore.setPrezzoAcquisto(resultSet1.getDouble("prezzo_acquisto"));
                        prodotto.aggiungiAListaAcquisto(prodottoFornitore);
                    }
                    preparedStatement1.close();
                }
                preparedStatement.close();
                return prodotto;
            }catch (Exception e){
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                System.out.println("Errore nella ricerca dei prodotti");
                return null;
            }
        }

        public Prodotto getByEan(String ean){
            Connection connection = ConnectionSingleton.getInstance();
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET);
                preparedStatement.setString(1, ean);
                ResultSet resultSet = preparedStatement.executeQuery();
                Prodotto prodotto = new Prodotto();
                if (resultSet.next()) {
                    prodotto.setId(resultSet.getInt("id"));
                    prodotto.setEan(resultSet.getString("ean"));
                    prodotto.setCategory(resultSet.getString("category"));
                    prodotto.setModel(resultSet.getString("model"));
                    prodotto.setManufacturer(resultSet.getString("manufacturer"));
                    prodotto.setDescrizione(resultSet.getString("description"));
                    prodotto.setDescrizioneLunga(resultSet.getString("long_description"));
                    prodotto.setPrezzoVendita(resultSet.getDouble("sell_price"));

                    PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_GET_PRODOTTI_FORNITORE);
                    preparedStatement1.setInt(1, prodotto.getId());
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        ProdottoFornitore prodottoFornitore = new ProdottoFornitore();
                        prodottoFornitore.setIdFornitore(resultSet1.getInt("id_fornitore"));
                        prodottoFornitore.setCodiceProdottoFornitore(resultSet1.getString("codice_prodotto_su_fornitore"));
                        prodottoFornitore.setQuantita(resultSet1.getDouble("quantita"));
                        prodottoFornitore.setDataInizio(resultSet1.getDate("data_inizio"));
                        prodottoFornitore.setDataFine(resultSet1.getDate("data_fine"));
                        prodottoFornitore.setPrezzoAcquisto(resultSet1.getDouble("prezzo_acquisto"));
                        prodotto.aggiungiAListaAcquisto(prodottoFornitore);
                    }
                    preparedStatement1.close();
                }
                preparedStatement.close();
                return prodotto;
            }catch (Exception e){
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                System.out.println("Errore nella ricerca dei prodotti");
                return null;
            }
        }

        public List<Prodotto> getAll(){
            List<Prodotto> prodotti = new ArrayList<Prodotto>();
            Connection connection = ConnectionSingleton.getInstance();
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Prodotto prodotto = new Prodotto();
                    prodotto.setId(resultSet.getInt("id"));
                    prodotto.setEan(resultSet.getString("ean"));
                    prodotto.setCategory(resultSet.getString("category"));
                    prodotto.setModel(resultSet.getString("model"));
                    prodotto.setManufacturer(resultSet.getString("manufacturer"));
                    prodotto.setDescrizione(resultSet.getString("description"));
                    prodotto.setDescrizioneLunga(resultSet.getString("long_description"));
                    prodotto.setPrezzoVendita(resultSet.getDouble("sell_price"));

                    PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_GET_PRODOTTI_FORNITORE);
                    preparedStatement1.setInt(1, prodotto.getId());
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        ProdottoFornitore prodottoFornitore = new ProdottoFornitore();
                        prodottoFornitore.setIdFornitore(resultSet1.getInt("id_fornitore"));
                        prodottoFornitore.setCodiceProdottoFornitore(resultSet1.getString("codice_prodotto_su_fornitore"));
                        prodottoFornitore.setQuantita(resultSet1.getDouble("quantita"));
                        prodottoFornitore.setDataInizio(resultSet1.getDate("data_inizio"));
                        prodottoFornitore.setDataFine(resultSet1.getDate("data_fine"));
                        prodottoFornitore.setPrezzoAcquisto(resultSet1.getDouble("prezzo_acquisto"));
                        prodotto.aggiungiAListaAcquisto(prodottoFornitore);
                    }
                    preparedStatement1.close();
                    prodotti.add(prodotto);
                }
                preparedStatement.close();
                return prodotti;  //<-- ritorna
            }catch (Exception e){
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                System.out.println("Errore nella ricerca dei prodotti");
                return null;
            }
        }

        // Restituisce l' id del prodotto appena inserito
        // In caso di errore restituisce:
        // -1 Errore generico
        // -2 Non ci sono righe in listaAcquisto
        // -3 Le date inizio e fine in lista acquisto non sono corrette
        public int update(Prodotto prodotto){
            // ATTENZIONE VERIFICARE CHE CI SIA ALMENO UNA RIGA DI PRODOTTOFORNITORE
            Connection connection = ConnectionSingleton.getInstance();
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
                int i = 1;
                preparedStatement.setString(i++,prodotto.getEan());
                preparedStatement.setString(i++,prodotto.getCategory());
                preparedStatement.setString(i++,prodotto.getModel());
                preparedStatement.setString(i++,prodotto.getManufacturer());
                preparedStatement.setString(i++,prodotto.getDescrizione());
                preparedStatement.setString(i++,prodotto.getDescrizioneLunga());
                preparedStatement.setDouble(i++,prodotto.getPrezzoVendita());
                preparedStatement.setInt(i++,prodotto.getId());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                for (ProdottoFornitore prodottoFornitore: prodotto.getListaAcquisto()) {
                    preparedStatement = connection.prepareStatement(QUERY_DELETE_PRODOTTO_FORNITORE_ID_PRODOTTO);
                    i = 1;
                    preparedStatement.setInt(i++, prodotto.getId());
                    preparedStatement.execute();
                    preparedStatement.close();

                    preparedStatement = connection.prepareStatement(QUERY_INSERT_PRODOTTO_FORNITORE);
                    i = 1;
                    preparedStatement.setInt(i++, prodotto.getId());
                    preparedStatement.setInt(i++, prodottoFornitore.getidFornitore());
                    preparedStatement.setString(i++, prodottoFornitore.getCodiceProdottoFornitore());
                    preparedStatement.setDouble(i++, prodottoFornitore.getQuantita());
                    preparedStatement.setDate(i++, new java.sql.Date(prodottoFornitore.getDataInizio().getTime()));
                    if(prodottoFornitore.getDataFine() != null)
                        preparedStatement.setDate(i++, new java.sql.Date(prodottoFornitore.getDataFine().getTime()));
                    else
                        preparedStatement.setDate(i++, null);
                    preparedStatement.setDouble(i++, prodottoFornitore.getPrezzoAcquisto());
                    preparedStatement.execute();
                    preparedStatement.close();
                }
                return 0;
            }
            catch (Exception e){
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return -1;
            }

        }

        public int delete(int id){
            Connection connection = ConnectionSingleton.getInstance();
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
                preparedStatement.setInt(1, id);
                boolean result = preparedStatement.execute();
                preparedStatement.close();
                return 0;
            }catch (Exception e){
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return -1;
            }
        }

        // Restituisce l' id del prodotto appena inserito
        // In caso di errore restituisce:
        // -1 Errore generico
        // -2 Non ci sono righe in listaAcquisto
        // -3 Le date inizio e fine in lista acquisto non sono corrette
        public int insert(Prodotto prodotto) {
            // ATTENZIONE VERIFICARE CHE CI SIA ALMENO UNA RIGA DI PRODOTTOFORNITORE
            Connection connection = ConnectionSingleton.getInstance();
            int productId = -1;
            try {
                // Verifichiamo la presenza dell' EAN nel nostro db
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_PRODOTTO_EAN);
                preparedStatement.setString(1, prodotto.getEan());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    productId = resultSet.getInt("id");
                }
                preparedStatement.close();
                // Se il prodotto non esiste lo aggiungiamo
                if(productId == -1){
                    String generatedColumns[] = { "id" };
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_PRODOTTO, generatedColumns);
                    int i = 1;
                    preparedStatement.setString(i++,prodotto.getEan());
                    preparedStatement.setString(i++,prodotto.getCategory());
                    preparedStatement.setString(i++,prodotto.getModel());
                    preparedStatement.setString(i++,prodotto.getManufacturer());
                    preparedStatement.setString(i++,prodotto.getDescrizione());
                    preparedStatement.setString(i++,prodotto.getDescrizioneLunga());
                    preparedStatement.setDouble(i++,prodotto.getPrezzoVendita());
                    preparedStatement.execute();
                    resultSet = preparedStatement.getGeneratedKeys();
                    while (resultSet.next()) {
                        productId = resultSet.getInt(1);
                    }
                    preparedStatement.close();
                }

                for (ProdottoFornitore prodottoFornitore: prodotto.getListaAcquisto()) {
                    preparedStatement = connection.prepareStatement(QUERY_DELETE_PRODOTTO_FORNITORE);
                    int i = 1;
                    preparedStatement.setInt(i++, productId);
                    preparedStatement.setInt(i++, prodottoFornitore.getidFornitore());
                    preparedStatement.setDate(i++, new java.sql.Date(prodottoFornitore.getDataInizio().getTime()));
                    preparedStatement.execute();
                    preparedStatement.close();

                    preparedStatement = connection.prepareStatement(QUERY_INSERT_PRODOTTO_FORNITORE);
                    i = 1;
                    preparedStatement.setInt(i++, productId);
                    preparedStatement.setInt(i++, prodottoFornitore.getidFornitore());
                    preparedStatement.setString(i++, prodottoFornitore.getCodiceProdottoFornitore());
                    preparedStatement.setDouble(i++, prodottoFornitore.getQuantita());
                    preparedStatement.setDate(i++, new java.sql.Date(prodottoFornitore.getDataInizio().getTime()));
                    if(prodottoFornitore.getDataFine() != null)
                        preparedStatement.setDate(i++, new java.sql.Date(prodottoFornitore.getDataFine().getTime()));
                    else
                        preparedStatement.setDate(i++, null);
                    preparedStatement.setDouble(i++, prodottoFornitore.getPrezzoAcquisto());
                    preparedStatement.execute();
                    preparedStatement.close();
                }


            } catch (Exception e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return -1;
            }
            return productId;
        }

    public boolean insertProdotto(Prodotto prodotto) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_PRODOTTO);
            preparedStatement.setInt(1,prodotto.getId());
            preparedStatement.setString(2, prodotto.getEan());
            preparedStatement.setString(3, prodotto.getCategory());
            preparedStatement.setString(4, prodotto.getModel());
            preparedStatement.setString(5, prodotto.getManufacturer());
            preparedStatement.setString(6, prodotto.getDescrizione());
            preparedStatement.setString(7, prodotto.getDescrizioneLunga());
            preparedStatement.setDouble(8, prodotto.getPrezzoVendita());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            System.out.println("ERRORE DI LETTURA NEL DATABASE");
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public List<Prodotto> search (String parameterOne, String parameterTwo){
        String QUERY_SEARCH = "select * from prodotto where " + parameterOne + "=?";
        List<Prodotto> listprodotto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SEARCH);
            preparedStatement.setString(1, parameterTwo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String ean = resultSet.getString("ean");
                String category = resultSet.getString("category");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                String descrizione = resultSet.getString("description");
                String descrizioneLunga = resultSet.getString("long_description");
                double prezzoVendita = resultSet.getDouble("sell_price");
                listprodotto.add(new Prodotto(id,ean,category,model,manufacturer,descrizione,descrizioneLunga,prezzoVendita));
            }
        }catch (SQLException e) {
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            System.out.println(".> ERRORE DI DIGITAZIONE DELLA PRIMA PAROLA CHIAVE <.");
        }
        return listprodotto;
    }

}

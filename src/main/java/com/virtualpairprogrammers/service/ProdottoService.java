package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.ProdottoDAO;
import com.virtualpairprogrammers.model.Fornitore;
import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.model.ProdottoFornitore;
import com.virtualpairprogrammers.utils.FornitoreFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ProdottoService {

    private ProdottoDAO prodottoDAO;

    public ProdottoService() {
        this.prodottoDAO = new ProdottoDAO();
    }

    public List<Prodotto> getProdottiDisponibili(){
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        List<Fornitore> fornitori = FornitoreFactory.getInstance().getFornitori();
        for(int i=0;i<fornitori.size();i++){
            List<Prodotto> catalogoFornitore = fornitori.get(i).getCatalogoProdotti();
            for(int j = 0; j < catalogoFornitore.size(); j++){
                Prodotto prodottoDalFornitore = catalogoFornitore.get(j);
                ProdottoFornitore prodottoFornitore = new ProdottoFornitore(fornitori.get(i).getId(),"" + prodottoDalFornitore.getId(),1, new Date(118,0,1), null, prodottoDalFornitore.getPrezzoVendita());
                int indiceProdotto = cercaEanProdotto(prodottoDalFornitore, prodotti);
                if(indiceProdotto >= 0){
                    prodotti.get(indiceProdotto).aggiungiAListaAcquisto(prodottoFornitore);
                }else{
                    prodottoDalFornitore.aggiungiAListaAcquisto(prodottoFornitore);
                    prodotti.add(prodottoDalFornitore);
                }
            }
        }
        return prodotti;
    }

    public void aggiornaProdottiDaFornitori(){
        List<Prodotto> prodotti = getProdottiDisponibili();
        prodotti.forEach(prodotto -> {prodottoDAO.insert(prodotto);});
    }

    public Prodotto get(int id){
        return prodottoDAO.get(id);
    }

    public void update(Prodotto prodotto){
        prodottoDAO.update(prodotto);
    }

    public void delete(int id){
        prodottoDAO.delete(id);
    }

    private int cercaEanProdotto(Prodotto prodotto, List<Prodotto> catalogo){
        for(int i = 0; i < catalogo.size(); i++){
            if(catalogo.get(i).getEan() == prodotto.getEan())
                return i;
        }
        return -1;
    }

    // FUNZIONA SOLO PER CATEGORIA SISTEMARE !!!
    public List<Prodotto> search (String parameterOne, String parameterTwo) {
        List<Prodotto> prodotti = getAllProdotti();
        List<Prodotto> prodottiFiltrati = new ArrayList<Prodotto>();
        prodotti.forEach(prodotto -> {
            if(prodotto.getCategory() != null && prodotto.getCategory().contains(parameterTwo))
                prodottiFiltrati.add(prodotto);
        });
        return prodottiFiltrati;
    }

   /* public List<ProdottoFornitore> prodottoFornitore(){
        return this.prodottoDAO.prodottoFornitore();
    }

    public boolean insertRequestBuy(Acquisto acquisto){
       return false;
       //return this.prodottoDAO.insertRequestBuy(acquisto);
   }*/

    public List<Prodotto> getAllProdotti () {
        return this.prodottoDAO.getAll();
    }

    public int insert (Prodotto prodotto) {
        //return false;
        return this.prodottoDAO.insert(prodotto);
    }

    public List<Prodotto> searchProduct(String parameterOne, String parameterTwo){
        return prodottoDAO.search(parameterOne,parameterTwo);
    }

    public boolean deleteProdotto (int prodotto) {
        return false;
        //return this.prodottoDAO.deleteProdotto(prodotto);
    }

    public Prodotto getProdotto (int barCode) {
        return null;
        //return this.prodottoDAO.getProdotto(barCode);
    }


    public boolean modifyProdotto (Prodotto pro, int id) {
        return false;
        //return this.prodottoDAO.modifyProdotto(pro,id);
    }
}
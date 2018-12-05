package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.model.Canale;
import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.utils.Amazon;
import com.virtualpairprogrammers.utils.Privol;

import java.util.List;

public class VenditaService {

    public VenditaService() {
    }


    public List<Prodotto> getCatalogoVendita(int canale, double margine, List<Prodotto> listProdotti) {

        Canale canaleVendita = null;
        if (canale == 1) {
            canaleVendita = new Amazon();
        } else if (canale == 2) {
            canaleVendita = new Privol();
        }


        listProdotti.forEach(prodotto -> {
            prodotto.setPrezzoVendita(prodotto.getPrezzoAcquisto() * (1 + margine));
        });
        if (canaleVendita != null)
            canaleVendita.setCatalogoProdotti(listProdotti);

        return listProdotti;
    }

}

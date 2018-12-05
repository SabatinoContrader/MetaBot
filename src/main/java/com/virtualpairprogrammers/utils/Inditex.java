package com.virtualpairprogrammers.utils;

import com.virtualpairprogrammers.model.Fornitore;
import com.virtualpairprogrammers.model.Prodotto;

import java.util.LinkedList;
import java.util.List;

public class Inditex implements Fornitore {

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        prodotti.add(new Prodotto(123,"EAN PROVA 1","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 100));
        prodotti.add(new Prodotto(1233,"EAN PROVA 2","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 50));
        prodotti.add(new Prodotto(123456,"EAN PROVA 3","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 80));
        prodotti.add(new Prodotto(11,"EAN PROVA 4","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 30));
        prodotti.add(new Prodotto(124,"EAN PROVA 5","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 150));
        prodotti.add(new Prodotto(23,"EAN PROVA 6","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 200));
        return prodotti;
    }

    @Override
    public int getId() {
        return 2;
    }

}

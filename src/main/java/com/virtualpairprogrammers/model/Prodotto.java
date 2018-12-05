package com.virtualpairprogrammers.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Prodotto {

    private int id;
    private String ean;
    private String category;
    private String model;
    private String manufacturer;
    private String descrizione;
    private String descrizioneLunga;
    private List<ProdottoFornitore> listaAcquisto;
    private double prezzoVendita;

    public Prodotto() {
        this.listaAcquisto = new ArrayList<ProdottoFornitore>();
    }

    public Prodotto(int id, String ean, String category, String model, String manufacturer, String descrizione, String descrizioneLunga, double prezzoVendita) {
        this();
        this.id = id;
        this.ean = ean;
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
        this.descrizione = descrizione;
        this.descrizioneLunga = descrizioneLunga;
        this.prezzoVendita = prezzoVendita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizioneLunga() {
        return descrizioneLunga;
    }

    public void setDescrizioneLunga(String descrizioneLunga) {
        this.descrizioneLunga = descrizioneLunga;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void aggiungiAListaAcquisto(ProdottoFornitore prodottoFornitore){
        listaAcquisto.add(prodottoFornitore);
    }

    public List<ProdottoFornitore> getListaAcquisto(){
        return listaAcquisto;
    }

    public void setListaAcquisto(List<ProdottoFornitore> listaAcquisto) {
        this.listaAcquisto = listaAcquisto;
    }

    public void rimuoviDaListaAcquisto(int idFornitore){
        // Da implementare
    }

    public double getPrezzoAcquisto(){
        if(listaAcquisto.size() == 0)
            return -1;
        double prezzoAcquisto = listaAcquisto.get(0).getPrezzoAcquisto();
        for(int i = 1; i < listaAcquisto.size(); i++) {
            if (listaAcquisto.get(i).getPrezzoAcquisto() < prezzoAcquisto) {
                prezzoAcquisto = listaAcquisto.get(i).getPrezzoAcquisto();
            }
        }
        return prezzoAcquisto;
    }

    @Override
    public String toString() {
        String returnString = "Prodotto{" +
                "id =" + id +
                ", ean=" + ean +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", prezzoAcquisto='" + getPrezzoAcquisto() + '\'' +
                ", prezzoVendita='" + getPrezzoVendita() + '\'' +
                ", listaAcquisto=' \n       ";
        for(ProdottoFornitore prodottoFornitore:listaAcquisto)
            returnString += "[" + prodottoFornitore.toString() + "]\n       ";
        returnString += "}";
        return returnString;
    }
}

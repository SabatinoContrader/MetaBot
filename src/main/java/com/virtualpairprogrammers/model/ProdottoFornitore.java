package com.virtualpairprogrammers.model;

import java.util.Date;

public class ProdottoFornitore {

    private int idFornitore;
    private String codiceProdottoFornitore;
    private double quantita;
    private Date dataInizio;
    private Date dataFine;
    private Double prezzoAcquisto;

    public ProdottoFornitore() {
    }

    public ProdottoFornitore(int idFornitore, String codiceProdottoFornitore, double quantita, Date dataInizio, Date dataFine, Double prezzoAcquisto) {
        this.idFornitore = idFornitore;
        this.codiceProdottoFornitore = codiceProdottoFornitore;
        this.quantita = quantita;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public int getidFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public String getCodiceProdottoFornitore() {
        return codiceProdottoFornitore;
    }

    public void setCodiceProdottoFornitore(String codiceProdottoFornitore) {
        this.codiceProdottoFornitore = codiceProdottoFornitore;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    @Override
    public String toString() {
        return "ProdottoFornitore{" +
                "idFornitore=" + idFornitore +
                ", codiceProdottoFornitore='" + codiceProdottoFornitore + '\'' +
                ", quantita=" + quantita +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", prezzoAcquisto=" + prezzoAcquisto +
                '}';
    }
}

package com.virtualpairprogrammers.model;

public class Assegnazione {

	private int iduser;
	private int idbadge;
	private String dataassegnazione;
	
    public Assegnazione(int iduser,int idbadge,String dataassegnazione) {
    	this.iduser = iduser;
    	this.idbadge = idbadge;
        this.dataassegnazione = dataassegnazione;
    }
    public int getIdUtente() {
    	return iduser;
    }
    public int getIdBadge() {
    	return idbadge;
    }
    public String getData() {
    	return dataassegnazione;
    }
//    public void setId(int iduser) {
//    this.iduser=iduser;
//    
//    }
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public double getPrezzo() {
//        return prezzo;
//    }
//
//    public void setPrezzo(double prezzo) {
//        this.prezzo = prezzo;
//    }
//
//    public String getDescrizione() {
//        return descrizione;
//    }
//
//    public void setDescrizione(String descrizione) {
//        this.descrizione = descrizione;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Gomma gomma = (Gomma) o;
//
//        if (Double.compare(gomma.price, price) != 0) return false;
//        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
//        return manufacturer != null ? manufacturer.equals(gomma.manufacturer) : gomma.manufacturer == null;
//    }

//  @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = model != null ? model.hashCode() : 0;
//        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32)); 
//        return result;
//    }

    @Override
    public String toString() {
        return "\nIdUser:" + iduser + "\n1)IdBadge: " + idbadge + "\n2)Data assegnazione: " + dataassegnazione +"\n";
    }
}

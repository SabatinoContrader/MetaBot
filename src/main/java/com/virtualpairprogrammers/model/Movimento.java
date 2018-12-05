package com.virtualpairprogrammers.model;

public class Movimento {

	private int idbadgereader;
	private int idbadge;
	private String datainizio;
	private String datafine;
	
    public Movimento(int idbadgereader,int idbadge, String datainizio, String datafine) {
    	this.idbadgereader = idbadgereader;
    	this.idbadge = idbadge;
    	this.datainizio = datainizio;
        this.datafine = datafine;
    }
    
    public int getIdbadgereader() {
    	return idbadgereader;
    	
    }
    public void setIdbadgereader(int idbadgereader) {
    this.idbadgereader=idbadgereader;
    
    }
    public int getIdbadge() {
    	return idbadge;
    	
    }
    public void setIdbadge(int idbadge) {
    this.idbadge=idbadge;
    
    }
    public String getDatainizio() {
        return datainizio;
    }

    public void setDatainizio(String datainizio) {
        this.datainizio = datainizio;
    }

    public String getDatafine() {
        return datafine;
    }

    public void setDatafine(String datafine) {
        this.datafine = datafine;
    }

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
        return "\nIdbadgereader:" + idbadgereader + "\nIdbadge: " + idbadge + "\nDatainizio: " + datainizio + "\nDatafine: " + datafine ;
    }
}

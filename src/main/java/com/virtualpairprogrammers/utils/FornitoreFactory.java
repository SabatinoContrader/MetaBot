package com.virtualpairprogrammers.utils;

import com.virtualpairprogrammers.model.Fornitore;

import java.util.LinkedList;
import java.util.List;

public class FornitoreFactory {
    private static FornitoreFactory ourInstance = new FornitoreFactory();

    public static FornitoreFactory getInstance() {
        return ourInstance;
    }

    private FornitoreFactory() {
    }

    public List<Fornitore> getFornitori(){
        List<Fornitore> fornitori = new LinkedList<Fornitore>();
        fornitori.add(new LeroyMerlin());
        fornitori.add(new Brico());
        fornitori.add(new Inditex());
        return fornitori;
    }


}

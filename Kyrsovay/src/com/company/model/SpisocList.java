package com.company.model;

import java.util.ArrayList;

public class SpisocList {
    public ArrayList<Spisoc> Spisocs = new ArrayList<Spisoc>();

    public int getCount(){
        return this.Spisocs.size();
    }
    public int getIndex(Spisoc p){
        return Spisocs.indexOf(p);
    }
    public Spisoc getWorkers(int index){
        return Spisocs.get(index);
    }

    public void add(Spisoc publication) {
        Spisocs.add(publication);
    }

    public void clear() {
        this.Spisocs.clear();
    }

    public Spisoc find(int Index){

        return this.Spisocs.get(Index);
    }
    public void remove(int Index){

        Spisocs.remove(Index);
    }

    public Spisoc search(String fio) {
        for (Spisoc pub : Spisocs) {
            System.out.print(pub.getFio());
            if (pub.getFio().equals(fio)) {
                return pub;
            }
        }
        return null;
    }
}

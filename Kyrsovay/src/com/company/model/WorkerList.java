package com.company.model;

import java.util.ArrayList;

public class WorkerList {
    public ArrayList<Worker> Workers = new ArrayList<Worker>();

    public int getCount(){
        return this.Workers.size();
    }
    public int getIndex(Worker p){
        return Workers.indexOf(p);
    }
    public Worker getWorkers(int index){
        return Workers.get(index);
    }

    public void add(Worker publication) {
        Workers.add(publication);
    }

    public void clear() {
        this.Workers.clear();
    }

    public Worker find(int Index){

        return this.Workers.get(Index);
    }
    public void remove(int Index){

        Workers.remove(Index);
    }

    public Worker search(String fio) {
        for (Worker pub : Workers) {
            System.out.print(pub.getFio());
            if (pub.getFio().equals(fio)) {
                return pub;
            }
        }
        return null;
    }
}

package com.company.model;

public class Worker {
    public String Fio;
    public String Sub;
    public String Post;
    public Integer Age;
    public Integer Nomer_order;
    public String Floor;
    public String Statys;


    public String getStatys() {
        return Statys;
    }

    public String getFio() {
        return Fio;
    }

    public String getSub() {
        return Sub;
    }

    public String getPost() {
        return Post;
    }

    public Integer getAge() {
        return Age;
    }

    public String getFloor() {
        return Floor;
    }

    public Integer getNomer_order() {
        return Nomer_order;
    }

    public Worker(String fio, String sub, String post, Integer age, String floor, String statys, Integer nomer_order) {
        Fio = fio;
        Sub = sub;
        Post = post;
        Age = age;
        Floor = floor;
        Statys= statys;
        Nomer_order=nomer_order;
    }
    public String print() {
        String str="";
        str+="ФИО: "+getFio()+"\n";
        str+="Номер приказа: "+getNomer_order()+"\n";
        str+="Подразделение: "+getSub()+"\n";
        str+="Должность: "+getPost()+"\n";
        str+="Возраст: "+getAge().toString()+"\n";
        str+="Пол: "+getFloor()+"\n";
        return str;
    }
}

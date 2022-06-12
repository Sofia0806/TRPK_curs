package com.company.model;


import java.sql.Date;

public class Spisoc {
    public String Fio;
    public String Sub;
    public String Post;
    public String date1;
    public String date2;

    public Spisoc(String fio, String sub, String post) {
        Fio = fio;
        Sub = sub;
        Post = post;
    }

    public Spisoc(String fio, String sub, String post, String date1, String date2) {
        Fio = fio;
        Sub = sub;
        Post = post;
        this.date1 = date1;
        this.date2 = date2;
    }

    public Spisoc(String fio, String sub, String post, String date1) {
        Fio = fio;
        Sub = sub;
        Post = post;
        this.date1 = date1;
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

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }
}

package com.company.Summative1MartinezLance.models;

public class Quote {

    private String quote;

    private  String author;

    private  int id;

    public Quote(){}

    public Quote(String quote, String author,int id){
        this.author = author;
        this.id = id;
        this.quote = quote;

    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }
    @Override
    public String toString() {
        //update this
        return "Id: " + this.getId() + " Quote: " + this.getQuote() + " Author: " + this.getAuthor();
    }
}

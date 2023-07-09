package com.company.Summative1MartinezLance.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Word {
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private String word;
    private String definition;

    public Word(){

    }
    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
        id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return word + '\'' +
                ", definition='" + definition + '\'';
    }
}

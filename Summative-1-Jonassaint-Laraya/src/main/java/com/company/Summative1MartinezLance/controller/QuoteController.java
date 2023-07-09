package com.company.Summative1MartinezLance.controller;

import com.company.Summative1MartinezLance.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


import java.util.ArrayList;
import java.util.List;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    private static int idCounter = 1;

    public QuoteController(){

        quoteList = new ArrayList<>();

        quoteList.add(new Quote("If your looking right your not looking left","Aaron",idCounter++));
        quoteList.add(new Quote("Am I a man or am I a muppet","Gary",idCounter++));
        quoteList.add(new Quote("Lets a go!","Chris Prat",idCounter++));
        quoteList.add(new Quote("Perfectly balanced as all things should be","Thanos",idCounter++));
        quoteList.add(new Quote("You only live once","Drake",idCounter++));
        quoteList.add(new Quote("Working on the weekend like usual","Drake",idCounter++));
        quoteList.add(new Quote("Do not pray for an easy life, pray for the strength to endure a difficult one.","Bruce lee",idCounter++));
        quoteList.add(new Quote("The single most powerful thing I can be is to be myself.","Dwayne",idCounter++));
        quoteList.add(new Quote("To laugh at your self is to love yourself","Mickey",idCounter++));
        quoteList.add(new Quote("I do what I do. Always.","Shaq",idCounter++));

    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getRandomQuote(){
        Random rand = new Random();
        int randomInt = rand.nextInt(10);
        return quoteList.get(randomInt);
    }

}

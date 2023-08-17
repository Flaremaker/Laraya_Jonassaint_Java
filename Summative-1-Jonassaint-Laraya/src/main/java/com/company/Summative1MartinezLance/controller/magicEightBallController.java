package com.company.Summative1MartinezLance.controller;

import com.company.Summative1MartinezLance.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class magicEightBallController {
    private static int idCounter = 0; // used to track answer objects
    private static Random random = new Random(); // used to select a random answer
    // our list of responses for the "askEightBallQuestion" route to pull from
    private static List<String> responsePool = new ArrayList<>(Arrays.asList(
            new String("Yes"), new String("Signs point to yes"),
            new String("As I see it, yes"), new String("Ask again later"),
            new String("Concentrate and ask again"), new String("Better not tell you now"),
            new String("Don't count on it"), new String("My sources say no"),
            new String("No")
    ));
    // controller class list of Answers formed via user's POST requests
    // private static List<Answer> answerList = new ArrayList<>();


    // route to POST question string and receive Answer object
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer askEightBallQuestion (@RequestBody (required = false) Answer answer) {
        // including this incase a user includes nothing in the request body
        if (answer == null) {
            Answer ans = new Answer();
            ans.setQuestion("");
            ans.setId(idCounter++);
            ans.setAnswer(responsePool.get(random.nextInt(8)));
            //answerList.add(ans);
            return ans;
        }
        answer.setId(idCounter++);
        answer.setAnswer(responsePool.get(random.nextInt(8)));
        //answerList.add(answer);
        return answer;
    }

}

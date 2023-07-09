package com.company.Summative1MartinezLance.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.company.Summative1MartinezLance.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    private List<Word> wordsList;
    public WordController(){
        Word enigma = new Word("Enigma", "A puzzling or inexplicable occurrence or situation");
        Word cry = new Word("Cry", "To shed tears, often noisily");
        Word laughter = new Word("Laughter", "The action of sound of laughing");
        Word awkward = new Word("Awkward", "Causing difficulty, hard to do or deal with");
        Word wholesome = new Word("Wholesome", "Conducive to or promoting moral well-being");
        Word panda = new Word("Panda", "A large bearlike mammal with characteristic black and white markings");
        Word syrup = new Word("Syrup", "A thick sweet liquid made by dissolving sugar in boiling water");
        Word coconut = new Word("Coconut", "The large, oval, brown seed of a tropical palm with a hard shell with edible white flesh and a clear liquid");
        Word brilliant = new Word("Brilliant", "Exceptionally clever or talented");
        Word billboard = new Word("Billboard", "A large outdoor board for displaying advertisements");
        Word foreign = new Word("Foreign", "Of, from, in, or characteristic of a country or language other than one's own");
        Word festival = new Word("Festival", "A day or period of celebration, typically a religious commemoration");

        wordsList = Arrays.asList(enigma, cry, laughter, awkward, wholesome, panda, syrup, coconut, brilliant, billboard, foreign, festival);
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getWord(){
        Random rand = new Random();
        Word randomElement = wordsList.get(rand.nextInt(wordsList.size()));
        return randomElement;
    }
}

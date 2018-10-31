package com.shivora.example.javajokes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JokeProvider {
    private static String[] jokes = new String[]{
      "Q: Why do birds fly south in the Fall? \n\n A: Because it's too far to walk.",
      "Forget about the past, you can't change it.\n\nForget about the future, you can't predict it.\n\nForget about the present, I didn't get you one.",
      "Q: Where do you find reindeer?\n\nA: It depends on where you leave them!",
      "Person 1: Do you know how to use Outlook?\n\nPerson 2: As a matter of fact, I Excel at it.\n\nPerson 1: Was that a Microsoft Office pun?\n\nPerson 2: Word.",
      "Guy: I'm sorry. I hate when we fight cuz I really like you too and wanna be with you too and everytime we fight I feel like I'm gonna make u lose all the feelings u have for me and I don't want that cuz I like when you like me back.\n" +
              "\n" +
              "Girl: I love you too … But who are you?"
    };

    public static String getAJoke(){
        Random random = new Random();
        int index = random.nextInt(jokes.length);
        System.out.println("Joke at index: "+index+" = "+jokes[index]);
        return jokes[index];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pellecarlsen
 */
public class ControlEngine implements WordPairControlInterface {

    private ArrayList<WordPair> word;
    int previousQuestion;
    

    public ControlEngine() {
        word = new ArrayList<WordPair>();
        int previousQuestion = 0;
    }

    @Override
    public void add(String question, String answer) {
        WordPair w = new WordPair(question, answer,1);
        word.add(w);
    }

    @Override
    public int size() {
        return word.size();
    }

    @Override
    public String getRandomQuestion() {
        int randomQuestion;
        int randomGenerator = 0;
        do {
            randomQuestion = RandomQuestion.roll(word.size());
           if(randomQuestion == previousQuestion)
               randomQuestion = RandomQuestion.roll(word.size());
        } while (randomGenerator!=1);
        String question = word.get(randomQuestion).getQuestion() + "";
        previousQuestion = randomQuestion;
        return question;
    }

        @Override
        public boolean checkGuess
        (String question, String quess
        
            ) {
        Boolean check = false;
            for (int i = 0; i < word.size(); i++) {
                if (question.equalsIgnoreCase(word.get(i).getQuestion())) {
                    if (quess.equalsIgnoreCase(word.get(i).getQuess())) {
                        check = true;
                    }
                }
            }
            return check;
        }

        @Override
        public String lookup
        (String question
        
            ) {
        for (int i = 0; i < word.size(); i++) {
                if (question.equals(word.get(i).getQuestion())) {
                    String answer = word.get(i).getQuess();
                    return answer;
                }

            }
            return null;
        }

        @Override
        public boolean load
        (String filename
        
            ) {
        if (Filehandler.loadWord("Word.txt") != null) {
                word = Filehandler.loadWord("Word.txt");
                return true;
            } else {
                return false;
            }

//word = Filehandler.loadWord(filename);
        }

        @Override
        public boolean save
        (String filename
        
            ) {
        if (Filehandler.saveWord(word, "Word.txt") == true) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public void clear
        
            () {
        word.clear();
        }

    }

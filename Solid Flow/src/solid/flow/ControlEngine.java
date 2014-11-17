/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pellecarlsen
 */
public class ControlEngine implements WordPairControlInterface {

    private ArrayList<Word> word;

    public ControlEngine() {
        word = new ArrayList<Word>();
    }

    @Override
    public void add(String question, String answer) {
        Word w = new Word(question, answer);
        word.add(w);
    }

    @Override
    public int size() {
        return word.size();
    }

    @Override
    public String getRandomQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(word.size());
        String question = word.get(randomNumber).getQuestion()+"";
        return question;
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        Boolean check = false;
        for (int i = 0; i < word.size(); i++) {
            if (question.equals(word.get(i).getQuestion())) {
                if (quess.equals(word.get(i).getQuess())) {
                    check = true;
                }
            }
        }
        return check;
    }

    @Override
    public String lookup(String question) {
        for (int i = 0; i < word.size(); i++) {
            if (question.equals(word.get(i).getQuestion())) {
                String answer = word.get(i).getQuess();
                return answer;
            }

        }
        return null;
    }

    @Override
    public boolean load(String filename) {
        if (Filehandler.loadWord("Word.txt") != null) {
            word = Filehandler.loadWord("Word.txt");
            return true;
        } else {
            return false;
        }

//word = Filehandler.loadWord(filename);
    }

    @Override
    public boolean save(String filename) {
        if (Filehandler.saveWord(word, "Word.txt") == true) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void clear() {
        word.clear();
    }

}

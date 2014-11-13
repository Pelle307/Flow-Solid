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
import java.util.Scanner;

/**
 *
 * @author pellecarlsen
 */
public class SolidFlow implements WordPairControlInterface {

    ArrayList<Word> word;

    public SolidFlow() {
    }

    @Override
    public void add(String question, String answer) {
        Word w = new Word(question, answer);
        word.add(w);
        System.out.println(word);
    }

    @Override
    public int size() {
        return word.size();
    }

    @Override
    public String getRandomQuestion() {
        return null;
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        return false;
    }

    @Override
    public String lookup(String question) {
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
    }

}

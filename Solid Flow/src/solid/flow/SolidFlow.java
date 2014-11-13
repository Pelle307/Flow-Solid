/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

import java.util.ArrayList;

/**
 *
 * @author pellecarlsen
 */
public class SolidFlow implements WordPairControlInterface{
    ArrayList<Word> word;
    
    public SolidFlow(){
        word = new ArrayList<Word>();
    }
    @Override
    public void add(String question, String answer) {
        Word w = new Word(question,answer);
        word.add(w);
    }

    @Override
    public int size() {
        return 0;
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
        return true;
    }

    @Override
    public boolean save(String filename) {
        return true;
    }

    @Override
    public void clear() {
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // testede at det virker.
//        ArrayList<Word> wordArray = Filehandler.loadWord("word.txt");
//        System.out.println(wordArray);
    }
    
}

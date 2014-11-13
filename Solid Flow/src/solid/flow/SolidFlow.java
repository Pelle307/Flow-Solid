/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pellecarlsen
 */
public class SolidFlow implements WordPairControlInterface{
    ArrayList<Word> word;
    
    public SolidFlow(){   
    }
    @Override
    public void add(String question, String answer) {
        Word w = new Word(question,answer);
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
        
        Scanner file_scanner = null;
        word = new ArrayList();

        try {
            file_scanner = new Scanner(new File(filename));  //Connection to the file using the Scanner object
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return false;  //If something goes wrong the method returns null
        }
        while (file_scanner.hasNextLine()) {  //File found. Reading one line. 
            String linje = file_scanner.nextLine();
            Scanner sc = new Scanner(linje).useDelimiter(",");
            String danishWord = sc.next();
            String englishWord = sc.next();
            Word w = new Word(danishWord, englishWord);
            System.out.println(w);
            word.add(w);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return true;    //returning the arraylist
        


//word = Filehandler.loadWord(filename);
        
    }

    @Override
    public boolean save(String filename) {
        return true;
    }

    @Override
    public void clear() {
    }

}

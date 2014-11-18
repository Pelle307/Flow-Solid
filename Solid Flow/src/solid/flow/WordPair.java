/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

/**
 *
 * @author pellecarlsen
 */
public class WordPair {
    String Question;
    String Quess;
    
    public WordPair (String danishWord, String englishWord){
        this.Question = danishWord;
        this.Quess = englishWord;
        Quess.equalsIgnoreCase(getQuess());
    }
    @Override
    public String toString() {
        return Question + "," + Quess;
    }

    public String getQuestion() {
        return Question;
    }

    public String getQuess() {
        return Quess;
    }

    
}

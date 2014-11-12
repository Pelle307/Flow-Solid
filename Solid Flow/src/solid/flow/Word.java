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
public class Word {
    String DanishWord;
    String EnglishWord;
    
    public Word (String danishWord, String englishWord){
        this.DanishWord = danishWord;
        this.EnglishWord = englishWord;
    }
    @Override
    public String toString() {
        return DanishWord + "," + EnglishWord;
    }
    
}

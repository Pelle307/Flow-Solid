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
public class ControlEngine implements WordPairControlInterface{

    @Override
    public void add(String question, String answer) {
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
    
}

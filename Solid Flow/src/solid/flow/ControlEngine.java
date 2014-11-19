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
    int getQuestion;

    public ControlEngine() {
        word = new ArrayList<WordPair>();
        getQuestion = 0;
    }

    @Override
    public void add(String question, String answer) {
        WordPair w = new WordPair(question, answer, 1);
        word.add(w);
    }

    @Override
    public int size() {
        return word.size();
    }

    @Override
    public String getRandomQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        String question = null;
        int randomQuestion = 0;
        do {
            int isAll3 = 0;
            randomQuestion = random.nextInt(word.size());
            if (randomNumber <= 80) {
                if (word.get(randomQuestion).getScore() == 1) {
                    question = word.get(randomQuestion).getQuestion() + "";
                    getQuestion = 0;
                }
            } else if (randomNumber >= 81 && randomNumber <= 94) {
                if (word.get(randomQuestion).getScore() == 2) {
                    question = word.get(randomQuestion).getQuestion() + "";
                    getQuestion = 0;

                }
            } else if (randomNumber >= 95) {
                if (word.get(randomQuestion).getScore() == 3) {
                    question = word.get(randomQuestion).getQuestion() + "";
                    getQuestion = 0;
                }
            }
            for (int i = 0; i < word.size(); i++) {
                if (word.get(i).getScore() == 3) {
                    isAll3 += 1;
                }
                if (isAll3 == word.size()) {
                    for (int j = 0; j < word.size(); j++) {
                        word.get(j).setScore(1);
                    }
                }
            }
        } while (getQuestion == 1);
        return question;
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        Boolean check = false;
        for (int i = 0; i < word.size(); i++) {
            if (question.equalsIgnoreCase(word.get(i).getQuestion())) {
                if (quess.equalsIgnoreCase(word.get(i).getQuess())) {
                    check = true;
                    if (word.get(i).getScore() == 1) {
                        word.get(i).setScore(2);
                    } else {
                        word.get(i).setScore(3);
                    }
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

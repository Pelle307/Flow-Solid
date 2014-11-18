/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.flow;

import java.util.Random;

/**
 *
 * @author pellecarlsen
 */
public class RandomQuestion {

    public static int roll(int i){
        Random random = new Random();
        int randomQuestion = random.nextInt(i);
        return randomQuestion;
    }
}

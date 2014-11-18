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
public class Filehandler {

    /**
     * The method loads strings from disk. The file resides in the project folder.
     *
     * Make sure to check for null before using the return value!
     *
     * @param filename String the name of the file (that is located in the project folder).
     * @return and ArrayList<String> were each String object is one line in the file.
     * If something goes wrong and an exception is raised this method will return null!
     */
    
    public static ArrayList<WordPair> loadWord(String filename)
    {
        Scanner file_scanner = null;
        ArrayList<WordPair> wordArray = new ArrayList<WordPair>();

        try {
            file_scanner = new Scanner(new File(filename));  //Connection to the file using the Scanner object
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return null;  //If something goes wrong the method returns null
        }
        while (file_scanner.hasNextLine()) {  //File found. Reading one line. 
            String linje = file_scanner.nextLine();
            Scanner sc = new Scanner(linje).useDelimiter(",");
            String danishWord = sc.next();
            String englishWord = sc.next();
            WordPair w = new WordPair(danishWord, englishWord);
            System.out.println(w);
            wordArray.add(w);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return wordArray;    //returning the arraylist
    }

    /**
     * This method saves an ArrayList of strings to disk.
     * Each string object in this array will be one line in the text file. 
     * The text file is overwritten, what ever was in there is lost. 
     *
     * @param stringArray ArrayList<String> Each String object in this array will be 
     * saved as one line in the text file. 
     * @params filename String the name of the file (that is located in the project folder).
     * @return true if everything went well. False if an exception was raised.
     */
       
    public static boolean saveWord(ArrayList<WordPair> wordArray, String filename)
    {
        if( wordArray == null ) { return false;  }  //Checking parameter for null.
        FileWriter output;  //Creating reference for filewriter.
        
        try {
                output = new FileWriter(new File(filename));  //Opening connection to file.
                for (WordPair wordline : wordArray) {   //running through the ArrayList.                    
                    output.write(wordline.toString() + "\n");  //Each String object is written as a line in file.
            }

            output.close();  //Closing the file
        } catch (Exception ex) {  //If something goes wrong everything is send to system out.
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
            ex.printStackTrace();
            return false;  //If something goes wrong false is returned!
        }

        return true;
    }

}
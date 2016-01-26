/*
 *
 * Homework2 question1 - 10-601A Introduction to Machine Learning
 * Author : Satvik Dhandhania
 * Date : 01/19/2016 Time: 3:00am
 * This program parses a file to find out all words in it 
 * and form a dictionary.
 */

/* Imports */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.TreeMap;

public class question1 {

    public static void main (String args[]) throws IOException{

        StringBuilder s = new StringBuilder();
        int c;
        String words[];
        FileInputStream fin;
        /* Read Input file */
        try
        {
            fin = new FileInputStream(args[0]);
        }
        catch(FileNotFoundException fex)
        {
            fex.printStackTrace();
            return;
        }
        /* Reads individual characters till End of file is encountered */
        while((c = fin.read())!=-1)
        {	   
            s.append((char) c);
        }
        /* Creates array of words without \n and splits based on spaces*/
        words = s.toString().replaceAll("\n"," ").split(" ");
        /* Creates a map */
        NavigableMap<String, Integer> nmap = new TreeMap<String, Integer>();
        /* Trims words and adds to map */
        for (int i = 0; i < words.length; i++) 
        {
            words[i] = words[i].toLowerCase().trim();
            nmap.put(words[i], 1);
        }
        /* Reverse sort map */
        nmap = nmap.descendingMap();
        int commaCorrection = 0;
        /* Print formatted output */
        for (String key : nmap.keySet())
        {
            if(commaCorrection == 0 )
            {
                System.out.print(key);
                commaCorrection =1;
            }
            else
                System.out.print(","+key);
        }
        fin.close();
    }
}

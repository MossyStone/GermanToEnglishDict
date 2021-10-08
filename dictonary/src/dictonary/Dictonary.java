/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictonary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rm305567
 */
public class Dictonary {

    /**
     * @param args the command line arguments
     */
    private Map<String, String> words;
    
    
//public static void main(String [] args)
//{
//        try {
//            Dictonary t = new Dictonary();
//            t.getTranslate("cabeza");
//        } catch (IOException ex) {
//            Logger.getLogger(Dictonary.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//}
    
    public Dictonary() throws FileNotFoundException, IOException
    {
    //Buffer Reader and Buffer Writer 
    //read in words from file and put in map
     words = new HashMap<String, String>();
     BufferedReader read = new BufferedReader(new FileReader("germanDictionary.txt"));
     String line;
        while((line = read.readLine()) != null)
        {
            //uses readLine to read line in doc then serapte via white spaces
            String[] word = line.split("\\s+");
            //System.out.println(word[1]);
            words.put(word[0] , word[1]);
        }
        read.close();
        //System.out.println(words);
    }       
            
     //Translatr method
            //Takes word and translates it
    public String getTranslate(String has)
    {
        //first determin langauge of word
        //cycel through keys 1st
        has.toLowerCase();
        String translation = "";
        boolean foundKey = false;
        
        if(words.containsKey(has))
        {
            translation = words.get(has);
        }
        
        else if(words.containsValue(has))
        {
            for (Entry<String, String> entry : words.entrySet()) 
            {
                if (entry.getValue().equalsIgnoreCase(has)) 
                {
                    translation = entry.getKey();
                    foundKey = true;
                }
            }
            
            //If no other values are there and foundkey is false run this
            if(!foundKey)
            {
                translation = "Word is not here";
            }
        }
        
        //if neither are tre straight away
        else
        {
            translation = "Word is not here";
        }
        
        
        
//        System.out.println(translation);
        return translation;
    
    }
        
    public void addWord(String nWord, String definition) throws FileNotFoundException, IOException
    {
        String newWords = nWord.toLowerCase() + "\t" + definition.toLowerCase();
        BufferedWriter writer = new BufferedWriter(new FileWriter("germanDictionary.txt", true));
        writer.newLine();
        writer.write(newWords);
        writer.close();
        words.put(nWord.toLowerCase(), definition.toLowerCase());
    }
}


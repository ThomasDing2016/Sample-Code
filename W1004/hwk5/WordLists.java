//*************
// A Word List class that generates word lists for scrabble players
//
//*************

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class WordLists{
    
    //instance variables
    private String[] words; //array of words taken in 
    private int wordCount;
    private File name;
    private Boolean hasLetter;

    //constructor    
    public WordLists(String fileName) throws FileNotFoundException {//throws exception because it takes and scans a file
	wordCount=0;
	name=new File(fileName);
	hasLetter=null;
	Scanner listScanner=new Scanner(name);
	while(listScanner.hasNextLine()){
	    listScanner.nextLine();
	    wordCount++;
	}
	listScanner.close();
	words=new String [wordCount];
	Scanner secondScanner=new Scanner(name);
	for(int i=0; i<wordCount; i++){
	    words[i]=secondScanner.nextLine();
	}
	secondScanner.close();
    }
    
    public String[] lengthN(int n){
	// returns an array of words of length n
	int i=0;
	String[] ofLength=new String[wordCount];
	while(i<words.length){
	    if((words[i].length())==n){
		ofLength[i]=words[i];
	    }
	    i++;
	}
	return ofLength;
    }
    
    public String[] startsWith(int n, char firstLetter){
	//returns an array of words of length n beginning with the letter firstLetter          
	int i=0;
	String[] ofFirst=new String[wordCount];
	while(i<words.length){
	    if ((words[i].length()==n)&&(words[i].charAt(0)==firstLetter)){		
		ofFirst[i]=words[i];
	    }
	    i++;
	}
	return ofFirst;
    }
    
    public String[] containsLetter(int n, char included){
	//returns an array of words, length n, including letter but not started with it
	int i=0;
	String[] includesLetter=new String[wordCount];
	while(i<words.length){
	    if(hasLetter(words[i],included)){ //calls on helper method
		if((words[i].charAt(0)!=included) && (words[i].length()==n)){
		    includesLetter[i]=words[i];
		}
	    }
	    i++;
	}
	return includesLetter;
    }
    
    private Boolean hasLetter(String x, char included){ //returns a Boolean when the character wanted is found in a word in the dictionary
	Boolean hasLetter=null;
	int j=0;
	for(j=0; j<x.length()-1; j++){
	    if(x.charAt(j)==included)
		hasLetter=true;
	    else 
		hasLetter=false;
	    //	    System.out.println("the value of j inside for loop" +j);
	}
	//	System.out.println("the value of j outside loop "+j);
	//	System.out.println("has letter is "+hasLetter);
	return hasLetter;
    }
    
    
    public String[] vowelHeavy(int n, int m){ 
	//array of words containing at least m vowels
	int i=0;
	String[] includesVowel=new String[wordCount];
	while(i<words.length){
	    if ((vowelCount(words[i])>=m)&&(words[i].length()==n)){  // calls on helper metho vowelCount
		includesVowel[i]=words[i];
	    }
	    i++;
	}
	return includesVowel;
    }
    
    private int vowelCount(String x){ //counts the number of vowels in a word
	final String VOWELS="aeiou";
	int vowelCount=0;
	for(int v=0; v<x.length(); v++){
	    for(int w=0; w<VOWELS.length(); w++){
		char vowel=VOWELS.charAt(w);
		if (x.charAt(v)==vowel)
		    vowelCount++;
	    }
	}
	return vowelCount;
    }	
    
    public String[] multiLetter(int m, char included){
	//array if words with at least m occurrences of letter
	int i=0;
	String[] includesLetter=new String[wordCount];
	while(i<words.length){
	    if(letterCount(words[i],included)>=m){ //calls on helper method letterCount
                includesLetter[i]=words[i];
	    }
	    i++;
        }
        return includesLetter;
    }
    
    private int letterCount(String x, char included){ // counds the number of letters in a word
	int letterCount=0;
	for(int l=0; l<x.length()-1; l++){
	    if (x.charAt(l)==included){
		letterCount++;
	    }
	}
	return letterCount;
    }
    
    public void check(String[] x){ //performs a check of a String array, returning the contents of said array
        for (int i=0; i < wordCount; i++){
            System.out.println("The contents are "+ x[i]);
        }
    }
    public String[] containsTwo(int n, char in, char alsoIn){ //returns words length n including letters In and alsoIn
	int i=0;
	String[] containsTwo=new String[wordCount];
	while(i<words.length){
	    if((hasLetter(words[i],in)) && (hasLetter(words[i],alsoIn)) && (words[i].length()==n)){ // calls on helper method hasLetter
		containsTwo[i]=words[i];
		//	System.out.println("hey there, I like to ignore loops");		
		//		System.out.println("this is i" + i);		
		check(containsTwo);
	    }
	    i++;
	}
	return containsTwo;
    }
    
    public String[] yesAndNo(int n, char in, char out){ // returns words length n including the letters in but not out
	int i=0;
	String[] yesNo=new String[wordCount];
	while(i<words.length){	
	    if((hasLetter(words[i],in)) && !(hasLetter(words[i], out)) && (words[i].length()==n)){ // calls on helper method hasLetter
		yesNo[i]=words[i];
	    }
	    i++;
	}
	check(yesNo);
	return yesNo;
    }
}//end of class


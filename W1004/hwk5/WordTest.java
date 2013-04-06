// a test class for Word List
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class WordTest{

    public static void main(String[] args){
	try{
	    String[] holder;
	    int length;
	    Scanner input=new Scanner(System.in);
	    WordLists wordlist=new WordLists(args[0]);
	    System.out.println("How long would you like the words to be?");
	    int wordLength1=input.nextInt();
	    holder=wordlist.lengthN(wordLength1);
	    length=holder.length;
	    PrintWriter out=new PrintWriter("Length" + wordLength1 + ".txt");   
	    for (int i=0; i<length;i++){
		if (holder[i]!=null){
		    out.println(holder[i]);
		}
	    }
	    out.close();
	    System.out.println("How long do you want the words to be? (startswith)");
	    int wordLength2=input.nextInt();
	    System.out.println("What letter should they start with?");
	    char letter=input.next().charAt(0);
	    //   if(letter!=''){
	    //throw new InputMismatchException("please enter a letter");
	    // }
	    holder=wordlist.startsWith(wordLength2,letter);
	    PrintWriter out2=new PrintWriter("StartsWith_" + letter +".txt");
	    length=holder.length;
	    for (int i=0; i<length;i++){
		if(holder[i]!=null){
		    out2.println(holder[i]);
	    	}
	    }
	    out2.close();
	    System.out.println("How long do you want the words to be? (contains)");
            int wordLength3=input.nextInt();
            System.out.println("What letter should they contain?");
            char letter2=input.next().charAt(0);
            holder=wordlist.containsLetter(wordLength3,letter2);
            PrintWriter out3=new PrintWriter("Contains_the_letter_" + letter2 +".txt");
            length=holder.length;
	    for (int i=0; i<length; i++){
                if(holder[i]!=null){
                    out3.println(holder[i]);
                }
            }
	    out3.close();
	    System.out.println("How long do you want the words to be? (vowel)");
	    int wordLength4=input.nextInt();
	    System.out.println("How many vowels should they contain?");
	    int vowels=input.nextInt();
	    if(wordLength4<vowels){
		throw new IllegalArgumentException("the number of vowels exceeds the letters in the word");
	    }
	    holder=wordlist.vowelHeavy(wordLength4,vowels);
	    PrintWriter out4=new PrintWriter("Contains_" + vowels +"vowels.txt");
	    length=holder.length;
	    for (int i=0; i<length; i++){
		if(holder[i]!=null){
		    out4.println(holder[i]);
		}
	    }
	    out4.close();
	    System.out.println("What letter should these words contain? (manyletters)");
	    char letter3=input.next().charAt(0);
	    System.out.println("At least how many times should it contain it?");
	    int times=input.nextInt();
	    holder=wordlist.multiLetter(times,letter3);
	    PrintWriter out5=new PrintWriter("Contains_at_least_" + letter3 +".txt");
	    length=holder.length;
	    for (int i=0; i<length; i++){
		if(holder[i]!=null){
		    out5.println(holder[i]);
		}
	    }
	    out5.close();
	    System.out.println("How long should these words be? (containsTwo)");
	    int wordLength5=input.nextInt();
	    System.out.println("What letter should these words contain? (first letter)");
            char letter4=input.next().charAt(0);
	    System.out.println("What letter should these words contain? (second letter)");
            char letter5=input.next().charAt(0);
            holder=wordlist.containsTwo(wordLength5,letter4,letter5);
            PrintWriter out6=new PrintWriter("Contains_two_" + letter4 + letter5 +".txt");
            length=holder.length;
            for (int i=0; i<length; i++){
                if(holder[i]!=null){
                    out6.println(holder[i]);
                }
            }
            out6.close();
	    System.out.println("How long should these words be? (yesAndNo)");
            int wordLength6=input.nextInt();
            System.out.println("What letter should these words contain? (first letter)");
            char letter6=input.next().charAt(0);
            System.out.println("What letter should these words not contain? (second letter)");
            char letter7=input.next().charAt(0);
            holder=wordlist.yesAndNo(wordLength6,letter6,letter7);
            PrintWriter out7=new PrintWriter("Contains_" + letter6 + "_but not_" + letter7 +".txt");
            length=holder.length;
            for (int i=0; i<length; i++){
                if(holder[i]!=null){
                    out7.println(holder[i]);
                }
            }
            out7.close();
	}
	catch (FileNotFoundException exception){
            System.out.println("The Filename you entered was not found. " +
                               "Please try again");
	}
	catch (InputMismatchException e){
	    System.err.println("Please read the prompt carefully." +
			       " Try again");
	}
	catch (NumberFormatException NumException){
	    System.out.println("The input was not a number");
	}
	catch (ArrayIndexOutOfBoundsException y){
	    System.out.println("Arrays out of bounds make me sad. " +
			       "Give me a file, please");
	}
    }
}

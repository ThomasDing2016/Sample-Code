/** This class acts as a menu for the user: displaying option lists and also managing types of input. The tester class will interact with menu heavily. */

import java.io.*;
import java.util.Scanner;

public final class Menu {
    private static String[] menu;
    private static Scanner input = new Scanner(System.in);
    private final static String NEWLINE = System.getProperty("line.separator");
    private final static String TITLE = "-----Welcome to the best Wiki ever!-----";
    private final static String FOOTER = NEWLINE + "************************" + NEWLINE;

    
    public static String mainMenu(){
	String toPrint = "";
	menu = new String [] { "Write new article", "Open an article", "Modify an article", "Delete article", "<Exit>"};
	for(int i = 0; i < menu.length; i++){
	    toPrint += (i+1) + ".- " + menu[i] + NEWLINE;
	}
	return TITLE+NEWLINE+toPrint+NEWLINE+FOOTER;
    }

    public static String menuPrompt(){
	return "Enter your choice below (only numbers, please): (1-"+menu.length+")"+NEWLINE;
    }

    public static int getInput(){
	int temp = 0;
	String entered = input.nextLine(); //why is this a String? Is input from input.nextLine always a string?
	try{
	    temp = Integer.parseInt(entered);
	    while(temp < 0 || temp > menu.length){
		temp = retryInput();
	    }
	}
	catch(NumberFormatException e){
	    temp = retryInput();
	}
	return temp;
    }
    
    private static int retryInput(){
	int temp = 0;
	System.out.println("Please enter a number between 0 and " + menu.length + ".");
	menuPrompt();
	try{
	    temp = Integer.parseInt(input.nextLine());
	}
	catch(NumberFormatException x){
	    retryInput();
	}
	return temp;
    }
    
    public static String getStringInput(){
	return input.nextLine();
    }

    public static String openSavedPrompt(){
	String prompt = "Do you want to open a saved library? (Yes-1, No-2)" + NEWLINE;
	return prompt;
    }

    public static String openArticlePrompt(){
	String prompt = "Please enter the number of the article you'd like to open." + NEWLINE +
	    "Or press 0 to cancel";
	return prompt;
    }

    public static String emptyPrompt(){
	String prompt = "There are no articles in the library. Write one!" + NEWLINE;
	return prompt;
    }
    
    public static String modifyArticlePrompt(){
	String prompt = "Please enter the number of the article you'd like to modify." + NEWLINE 
	    + "Or press 0 to cancel";
	return prompt;
    }

  public static String modifyMenu(){
	String toPrint = "";
	menu = new String [] { "Title", "Body", "References"};
        for(int i = 0; i < menu.length; i++){
            toPrint += "Enter what you want to modify " + (i+1) + ".- " + menu[i] + NEWLINE;
        }
        return NEWLINE+toPrint+NEWLINE;
    }    

    public static String newArticlePrompt(){
	String prompt = "Please enter the title of your Article:";
	return prompt;
    }

    public static String newArticleContentPrompt() {
        String prompt = "Please enter the body of your Article:";
        return prompt;
    }

    public static String newArticleRefPrompt(){
	String prompt = "Please enter the references of your Article:";
        return prompt;
    }

    public static String deleteArticlePrompt() {
	/**	menu = new String[articleCount];
	for(int i = 1; i <= articleCount; i++){
	    menu[i-1]=Integer.toString(i);
	    } */
	String prompt = "Please enter the number for the article you would like to delete" + NEWLINE + "Or press [0] to cancel";
	return prompt;
    }

    public static String savePrompt(){
	String prompt = "Would you like to save your articles? (Y or N)";
	return prompt;
	    }
    
    public static String notSavePrompt(){
	String prompt = "Are you sure? Your articles will not be saved!";
	return prompt;
    }

    public static String invalidSelection(){
	return "You made an invalid selection.  Please try again.";
    }
    
}
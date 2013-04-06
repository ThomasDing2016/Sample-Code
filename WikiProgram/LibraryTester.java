/** This class is a Tester for the Library, and the whole Wiki */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class LibraryTester {

    private static Library library;
    private final static String NEWLINE = System.getProperty("line.separator");
  

    public static void main(String[] args) {
	run();
    }

    private static void run(){
        library = new Library();
	libraryRun();
    }

    private static void libraryRun(){
	System.out.println(Menu.mainMenu());
	System.out.println(Menu.menuPrompt());
	int menuChoice = Menu.getInput();
	if (menuChoice == 1){ /** write new */
	    writeNew();
	}
	else if (menuChoice == 2){ /** open article */
	    /** shows menu with choices of articles, handle when library is empty */	   
	    if (library.emptyLib()){
		System.out.println(Menu.emptyPrompt());
		writeNew();
	    }
	    else {
		System.out.println(Menu.openSavedPrompt());
		int choice = Menu.getInput();
		if (choice == 1){
		    loadLibrary("CeciWiki.lib");
		}
		else if (choice == 2){
			System.out.println(library.listArticles());
			System.out.println(Menu.openArticlePrompt());
			int articleChoice = Menu.getInput();
			if (articleChoice == 0){
			    libraryRun();
			}
			else{
			    System.out.println(library.displayArticle(articleChoice));
			    /** show the article, i.e. return title, content and refs */
			    libraryRun();	
			}
		    }
	    }
	}
	
	else if (menuChoice == 3){ /** modify article */
	    /** shows menu with choices of articles, handle when library is empty */
            if (library.emptyLib()){
                System.out.println(Menu.emptyPrompt());
                writeNew();
            }
            else {
		System.out.println(library.listArticles());
		System.out.println(Menu.modifyArticlePrompt());
		int articleChoice = Menu.getInput();
		if (articleChoice == 0){
                    libraryRun();
		}
                else{
		    System.out.println(Menu.modifyMenu());
		    Menu.menuPrompt();
		    int modifyChoice = Menu.getInput();
		    /** directs to modify actions */
		    if (modifyChoice == 1){
			System.out.println(Menu.newArticlePrompt());
			String articleTitle = Menu.getStringInput();
			library.updateTitle(articleChoice, articleTitle);
			libraryRun();	
		    }
		    else if (modifyChoice == 2){
			System.out.println(Menu.newArticleContentPrompt());
			String articleBody = Menu.getStringInput();
			library.updateBody(articleChoice, articleBody);
			libraryRun();
		    }
		    else if (modifyChoice == 3){
			System.out.println(Menu.newArticleRefPrompt());
			String articleRefs = Menu.getStringInput();
			library.updateRefs(articleChoice, articleRefs);
			libraryRun();
		    }
		}
	    }
	}
	
	    else if (menuChoice == 4){ /** delete */
		/** shows menu with choices of articles, handle when library is empty */
		if (library.emptyLib()){
		    System.out.println(Menu.emptyPrompt());
		    writeNew();
		}
		else {
		    System.out.println(library.listArticles());
		    System.out.println(Menu.deleteArticlePrompt());
		    int articleChoice = Menu.getInput();
		    if (articleChoice == 0){
			libraryRun();
		    }
		    else {
			library.deleteArticle(articleChoice);
                        libraryRun();
		    }
		}
	    }
	    else if (menuChoice == 5){ /** Exit */
		System.out.println(Menu.savePrompt());
		String save = Menu.getStringInput();
		if (save.equals("Y"))
		    saveLibrary();
		else if (save.equals("N"))
		    System.out.println(Menu.notSavePrompt()); 
		    System.out.println("You will be redirected to the main menu"); 
	    }
    }
		       
    
    private static void articleSave(){
	System.out.println(Menu.savePrompt());
	String choice = Menu.getStringInput();
	if (choice.equals("Y")) { //save library
	   saveLibrary();
	}
	else if (choice.equals("N")){
	    System.out.println(Menu.notSavePrompt());
	    System.out.println("You will be redirected to the main menu");	
	    libraryRun();
	}
    }
    
    private static void writeNew(){
	System.out.println(Menu.newArticlePrompt());
	String articleTitle = Menu.getStringInput();
	System.out.println(Menu.newArticleContentPrompt());
	String articleContent = Menu.getStringInput();
	System.out.println(Menu.newArticleRefPrompt());
	String articleRefs = Menu.getStringInput();
	library.addArticle(articleTitle, articleContent, articleRefs);
	articleSave();	
	libraryRun();
    }
    
    
    private static void saveLibrary(){
	try{
	    String filename = "CeciWiki";
	    FileOutputStream fileOut = new FileOutputStream("saved_wikis/"+filename+".lib");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(library);
	    out.close();
	    fileOut.close();
       }
       catch(IOException i){
       i.printStackTrace();
       }
       
       }
       
       private static void loadLibrary(String filename){
	filename = "saved_wikis/"+filename;
	FileInputStream fileIn = null;
	ObjectInputStream in = null;
	try {
	    fileIn = new FileInputStream(filename);
	    in = new ObjectInputStream(fileIn);
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	//try and read in a previously saved friend object.  Otherwise, create.
	try {
	    library = (Library) in.readObject();
	}
	catch(IOException i) {
	    System.err.println("There was an error reading the Library File."+
			       " Action Aborted" + NEWLINE);
	    libraryRun();
	}
	catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	try {
	    in.close();
	    fileIn.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    
}
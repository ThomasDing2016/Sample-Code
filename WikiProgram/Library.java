import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{

    private String libraryTitle;
    private ArrayList<Article> articles;
    private final static String NEWLINE = System.getProperty("line.separator");
    private int articleCount = 0;

    public Library(){
	articles = new ArrayList<Article> ();
	libraryTitle = "CeciWiki";
    }

    public String listArticles(){
	String list ="";
	for(int i = 0; i < articles.size(); i++){
	    list+= (i+1) + ".- " + articles.get(i).getArticleTitle() + NEWLINE;
	}
	return list;
    }
    
    public void addArticle(String articleTitle, String articleBody, String articleRefs){
	int index = articles.size();
	articles.add(new Article(articleTitle, articleBody, articleRefs, index));
	articleCount++;
    }
    
    public void deleteArticle(int index){
	articles.remove(index-1);
	
    }

    public String displayArticle(int index){
	Article current = getArticle(index);
	String toRead =  "***" + NEWLINE;
	toRead += "TITLE:" + current.getArticleTitle() + NEWLINE + NEWLINE;
	toRead += "BODY:" + current.getArticleBody() + NEWLINE + NEWLINE;
	toRead += "REFERENCES:" + current.getArticleRefs() + NEWLINE + NEWLINE;
	return toRead;
    }

    public Article getArticle(int index){
	return articles.get(index-1);
    }

    public void updateTitle(int index, String title){
	Article current = articles.get(index-1);
	current.setTitle(title);
    }

    public void updateBody(int index, String body){
	Article current = articles.get(index-1);
	current.setBody(body);
    }

    public void updateRefs(int index, String refs){
	Article current = articles.get(index-1);
	current.setRefs(refs);
    }
    
    public boolean emptyLib(){
	boolean empty = false;
	if (articleCount < 1){
	    empty = true;
	}
	else
	    empty = false;
	return empty;
    }
}
    
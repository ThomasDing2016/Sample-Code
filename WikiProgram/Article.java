import java.io.Serializable;


public class Article implements Serializable{

    private static final long serialVersionUID = 1L;
    private String articleTitle, articleBody, articleRefs;
    private final String NEWLINE = System.getProperty("line.separator");
    private int index;

    public Article(int index){
	articleTitle = "Untitled";
	articleBody = "No Body";
	this.index = index;
    }

    public Article(String articleTitle, int index){
	this.articleTitle = articleTitle;
	this.index = index;

    }

    public Article(String articleTitle, String articleBody, String articleRefs, int index){
	this.articleTitle = articleTitle;
	this.index = index;
	int value = 50;
	while(value<articleBody.length()){
	    while(value<articleBody.length() && articleBody.codePointAt(value) != ' '){
		value++;
	    }
	    if(value < articleBody.length()-1){
		String temp = articleBody.substring(0,value) + "\n";
		articleBody = temp + articleBody.substring(value+1);
	    }
	    value+=60;
	}
	this.articleBody = articleBody;
        while(value<articleBody.length()){
            while(value<articleBody.length() && articleBody.codePointAt(value) != ' '){
                value++;
            }
            if(value < articleBody.length()-1){
                String temp = articleBody.substring(0,value) + "\n";
                articleBody = temp + articleBody.substring(value+1);
            }
            value+=60;
        }
	this.articleRefs = articleRefs;
    }
    
    public void setTitle(String articleTitle){
	this.articleTitle = articleTitle;
    }
    
    public void setRefs(String articleRefs){
	this.articleRefs = articleRefs;
    }
    
    public void setBody(String articleBody){
	int value = 60;
	while(value<articleBody.length()){
	    while(value<articleBody.length() && articleBody.codePointAt(value) != ' '){
		value++;
	    }
	    if(value < articleBody.length()-1){
		String temp = articleBody.substring(0,value) + "\n";
		articleBody = temp + articleBody.substring(value+1);
	    }
	    value+=60;
	}
	this.articleBody = articleBody;
    }

    public String getArticleBody(){
	return articleBody + NEWLINE;
    }

    public String getArticleTitle(){
	return articleTitle;
    }

    public String getArticleRefs(){
	return articleRefs + NEWLINE;
    }

    public int getArticleIndex(){
	return index;
    }
}
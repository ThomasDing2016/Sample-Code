/** This is the Board class that implements the Location interface
 * It keeps track of the tiles and board
 * Cecilia Reyes • kcr118
 */

public class Board implements Location {
    private int Board [][];
    private boolean flippable=false;
    private int newX = 0, newY = 0;
    private int horizontal, vertical, opponent;
    private final int SIZE = 8;
    private int whites = 0, blacks = 0;
    
    public Board(int r, int c){
	Board =  new int [r][c];
	for(int i = 0; i< 8; i++){
            for(int j= 0; j< 8; j++){
		if((i==3 && j == 3) || (i==4 && j == 4)){
		    Board [i][j] = 1;
		}
		else if((i==3 && j == 4) || (i==4 && j == 3)){
		    Board [i][j] = 2;
		}
		else{
		    Board [i][j] = 0;
		}
	    }
	}
    }
    
    /** @Override */
    public int getHorizontal() {
	return horizontal;
    }
    
    /**@Override */
    public int getVertical() {
	return vertical;
    }
   
    public boolean valid (int x, int y, int player){ /** checks if the move is valid */
	int[] move = {x, y, player};
	boolean valid = false;
	if (Board[move[1]][move[0]] == 2 || Board[move[1]][move[0]]== 1){
	    System.out.println("There's a tile already on this spot, choose another location");
	    valid = false;
	    return valid;
	}
	if (flipped(move)){
	    valid = true;
	}
	return valid;
    }
    
    private boolean flipped(int[] move){
	boolean flip=false;
	int x = move[0];
	int y = move[1];
	int player = move[2];
	int instance = 0;
	int instance2 = 0;
	int instance3 = 0;
	int instance4 = 0;
	int instance5 = 0;
	int instance6 = 0;
	int instance7 = 0;
	int instance8 = 0;
	
	if (x+1 < SIZE)
	    instance = Board[y][x+1];
	if (x-1 >= 0)
	    instance2 = Board[y][x-1]; 
	if (y+1 < SIZE)
	    instance3 = Board[y+1][x];
	if (y-1 >= 0)
	    instance4 = Board[y-1][x];
	if ((x+1 < SIZE) && (y+1 < SIZE))
	    instance5 = Board[y+1][x+1];
	if ((y-1 >= 0) && (x+1 > SIZE))
	    instance6 = Board[y-1][x+1];
	if ((y-1 >= 0) && (x-1 >=0))
	    instance7 = Board[y-1][x-1];
	if ((y+1 < SIZE) && (x-1 >= 0))
	    instance8 = Board[y+1][x-1];

	if (player==1){
	    opponent = 2; }
	else {
	    opponent = 1; }
	if (instance==opponent){
	    flip=flipHorizontally(x, y, player); }  
        if (instance2==opponent) {
	    flip=flipHorizontally2(x, y, player); }
        if (instance3==opponent) {
	    flip=flipVertically(x, y, player); }
	if (instance4==opponent) {
	    flip=flipVertically2(x, y, player); }
	if (instance5==opponent){
	    flip=flipDiagonally(x, y, player); }
	if (instance6==opponent) {
	    flip=flipDiagonally2(x, y, player); }
	if (instance7==opponent) {
	    flip=flipDiagonally3(x, y, player); }
	if (instance8==opponent) {
	    flip=flipDiagonally4(x, y, player); }
	return flip;
    }
    
    private boolean flipHorizontally(int x, int y, int player){
	flippable=false;
	for (int i=x+1; i< SIZE; i++){
	    if (Board[y][i]==player){
		flippable=true;
		newX = i;
	    }
	}
	if (flippable){
	    for (int j=x; j<=newX; j++){
		Board[y][j]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipHorizontally2(int x, int y, int player){
	flippable=false;
	for (int i=x-1; i>= 0; i--){
	    if (Board[y][i]==player){
		flippable=true;
		newX = i;
	    }
	}
	if (flippable){
	    for (int j=x; j>= newX; j--){
		Board[y][j]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipVertically(int x, int y, int player){
	flippable=false;
	for (int i=y+1; i< SIZE; i++){
	    if (Board[i][x]==player){
		flippable=true;
		newY = i;
	    }
	}
	if (flippable){
	    for (int j=y; j<=newY; j++){
		Board[j][x]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipVertically2(int x, int y, int player){
	flippable=false;
	for (int i=y-1; i>= 0; i--){
	    if (Board[i][x]==player){
		flippable=true;
		newY = i;
	    }
	}
	if (flippable){
	    for (int j=y; j>= newY; j--){
		Board[j][x]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipDiagonally(int x, int y, int player){
	flippable=false;
	for (int i=x+1, f=y+1; i< SIZE; i++, f++){
	    if (f < SIZE){
		if (Board[f][i]==player){ 
		    flippable=true;
		    newX = i;
		    newY = f;
		}
	    }
	}
	if (flippable){
	    for (int j=x, h=y; j<= newX; j++, h++){
		if (h <= newY)
		    Board[h][j]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipDiagonally2(int x, int y, int player){
	flippable=false;
	for (int i=x+1, f=y-1; i< SIZE; i++, f--){
	    if (f >= 0){
		if (Board[f][i]==player){
		    flippable=true;
		    newX = i;
		    newY = f;
		}
	    }
	}
	if (flippable){
	    for (int j=x, h=y; j<=newX; j++, h--){
		if (h >= newY)
		    Board[h][j]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipDiagonally3(int x, int y, int player){
	flippable=false;
	for (int i=y-1, f=x-1; i>= 0; i--, f--){
	    if (f >= 0){
		if (Board[i][f]==player){
		    flippable=true;
		    newY = i;
		    newX = f;
		}
	    }
	}
	if (flippable){
	    for (int j=y, h=x; j>= newY; j--, h--){
		if (h >= newX)
		    Board[j][h]=player;
	    }
	    return true;
	}
	return false;
    }
    
    private boolean flipDiagonally4(int x, int y, int player){
	flippable=false;
	for (int i=y+1, f=x-1; i< SIZE; i++, f--){
	    if (f >= 0){	 
		if (Board[i][f]==player){
		    flippable=true;
		    newY = i;
		    newX = f;
		}
	    }
	}
	if (flippable){
	    for (int j=y, h=x; j<=newY; j++, h--){
		if(h >= newX)
		    Board[j][h]=player;
	    }
	    return true;
	}
	return false;
    }
    
    public void setTile(int a, int b, int player){
	Board [b][a] = player;
    }
    
    public boolean fullBoard(){
	int count = 0;
	for(int i = 0; i< 8; i++){
	    for(int j= 0; j< 8; j++){
		if(Board[i][j] != 0){
		    count++;
		}
	    }
	}
	if (count == 64){
	    return true;
	}
	return false;
    }
    
    public String toString(){
	String b = "";
	for(int i = 0; i<8; i++){
	    for(int j= 0; j<8; j++){
		if(j==7)
		    b += Board[i][j] + " \n";
		else
		    b += Board[i][j] + " ";
	    }
	}
	return b;
    }
    
    public int countBlackTiles(){
        for(int i = 0; i< 8; i++){
            for(int j= 0; j< 8; j++){
                if(Board[i][j] == 1){
                    blacks++;
                }
            }
        }
        return blacks;
    }
    
    public int countWhiteTiles(){
        for(int i = 0; i< 8; i++){
            for(int j= 0; j< 8; j++){
                if(Board[i][j] == 2){
                    whites++;
                }
            }
        }
        return whites;
    }
}
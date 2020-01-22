
public class Board {
	//fields
	private char[][] myBoard;
	private int column_x;
	private int row_y;
	
	//constructors
	public Board(){
		this(10,10);
	}
	public Board(int x, int y){
		column_x = x;
		row_y = y;
		myBoard = new char[x-1][y-1];
		for (int i = 0 ;i < x ;i++){
			for(int j = 0; j<y; j++){
				myBoard[i][j] = '~';
			}
		}
	}
	
	//methods
	public String toString(){
		return ("# of colunns: " + column_x + " # of rows: " + row_y );
	}
	public boolean equals(Object thing){
		if (!(thing instanceof Board)){
			return false;
		}
		Board other = (Board)thing;
		if (!(this.column_x == other.column_x)||!(this.row_y == other.row_y)){
			return false;
		}
		for (int i = 0 ;i < column_x ;i++){
			for(int j = 0; j<row_y; j++){
				if (!(this.get_point(i,j) == other.get_point(i,j))){
					return false;
				}
			}
		}
		return true;
	}
	public char get_point(int i, int j){
		return myBoard[i][j];
	}
	public void change(int i , int j, char s){
		myBoard[i][j] = s;
	}
}

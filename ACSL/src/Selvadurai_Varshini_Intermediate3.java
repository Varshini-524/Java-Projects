import java.util.*;
public class Selvadurai_Varshini_Intermediate3 {
	public static void main (String[] args){
		int end = 0;
		do{
			try{
				Scanner kb = new Scanner(System.in);
				System.out.println("Test case: ");
				String[] input = kb.nextLine().split(" ");
				int[][] board = new int[8][8];
				int i = 1;
				while(i<=Integer.parseInt(input[0])){
					int[] ugh = new int[input[i].length()];
					for(int j = 0; j<ugh.length; j++){
						ugh[j] = input[i].charAt(j) - 48;
					}
					i++;
					board = setBoard(board,ugh);
				}
				i++;
				while(i<input.length){
					int r = input[i].charAt(0) - 48;
					int c = input[i].charAt(1) - 48;
					i++;
					flip(board, r-1, c-1);
				}
				System.out.println(count(board));
				end ++;
			}catch(Exception e){
				System.err.println("An Exception was thrown: " + e);	
			}
		}while(end != 5);
	}
	public static int count(int[][] board){
		int c = 0;
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				if(board[i][j] == 1){
					c++;
				}
			}
		}
		return c;
	}
	public static int[][] setBoard(int[][] board, int[]input){
		int row = input[0];
		for(int i = 1; i<input.length; i++)
			board[row - 1][input[i] - 1] = 1;
		return board;
	}	
	public static int[][] flip(int[][] board, int r, int c){
		board[r][c] = num(board[r][c]);
		if (r>0){
			board[r-1][c] = num(board[r-1][c]);
			if(r>1){
				board[r-2][c] = num(board[r-2][c]);
			}
		}
		if (r<7){
			board[r+1][c] = num(board[r+1][c]);
			if (r<6){
				board[r+2][c] = num(board[r+2][c]); 
			}
		}
		if (c>0){
			board[r][c-1] = num(board[r][c-1]);
			if (c>1){
				board[r][c-2] = num(board[r][c-2]);
			}
		}
		if (c<7){
			board[r][c+1] = num(board[r][c+1]); 
			if (c<6){
				board[r][c+2] = num(board[r][c+2]);
			}
		}
		if (r!=0 && c!= 0){
			board[r-1][c-1] = num(board[r-1][c-1]);
		}
		if (r != 0 && c != 7){
			board[r-1][c+1] = num(board[r-1][c+1]);
		}
		if (r!=7 && c!= 0){
			board[r+1][c-1] = num(board[r+1][c-1]);
		}
		if (r != 7 && c != 7){
			 board[r+1][c+1] = num(board[r+1][c+1]);
		}	
		return board;
	}
	public static int num(int x){
		if (x == 1)
			return 0;
		return 1;
	}
}
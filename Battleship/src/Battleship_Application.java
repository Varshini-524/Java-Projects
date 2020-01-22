//Varshini Selvadurai
//Block Y
import java.util.Scanner;
import java.util.Random;
public class Battleship_Application {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		intro(kb);
		int column = 7;
		int row = 7;
	    Board ocean = new Board(column,row);
	    printboard(ocean,column,row);
	    Ship_Placer ship1 = new Ship_Placer(column,row);
	    int[] send = ship1.location(column, row);
	    int sunk = 0;
	    while (sunk<2){
	         int x = userguess_col(kb,column);
	         int y = userguess_row(kb,row);
	         sunk = hit(x,y,send[0],send[2],send[1],send[3],ocean,sunk,column,row);
	    }    
	    System.out.println("YOU SUNK MY SHIP CONGRAGULATIONS");
	}
	public static void intro(Scanner kb){ //introduces the game to the user
	    System.out.println("Hello, we are going to play battleship");
		System.out.println("What is ur name?: ");
		String name = kb.nextLine();
		System.out.println("Sup " + name + "! Below is the game board that is currently all water. ");
		System.out.println("I have placed a ship in the ocean. The ship is 2 spaces long. The goal of this game is to correctly identify");
		System.out.println("the location of this ship. You will do this by guessing the location as prompted.");
		System.out.println();
	}   
	public static void printboard(Board ocean, int x , int y){ //print ocean
		System.out.println();
		System.out.print("    ");
		for(int i = 0; i < x; i ++){
			System.out.print(i+1);
			System.out.print(" ");
		}
		System.out.println();
	    for (int i = 0; i < x ; i++){
	    	System.out.print(i+1);
	    	System.out.print("   ");
	    	for (int j = 0; j < y ; j++){
	    		System.out.print(ocean.get_point(j, i));
	    		System.out.print(' ');
	    	}
	    	System.out.println();
	    }
	}    
		
	public static int userguess_col(Scanner kb, int column){ //promts user to input coordinates and calls upon 2 other functions to check this data and 1 function to reassign data
	    System.out.println();
	    System.out.println("********************************");
	    System.out.println("Now time to make your guess!");
	    System.out.println("Please enter the column letter(1-"+ column + "): ");
	    int guesscol = kb.nextInt();
	    return assignment(check(guesscol,kb));
	}  
	public static int userguess_row(Scanner kb, int row){
		System.out.println("Please enter the row letter(1-"+ row + "): ");	    	
		int guessrow = kb.nextInt();
	    System.out.println("********************************");
	    System.out.println();
		return assignment(check(guessrow,kb));
	}
	public static int check(int guess,Scanner kb){ //checks whether user has inputed the correct data{
	    while (true){
	        if (guess == 1 ||guess == 2 || guess == 3 || guess == 4 ||guess == 5 ||guess == 6 ||guess == 7){
	        	return(guess);			
	        }else{
	            System.out.println("Please re-enter the row number(a letter from 1-7 that coordinates with the game board): ");
	            guess = kb.nextInt();
	            check(guess,kb);
	        }  
	    }     
	}            
	public static int assignment(int guessnumber){ //reassigns the user input to compare with ship location{
		return (guessnumber-1);
	}
	public static int hit(int x,int y,int bx1,int bx2,int by1,int by2,Board ocean, int sunk, int column, int row){ // determines whether user has hit ship{
		System.out.println();
		System.out.println("M-Miss and S-Sunk");
		System.out.println();
	    if ((bx1 == x || bx2 == x) && (by1 == y || by2 == y)){
	        ocean.change(x, y, 'S');
	        sunk +=1;
	    }else{
	    	ocean.change(x, y, 'M');
	    }
	    printboard(ocean,column,row);
	    return sunk;
	}
}
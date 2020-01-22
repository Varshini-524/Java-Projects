import java.util.ArrayList;
import java.util.Scanner;
//3221, 41, 22, 14, 231422, 2313
//2214, 22, 13, 22, 31, 3231
//3212, 32, 41, 22, 12, 1232
public class Selvadurai_Varshini_Intermediate4 {
	public static void main (String[] args){
		Scanner kb = new Scanner(System.in);
		char[][] grid = null;
		try{
			System.out.print("1. ");
			String[] input = kb.nextLine().split(", ");
			grid = new char[6][6];
			grid[0][0] = 'X'; grid[0][5] = 'X'; grid[5][0] = 'X'; grid[5][5] = 'X';
			for(int i = 1; i < 5; i++){
				grid[0][i] = input[0].charAt(i-1); grid[5][i] = input[5].charAt(i-1);
				if(input[i].length() == 2){
					grid[i][0] = input[i].charAt(0); grid[i][5] = input[i].charAt(1);
				}else{
					for(int j = 0; j<6; j++){
						grid[i][j] = input[i].charAt(j);
					}
				}
			}
			grid = conditions(grid);
			int c = 0;
			while(!killme(grid) && c<5){
				grid = checkcols(grid);
				grid = (checkrows(grid));
				grid = check2(grid);
				c++;
			}
			grid = last(grid);
			/*for(int i = 1; i<5 ;i++){
				for(int j = 1; j<5; j++){
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();*/
			int end = 0;
			do{
				System.out.print("input: ");
				String x = kb.nextLine();
				int a = x.charAt(0)-48;
				int b = x.charAt(1)-48;
				System.out.println(grid[a][b]);
				end++;
			}while(end != 5);
		}catch(Exception e){
			System.err.println("An Exception was thrown: " + e);	
		}
	}
	public static char[][] checkrows(char[][] list){
		for(int i = 1; i < 5; i++){
			ArrayList<Character> ugh = new ArrayList<Character>(); ugh.add('1'); ugh.add('2'); ugh.add('3'); ugh.add('4'); 
			for(int j = 1; j< 5; j++){
				for(int z = 0; z < ugh.size(); z++){
					if (list[i][j] == ugh.get(z)){
						ugh.remove(z);
					}
				}	
			}
			for(int a = 0; a<5; a++){
				if (list[a][i] == 0){
					if(ugh.size() == 1){
						list[a][i] = ugh.get(0);
					}
				}
			}
			
		}
		return list;
	}
	public static char[][] checkcols(char[][] list){
		for(int j = 1; j < 5; j++){
			ArrayList<Character> ugh = new ArrayList<Character>(); ugh.add('1'); ugh.add('2'); ugh.add('3'); ugh.add('4'); 
			for(int i = 1; i< 5; i++){
				for(int z = 0; z < ugh.size(); z++){
					if (list[i][j] !=0 && list[i][j] == ugh.get(z)){
						ugh.remove(z);
						z--;
					}
				}	
			}
			for(int a = 0; a<5; a++){
				if (list[a][j] == 0){
					if(ugh.size() == 1){
						list[a][j] = ugh.get(0);
					}
				}
			}
		}
		return list;
	}
	public static boolean killme(char[][] list){
		for(int i = 1; i<5; i++){
			for(int j = 1; j <5; j++){
				if(list[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	public static char[][] conditions(char[][] list){
		for(int i = 1; i<5; i++){
			if(list[i][0] == '4'){
				list[i][1] = '1'; list[i][2] = '2'; list[i][3] = '3'; list[i][4] = '4'; 
			}else if(list[i][5] == '4'){
				list[i][4] = '1'; list[i][3] = '2'; list[i][2] = '3'; list[i][1] = '4'; 
			}else if(list[i][0] == '1'){
				list[i][1] = '4'; 
				if(list[i][5] == '2'){
					list[i][4] = '3';
				}
			}else if(list[i][5] == '1'){
				list[i][4] = '4'; 
				if(list[i][0] == '2'){
					list[i][1] = '3';
				}
			}else if(list[i][0] == '2'){
				if(list[i][5] == '3'){
					list[i][2] = '4';
				}
			}else if(list[i][5] == '2'){
				if(list[i][0] == '3'){
					list[i][3] = '4';
				}
			}  
			int j = i;
			if(list[0][j] == '4'){
				list[1][j] = '1'; list[2][j] = '2'; list[3][j] = '3'; list[4][j] = '4'; 
			}else if(list[5][j] == '4'){
				list[4][j] = '1'; list[3][j] = '2'; list[2][j] = '3'; list[1][j] = '4'; 
			}else if(list[0][j] == '1'){
				list[1][j] = '4'; 
				if(list[5][j] == '2'){
					list[4][j] = '3';
				}
			}else if(list[5][j] == '1'){
				list[4][j] = '4';  
				if(list[0][j] == '2'){
					list[1][j] = '3';
				}
			}else if(list[0][j] == '2'){
				if(list[5][j] == '3'){
					list[2][j] = '4';
				}
			}else if(list[5][j] == '2'){
				if(list[0][j] == '3'){
					list[3][j] = '4';
				}
			}
			
			
		}
		return list;
	}
	public static void printArray(char[][] list){
		for(int i = 0; i<list.length; i++){
			for(int j = 0; j<list[i].length; j++){
				if(list[i][j] == 0){
					System.out.print("_"+ " ");
				}else{
					System.out.print(list[i][j] + " ");
			
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static char[][] check2(char[][] list){
		for(int i = 1; i< 5; i++){
			if(list[i][0] == '1' && list[i][5] == '3'){
				if(list[i][2] == '3' || list[i][3] == '1'){
					list[i][2] = '3'; list[i][3] = '1'; list[i][4] = '2';
				}else if(list[i][2] == '2' || list[i][4] == '1'){
					list[i][2] = '2'; list[i][3] = '3'; list[i][4] = '1';
				}else if(list[i][2] == '1'){
					list[i][3] = '3'; list[i][4] = '2';
				}	
			}else if(list[i][5] == '1' && list[i][0] == '3'){
				if(list[i][3] == '3' || list[i][2] == '1'){
					list[i][3] = '3'; list[i][2] = '1'; list[i][1] = '2';
				}else if(list[i][3] == '2' || list[i][1] == '1'){
					list[i][3] = '2'; list[i][2] = '3'; list[i][1] = '1';
				}else if(list[i][3] == '1'){
					list[i][2] = '3'; list[i][1] = '2';
				}	
			}else if(list[i][0] == '2' && list[i][5] == '2'){
				if(list[i][2] == '2' || list[i][4] == '1'){
					list[i][1] = '3'; list[i][2] = '2'; list[i][3] = '4'; list[i][4] = '1';
				}else if(list[i][1] == '1' || list[i][3] == '2'){
					list[i][4] = '3'; list[i][3] = '2'; list[i][2] = '4'; list[i][1] = '1';
				}
			}else if(list[i][0] == '2' && list[i][5] == '3'){
				if(list[i][1] == '1' || list[i][4] == '2'){
					list[i][1] = '1';  list[i][3] = '3'; list[i][4] = '2';
				}else if(list[i][1] == '3' || list[i][3] == '2'){
					list[i][1] = '3';  list[i][3] = '2'; list[i][4] = '1';
				}else if(list[i][1] == '2'){
					list[i][3] = '3'; list[i][4] = '1';
				}
			}else if(list[i][5] == '2' && list[i][0] == '3'){
				if(list[i][4] == '1' || list[i][1] == '2'){
					list[i][4] = '1';  list[i][2] = '3'; list[i][1] = '2';
				}else if(list[i][4] == '3' || list[i][2] == '2'){
					list[i][4] = '3';  list[i][2] = '2'; list[i][1] = '1';
				}else if(list[i][4] == '2'){
					list[i][2] = '3'; list[i][1] = '1';
				}
			}
			int j = i;
			if(list[0][j] == '1' && list[5][j] == '3'){
				if(list[2][j] == '3' || list[3][j] == '1'){
					list[2][j] = '3'; list[3][j] = '1'; list[4][j] = '2';
				}else if(list[2][j] == '2' || list[4][j] == '1'){
					list[2][j] = '2'; list[3][j] = '3'; list[4][j] = '1';
				}else if(list[2][j] == '1'){
					list[3][j] = '3'; list[4][j] = '2';
				}	
			}else if(list[5][j] == '1' && list[0][j] == '3'){
				if(list[3][j] == '3' || list[2][j] == '1'){
					list[3][j] = '3'; list[2][j] = '1'; list[1][j] = '2';
				}else if(list[3][j] == '2' || list[1][j] == '1'){
					list[3][j] = '2'; list[2][j] = '3'; list[1][j] = '1';
				}else if(list[3][j] == '1'){
					list[2][j] = '3'; list[1][j] = '2';
				}	
			}else if(list[0][j] == '2' && list[5][j] == '2'){
				 if(list[2][j] == '2' || list[4][j] == '1'){
					list[1][j] = '3'; list[2][j] = '2'; list[3][j] = '4'; list[4][j] = '1';
				}else if(list[1][j] == '1' || list[3][j] == '2'){
				}
			}else if(list[0][j] == '2' && list[5][j] == '3'){
				if(list[1][j] == '1' || list[4][j] == '2'){
					list[1][j] = '1';  list[3][j] = '3'; list[4][j] = '2';
				}else if(list[1][j] == '3' || list[3][j] == '2'){
					list[1][j] = '3';  list[3][j] = '2'; list[4][j] = '1';
				}else if(list[1][j] == '2'){
					list[3][j] = '3'; list[4][j] = '1';
				}
			}else if(list[5][j] == '2' && list[0][j] == '3'){
				if(list[4][j] == '1' || list[1][j] == '2'){
					list[4][j] = '1';  list[2][j] = '3'; list[1][j] = '2';
				}else if(list[4][j] == '3' || list[2][j] == '2'){
					list[4][j] = '3';  list[2][j] = '2'; list[1][j] = '1';
				}else if(list[4][j] == '2'){
					list[2][j] = '3'; list[1][j] = '1';
				}
			}
		}
		return list;
	}
	public static char[][] last(char[][] list){
		for(int i = 1; i < 5; i++){
			for(int j = 1; j < 5; j++){
				 if(list[i][j] == 0){
					 ArrayList<Character> row = new ArrayList<Character>(); row.add('1'); row.add('2'); row.add('3'); row.add('4'); 
					 ArrayList<Character> col = new ArrayList<Character>(); col.add('1'); col.add('2'); col.add('3'); col.add('4');
					 for(int a = 1; a < 5; a++){
						 for(int z = 0; z<row.size(); z++){
							 if(list[i][a] == row.get(z)){
								 row.remove(z);
								 z--;
							 }
						 }
						 for(int z = 0; z<col.size(); z++){
							 if(list[a][j] == col.get(z)){
								 col.remove(z);
								 z--;
							 }
						 }
					 }
					 char x = 0;
						for(int a = 0; a<row.size(); a++){
							for(int b = 0; b<col.size(); b++){
								if(row.get(a) == col.get(b)){
									x = row.get(a);
									break;
								}
							}
						}
						list[i][j] = x;
				 }
			}
		}
		return list;
	}
}
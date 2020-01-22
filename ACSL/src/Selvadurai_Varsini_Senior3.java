import java.util.Arrays;
import java.util.Scanner;
public class Selvadurai_Varsini_Senior3 {
	public static int x = 0;
	public static int y = 0;
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int end = 0;
		System.out.println("Please enter initial line of input: ");
		String[] first = kb.nextLine().split(", ");
		String[][] array = new String[8][8];
		for (int i = 8; i > 0; i--){
			String[] line = HextoOct(first[8-i]);
			for (int j = 0; j<line.length; j++){
				array[i-1][j] = line[7-j];
			}
		}
		//printArray(array);
		do{
			x = 0;
			y = 0;
			try{
				System.out.println("Please enter input: ");
				String[] input = kb.nextLine().split(", ");
				x = 8 -Integer.parseInt(input[0]);
				y = Integer.parseInt(input[1]) - 1;
				int next = Integer.parseInt(array[x][y])*45;
				String dir = input[2];
				for (int i = 0; i < Integer.parseInt(input[3]); i++ ){
					switch (dir){
					case("A"): dir = above(next, dir);
						break;
					case("B"): dir = below(next, dir);
						break;
					case("L"): dir = left(next, dir);
						break;
					case("R"): dir = right(next, dir);
						break;
					case("NE"): dir = northeast(next, dir);
						break;
					case("NW"): dir = northwest(next, dir);
						break;
					case("SE"): dir = southeast(next, dir);
						break;
					case("SW"): dir = southwest(next, dir);
						break;
					}	
					if (x == -1){
						x = 7;
					}else if (x == 8){
						x = 0;
					}
					if (y == -1){
						y = 7;
					}else if (y == 8){
						y = 0;
					}
					next = Integer.parseInt(array[x][y])*45;
					//System.out.println(i +" " + (8-x) + ", " + (y+1));
				}
				//System.out.println(x + ", " + y);
				System.out.println(8-x + ", " + (y+1));
			}catch(Exception e){
				System.err.println("An Error Occured");
			}
			end++;
		}while(end<5);
	}
	public static String[] HextoOct(String hex){
	    String oct[] = new String[8];			    	    
	    String num = "0123456789ABCDEF";
        int dec = 0;
        for (int i = 0; i < hex.length(); i++){
            char c = hex.charAt(i);
            int n = num.indexOf(c);
            dec = 16*dec + n;
        }
        int n = 0;
	    while(dec != 0){
	        oct[n++] = Integer.toString(dec%8);
	        dec = dec/8;
	    }
	    return oct;
	}
	public static void printArray(String[][] list){
		for(int i = 0; i<list.length; i++){
			for(int j = 0; j<list.length; j++){
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static String below(int next, String dir){
		switch (next){
		case(0): x++; dir = "A";
			break;
		case(90): y--; dir = "R";
			break;
		case(180): x--; dir = "B";
			break;
		case(270): y++; dir = "L";
			break;
		}
		if (next > 0 && next < 90){
			y--; x++; dir = "SW";
		}else if (next > 90 && next < 180){
			y--; x--; dir = "NW";
		}else if (next > 180 && next < 270){
			y++; x--; dir = "NE";
		}else if (next > 270 && next < 360){
			y++; x++; dir = "SE";
		}
		return dir;
	}
	public static String above(int next, String dir){
		switch (next){
		case(0): x--; dir = "B";
			break;
		case(90): y++; dir = "L";
			break;
		case(180): x++; dir = "A";
			break;
		case(270): y--; dir = "R";
			break;
		}
		if (next > 0 && next < 90){
			y++; x--; dir = "NE";
		}else if (next > 90 && next < 180){
			y++; x++; dir = "SE"; 
		}else if (next > 180 && next < 270){
			y--; x++; dir = "SW"; 
		}else if (next > 270 && next < 360){
			y--; x--; dir = "NW"; 
		}
		return dir;
	}
	public static String left(int next, String dir){
		switch (next){
		case(0): y--; dir = "R";
			break;
		case(90): x--; dir = "B";
			break;
		case(180): y++; dir = "L";
			break;
		case(270): x++; dir = "A";
			break; 
		}
		if (next > 0 && next < 90){
			y--; x--; dir = "NW";
		}else if (next > 90 && next < 180){
			y++; x--; dir = "NE";
		}else if (next > 180 && next < 270){
			y++; x++; dir = "SE";
		}else if (next > 270 && next < 360){
			y--; x++; dir = "SW"; 
		}
		return dir;
	}
	public static String right(int next, String dir){
		switch (next){
		case(0): y++; dir = "L";
			break;
		case(90): x++; dir = "A";
			break;
		case(180): y--; dir = "R";
			break;
		case(270): x--; dir = "B";
			break;
		}
		if (next > 0 && next < 90){
			y++; x++; dir = "SE";
		}else if (next > 90 && next < 180){
			y--; x++; dir = "SW";
		}else if (next > 180 && next < 270){
			y--; x--; dir = "NW";
		}else if (next > 270 && next < 360){
			y++; x--; dir = "NE";
		}
		return dir;
	}
	public static String northeast(int next, String dir){
		switch (next){
		case(0): y--; x++; dir = "SW"; 
			break;
		case(90): y--; x--; dir = "NW"; 
			break;
		case(180): y++; x--; dir = "NE"; 
			break;
		case(270): y++; x++; dir = "SE"; 
			break;
		}
		if (next > 0 && next < 90){
			y--; dir = "R"; 
		}else if (next > 90 && next < 180){
			x--; dir = "B"; 
		}else if (next > 180 && next < 270){
			y++; dir = "L"; 
		}else if (next > 270 && next < 360){
			x++; dir = "A";
		}
		return dir;
	}
	public static String northwest(int next, String dir){
		switch (next){
		case(0): y++; x++; dir = "SE"; 
			break;
		case(90): y--; x++; dir = "SW"; 
			break;
		case(180): y--; x--; dir = "NW"; 
			break;
		case(270): y++; x--; dir = "NE"; 
			break;
		}
		if (next > 0 && next < 90){
			x++; dir = "A"; 
		}else if (next > 90 && next < 180){
			y--; dir = "R"; 
		}else if (next > 180 && next < 270){
			x--; dir = "B"; 
		}else if (next > 270 && next < 360){
			y++; dir = "L"; 
		}
		return dir;
	}
	public static String southeast(int next, String dir){
		switch (next){
		case(0): y--; x--; dir = "NW";
			break;
		case(90): y++; x--; dir = "NE";
			break;
		case(180): y++; x++; dir = "SE";
			break;
		case(270): y--; x++; dir = "SW";
			break;
		}
		if (next > 0 && next < 90){
			x--; dir = "B";
		}else if (next > 90 && next < 180){
			y++; dir = "L";
		}else if (next > 180 && next < 270){
			x++; dir = "A";
		}else if (next > 270 && next < 360){
			y--; dir = "R";
		}
		return dir;
	}
	public static String southwest(int next, String dir){
		switch (next){
		case(0): y++; x--; dir = "NE";
			break;
		case(90): y++; x++; dir = "SE";
			break;
		case(180): y--; x++; dir = "SW";
			break;
		case(270): y--; x--; dir = "NW";
			break;
		}
		if (next > 0 && next < 90){
			y++; dir = "L";
		}else if (next > 90 && next < 180){
			x++; dir = "A";
		}else if (next > 180 && next < 270){
			y--; dir = "R";
		}else if (next > 270 && next < 360){
			x--; dir = "B";
		}
		return dir;
	}
}
//4F9D39, DEB456, 3DA8B9, A57CA7, 26A84A, 2FCFA3, 3AAB09, 89CBF5
//1, 2, L, 2
//5, 3, A, 4
//3, 5, B, 2
//6, 7, R, 5
//4, 7, L, 6
//C522E2, 713977, 29CBB9, 4E6D77, 72EDB9, 923E94, 975FCA, 25629D
//7, 8, L, 3
//5, 4, B, 12
//2, 2, R, 3
//6, 7, A, 9
//1, 5, B, 6
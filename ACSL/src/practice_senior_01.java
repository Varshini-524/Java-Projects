import java.util.*;
public class practice_senior_01 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int end = 0;
		do{
			System.out.print((end+1) + ") ");
			String[] input = kb.nextLine().split(", ");
			int len = input.length - 1;
			char e = 'A';
			for(int i = 0; i<len;i = i+2){
				int c = input[i].charAt(0) - 64;
				int r = Integer.parseInt(input[i+1]);
				e = rule(c,r,e);
			}
			System.out.println();
			end++;
		}while(end<5);
	}
	public static char rule(int c, int r, char e){
		int x = 0;
		switch(r){
			case 1: x = c*2;
				break;
			case 2: x = c%3 * 5;
				break;
			case 3: x = c/4 * -8;
				break;
			case 4: x = (int) Math.sqrt(c) * -12;
				break;
			case 5:
				for(int i = 1; i <= Math.sqrt(c); i++) {
			        if(c % i == 0) {
			            x = x + i;
			            if(i != c/i) {
			                x = x + c/i;
			            }
			        }
			    }
			    x = x*10;
				break;
		}
		x = x%26;
		if ((char)(x+e) < 'A'){
			x = 26 + x;		
		}else if ((char)(x+e) > 'Z'){
			x = x - 26;
		}
		e = (char)(e + x);
		System.out.print(e);
		return e;
	}
}
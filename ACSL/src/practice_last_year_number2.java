import java.util.Scanner;

public class practice_last_year_number2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		//System.out.println(char_split(kb));
		//System.out.println(strrem(kb));
		//System.out.println(strchr(kb));	
		System.out.println(strtok(kb));
	}
	public static StringBuilder char_split(Scanner kb){
		System.out.println("Please input line of input: ");
		String[] input = kb.nextLine().split(", ");
		String a$ = input[0];
		int n = Integer.parseInt(input[1]); 
		char c = input[2].charAt(0);
		StringBuilder str = new StringBuilder(a$);
		for (int i = n; i<str.length(); i = i + n + 1){
			str.insert(i,c);
		}
	return str;
	}
	public static StringBuilder strrem(Scanner kb){
		System.out.println("Please input line of input: ");
		String[] input = kb.nextLine().split(", ");
		String a$ = input[0];
		String b$ = input[1];
		int end = b$.length();
		StringBuilder str = new StringBuilder(a$);
		do{
			str.delete(str.indexOf(b$), str.indexOf(b$) + end);
		}while(str.indexOf(b$)!=-1);
		return str;
	}
	public static String strchr(Scanner kb){
		System.out.println("Please input line of input: ");
		String[] input = kb.nextLine().split(", ");
		String a$ = input[0];
		String b$ = input[1];
		StringBuilder str = new StringBuilder(a$);
		return str.substring(0,str.indexOf(b$));	
	}
	public static StringBuilder strtok(Scanner kb){
		System.out.println("Please input line of input: ");
		String[] input = kb.nextLine().split(", ");
		StringBuilder str = new StringBuilder(input[0]);
		StringBuilder blah = new StringBuilder();
		int x;
		int y;
		do{
			x = str.indexOf(input[1]);
			y = str.indexOf(input[1],x);
			if (x!=-1){
				blah.append(str.substring(0,x-1) + ' ');
				str.delete(0, x-1);
				blah.append(str.substring(0,y-1) + ' ');
			}else{
				blah.append(str);
			}
		}while(str.indexOf(input[1])!=-1);
		return blah;
	}
}

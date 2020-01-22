
import java.util.Scanner;
public class Selvadurai_Varshini_Intermediate1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str;
		int end = 0;
		do{
			try{
				System.out.println("Please input line of input: ");
				str = kb.nextLine();
				String[] input = new String[5];
				input = idkwhattocallthis(str,input);
				String[] suit = new String[5];
				suit = samesuit(input, suit);
				int usernum = charToInteger(input, 0);
				int suitnum = 0;
				int numindex = 0;
				int lastnum = 0;
				for (int i = 0; i < suit.length; i++){
					if (suit[i] != null){
						suitnum = charToInteger(suit, i);
						if(usernum<suitnum){
							if(lastnum>=suitnum){
								numindex = i;
								lastnum = suitnum;
							}
						}else{
							if (suit[i+1] != null){
								lastnum = charToInteger(suit, i+1);
							}
						}
					}
				}
				if (suit[numindex] == null){
					suitnum = 0;
					numindex = 0;
					lastnum = charToInteger(input, 1);
					for (int i = 1; i < input.length; i++){
						suitnum = charToInteger(input, i);
						if(lastnum>=suitnum){
							numindex = i;
							lastnum = suitnum;
						}
					}
				System.out.println(input[numindex]);
				}else{
					System.out.println(suit[numindex]);
				}
			}catch(Exception e){
				System.err.println("An Exception was thrown: " + e);
			}
			end++;
		}while(end != 5);
	}
	public static String[] idkwhattocallthis(String str, String[] input){
		input = str.split(", ");
		/*for (int i = 0; i< input.length; i++ ){
			System.out.println(input[i]);
		}*/
		return input;
	}
	public static String[] samesuit(String[] input, String[] suit){
		int j = 0;
		for (int i = 1 ; i<input.length ; i++){	
			if (input[0].charAt(1) == input[i].charAt(1)){
				suit[j] = input[i];
				j++;
			}	
		}
		/*for (int i = 0; i< suit.length; i++ ){
			System.out.println(suit[i]);
		}*/
		return suit;
	}
	public static int charToInteger(String[] array, int i){
		switch(array[i].charAt(0)){
			case 'A': return 1;
			case '2':return 2;
			case '3':return 3;
			case '4':return 4;
			case '5':return 5;
			case '6':return 6;
			case '7':return 7;
			case '8':return 8;
			case '9':return 9;
			case 'T':return 10;
			case 'J':return 11;
			case 'Q':return 12;
			case 'K':return 13;
		}
		return 0;
	}
}


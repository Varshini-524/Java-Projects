import java.util.Scanner;
public class Selvadurai_Varshini_Intermediate2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int end = 0;
		do{
			try{
				System.out.println("Please input line of input: ");
				String input = kb.nextLine();
				int d = Integer.parseInt(input.substring(0,1));
				String left = input.substring(1);
				System.out.print(left.substring(0,d) + " ");
				int x = Integer.parseInt(left.substring(0,d));
				left = left.substring(d);
				left = reverse(left);
				while(left.length()!=0 && Long.parseLong(left)>x){
					for(int i = 1 ; i <left.length()+1; i++){
						if (x<Integer.parseInt(left.substring(0,i))){
							System.out.print(Integer.parseInt(left.substring(0,i)) + " ");
							x = Integer.parseInt(left.substring(0,i));
							left = left.substring(i);
							i = left.length() + 1;
						}
					}
				}
			}catch(Exception e){
				//System.err.println("An Exception was thrown: " + e);
			}
			System.out.println();
			end++;
		}while(end != 5);
	}

	public static String reverse(String str){
		StringBuffer s = new StringBuffer(str);
		s.reverse();
		return s.toString();
	}
}

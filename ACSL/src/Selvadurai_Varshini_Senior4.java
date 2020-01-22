import java.util.Scanner;
import java.util.Stack;
//* + 4 5 - 3 -1
//@ - 8 9 82 46
//@ | - -8 10 82 46
//+ > 8 * 2 7 9 6
//| * @ - 1 6 34 12 > - 990 1000 * -2 3 + -51 49
public class Selvadurai_Varshini_Senior4 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int end = 0;
		
		do{
			try{
				Stack<String> s = new Stack<String>();
				System.out.println("Please enter: ");
				String[] str = kb.nextLine().split(" ");
				int x = 0;
				for(int i = str.length - 1; i>=0; i--){
					if (str[i].equals("+")){
						x = Integer.parseInt(s.pop()) + Integer.parseInt(s.pop());
						s.push(Integer.toString(x));
					}else if (str[i].equals("-")){
						x = Integer.parseInt(s.pop()) - Integer.parseInt(s.pop());
						s.push(Integer.toString(x));
					}else if (str[i].equals("*")){
						x = Integer.parseInt(s.pop()) * Integer.parseInt(s.pop());
						s.push(Integer.toString(x));
					}else if (str[i].equals("|")){
						x = Math.abs(Integer.parseInt(s.pop()));
						s.push(Integer.toString(x));
					}else if (str[i].equals(">")){
						x = Math.max(Integer.parseInt(s.pop()),Integer.parseInt(s.pop()));
						x = Math.max(x,Integer.parseInt(s.pop()));
						s.push(Integer.toString(x));
					}else if (str[i].equals("@")){
						if (Integer.parseInt(s.pop()) > 0){
							x = Integer.parseInt(s.pop());
							s.pop();
						}else{
							s.pop();
							x = Integer.parseInt(s.pop());
						}
						s.push(Integer.toString(x));
					}else{
						s.push(str[i]);
					}
					//System.out.println(s.toString());
				}
				System.out.println(s.pop());
			}catch(Exception e){
				System.out.println();
			}
			end ++;
		}while(end<5);

	}

}

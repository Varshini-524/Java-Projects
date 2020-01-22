import java.util.*;
//{[(2+3)*6/10}
//{60+[15*(520-505)]/5-23
//{[(24+900/300*64]}
//{[4*2/(3+2)*6/10} 6 12 14 17
//{[7*25/5+14)*51]+6}
//{32*510+(8/4)*2+43]/24}
//{[5+7*3000000/85+24*(32/16)+24}
//{(2+3)}]
//{[4+3)]}
//{[4+2}])
//{[(3+4+5+6+7+8+9)+10]+11
public class Selvadurai_Varshini_Senior2 {
	private static char missing; //which one is missing
	private static boolean state = false; //open = true or close = false
	private static char comp;
	public static void main(String[] args) {
		int end = 0;
		do{
			state = false;
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter line of input: ");
			String initial = kb.nextLine();        
			int len = initial.length();
			int[] output = new int[len];
			int o = 0;
			ArrayList<Character> input = new ArrayList<Character>(); //input array
			for(int i = 0; i<len; i++){
				input.add(initial.charAt(i));
			}
			int original_index = check(input); //index of symbol of enclosure's pair
			int index = original_index;
			//System.out.println("oi: "+original_index);
			boolean done = false;
			boolean UGH = false;
			//System.out.println("state: " + state);
			if(state == true){
				int l = index + 1;
				do{
					if(isOperator(input.get(l))){
						index=l+1;
						done = true;
					}
					l++;
				}while(l<len && done == false);
				done = false;
				for(int i = 0; i <original_index; i++){
					if(isOpen(input.get(i))){
						UGH = true;
					}
				}
				for(int i = index; i<len; i++){
					if(isClose(input.get(i-1)) && isOperator(input.get(i))){
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if(isNumber(input.get(i-1)) && isOperator(input.get(i))){
						//System.out.println((i+1) + " before: " + input.get(i-1) + " after: " + input.get(i));
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if(isNumber(input.get(i-1)) && isClose(input.get(i))){
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if((original_index == 0 || UGH == false) && done == false){
						output[o] = len+1;
						o++;
						done = true;
					}
				}
			}else{
				//System.out.println("index" + index);
				UGH = false;
				done = false;
				int l = index -1;
				do{
					if (isOperator(input.get(l))){
						index = l-1;
						done = true;
					}
					l--;
				}while(l>0 && done == false);
				done = false;
				for(int i = original_index; i <len; i++){
					if(isClose(input.get(i))){
						UGH = true;
					}
				}
				//System.out.println("index: " + index);
				for(int i = index; i>0; i--){
					if (isOperator(input.get(i-1)) && isOpen(input.get(i))){
						//System.out.println((i+1) + " before: " + input.get(i-1) + " after: " + input.get(i));
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if(isOperator(input.get(i-1)) && isNumber(input.get(i))){
						//System.out.println((i+1) + " before: " + input.get(i-1) + " after: " + input.get(i));
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if(isOpen(input.get(i-1)) && isNumber(input.get(i))){
						//System.out.println((i+1) + " before: " + input.get(i-1) + " after: " + input.get(i));
						if (acceptable(i,input,original_index)){
							output[o] = i+1;
							o++;
						}
					}else if((original_index == len-1 || UGH == false) && done == false){
						//System.out.println((i+1) + " before: " + input.get(i-1) + " after: " + input.get(i));
						output[o]=1;
						o++;
						done = true;
					}
				}
			}
			printArray(sort(output));
			end++;
			missing = ' ';
			comp = ' ';
		}while(end<5);
	}
	public static int check(ArrayList<Character> input){
		if (input.indexOf('{') != -1){
			if (input.indexOf('}') == -1){
				missing = '}';
				comp = '{';
				state = true;
				return input.indexOf('{');
			}
		}else{
			if (input.indexOf('}') != -1){
				missing = '{';
				comp = '}';
				return input.indexOf('}');
			}
		}
		if (input.indexOf('(') != -1){
			if (input.indexOf(')') == -1){
				missing = ')';
				comp = '(';
				state = true;
				return input.indexOf('(');
			}
		}else{
			if (input.indexOf(')') != -1){
				missing = '(';
				comp = ')';
				return input.indexOf(')');
			}
		}
		if (input.indexOf('[') != -1){
			if (input.indexOf(']') == -1){
				missing = ']';
				comp = '[';
				state = true;
				return input.indexOf('[');
			}
		}else{
			if (input.indexOf(']') != -1){
				missing = '[';
				comp = ']';
				return input.indexOf(']');
			}
		}
		return 0;
	}
	public static boolean isOperator(char c){
		if (c == 43 || c == 45 || c == 42 || c == 47 ){
			return true;
		}
		return false;
	}
	public static boolean isNumber(char c){
		if (c>=48 && c<=57 ){
			return true;
		}
		return false;
	}
	public static boolean isClose(char c){
		if (c == ')' || c == '}' || c == ']'){
			return true;
		}
		return false;
	}
	public static boolean isOpen(char c){
		if (c == '(' || c == '{' || c == '['){
			return true;
		}
		return false;
	}
	public static int[] sort(int[] list) {	
		for (int pass = 0; pass<list.length; pass++){
			int min = pass;
			for(int i = pass; i<list.length; i++){
				if (list[min]>list[i]){
					min = i;
				}					
			}
			int temp = list[pass];
			list[pass] = list[min];
			list[min] = temp;
		}
		return list;
	}
	public static void printArray(int[] output){
		for (int i = 0; i <output.length; i++){
			if (output[i] != 0){
				System.out.print(output[i]);
				if(i!= output.length-1){
					System.out.print(",");
				}
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	public static boolean acceptable(int index, ArrayList<Character> input, int original_index){
		//System.out.println(index+1);
		boolean one = true;
		boolean two = true;
		boolean three = true;
		if(state == true){
			if('(' != comp && input.indexOf('(') !=-1){
				if(!((input.indexOf('(')>=index && input.indexOf(')')>index)||
						(input.indexOf('(')<=index && input.indexOf(')')<index)||
						(input.indexOf('(')<original_index && input.indexOf(')')>=index))){
					one = false;
				}
			}
			if ('{' != comp && input.indexOf('{') !=-1){
				if(!((input.indexOf('{')>=index && input.indexOf('}')>index)||
						(input.indexOf('{')<=index && input.indexOf('}')<index)||
						(input.indexOf('{')<original_index && input.indexOf('}')>=index))){
					two = false;
				}
			}if('[' != comp && input.indexOf('[') !=-1){
				if(!((input.indexOf('[')>=index && input.indexOf(']')>index)||
						(input.indexOf('[')<=index && input.indexOf(']')<index)||
						(input.indexOf('[')<original_index && input.indexOf(']')>=index))){
					three = false;
				}
			}
		}else{
			if(')' != comp && input.indexOf(')') !=-1){
				//System.out.println("@");
				//System.out.println((input.indexOf('(')>=index && input.indexOf(')')>index));
				//System.out.println((input.indexOf(')')<=index && input.indexOf('(')<index));
				//System.out.println((input.indexOf('(')<=index && input.indexOf(')')>original_index));
				if(!((input.indexOf('(')>=index && input.indexOf(')')>index)||
						(input.indexOf(')')<=index && input.indexOf('(')<index)||
						(input.indexOf('(')<=index && input.indexOf(')')>original_index))){
					one = false;
				}
			}if ('}' != comp && input.indexOf('}') !=-1){
				//System.out.println("@@");
				if(!((input.indexOf('{')>=index && input.indexOf('}')>index)||
						(input.indexOf('}')<=index && input.indexOf('{')<index)||
						(input.indexOf('{')<=index && input.indexOf('}')>original_index))){
					two = false;
				}
			}if(']' != comp && input.indexOf(']') !=-1){
				//System.out.println("@@@");
				if(!((input.indexOf('[')>=index && input.indexOf(']')>index)||
						(input.indexOf(']')<=index && input.indexOf('[')<index)||
						(input.indexOf('[')<=index && input.indexOf(']')>original_index))){
					three = false;
				}
			}
		}
		//System.out.println("one:" + one + " two: " + two + " three: " + three);
		return (one && two && three);
	}
}
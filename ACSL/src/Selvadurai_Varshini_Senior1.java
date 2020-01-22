import java.util.Scanner;
public class Selvadurai_Varshini_Senior1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int end = 0;
		System.out.println("Please enter initial line of input: ");
		int[] initial = charToInteger(kb.nextLine().split(", "));
		int[] p1 = new int[5];
		int[] p2 = new int[5];
		do{
			try{
				for (int i = 0; i<5; i++){
					p1[i] = initial[i];
					p2[i] = initial[i+5];
				}
				System.out.println("Please input line of input: ");
				String[] str = kb.nextLine().split(", ");
				int x = 0;
				int pv = Integer.parseInt(str[x]);
				int[] input = charToInteger(str);
				//printarray(input);
				boolean nn = false;
				while (nn == false){
					//System.out.println("___________________________");
					p1 = sort(p1);
					p2 = sort(p2);
					//printarray(p1);
					//printarray(p2);
					if (pv <= 99){
						//System.out.println("pv: " + pv + "median: " + p1[2]);
						pv = increment(p1[2], pv);
						try{
							p1[2] = input[++x];
						}catch(Exception e){	
						}
						//System.out.println(x +" check " + p1[2]);
						if (pv <= 99){
							//System.out.println("pv: " + pv + "median: " + p2[2]);
							pv = increment(p2[2], pv);
							try{
								p2[2] = input[++x];
							}catch(Exception e){	
							}
							//System.out.println(x + " check " + p2[2]);
						}else{
							System.out.println(pv + ", Player #2"); 
							nn = true;
						}
					}else{
						System.out.println(pv + ", Player #1"); 
						nn = true;
					}
				}
			}catch(Exception e){
				System.err.println("An Error Occured");
			}
			end++;
		}while(end<5);
	}
	public static int[] charToInteger(String[] array){
		int[] a = new int[array.length];
		for(int i = 0; i<array.length; i++){
			switch(array[i].charAt(0)){
				case '2':a[i] = 2; break;
				case '3':a[i] = 3; break;
				case '4':a[i] = 4; break;
				case '5':a[i] = 5; break;
				case '6':a[i] = 6; break;
				case '7':a[i] = 7; break;
				case '8':a[i] = 8; break;
				case '9':a[i] = 9; break;
				case 'T':a[i] = 10; break;
				case 'J':a[i] = 11; break;
				case 'Q':a[i] = 12; break;
				case 'K':a[i] = 13; break;
				case 'A':a[i] = 14; break;
			}
		}
		return a;
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
	public static void printarray(int[] list){
		for(int i = 0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	public static int increment(int median, int pv){
		int old = pv;
		switch(median){
		case 2: 
			pv = pv + 2;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;  
		case 3: 
			pv = pv + 3;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv; 
		case 4: 
			pv = pv + 4;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv; 
		case 5: 
			pv = pv + 5;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 6: 
			pv = pv + 6;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 7: 
			if (pv + 7 <= 99){
				pv = pv + 7;
			}else{
				pv = pv + 1;
			}
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 8: 
			pv = pv + 8;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 10: 
			pv = pv - 10;
			if (((old >= 78) && (pv < 78))||((old >= 56) && (pv < 56))||((old >= 34) && (pv < 34))){
				pv = pv + 5;
			}
			return pv; 
		case 11: 
			pv = pv + 11;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 12: 
			pv = pv + 12;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 13: 
			pv = pv + 13;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		case 14: 
			pv = pv + 14;
			if (((old <= 77) && (pv > 77))||((old <= 55) && (pv > 55))||((old <= 33) && (pv > 33))){
				pv = pv + 5;
			}
			return pv;
		}
		return pv;
	}
}
//8, 9, Q, 6, 7, K, A, 5, 9, 8
//75, J, 7, Q, T, A, 6, 2, 3, 4, 5
//50, 7, K, T, 8, 3, Q, 9, 7, 2, 3
//63, 3, 6, 8, T, 7, 7, T, 3, 5, 8
//79, A, 9, 7, T, A, 9, T, A, 6, 4
//50, A, T, Q, A, T, K, J, T, A, 7
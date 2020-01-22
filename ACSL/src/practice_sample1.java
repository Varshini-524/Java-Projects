import java.util.*;
public class practice_sample1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int w =0;
		while(w<5){
			String[] list = kb.nextLine().split(",");
			char c = 'A';
			for(int i=0; i<list.length -1; i++){
				int n = list[i].charAt(0);
				int x = 0;
				n = n-64;
				if(n>=1 && n<=5){
					x = n*2;
					c= (char) ((x+c)%26);
					System.out.print(c + " ");
				}
				if(n>=6 && n<=10){
					x = n%3 * 5;
					c= (char) ((x+c)%26);
					System.out.print(c + " ");
				}
				if(n>=11 && n<=15){
					x = n/4 * 8;
					c= (char) ((x+c)%26);
					System.out.print(c + " ");
				}
				if(n>=16 && n<=20){
					x = 10*(n/10 + n%10);
					c= (char) ((x+c)%26);
					System.out.println((int)c);
					System.out.print(c + " ");
				}
				if(n>=21 && n<=26){
					if (n % 2 == 0){
						x = 12 * n/2;
					}else{
						switch(n){
						case 21:
							x = 12*7;
							break;
						case 23:
							x = 12;
							break;
						case 25:
							x = 60;
							break;
						}
					}
					c= (char) ((x+c)%26);
					System.out.print(c + " ");
				}
		
			}
			w++;
		}
	}
}

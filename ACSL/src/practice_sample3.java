import java.util.*;

public class practice_sample3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int i = 0;
		while(i <5){
			String[] input = kb.nextLine().split(", ");
			String num = input[0];
			int c = 0;
			while(c<10){
				num = add(num,reverse(num),Integer.parseInt(input[1]));
				if (num.equals(reverse(num))){
					System.out.println(num);
					c = 10;
				}
				c++;
			}
			if (c == 10){
				System.out.println("NONE " + num);
			}
		i++;
		}
	}
    public static String add (String a, String b, int base) {
        final StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int x =  getIntValue(a.charAt(i), base) + getIntValue(b.charAt(i), base) + carry;
            if (x >= base) { 
                carry = 1;
                x = x - base;
            } else {
                carry = 0;
            }
            stringBuilder.append(getCharValue(x, base));
        }
        if (carry == 1) stringBuilder.append(1);
        return stringBuilder.reverse().toString();
    }
    public static int getIntValue(char c, int base) {
        if (c >= '0' &&  c <= '9') {
            return c - '0';
        } 
        Character.toUpperCase(c);
        return c - 'A' + 10;
    }
    public static char getCharValue(int x, int base) {
        if (x >= 0 &&  x <= 9) {
            return (char) (x + '0');
        } 
        return (char)(x + 'A' - 10);
    }
    public static String reverse(String str){
		StringBuffer s = new StringBuffer(str);
		s.reverse();
		return s.toString();
	}
}

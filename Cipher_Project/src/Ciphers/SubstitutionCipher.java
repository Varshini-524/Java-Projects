package Ciphers;
import java.util.Random;
public class SubstitutionCipher implements Codeable {
	//fields
	public String randalph;
	private String alph;
	
	public SubstitutionCipher(){
		alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//randalph = randomize();
		randalph = "VNIWBKGHUJEFYMPCSTRLAODXQZ";
		
	}
	
	public String encode(String s) {
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			int spot = alph.indexOf(s.charAt(i));
			newS +=  randalph.charAt(spot);
		}
		return newS;
	}

	public String decode(String s) {
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			int spot = randalph.indexOf(s.charAt(i));
			newS +=  alph.charAt(spot);
		}
		return newS;
	}
	
	private String randomize(){
		// StringBuilder q = new StringBuilder(alph);
		char[] q = new char[25];
        q = alph.toCharArray();
        Random rand = new Random();
        for (int i = 0; i < 26; i++ ){
	        int x = rand.nextInt(25);
	        int y = rand.nextInt(25);
	        char hold = q[x];
	        q[x] = q[y];
	        q[y] = hold;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(q[i]);
        }
        return sb.toString();
	}
	
}

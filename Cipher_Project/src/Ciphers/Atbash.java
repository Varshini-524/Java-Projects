package Ciphers;

public class Atbash implements Codeable {
	//fields
	private String firstalph;
	private String secondalph;
	
	public Atbash(){
		firstalph = "ABCDEFGHIJKLM";
		secondalph = "ZYXWVUTSRQPON";
	}

	public String encode(String s) {
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i)<'N'){
				int spot = firstalph.indexOf(s.charAt(i));
				newS +=  secondalph.charAt(spot);
			}else if (s.charAt(i)>='N'){
				int spot = secondalph.indexOf(s.charAt(i));
				newS +=  firstalph.charAt(spot);
			}
		}
		return newS;
	}

	public String decode(String s) {
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i)<'N'){
				int spot = firstalph.indexOf(s.charAt(i));
				newS +=  secondalph.charAt(spot);
			}else if (s.charAt(i)>='N'){
				int spot = secondalph.indexOf(s.charAt(i));
				newS +=  firstalph.charAt(spot);
			}
			
		}
		return newS;
	}
}	
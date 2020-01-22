package Ciphers;

public class CaesarCipher implements Codeable {
	//fields
	private int rot;
	private int derot;
	private String alph;
	private String newAlph;
	private String denewAlph;
	
	public CaesarCipher(int userrot){
		rot = userrot %26;
		derot = (26 - userrot) % 26;
		alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		newAlph = alph.substring(rot,26) + alph.substring(0,rot);
		denewAlph = alph.substring(derot,26) + alph.substring(0,derot);
	}
	
	public String encode(String s){
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			int spot = alph.indexOf(s.charAt(i));
			newS +=  newAlph.charAt(spot);
		}
		return newS;
	}
	public String decode(String s){
		s = s.toUpperCase();
		String newS ="";
		for(int i = 0; i < s.length(); i++){
			int spot = alph.indexOf(s.charAt(i));
			newS +=  denewAlph.charAt(spot);
		}
		return newS;
	}
}

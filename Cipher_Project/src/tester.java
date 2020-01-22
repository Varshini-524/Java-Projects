import Ciphers.CaesarCipher;
import Ciphers.SubstitutionCipher;
import Ciphers.Atbash;

public class tester {

	public static void main(String[] args) {
		CaesarCipher cc = new CaesarCipher(1);
		SubstitutionCipher sc = new SubstitutionCipher();
		Atbash a = new Atbash();
		System.out.println(cc.encode("abcde"));
		System.out.println(cc.decode("bcdef"));
		System.out.println(sc.randalph);
		System.out.println(sc.encode("abcde"));
		System.out.println(sc.decode("VNIWB"));
		System.out.println(a.encode("abcde"));
		System.out.println(a.decode("zyxwv"));
		
	}

}

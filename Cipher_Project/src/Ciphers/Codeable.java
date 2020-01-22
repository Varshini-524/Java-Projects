package Ciphers;

public interface Codeable {
	public String encode(String message);
	public String decode(String encodedmessage);
}

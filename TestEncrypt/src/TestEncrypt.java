/**
 * @FileName TestEncrypt.java
 * @Description Ask user for a string, encrypt and decrypt it
 * @author Fan Chen
 * @Date Jan 28, 2012
 * @Compiler Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.Scanner;

public class TestEncrypt {

	public static void main(String[] args) {
		System.out
				.println("Enter a string and I will encrypt it a single number.");
		Scanner keyboard = new Scanner(System.in);
		String str = keyboard.nextLine();
		if (str.length() > 80) {
			System.out.println("Too long!! Must less than 80!");
		} else {
			System.out.println("Clear text:" + "\n" + str);
			System.out.println("Number of clear text bytes = " + str.length());
			System.out.println(str + " is encrypted as ");
			MerkleHellman mh = new MerkleHellman(str);
			mh.fillW();
			mh.setQ();
			mh.setR();
			mh.fillB();
			mh.Encrypt();
			System.out.println("Result of decryption: ");
			mh.Decrypt();
		}
	}

}

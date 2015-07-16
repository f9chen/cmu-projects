import java.math.BigInteger;
import java.util.Random;

public class MerkleHellman {
	BigInteger Q;
	BigInteger R;
	String EncryptedNum;
	static Random ran = new Random();
	String str;
	int strLen;

	/**
	 * w will be used to hold the superincreasing sequence of integers that make
	 * up part of the private key and used for decryption.
	 */
	static list w = new list();
	/**
	 * b will be used to hold the public key material used for encryption
	 */
	static list b = new list();

	/**
	 * 
	 * @param content
	 */
	public MerkleHellman(String content) {
		str = content;
		strLen = content.length();
	}

	/**
	 * 
	 * runtime complexity: Theta(n) 
	 * fill the private key list
	 * @param increasingSeq
	 */
	public void fillW() {
		for (int i = 0; i < strLen * 8; i++) {
			BigInteger newNum = BigInteger.valueOf(5).pow(i);
			w.addIntAtEnd(newNum);
		}
	}

	/**
	 * runtime complexity: Theta(n)
	 * fill the public key list
	 */
	public void fillB() {
		for (int i = 0; i < strLen * 8; i++) 
			b.addIntAtEnd((w.getInt(i).multiply(R)).mod(Q));
	}

	/**
	 * cannot decide because I don't know what is going on inside BigInteger.probablePrime()
	 * set Q. Q is a random number that is bigger than sum in W.
	 */
	public void setQ() {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < strLen * 8; i++) {
			sum = sum.add(w.getInt(i));
		}
		while (true) {
			BigInteger theQ = BigInteger
					.probablePrime(sum.bitLength() + 1, ran);
			//if (theQ.compareTo(sum) > 0) { // Q > sum
				Q = theQ;
				break;
			//}
		}
	}

	/**
	 * cannot decide because I don't know what is going on inside BigInteger.probablePrime()
	 * set R. R is gcd to Q, and ranges in [1, Q]
	 */
	public void setR() {
		while (true) {
			BigInteger theR = BigInteger.probablePrime(Q.bitLength(), ran);
			if (theR.compareTo(Q) < 0
					&& theR.gcd(Q).compareTo(BigInteger.ONE) == 0
					&& theR.compareTo(BigInteger.ZERO) > 0) {
				// R < Q; gcd(R,Q) = 1; R > 0
				R = theR;break;
			}
		}
	}

	/**
	 * Encryp one character
	 * runtime complexity: Theta(n)
	 */
	public void Encrypt() {
		int[] bitArray = new int[strLen * 8];
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < strLen; i++) {
			String binStr = Integer.toBinaryString((int) str.charAt(i));
			for (int j = 0; j < 8; j++) {
				if (j < 8 - binStr.length()) {
					bitArray[8 * i + j] = 0;// 0
				} else {
					if (binStr.charAt(j - 8 + binStr.length()) == '0')
						bitArray[8 * i + j] = 0;
					else
						bitArray[8 * i + j] = 1;
					// whatever it is, 0 or 1
				}
				sum = sum.add(BigInteger.valueOf(bitArray[8 * i + j]).multiply(
						b.getInt(8 * i + j)));
			}
		}
		EncryptedNum = "";
		EncryptedNum += sum;
		System.out.println(EncryptedNum);
	}

	/**
	 * Decrypt the string
	 * best runtime complexity: Theta(n)
	 */
	public void Decrypt() {
		BigInteger encNum = new BigInteger(EncryptedNum);
		BigInteger theNumber = (encNum.multiply((R).modInverse(Q)).mod(Q));
		int[] arr = new int[strLen * 8];
		for (int i = strLen * 8 - 1; i > -1; i--) {
			if (theNumber.compareTo(w.getInt(i)) >= 0) {
				// theNumber >= ith digit
				theNumber = theNumber.subtract(w.getInt(i));
				arr[strLen * 8 - 1 - i] = 1;
			}// get the bin arr
		}
		for (int i = 0; i < strLen; i++) {
			int charValue = 0;
			for (int j = 0; j < 8; j++) {
				charValue += arr[strLen * 8 - 1 - (i * 8 + j)]
						* Math.pow(2, 7 - j);
			}
			System.out.print((char) charValue);
		}
	}
}

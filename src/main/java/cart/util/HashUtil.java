package cart.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashUtil {

	public static String generateSalt() throws Exception{
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16]; // 16 bytes = 128 bits
		random.nextBytes(salt);
		return bytesToHex(salt);
	}

	public static String hashPassword(String password, String salt) throws Exception{
		//使用 SHA-256 雜湊演算法
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest((password + salt).getBytes());
		return bytesToHex(hashBytes);
	}
	
	private static String bytesToHex(byte[] bytes) {
		// 將 byte[] 轉成16進位字串
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
}

package br.com.pi.sebovirtual.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
	private static final PasswordEncoder encoder = 
			new BCryptPasswordEncoder();

	public static String encriptyPassword(String password) {
		return encoder.encode(password);
	}
	
	public static Boolean comparesPassword(String password, String encryptedPassword) {
		try {
			return encoder.matches(password, encryptedPassword);
		} catch (IllegalArgumentException e) {
			return true;
		}
	}
	
	public static Boolean checksIfPasswordIsEncrypted(String password) {
		try {
			encoder.upgradeEncoding(password);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}

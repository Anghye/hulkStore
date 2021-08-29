package com.hulkStore.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Hello world!
 *
 */
public class Seguridad 
{
	public static String encryptSHA256(String str) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));

			StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			return null;
		}
	}
}

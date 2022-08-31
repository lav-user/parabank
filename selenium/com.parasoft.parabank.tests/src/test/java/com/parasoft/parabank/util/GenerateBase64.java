package com.parasoft.parabank.util;

import java.util.Base64;

public class GenerateBase64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = "Type Your PIN Password Here";
		byte[] encodedPassword = encodePassord(password);
		System.out.println(new String(encodedPassword));
		String decodedPassword = decodePassword(encodedPassword);
		//System.out.println(decodedPassword);
	}
	
	public static byte[] encodePassord(String password) {
		return Base64.getEncoder().encode(password.getBytes());
	}
	
	public static String decodePassword(byte[] encodedPassowrd) {
		return new String(Base64.getDecoder().decode(encodedPassowrd));
	}
}

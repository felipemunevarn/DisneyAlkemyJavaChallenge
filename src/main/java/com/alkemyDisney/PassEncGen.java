package com.alkemyDisney;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncGen {

	public static void main(String[] args) {
		PasswordEncoder passEnc = new BCryptPasswordEncoder();
		//username=user1
		System.out.println(passEnc.encode("pass1"));

	}

}

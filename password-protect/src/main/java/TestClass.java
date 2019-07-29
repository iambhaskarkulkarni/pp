

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClass {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String msg = bCryptPasswordEncoder.encode("password");
		System.out.println(msg);
	}
}

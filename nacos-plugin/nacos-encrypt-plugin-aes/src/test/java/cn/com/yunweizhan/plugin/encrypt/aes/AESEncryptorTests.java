package cn.com.yunweizhan.plugin.encrypt.aes;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Weizhan▪Yun
 * @date 2022/7/21 22:27
 */
class AESEncryptorTests {
	public static final AESEncryptor INSTANCE = new AESEncryptor();

	@Test
	void encrypt() {
		String secretKey = INSTANCE.generateSecretKey();
		String encrypt = INSTANCE.encrypt(secretKey, "encrypt");
		System.out.println(encrypt);
		assertNotEquals("encrypt", encrypt);
		assertEquals("encrypt", INSTANCE.decrypt(secretKey, encrypt));

	}

	@Test
	void generateKey() {
		INSTANCE.generateSecretKey();
	}

	private String base64Encode(String source) {
		return Base64.getEncoder().encodeToString(source.getBytes(StandardCharsets.UTF_8));
	}
}
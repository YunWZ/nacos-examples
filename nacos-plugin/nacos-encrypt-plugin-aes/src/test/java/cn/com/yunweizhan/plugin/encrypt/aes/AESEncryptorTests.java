package cn.com.yunweizhan.plugin.encrypt.aes;

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
		String encrypt = INSTANCE.encrypt(INSTANCE.generateSecretKey(), "encrypt");
		assertEquals("encrypt", INSTANCE.decrypt(INSTANCE.generateSecretKey(), encrypt));
	}

	@Test
	void emptyKey() {
//		String encrypt = INSTANCE.encrypt(INSTANCE.generateSecretKey(), "encrypt");
		assertEquals("encrypt", INSTANCE.decrypt(INSTANCE.generateSecretKey(), "encrypt"));
	}
}
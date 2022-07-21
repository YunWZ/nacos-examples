package cn.com.yunweizhan.plugin.encrypt.aes;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Locale;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.nacos.plugin.encryption.spi.EncryptionPluginService;

/**
 * @author Weizhan▪Yun
 * @date 2022/7/21 18:25
 */
public class AESEncryptor implements EncryptionPluginService {
	private static final String AES_PRIVATE_KEY;

	private static final String ALGORITHM = "AES";

	static {
		try {
			KeyGenerator instance;
			instance = KeyGenerator.getInstance(ALGORITHM);
			instance.init(128);
			AES_PRIVATE_KEY = new String(instance.generateKey().getEncoded(), StandardCharsets.UTF_8);

		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Encrypted interface.
	 *
	 * @param secretKey secret key
	 * @param content   content unencrypted
	 * @return encrypt value
	 */
	@Override
	public String encrypt(String secretKey, String content) {
		String encryptedContent = content;

		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM));
			encryptedContent = Base64.getEncoder()
					.encodeToString(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));
		}
		catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
			   InvalidKeyException ignored) {

		}


		return encryptedContent;
	}

	/**
	 * Decryption interface.
	 *
	 * @param secretKey secret key
	 * @param content   encrypted
	 * @return decrypt value
	 */
	@Override
	public String decrypt(String secretKey, String content) {
		String sourceContent = content;
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM));
			sourceContent = new String(cipher.doFinal(Base64.getDecoder().decode(content)), StandardCharsets.UTF_8);
		}
		catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
			   InvalidKeyException ignored) {

		}

		return sourceContent;
	}

	/**
	 * Generate Secret key.
	 *
	 * @return Secret key
	 */
	@Override
	public String generateSecretKey() {
		return AES_PRIVATE_KEY;
	}

	/**
	 * Algorithm naming.
	 *
	 * @return name
	 */
	@Override
	public String algorithmName() {
		return ALGORITHM.toLowerCase(Locale.ROOT);
	}

	/**
	 * encrypt secretKey.
	 *
	 * @param secretKey secretKey
	 * @return encrypted secretKey
	 */
	@Override
	public String encryptSecretKey(String secretKey) {
		return secretKey;
	}

	/**
	 * decrypt secretKey.
	 *
	 * @param secretKey secretKey
	 * @return decrypted secretKey
	 */
	@Override
	public String decryptSecretKey(String secretKey) {
		return secretKey;
	}
}

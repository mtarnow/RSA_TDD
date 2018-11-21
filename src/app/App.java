package app;

import javax.crypto.KeyGenerator;
import java.math.BigInteger;

public class App {

    public static void main(String[] args) {
        String message = "hello";

        // IKeyGenerator takes a generic argument, which determines the type of the returned keys
        IKeyGenerator<BigInteger[]> keyGenerator = new RSAKeyGenerator();
        BigInteger[] keys = keyGenerator.generate();
        BigInteger[] encryptKey = {keys[0], keys[2]};
        BigInteger[] decryptKey = {keys[1], keys[2]};

        RSAEncryptor encryptor = new RSAEncryptor();
        BigInteger[] cryptogram = encryptor.encrypt(message, encryptKey);
        System.out.println(cryptogram);

        RSADecryptor decryptor = new RSADecryptor();
        String decryptedMessage = decryptor.decrypt(cryptogram, decryptKey);
        System.out.println(decryptedMessage);
    }
}

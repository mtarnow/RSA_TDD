package app;

import java.math.BigInteger;

public class RSAEncryptor {

    public BigInteger[] encrypt (String message, BigInteger[] key) {
        BigInteger msg = new BigInteger(message.getBytes());
        return new BigInteger[]{new BigInteger(String.valueOf(msg.modPow(key[0], key[1])))};
    }
}

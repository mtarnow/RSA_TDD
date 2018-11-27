package app;

import java.math.BigInteger;

public class RSADecryptor {

    public String decrypt (BigInteger[] cryptogram, BigInteger[] key) {
        BigInteger dec = cryptogram[0].modPow(key[1], key[0]);
        return String.valueOf(new String(dec.toByteArray()));
    }
}

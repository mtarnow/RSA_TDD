package app;

import java.math.BigInteger;

public class RSADecryptor {

    public String decrypt (BigInteger[] cryptogram, BigInteger[] key) {
        BigInteger dec = cryptogram[0].modPow(key[0], key[1]);
        return String.valueOf(new String(dec.toByteArray()));
    }
}

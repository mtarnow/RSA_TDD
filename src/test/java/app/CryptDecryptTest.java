package app;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CryptDecryptTest {
    @Test
    public void cryptDecryptTest()
    {
        RSAKeyGenerator keygen=new RSAKeyGenerator();
        BigInteger[] key=keygen.generate();
        BigInteger[]  publicKey= Arrays.copyOfRange(key, 0, 2)  ;
        BigInteger[] privateKey=Arrays.copyOfRange(key, 1, 3);
        String  cryptogram="Ala ma kota !! 11 ą ";
        RSAEncryptor encryptor=new RSAEncryptor();
        RSADecryptor decryptor =new RSADecryptor();

        BigInteger[] crypted=encryptor.encrypt(cryptogram, privateKey);
        String decrypted=decryptor.decrypt(crypted,publicKey);
        assertEquals(cryptogram,decrypted);

    }

}

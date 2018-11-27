package app;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CryptDecryptTest {
    @Test
    public void cryptDecryptTest()
    {
        RSAKeyGenerator keygen=new RSAKeyGenerator();
        BigInteger[] key=keygen.generate();
        String  cryptogram="Ala ma kota !! 11 ą ";
        RSAEncryptor encryptor=new RSAEncryptor();
        RSADecryptor decryptor =new RSADecryptor();
        BigInteger[] crypted=encryptor.encrypt(cryptogram,key);
        String decrypted=decryptor.decrypt(crypted,key);
        assertEquals(cryptogram,decrypted);

    }

}

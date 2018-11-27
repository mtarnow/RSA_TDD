package app;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class RSAKeyGeneratorTest {
  /*  private static BigInteger[] factorise(int  n)
    {
        int p=2;
        while(n%p!=0)
        {
            p++;
        }
        int[] factors=[p;n]
    }*/
    @Test
    public void generateTest()
    {
        RSAKeyGenerator keygen=new RSAKeyGenerator();
        BigInteger[] keys=keygen.generate();
        assertNotNull(keys[0]);
        assertNotNull(keys[1]);
        assertNotNull(keys[2]);
        assertNotNull(keys[3]);
        assertEquals(keys[0],keys[2]);
        assertEquals(keys[0].compareTo(BigInteger.valueOf(2)),1);
        assertEquals(keys[0].compareTo(keys[1]),1);
        assertEquals(keys[0].compareTo(keys[3]),1);


    }
}

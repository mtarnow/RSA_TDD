package app;

import app.Algo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class AlgoTest {

    @Test
   public void  euclidGcdTestNoCoprime(){
       BigInteger a =BigInteger.valueOf(5040);
       BigInteger b=BigInteger.valueOf(29120);
       BigInteger result =Algo.euclidesGCD(a,b);
       assertEquals(result,BigInteger.valueOf(560));
   }
    @Test
    public void euclidesAreCoprimeTest_primes() {
        // prime
        BigInteger a = new BigInteger("10000019");
        // prime
        BigInteger b = new BigInteger("10002347");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_pseudoprimeCoprimes() {
        // pseudoprime (3 * 43 * 257)
        BigInteger a = new BigInteger("33153");
        // pseudoprime (151 * 331)
        BigInteger b = new BigInteger("49981");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_notCoprimes() {
        // (3 * k)
        BigInteger a = new BigInteger("13860");
        // pseudoprime (3 * 43 * 257)
        BigInteger b = new BigInteger("18200");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertFalse(result);
    }

    @Test
    public void euclidesAreCoprimeTest_primesWithNegative() {
        // negative prime
        BigInteger a = new BigInteger("-10000019");
        // prime
        BigInteger b = new BigInteger("10002347");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_pseudoprimeCoprimesWithNegative() {
        // negative pseudoprime (3 * 43 * 257)
        BigInteger a = new BigInteger("-33153");
        // pseudoprime (151 * 331)
        BigInteger b = new BigInteger("49981");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_notCoprimesWithNegative() {
        // negative number (3 * k)
        BigInteger a = new BigInteger("-10000021");
        // pseudoprime (3 * 43 * 257)
        BigInteger b = new BigInteger("33153");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertFalse(result);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void euclidesAreCoprimeTest_withZero() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = new BigInteger("4");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesAreCoprime(a, b);
    }

    @Test
    public void euclidesInverseTest_knownValueOfExistingInverse() {
        BigInteger a = new BigInteger("10001");
        BigInteger m = new BigInteger("678");
        BigInteger result = Algo.euclidesInverse(a, m);

        assertEquals(new BigInteger("341"), result);
    }

    @Test
    public void euclidesInverseTest_noInverse() {
        BigInteger a = new BigInteger("10000");
        BigInteger m = new BigInteger("678");
        BigInteger result = Algo.euclidesInverse(a, m);

        assertEquals(new BigInteger("-1"), result);
    }

    @Test
    public void euclidesInverseTest_barelyLegalArguments() {
        BigInteger a = BigInteger.ZERO;
        BigInteger m = BigInteger.ONE;

        Algo.euclidesInverse(a, m);
        // no exception thrown = success
    }

    @Test
    public void euclidesInverseTest_illegalFirstArgument() {
        BigInteger a = new BigInteger("-1");
        BigInteger m = new BigInteger("678");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesInverse(a, m);
    }

    @Test
    public void euclidesInverseTest_illegalSecondArgument() {
        BigInteger a = new BigInteger("10000");
        BigInteger m = new BigInteger("0");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesInverse(a, m);
    }

    @Test
    public void fastPower_knownResult() {
        BigInteger a = new BigInteger("134");
        BigInteger b = new BigInteger("456");
        BigInteger m = new BigInteger("26");

        BigInteger result = Algo.fastPower(a, b, m);
        assertEquals(new BigInteger("14"), result);
    }

    @Test
    public void fastPower_barelyLegalArguments() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;
        BigInteger m = BigInteger.ONE;

        Algo.fastPower(a, b, m);
        // no exception thrown = success
    }

    @Test
    public void fastPower_illegalFirstArgument() {
        BigInteger a = new BigInteger("-1");
        BigInteger b = new BigInteger("456");
        BigInteger m = new BigInteger("26");

        exception.expect(IllegalArgumentException.class);
        Algo.fastPower(a, b, m);
    }

    @Test
    public void fastPower_illegalSecondArgument() {
        BigInteger a = new BigInteger("134");
        BigInteger b = new BigInteger("-1");
        BigInteger m = new BigInteger("26");

        exception.expect(IllegalArgumentException.class);
        Algo.fastPower(a, b, m);
    }

    @Test
    public void fastPower_illegalThirdArgument() {
        BigInteger a = new BigInteger("134");
        BigInteger b = new BigInteger("456");
        BigInteger m = BigInteger.ZERO;

        exception.expect(IllegalArgumentException.class);
        Algo.fastPower(a, b, m);
    }

    @Test
    public void lcmTest() {
        BigInteger a=BigInteger.valueOf(106260);
        BigInteger b =BigInteger.valueOf(4788);
        assertEquals(Algo.lcm(a,b),BigInteger.valueOf(6056820));
    }

}

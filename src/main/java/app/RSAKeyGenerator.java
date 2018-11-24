package app;

import java.math.BigInteger;
import java.util.Random;

public class RSAKeyGenerator implements IKeyGenerator<BigInteger[]> {

    @Override
    public BigInteger[] generate() {
        BigInteger p = BigInteger.probablePrime(1024, new Random());
        BigInteger q = BigInteger.probablePrime(1024, new Random());
        BigInteger n = p.multiply(q);
        BigInteger tmp = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e;
        do {
            e = BigInteger.probablePrime(1024, new Random());
        } while (Algo.euclidesAreCoprime(e, tmp));
        BigInteger d = Algo.euclidesInverse(e, tmp);
        return new BigInteger[]{e, d, n};
    }
}

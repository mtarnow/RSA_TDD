package app;

import java.math.BigInteger;
import java.util.Random;

public class RSAKeyGenerator implements IKeyGenerator<BigInteger[]> {

    @Override
    public BigInteger[] generate() {
        /*
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
        */
        int BIT_LENGTH = 1024;

        // Generate random primes
        Random rand = new Random();
        BigInteger p = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
        BigInteger q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);

        // Calculate products
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        // Generate public and private exponents
        BigInteger e;
        do e = new BigInteger(phi.bitLength(), rand);
        while (e.compareTo(BigInteger.ONE) <= 0
                || e.compareTo(phi) >= 0
                || !e.gcd(phi).equals(BigInteger.ONE));
        BigInteger d = e.modInverse(phi);
        return new BigInteger[]{e, d, n};
    }
}

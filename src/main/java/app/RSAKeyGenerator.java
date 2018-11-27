package app;

import java.math.BigInteger;
import java.util.Random;

public class RSAKeyGenerator implements IKeyGenerator<BigInteger[]> {

//    @Override
    public BigInteger[] generate() {
/*
        BigInteger p = BigInteger.probablePrime(1024, new Random());
        BigInteger q = BigInteger.probablePrime(1024, new Random());
        BigInteger n = p.multiply(q);
        //  BigInteger tmp = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger fi=Algo.lcm(q.subtract(BigInteger.ONE),p.subtract(BigInteger.ONE));// fi(n)=lcm(p-1,q-1)
        BigInteger e =BigInteger.probablePrime(1024,new Random());
        while (! Algo.euclidesAreCoprime(e,fi) && e.compareTo(fi)==-1)
        {
            e=BigInteger.probablePrime(1024,new Random());
        }
        BigInteger d=Algo.euclidesInverse(e,fi);*/

        return  null;
    }
}

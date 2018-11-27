package app;

import java.lang.Math;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class Algo {
    // returns true if a and b are coprime and false otherwise
    public static boolean euclidesAreCoprime(BigInteger a, BigInteger b) throws IllegalArgumentException {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))
            throw new IllegalArgumentException("arguments cannot be equal to 0");
        else if(a.signum()<0||b.signum()<0)
                return false;
        else if (euclidesGCD(a, b).compareTo(BigInteger.ONE) == 0)
            return true;
        else
            return false;
    }
public static BigInteger lcm(BigInteger x, BigInteger y )
{
    return x.multiply(y).divide(euclidesGCD(x,y));
}
    // returns the GCD of a and b
    public static BigInteger euclidesGCD(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }
    private static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1)
        {
            // q is quotient
            if (m<=0) return  -1;
            int q = a / m;

            int t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }
    // returns an inverse of a mod m
    public static BigInteger euclidesInverse(BigInteger a, BigInteger m) throws IllegalArgumentException {
        if (a.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("argument 'a' cannot be less than 0");
        } else if (m.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("argument 'm' cannot be equal to or less than 0");
        } else {
                    return BigInteger.valueOf(modInverse(a.intValue(),m.intValue()));
        }
        }




    // returns a to power b mod m
    public static BigInteger fastPower(BigInteger a, BigInteger b, BigInteger m) throws IllegalArgumentException {
        if (a.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("argument 'a' cannot be less than 0");
        } else if (b.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("argument 'b' cannot be less than 0");
        } else if (m.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("argument 'm' cannot be equal to or less than 0");
        } else {
            return a.modPow(b, m);
        }
    }
}

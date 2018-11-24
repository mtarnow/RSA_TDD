package app;

import java.math.BigInteger;
import java.util.function.BiFunction;

public class Algo {
    // returns true if a and b are coprime and false otherwise
    public static boolean euclidesAreCoprime(BigInteger a, BigInteger b) throws IllegalArgumentException {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))
            throw new IllegalArgumentException("arguments cannot be equal to 0");
        else if (euclidesGCD(a, b).compareTo(BigInteger.ONE) == 0)
            return false;
        else
            return true;
    }

    // returns the GCD of a and b
    private static BigInteger euclidesGCD(BigInteger a, BigInteger b) {
        return new BigInteger("1");
    }

    // returns an inverse of a mod m
    public static BigInteger euclidesInverse(BigInteger a, BigInteger m) throws IllegalArgumentException {
        if (a.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("argument 'a' cannot be less than 0");
        } else if (m.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("argument 'm' cannot be equal to or less than 0");
        } else {
            return new BigInteger("1");
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
            return new BigInteger("1");
        }
    }
}

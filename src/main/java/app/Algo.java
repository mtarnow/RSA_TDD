package app;

import java.lang.Math;
import java.math.BigInteger;
//import java.util.function.BiFunction;

public class Algo {
    // returns true if a and b are coprime and false otherwise
    public static boolean euclidesAreCoprime(BigInteger a, BigInteger b) throws IllegalArgumentException {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))
            throw new IllegalArgumentException("arguments cannot be equal to 0");
        else if (euclidesGCD(a, b).compareTo(BigInteger.ONE) == 0)
            return true;
        else
            return false;
    }

    // returns the GCD of a and b
    public static BigInteger euclidesGCD(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    // returns an inverse of a mod m
    public static BigInteger euclidesInverse(BigInteger a, BigInteger m) throws IllegalArgumentException {
        if (a.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("argument 'a' cannot be less than 0");
        } else if (m.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("argument 'm' cannot be equal to or less than 0");
        } else {

            //Do czasu znalezienia problemu
       //     return new BigInteger("1");
            BigInteger m0 = m;
            BigInteger y = BigInteger.ZERO, x = BigInteger.ONE;

            if (m == BigInteger.ONE)
                return BigInteger.ZERO;

            while (a .compareTo(BigInteger.ONE)>0)
            {
                // q is quotient
                if (m.compareTo(BigInteger.ZERO)<=0) return  BigInteger.valueOf(-1);
                BigInteger q = a.divide(m);

                BigInteger t = m;

                // m is remainder now, process
                // same as Euclid's algo
                m = a. mod(m);
                a = t;
                t = y;

                // Update x and y
                y = x .subtract(q .multiply(y));
                x = t;
            }

            // Make x positive
            if (x .compareTo(BigInteger.ZERO)<0)
                x =x.add(m0);

            return x;
/*
            BigInteger u= new BigInteger("1");
            BigInteger x= new BigInteger("0");
            BigInteger w= a;
            BigInteger z= m;

            while(!w.equals(new BigInteger("0"))) {
                if (w.compareTo(z) < 0) {
                    BigInteger q = u;
                    u = x;
                    x = q;
                    q = w;
                    w = z;
                    z = q;
                }
                BigInteger q = w.divide(z);
                u = u.subtract(q.multiply(x));
                w = w.subtract(q.multiply(x));
            }
            if(z.equals(new BigInteger("1"))) {
                if (x.compareTo(new BigInteger("0")) < 0) {
                    x = x.add(m);
                }
                return x;
            }
            else {
                return new BigInteger("-1");
            }
            */
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

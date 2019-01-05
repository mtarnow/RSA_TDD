package app;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class AlgoJMH {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    public BigInteger primeNum1;
    public BigInteger primeNum2;
    public BigInteger primeNum3;
    public BigInteger notPrimeNum1;
    public BigInteger notPrimeNum2;
    public BigInteger smallNum1;
    public BigInteger smallNum2;
    public BigInteger smallNum3;

    @Setup
    public void init() {
        primeNum1 = BigInteger.probablePrime(2048,
                new Random());
        primeNum2 = BigInteger.probablePrime(2048,
                new Random());
        primeNum3 = BigInteger.probablePrime(2048,
                new Random());
        notPrimeNum1 = new BigInteger(2048,
                new Random());
        while (notPrimeNum1.bitLength() != 2048)
            notPrimeNum1 = new BigInteger(2048,
                    new Random());
        if (notPrimeNum1.mod(new BigInteger("2")) != BigInteger.ZERO)
            notPrimeNum1 = notPrimeNum1.add(BigInteger.ONE);
        notPrimeNum2 = new BigInteger(2048,
                new Random());
        while (notPrimeNum2.bitLength() != 2048)
            notPrimeNum2 = new BigInteger(2048,
                    new Random());
        if (notPrimeNum2.mod(new BigInteger("2")) != BigInteger.ZERO)
            notPrimeNum2 = notPrimeNum2.add(BigInteger.ONE);
        smallNum1 = new BigInteger("26");
        smallNum2 = new BigInteger("15");
        smallNum3 = new BigInteger("7");
    }

    // euclidesAreCoprimeBenchmark -------------------------------------------------

    // euclidesAreCoprimeBenchmark_unallowedArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_unallowedArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_unallowedArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // euclidesAreCoprimeBenchmark_easyArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_easyArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(smallNum1, smallNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_easyArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(smallNum1, smallNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // euclidesAreCoprimeBenchmark_properPrimeArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_properPrimeArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(primeNum1, primeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_properPrimeArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(primeNum1, primeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }


    // euclidesAreCoprimeBenchmark_properNotPrimeArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_properNotPrimeArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(notPrimeNum1, notPrimeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesAreCoprimeBenchmark_properNotPrimeArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesAreCoprime(notPrimeNum1, notPrimeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // euclidesInverseBenchmark -------------------------------------------------

    // euclidesInverseBenchmark_unallowedArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_unallowedArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_unallowedArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // euclidesInverseBenchmark_easyArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_easyArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(smallNum1, smallNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_easyArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(smallNum1, smallNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // euclidesInverseBenchmark_properArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_properArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(primeNum1, primeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void euclidesInverseBenchmark_properArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.euclidesInverse(primeNum1, primeNum2));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // fastPowerBenchmark -------------------------------------------------

    // fastPowerBenchmark_unallowedArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_unallowedArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_unallowedArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // fastPowerBenchmark_easyArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_easyArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(smallNum1, smallNum2, smallNum3));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_easyArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(smallNum1, smallNum2, smallNum3));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    // fastPowerBenchmark_properArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_properArgs_at(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(primeNum1, primeNum2, primeNum3));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void fastPowerBenchmark_properArgs_tp(Blackhole bh) throws InterruptedException {
        try {
            bh.consume(Algo.fastPower(primeNum1, primeNum2, primeNum3));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }
}

package app;

        import org.openjdk.jmh.annotations.*;
        import org.openjdk.jmh.infra.Blackhole;

        import java.math.BigInteger;
        import java.util.Random;
        import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class RSATestJMH {
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
    public BigInteger[] encryptKey = new BigInteger[2];
    public BigInteger[] decryptKey = new BigInteger[2];
    public BigInteger[] shortMsgCryptogram;
    public BigInteger[] longMsgCryptogram;
    public String longMessage;


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

        IKeyGenerator<BigInteger[]> keyGenerator = new RSAKeyGenerator();
        BigInteger[] keys = keyGenerator.generate();
        encryptKey[0] = keys[0];
        encryptKey[1] = keys[2];
        decryptKey[0] = keys[1];
        decryptKey[1] = keys[2];

        longMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam iaculis hendrerit libero ac sodales. Morbi nulla justo, congue sed dictum eget, molestie eu sem. Vivamus elementum mattis tortor ac sagittis. Praesent ultrices augue ac commodo consequat. Quisque eget magna ac augue venenatis vulputate. Donec vitae tristique dolor. Nunc nibh felis, blandit ac dictum eget, consequat eget risus. Pellentesque in nisl ac neque aliquet feugiat. Mauris nisl tortor, posuere eget fringilla a, ultrices eget arcu. Mauris eget mauris sapien. Phasellus suscipit vel orci dignissim dignissim. Integer in tellus lobortis, molestie mi in, porta odio. Integer et sem leo. Phasellus justo leo, varius et pharetra eget, cursus accumsan risus. Mauris vel enim quis libero placerat tincidunt id et elit. Mauris vitae ultrices dui, eu accumsan lacus.";

        RSAEncryptor encryptor = new RSAEncryptor();
        longMsgCryptogram = encryptor.encrypt(longMessage, encryptKey);
        shortMsgCryptogram = encryptor.encrypt("hello", encryptKey);
    }

    // euclidesAreCoprimeBenchmark -------------------------------------------------

    // euclidesAreCoprimeBenchmark_unallowedArgs
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void RSAKeyGenerator_generate_at(Blackhole bh) throws InterruptedException {
        try {
            RSAKeyGenerator keyGen = new RSAKeyGenerator();
            bh.consume(keyGen.generate());
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
    public void RSAKeyGenerator_generate_tp(Blackhole bh) throws InterruptedException {
        try {
            RSAKeyGenerator keyGen = new RSAKeyGenerator();
            bh.consume(keyGen.generate());
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void RSAEncryptor_encrypt_shortMessage_at(Blackhole bh) throws InterruptedException {
        try {
            RSAEncryptor enc = new RSAEncryptor();
            bh.consume(enc.encrypt("hello",encryptKey));
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
    public void RSAEncryptor_encrypt_shortMessage_tp(Blackhole bh) throws InterruptedException {
        try {
            RSAEncryptor enc = new RSAEncryptor();
            bh.consume(enc.encrypt("hello",encryptKey));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void RSAEncryptor_encrypt_longMessage_at(Blackhole bh) throws InterruptedException {
        try {
            RSAEncryptor enc = new RSAEncryptor();
            bh.consume(enc.encrypt(longMessage,encryptKey));
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
    public void RSAEncryptor_encrypt_longMessage_tp(Blackhole bh) throws InterruptedException {
        try {
            RSAEncryptor enc = new RSAEncryptor();
            bh.consume(enc.encrypt(longMessage,encryptKey));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void RSADecryptor_decrypt_shortMessage_at(Blackhole bh) throws InterruptedException {
        try {
            RSADecryptor dec = new RSADecryptor();
            bh.consume(dec.decrypt(shortMsgCryptogram,decryptKey));
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
    public void RSADecryptor_decrypt_shortMessage_tp(Blackhole bh) throws InterruptedException {
        try {
            RSADecryptor dec = new RSADecryptor();
            bh.consume(dec.decrypt(shortMsgCryptogram,encryptKey));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1) // test powtarzamy tylko dla jednego procesu
    @Warmup(iterations = 1, time = 2) // jedna iteracja rozgrzewkowa trwająca 2 sekundy
    @Measurement(iterations = 2, time = 2) // dwie iteracje pomiarowe, każda trwające 2 sekundy
    public void RSADecryptor_decrypt_longMessage_at(Blackhole bh) throws InterruptedException {
        try {
            RSADecryptor dec = new RSADecryptor();
            bh.consume(dec.decrypt(longMsgCryptogram,decryptKey));
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
    public void RSADecryptor_decrypt_longMessage_tp(Blackhole bh) throws InterruptedException {
        try {
            RSADecryptor dec = new RSADecryptor();
            bh.consume(dec.decrypt(longMsgCryptogram,encryptKey));
        } catch (IllegalArgumentException e) {
            // DO NOTHING
        }
    }




}

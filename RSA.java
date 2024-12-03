import java.io.*;
import java.math.*;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a Prime number: ");
        BigInteger p = sc.nextBigInteger();        
        System.out.print("Enter another prime number: ");
        BigInteger q = sc.nextBigInteger();
       
        BigInteger n = p.multiply(q);
        BigInteger phiOfN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // φ(n) = (p-1)(q-1)
       
        BigInteger e = generateE(phiOfN);
       
        BigInteger d = e.modInverse(phiOfN);
       
       
        System.out.println("Encryption keys are: " + e + ", " + n);
        System.out.println("Decryption keys are: " + d + ", " + n);
    }

    public static BigInteger generateE(BigInteger phiOfN) {
        Random random = new Random();
        BigInteger e;
        do {
           
            e = new BigInteger(phiOfN.bitLength(), random);
        } while (e.compareTo(BigInteger.TWO) <= 0 || !phiOfN.gcd(e).equals(BigInteger.ONE));
        return e;
    }
}

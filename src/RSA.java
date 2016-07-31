import java.util.Random;
import java.util.Scanner;

public class RSA {

    // method for generating random number
    private static int randInt() {
        return new Random().nextInt((10000 - 1) + 1) + 1;
    }

    // method for checking if a number is positive
    private static boolean isPos(int n) {
        return (n > 0);
    }

    // method for checking if a number is prime
    private static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    // method for finding a random positive prime
    private static int genPrime() {
        int randNo = new Random().nextInt();
        while (!isPrime(randNo) || !isPos(randNo)) {
            randNo = randInt();
        }
        return randNo;
    }

    // method for finding gcd of two numbers
    // recursive implementation
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    // method for generating the totient of the product
    // m = (p-1)(q-1)
    private static int m (int p, int q){
        return (p-1) * (q-1);
    }

    // method for finding e
    private static int genE () {
        int e = genPrime();
        while (e > m(p,q)) {
            e = genPrime();
        }
        return e;
    }

    // Choose two distinct prime numbers p and q
    private static int p = genPrime();
    private static int q = genPrime();

    // Compute n = pq
    private static int n = p * q;

    // Compute the multiplicative inverse
    private static int multiplicativeInverse (int e, int m) {
        e = e % m;
        for (int i = 1; 1 < m; i++)
            if ((e * i) % m == 1)
                return i;
        return 0;
    }

    public static void main (String args[]) {

        // Choose two distinct prime numbers p and q
        System.out.println("p = " + p + " q = " + q);

        // Compute n = pq
        System.out.println("n = " + p + " * " + q);
        System.out.println("n = " + n);

        System.out.println();

        // Compute the totient of the product as φ(n) = m = (p − 1)(q − 1)
        int m = (p-1) * (q-1);
        System.out.println("m = (p-1) * (q-1)");
        System.out.println("m = (" + p + "-1)" +  " * (" + q + "-1)");
        System.out.println("m = " + (p-1) + " * " + (q-1));
        System.out.println("m = " + m);

        System.out.println();

        // Choose any number 1 < e < m that is coprime to m
        int e = genE();
        System.out.println("e = " + e);

        System.out.println();

        // Compute d, the modular multiplicative inverse of e (mod φ(n))
        int d = multiplicativeInverse(e,m);
        System.out.println("d = " + d);

        System.out.println();

        // Public Key
        System.out.println("The Public Key is n = " + n + " , e = " + e);

        System.out.println();

        // Private Key
        System.out.println("The Private Key is d = " + d);

        System.out.println();

        // Encrypt
        System.out.println("Enter the number that you wish to encrypt:");
        Scanner scan = new Scanner(System.in);
        int enc = scan.nextInt();
        int c = (enc ^ e) % n;
        System.out.println();
        System.out.println("The encrypted number is: " + c);

        // Decrypt
        System.out.println("Enter the number that you wish to decrypt:");
        int dec = scan.nextInt();
        int x = (dec ^ d) % n;
        System.out.println();
        System.out.println("The decrypted number is: " + x);
    }

}
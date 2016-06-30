import java.util.Random;

public class RSA {

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
            randNo = new Random().nextInt();
        }
        return randNo;
    }

    // method for finding gcd of two numbers
    // recursive implementation
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    // method for finding e
    // TODO

    public static void main (String args[]) {

        // Choose two distinct prime numbers p and q
        int p = genPrime();
        int q = genPrime();
        System.out.println("p = " + p + " q = " + q);

        // Compute n = pq
        long n = p * q;
        System.out.println("n = " + p + " * " + q);
        System.out.println("n = " + n);

        // Compute the totient of the product as φ(n) = m = (p − 1)(q − 1)
        long m = (p-1) * (q-1);
        System.out.println("m = (" + p + "-1)" +  " * (" + q + "-1)");
        System.out.println("m = " + (p-1) + " * " + (q-1));
        System.out.println("m = " + m);

        // Choose any number 1 < e < m that is coprime to m
        // TODO
        // int e;

        // compute e * d = mod m
        // TODO
    }
}
package Array;

import java.util.ArrayList;

public class EnumeratePrimeNumbers {
    // Prime Number - divisible by only itself and 1
    public static void main(String[] args) {

    }


    // O(n^1.5)
    private static int[] getPrimeSimple(int n) {
        if(n == 0 || n == 1) {
            return new int[0];
        }

        ArrayList<Integer> primes = new ArrayList<>();

        // O(n * sqrt(n))
        // Go through each possible number until n
        int i = 2;
        while (i < n) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        // O(n)
        // ArrayList to array
        int[] primes_arr = new int[primes.size()];
        for(i = 0; i < primes.size(); i++) primes_arr[i] = primes.get(i);

        return primes_arr;
    }

    // O(sqrt(n))
    private static boolean isPrime(int i) {
        // O(sqrt(n))
        // Go through each number until i to test if it is prime
        boolean isPrime = true;
        for(int j = 2; j * j < i; j++) {
            if(i % j == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    // O(n)
    private static boolean isPrimeBruteForce(int i) {
        // O(n)
        // Go through each number until i to test if it is prime
        boolean isPrime = true;
        for(int j = 2; j < i; j++) {
            if(i % j == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }


    //
    // Bonus
    //

    // O(n * log(log(n)) * n) time
    // Sieve of Eratosthenes
    private static int[] getPrime(int n) {
        if(n == 0 || n == 1) {
            return new int[0];
        }

        // O(n * log(log(n)) * n) time
        // For each number to n, find if prime using Sieve of Eratosthenes
        ArrayList<Boolean> isPrimes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            isPrimes.add(true);
        }
        isPrimes.set(0, false);
        isPrimes.set(1, false);

        for(int i = 0; i < n; i++) {
            if(isPrimes.get(i)) {
                int j = i + i;
                while(j < n) {
                    isPrimes.set(j, false);
                    j += i;
                }
            }
        }

        // O(n)
        // Get all primes
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(isPrimes.get(i)) {
                primes.add(i);
            }
        }

        // O(n)
        // ArrayList to array
        int[] primes_arr = new int[primes.size()];
        for(int i = 0; i < primes.size(); i++) primes_arr[i] = primes.get(i);

        return primes_arr;
    }



}

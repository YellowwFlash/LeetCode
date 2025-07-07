import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    // Approach-1 -> Using basic iterating
    public static List<Integer> findPrimeFactorsIteration(int n) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Start iteration from 1 till n for all factors
        for (int i = 1; i <= n; i++)
            // If n is divisible by i and i is prime, add it
            if (n % i == 0 && isPrime(i))
                result.add(i);

        // Return the final result
        return result;
    }

    private static boolean isPrime(int n) {

        // If n <= 1, there is no prime
        if (n <= 1)
            return false;

        // If n <= 3, it is prime(2,3)
        if (n <= 3)
            return true;

        // If n is divisible by 2 or 3, its not prime
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        // Start from 5 till root of n
        // All primes falls in patter of 6k+1 or 6k-1
        for (int i = 5; i * i <= n; i += 6)

            // If any of the pattern is breaking, its not prime
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Approach-2 -> Using the cascade method
    public static List<Integer> findPrimeFactorsCascade(int n) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Traverse from 1 till root of n
        for (int i = 1; i * i <= n; i++) {

            // If i divides n and is a prime, add it
            if (n % i == 0 && isPrime(i))
                result.add(i);

            // Since i divides n, n/i also divides n
            if (n / i != i && isPrime(n / i))
                result.add(n / i);
        }

        // Return the final result
        return result;
    }

    // Approach-3 -> Using simple divisions
    public static List<Integer> findPrimeFactors(int n) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Iterate from 2 till the root of n
        for (int i = 2; i * i <= n; i++) {

            // if n is divisible by i, divide it until its not
            if (n % i == 0) {

                // Add current number to result
                result.add(i);

                // Divide n until no divisible by i or its factors
                while (n % i == 0)
                    n /= i;
            }
        }

        // Add the final number remaining as n
        if (n > 1)
            result.add(n);

        // Return the final result
        return result;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieve {

    // Approach-1 -> Using Sieve of Eratosthenes
    public static List<Integer> sieveOfEratosthenes(int n) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Primes boolean array
        boolean[] primes = new boolean[n + 1];

        // Fill the array with true values
        Arrays.fill(primes, true);

        // Starting from 2 till n
        for (int i = 2; i * i <= n; i++) {

            // Only mark multiples if current multiple is not prime
            if (primes[i])

                for (int j = i * i; j <= n; j += i)
                    // Mark the multiple true as its visited
                    primes[j] = false;

        }

        // Collect all the primes
        for (int i = 2; i <= n; i++)
            if (primes[i])
                result.add(i);

        return result;
    }

    // Approach-2 -> For Q queries and finding count in range [L,R]
    public static List<Integer> getPrimesInRange(int[][] queries) {

        // Result list
        List<Integer> result = new ArrayList<>();

        int[] primesCounted = getSieve(1000000);

        // Traverse the queries
        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];

            // Add the result for l to r range
            result.add(primesCounted[R] - primesCounted[L - 1]);
        }

        // Return the final result
        return result;
    }

    public static int[] getSieve(int n) {

        // Result array
        int[] result = new int[n + 1];

        // Fill the array with 1
        Arrays.fill(result, 1);

        // Fill the 0 and 1 as 0 since they arent prime
        result[0] = result[1] = 0;

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++)

            if (result[i] != 0)
                for (int j = i * i; j <= n; j += i)
                    result[j] = 0;

        // Find the prefix sum of the result array
        for (int i = 2; i <= n; i++)
            result[i] += result[i - 1];

        return result;
    }
}

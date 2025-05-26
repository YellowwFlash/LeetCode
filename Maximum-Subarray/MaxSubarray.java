public class MaxSubarray {

    // Approach-1 -> Using two for loops to calculate every possible subarray sum -> O(n^2)
    public int maxSubarray(int numbers[]) {
         int result = Integer.MIN_VALUE; // The result will hold the max so initializing with min value
         int current = 0; // current sum 

        // Looping through the array to find each and every possible subarray sum
        for (int i = 0; i < numbers.length; i++) {
            current = 0;
            for (int j = i; j < numbers.length; j++)
                current += numbers[j];

            result = Math.max(result, current); 
        }

        return result;
    }

    // Approach-2 -> Using Kadane's Algo -> O(n)
    public int maxSubarrayKadaneAlgo(int numbers[]) {
        int result = Integer.MIN_VALUE; // The result will hold the max so initializing with min value
        int current = 0; // current sum

        for (int number : numbers) {
            current += number;

            // Update the result for the maximum value
            result = Math.max(result, current);

            // if current sum goes down -ve, it is ignored and resetted to 0
            if (current < 0)
                current = 0;
                
        }

        return result;
    }
}
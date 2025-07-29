import java.util.Arrays;

public class FractionalKnapsack {

    public static class Pair {
        int weight, value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // Approach-1 -> Using greedy sorting method
    public static double fractionalKnapsack(int[] weight, int[] value, int capacity) {

        // Find length
        int n = weight.length;

        // Create an array of pairs
        Pair[] items = new Pair[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Pair(weight[i], value[i]);
        }

        // Sort the array in decreasing order of value/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;

        // Iterate through the sorted array and add items to the knapsack
        for (Pair item : items) {
            if (capacity == 0) {
                break;
            }

            int currentWeight = Math.min(item.weight, capacity);
            totalValue += currentWeight * (double) item.value / item.weight;
            capacity -= currentWeight;
        }

        // Return the total value of the items in the knapsack
        return totalValue;
    }
}

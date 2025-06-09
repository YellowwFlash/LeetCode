public class LeadersInArray {

    // Approach-1 -> Using the two loops
    public static void leaders(int[] nums) {
        int n = nums.length;

        // Using two loops to find whether there is a larger element or not
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            inner: for (int j = i + 1; j < n; j++) {
                // The current element is not feasible to be a leader
                if (nums[i] < nums[j]) {
                    flag = false;
                    break inner;
                }
            }
            if (flag)
                System.out.println("Flag : " + nums[i]);
        }
    }

    // Approach-2 -> Using the backward traversal
    public static void leadersOptimized(int[] nums) {
        int n = nums.length;

        // Choose the current leader
        int leader = nums[n - 1];

        // Traverse the array from backwards
        for (int i = n - 2; i >= 0; i++) {
            // If the current element is greater than the leader, then update the leader
            if (nums[i] > leader) {
                System.out.println("Leader : " + nums[i]);
                leader = nums[i];
            }
        }
    }
}

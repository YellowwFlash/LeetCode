public class MajorityElement {

    // Approach-1 -> Using Moore's voting algorithm
    public static int majorityElement(int[] nums) {
        int count = 0, candidate = 0, n = nums.length;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            count += (candidate == num) ? 1 : -1;
        }

        int check = 0;
        for (int num : nums)
            if (num == candidate)
                check++;

        if (check > (n / 2))
            return candidate;

        return -1;
    }
}

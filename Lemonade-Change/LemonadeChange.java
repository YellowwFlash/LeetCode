public class LemonadeChange {

    // Approach-1 -> Using greedy sorting method
    public static boolean lemonadeChange(int[] customers) {

        // Keep tracking variables
        int fives = 0, tens = 0;

        // Iterate through customers
        for (int customer : customers) {

            // If the value is 5, no change required
            if (customer == 5)
                fives++;

            // If the value is 10, change of 5 is required
            else if (customer == 10) {
                tens++;

                if (fives > 0)
                    fives--;
                else
                    return false;
            }

            // If the value is 20, change of 15 is required
            else {

                if (fives > 0 && tens > 0) {
                    fives--;
                    tens--;
                } else if (fives > 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }

        // Return true since all the customer can get change
        return true;
    }
}

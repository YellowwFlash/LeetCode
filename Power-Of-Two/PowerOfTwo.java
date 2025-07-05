public class PowerOfTwo {

    // Approach-1 -> Using log function
    public boolean powerOfTwoLog(int n) {

        // Find the natural log of given number with base 2
        int log = (int) (Math.log(n) / Math.log(2));

        return (int) (Math.pow(2, log)) == n;
    }

    // Approach-2 -> Using bitwise &(and) operator
    public boolean powerOfTwoAnd(int n) {

        // For any number less than 1 is no power of 2
        if (n <= 0)
            return false;

        // Number anded with number-1 will result in 0
        return (n & (n - 1)) == 0;
    }
}

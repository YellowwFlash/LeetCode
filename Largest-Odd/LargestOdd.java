public class LargestOdd {

    // Appraoch-1 -> Using basic maths
    public static String largestOdd(String num) {

        int n = num.length();

        // Start traversing from back
        for (int i = n - 1; i >= 0; i++) {

            // Current character
            char ch = num.charAt(i);

            // If ch is 1,3,5,7,9 ,its an odd number so return
            if ((ch - '0') % 2 == 1)
                // Given number is odd, hence return a substring of num
                return num.substring(0, i + 1);
        }

        return "";
    }
}

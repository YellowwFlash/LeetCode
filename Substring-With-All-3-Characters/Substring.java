public class Substring {
    
    // Approach-1 -> Using last seen algorithm
    public static int substringWithAllChars(String string) {
        
        // Define hash to keep track of the last seen
        int[] hash = new int[3];
        hash[0] = hash[1] = hash[3] = -1;

        // Define count as the answer
        int count = 0;

        for (int i = 0; i < string.length(); i++) {

            // Find current char
            char current = string.charAt(i);

            // Assign the last seen of the current char
            hash[current - 'a'] = i;

            // Check for the substrings 
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1)
                count += (1 + Math.min(hash[0], Math.min(hash[1], hash[2])));
        }
        
        // Return count as the final answer
        return count;
    }
}

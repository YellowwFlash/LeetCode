public class BookAllocation {

    // Approach-1 -> Using the linear search
    public static int findMinMaxBook(int[] pages, int students) {

        if (pages.length < students)
            return -1;

        // Define search space
        int util[] = findSumMax(pages);
        int start = util[0], end = util[1];

        // Linear scan
        for (int i = start; i <= end; i++) {

            // Check if the current page limit is valid or not
            if (isPageLimitValid(pages, students, i))
                return i;

        }

        return -1;
    }

    // Approach-2 -> Using modified binary search
    public static int findMinMaxBookBS(int[] pages, int students) {

        if (pages.length < students)
            return -1;

        // Define the search space
        int util[] = findSumMax(pages);
        int low = util[0], high = util[1];
        int answer = -1;

        // Modified binary search
        while (low <= high) {

            // Find mid
            int mid = low + (high - low) / 2;

            // Check the validity for mid
            if (isPageLimitValid(pages, students, mid)) {
                // Add mid as potential answer
                answer = mid;
                // Go to the left to find the minimum possible
                high = mid - 1;
            }

            // If not possible, then go to right
            else
                low = mid + 1;
        }

        return answer;
    }

    private static boolean isPageLimitValid(int[] pages, int students, int limit) {

        int currentStudents = 1, currentPages = 0;

        // Start with the pages validation
        for (int page : pages) {

            // Check if the current page can be added or not
            if (currentPages + page > limit) {
                // Reset the pages to current page
                currentPages = page;
                // Increment the current students
                currentStudents++;
            }
            // If it is then simply add the pages
            else
                currentPages += page; // Add the pages to the current student

            // At any point, the current students exceeds the total students, return false
            if (currentStudents > students)
                return false;
        }

        return currentStudents == students;
    }

    private static int[] findSumMax(int[] pages) {

        int max = pages[0], sum = 0;

        for (int page : pages) {
            max = Math.max(max, page);
            sum += page;
        }

        return new int[] { max, sum };
    }
}

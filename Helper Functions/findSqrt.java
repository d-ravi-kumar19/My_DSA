class Solution {

    // using linear search
    int findSqrt(int n) {
        if (n == 0 || n == 1) {
            return n; // Handle edge cases for 0 and 1
        }

        for (int i = 1; i <= n / 2; i++) { // Adjusted to include n/2
            if (i * i == n) {
                return i;
            }
        }
        return -1; // Return -1 if n is not a perfect square
    }

    // using binary search
    int findSqrtBS(int n) {
        if (n == 0 || n == 1) {
            return n; 
        }

        int low = 0;
        int high = n / 2 + 1; 
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                low = mid + 1;
                ans = mid; // Update answer to the last valid mid
            } else {
                high = mid - 1;
            }
        }

        return ans; // Return the integer part of the square root
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 25;

        // linear search
        System.out.println("Square root of " + number + " using linear search: " + solution.findSqrt(number));

        // binary search
        System.out.println("Square root of " + number + " using binary search: " + solution.findSqrtBS(number));
    }
}

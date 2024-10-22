class Solution {

    // Method to find the square root using binary search with k decimal places
    double findSqrtWithPrecision(int n, int k) {
 
        if (n == 0 || n == 1) {
            return n; 
        }

        int low = 0;
        int high = n / 2 + 1;
        int intSqrt = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == n) {
                return mid; 
            } else if (mid * mid < n) {
                low = mid + 1;
                intSqrt = mid; 
            } else {
                high = mid - 1;
            }
        }

        // Start calculating the decimal part
        double result = intSqrt;
        double increment = 0.1; // Start with tenths place

        // Iterate for k decimal places
        for (int i = 0; i < k; i++) {
            while (result * result <= n) {
                result += increment; // Increase result until square exceeds n
            }
            result -= increment; // Step back to the last valid result
            increment /= 10; // Move to the next decimal place
        }

        return result; // Return the final result with k decimal places
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 35;
        int k = 5; // Number of decimal places

        double sqrt = solution.findSqrtWithPrecision(number, k);
        System.out.printf("Square root of %d with %d decimal places: %.5f%n", number, k, sqrt, k);
    }
}

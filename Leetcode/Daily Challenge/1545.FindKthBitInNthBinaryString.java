
// 1545. Find Kth Bit in Nth Binary String
// Solved
// Medium
// Topics
// Companies
// Hint
// Given two positive integers n and k, the binary string Sn is formed as follows:

// S1 = "0"
// Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
// Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

// For example, the first four strings in the above sequence are:

// S1 = "0"
// S2 = "011"
// S3 = "0111001"
// S4 = "011100110110001"
// Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

 

// Example 1:

// Input: n = 3, k = 1
// Output: "0"
// Explanation: S3 is "0111001".
// The 1st bit is "0".
// Example 2:

// Input: n = 4, k = 11
// Output: "1"
// Explanation: S4 is "011100110110001".
// The 11th bit is "1".
 

// Constraints:

// 1 <= n <= 20
// 1 <= k <= 2n - 1


// =================== SOLUTION -1 ============================


class Solution {
    public char findKthBit(int n, int k) {
        String s1 = "0";
        String s = "";

        for (int i = 1; i < n; i++) {
            String modString = modify(s1);
            s = s1 + "1" + modString;
            s1 = s;
        }
        System.out.println(s1);

        return s1.charAt(k - 1);
    }

    private String modify(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = (arr[i] == '0' ? '1' : '0');
            arr[i] = (arr[arr.length - i - 1] == '0' ? '1' : '0');
            arr[arr.length - i - 1] = temp;
        }

        return new String(arr);
    }
}



// =========================== SOLUTION -2 ==========================

class Solution {
    public char findKthBit(int n, int k) {
        // return '0' or '1' based on the result
        return solve(n, k) == 0 ? '0' : '1';
    }

    private int solve(int n, int k) {

        // Base case: 
        // for the first binary string, return 0 if k is 1
        if (n == 1 || k == 1) {
            return 0;
        }

        // length of the N-th string (2^n - 1)
        int len = (1 << n) - 1; 
        // midpoint of the string
        int mid = len / 2;

        // If k is in the first half, continue in the first half
        if (mid > k - 1) {
            return solve(n - 1, k);
        } 
        // If k is in the second half, continue with reversed position of the first half
        else if (mid < k - 1) {
            return solve(n - 1, len - k + 1) == 1 ? 0 : 1;
        }
        else{
            // If k equals the midpoint, the bit is always '1'
            return 1;
        }
    }
}

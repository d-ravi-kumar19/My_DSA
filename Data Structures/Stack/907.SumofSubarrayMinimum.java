// 907. Sum of Subarray Minimums
// Solved
// Medium
// Topics
// Companies
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:

// Input: arr = [11,81,94,43,3]
// Output: 444
 

// Constraints:

// 1 <= arr.length <= 3 * 104
// 1 <= arr[i] <= 3 * 104




import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] right = findNSEE(arr);
        int[] left = findPSE(arr);
        long res = 0;

        for(int i=0; i<n; i++){
            res = ( res + (long)arr[i]* left[i]* right[i]) % MOD;
        }
        return (int)res;
    }

    private int[] findNSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int i=n-1; i>= 0 ; i-- ){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n-i : st.peek() - i;
            st.push(i);
        }

        return nse;
    }    

    private int[] findPSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for(int i= 0; i < n ; i++ ){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? i + 1 : i - st.peek() ;
            st.push(i);
        }

        return pse;
    }    
}
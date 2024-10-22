// Largest Palindromic Substringlocked

// Given a string, find the length of the largest palindromic substring.

// Input Format
// First line of input contains T - number of test cases. Its followed by 2T lines. The first line contains N - the size of the string and the second line contains a string of size N, containing only lowercase english alphabets.

// Constraints
// 30 points
// 1 <= T <= 200
// 1 <= len(S) <= 102
// 'a' <= S[i] <= 'z'

// 70 points
// 1 <= T <= 200
// 1 <= len(S) <= 103
// 'a' <= S[i] <= 'z'

// Output Format
// For each test case, print the length of the largest palindromic substring, separated by newline.

// Sample Input 0
// 5
// 8
// pfyafafd
// 9
// sllwffoqq
// 6
// yoogvb
// 4
// hcch
// 23
// mzmqnnrkurfmmfrukrnnqsm

// Sample Output 0
// 3
// 2
// 2
// 4
// 18


import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); 
            String s = sc.next(); 

            // Find the length of the longest palindromic substring
            int result = longestPalindromicSubstring(s);
            System.out.println(result);
        }
        sc.close();
    }

    private static int longestPalindromicSubstring(String s) {
        int maxLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // for odd-length palindromes (single character center)
            maxLength = Math.max(maxLength, expandAroundCenter(s, i, i));

            // for even-length palindromes (two character center)
            maxLength = Math.max(maxLength, expandAroundCenter(s, i, i + 1));
        }

        return maxLength;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        char[] arr = s.toCharArray(); 
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        // Length of the palindrome
        return right - left - 1; // (right - 1) - (left + 1) + 1 = right - left - 1
    }
}

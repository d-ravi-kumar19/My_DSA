// 131. Palindrome Partitioning

// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int start, String s, List<List<String>> result,List<String> temp){
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int end = start; end< s.length(); end++){
            if(isPalindrome(s, start, end)){
                temp.add(s.substring(start, end + 1));
                backtrack(end + 1, s, result, temp);
                temp.remove(temp.size() -1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
       while(low < high){
        if(s.charAt(low++) != s.charAt(high--)){
            return false;
        }
       }
        return true;
    }
}
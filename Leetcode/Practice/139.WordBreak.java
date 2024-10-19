// 139. Word Break

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() +1];

        return backtrack( s, 0, dict, dp);
    }
    
    private boolean backtrack(String s,int ind, HashSet<String> dict, Boolean[] dp){
        if(ind == s.length()){
            return true;
        }

        if(dp[ind] != null){
            return dp[ind];
        }

        for(int i = ind; i < s.length(); i++){

            String word = s.substring(ind ,i+1);

            if(dict.contains(word) && backtrack(s,i+1,dict, dp))
            {
                System.out.println(word);
                return dp[ind] = true;
            }
        }

        return dp[ind] = false;
    }
}
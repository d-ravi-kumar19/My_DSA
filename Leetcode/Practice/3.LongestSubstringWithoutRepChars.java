// 3. Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

// 3.LongestSubstringWithoutRepChars

class LongestSubstringWithoutRepChars {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length() ==0)
        // return 0;
        // HashMap<Character,Integer> hm = new HashMap<>();

        // int left=0, right=0;
        // int ans =0;
        // // hm.put(s.charAt(right),right);
        // // right++;

        // while(right < s.length()){
        //     if(hm.containsKey(s.charAt(right))){
        //         System.out.println(hm.get(s.charAt(right)));
        //         left = Math.max(left, hm.get(s.charAt(right)) + 1);
        //     }

        //     hm.put(s.charAt(right), right);
        //     ans = Math.max(ans, right - left + 1);
        //     right += 1;

        //     // ans = Math.max(ans, right - left +1 );
        // }
        // return ans;

        int n=s.length();
        int[] lastIndex=new int[128];
        int maxLen=0;
        int start=0;

        for(int end=0;end<n;end++){
            char currentChar=s.charAt(end);
            start=Math.max(start, lastIndex[currentChar]);
            maxLen=Math.max(maxLen, end-start+1);
            lastIndex[currentChar]=end+1;
        }
        return maxLen;
    }
}
// 30. Substring with Concatenation of All Words

// You are given a string s and an array of strings words. All the strings of words are of the same length.

// A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
// Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.



// Example 1:

// Input: s = "barfoothefoobarman", words = ["foo","bar"]

// Output: [0,9]

// Explanation:

// The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
// The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

// Example 2:

// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

// Output: []

// Explanation:

// There is no concatenated substring.

// Example 3:

// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

// Output: [6,9,12]

// Explanation:

// The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
// The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
// The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



// Constraints:

// 1 <= s.length <= 104
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// s and words[i] consist of lowercase English letters.


// =========================== SOLUTION - 1 ================================
// Little Bit tuff to understand

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();  // To store the starting indices of valid substrings
        
        int len = s.length();       // Length of the input string `s`
        int n = words.length;       // Number of words in the array `words`
        int wordSize = words[0].length();  // Length of each word in `words`
        int windowSize = wordSize * n;     // Total length of the substring we are looking for (concatenation of all words)
        
        // Frequency map to track how many times each word appears in the `words` array
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // Try starting the sliding window from every possible position within a word
        for (int i = 0; i < wordSize; i++) {
            int startPos = i;  // Start position for this iteration
            
            int left = startPos;  // Left pointer of the sliding window
            Map<String, Integer> currMap = new HashMap<>();  // To track current words in the window
            int count = 0;  // Number of valid words matched in the current window
            
            // Slide the window across the string `s`, checking windows of size `windowSize`
            for (int right = startPos; right + wordSize <= len; right += wordSize) {
                // Extract the current word at the right end of the window
                String currWord = s.substring(right, right + wordSize);
                
                if (freqMap.containsKey(currWord)) {
                    // Add the current word to `currMap` and update the count
                    currMap.put(currWord, currMap.getOrDefault(currWord, 0) + 1);
                    
                    if (currMap.get(currWord) <= freqMap.get(currWord)) {
                        count++;
                    }
                    
                    // If the window size exceeds, remove the leftmost word to maintain size
                    while (right - left + wordSize > windowSize) {
                        String leftWord = s.substring(left, left + wordSize);
                        left += wordSize;
                        
                        if (freqMap.containsKey(leftWord)) {
                            if (currMap.get(leftWord) <= freqMap.get(leftWord)) {
                                count--;
                            }
                            currMap.put(leftWord, currMap.get(leftWord) - 1);
                        }
                    }
                    
                    // If all words match, add the start index to the result
                    if (count == n) {
                        res.add(left);
                    }
                } else {
                    // Reset the window if a non-matching word is found
                    currMap.clear();
                    count = 0;
                    left = right + wordSize;
                }
            }
        }
        
        return res;  // Return the list of starting indices where valid substrings are found
    }
}

//  ================================== SOLUTION -2 =============================
// Easy to Understand

class SolutionA{
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();               
        int m = words.length;
        int w = words[0].length(); 

        // Create a hash table chars to store the frequency of each word in the words array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);  
        }

        List<Integer> result = new ArrayList<>();  
        // Start at each starting point i (at most w times) to avoid missing all possible combinations
        for (int i = 0; i < w; i++) {  
            Map<String, Integer> currentWindowWordFreq = new HashMap<>();
            StringBuilder t = new StringBuilder();  // Used to dynamically construct the current word
            for (int left = i, right = i; right < n; right++) {  // Start the sliding window from index i
                t.append(s.charAt(right));  // Add the current character to t, building a word of length w
                
				if (t.length() == w) {  // When the length of t is equal to the word length w, it means that a complete word has been constructed
                    String tempStr = t.toString();
                    currentWindowWordFreq.put(tempStr, currentWindowWordFreq.getOrDefault(tempStr, 0) + 1);  // update wordFrequency in current window
                    t = new StringBuilder();  // Clear t, used to construct the next word
                }
                
                // If the size of the current window is exactly the length of m words (m*w)
                if (right - left + 1 == m * w) {
                    if (wordFreq.equals(currentWindowWordFreq)) { 
                        result.add(left); 
                    }
                    // Prepare to remove the leftmost word from the window
                    String remove = s.substring(left, left + w); 
                    if (currentWindowWordFreq.get(remove) > 1) { 
                        currentWindowWordFreq.put(remove, currentWindowWordFreq.get(remove) - 1);  
                    } else {
                        currentWindowWordFreq.remove(remove);  
                    }
                    left += w;  
                }
            }
        }
        return result;  // Returns the starting index of all matches
    }
}
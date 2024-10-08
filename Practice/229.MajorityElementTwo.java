// 229. Majority Element II

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow up: Could you solve the problem in linear time and in O(1) space?

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // boyer-moore voting algorithm
        int n = nums.length;
        List<Integer> results= new ArrayList<>();

        int candidate1 = Integer.MAX_VALUE, candidate2= Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;

        for(int num : nums){
            if(num == candidate1)
                count1++;
            else if(num == candidate2){
                count2++;
            }
            else if(count1 ==0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num == candidate1)
                count1++;
            else if(num == candidate2){
                count2++;
            }
        }

        if(count1 > n/3)
            results.add(candidate1);
        if(count2 > n/3)
            results.add(candidate2);

        return results;

        // Map<Integer, Integer> hm = new HashMap<>();
        // List<Integer> results= new ArrayList<>();

        // for(int num :nums){
        //     hm.put(num, hm.getOrDefault(num,0) +1);
        // }

        // for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
        //     if(entry.getValue() > n/3){
        //         results.add(entry.getKey());
        //     }
        // }

        // return results;
    }

}
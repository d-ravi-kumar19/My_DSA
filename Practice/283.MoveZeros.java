// 283. Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 

// Follow up: Could you minimize the total number of operations done?



class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0; // Pointer for scanning the array
        int p2 = 0; // Pointer for placing non-zero elements
        
        // First pass: move non-zero elements to the front
        while (p1 < nums.length) {
            if (nums[p1] != 0) {
                nums[p2] = nums[p1];
                p2++;
            }
            p1++;
        }
        
        // Second pass: fill the rest of the array with zeroes
        while (p2 < nums.length) {
            nums[p2] = 0;
            p2++;
        }
    }
}

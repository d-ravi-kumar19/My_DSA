// 42. Trapping Rain Water

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105


class TrappingRainWater {
    public int trap(int[] height) {
    /*
        --------------------------------------------
        |           TC : O(N) => O(3N)             |    
        |           SC : O(1)                      |
        --------------------------------------------
    */
        int n = height.length;
        int l =0, r = n-1;
        int lMax = 0, rMax = 0;
        int total = 0;

        while(l < r){
            if(height[l] < height[r]){
                if(lMax > height[l])
                    total += lMax - height[l];
                else
                    lMax = height[l];
                l = l + 1;
            }else{
                if(rMax > height[r])
                    total += rMax - height[r];
                else    
                    rMax = height[r];
                r = r - 1;
            }
        }

        return total;


        /*
        ----------------------------------------------------
        |           TC : O(2N) + O(N) => O(3N)             |
        |      SC : O(2N) => leftPrefix & rightPrefix      |
        ----------------------------------------------------
            int n = height.length;
            int[] prefixLeft = new int[n];
            int[] prefixRight = new int[n];

            prefixLeft[0] = height[0];
            for(int i=1; i<n; i++){
                prefixLeft[i] = Math.max(prefixLeft[i-1], height[i]);
            }

            prefixRight[n-1] = height[n-1];
            for(int i=n-2; i >=0 ; i--){
                prefixRight[i] = Math.max(prefixRight[i+1], height[i]);
            }

            int leftMax =0, rightMax = 0;
            int total = 0;

            for(int i=0; i<n; i++){
                leftMax = prefixLeft[i];
                rightMax = prefixRight[i];

                if(height[i] < leftMax || height[i] < rightMax){
                    total += Math.min(leftMax, rightMax) - height[i];
                }
            }

            return total;
        */
    }
}
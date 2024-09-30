// 85. Maximal Rectangle

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

// Example 1:


// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
// Example 2:

// Input: matrix = [["0"]]
// Output: 0
// Example 3:

// Input: matrix = [["1"]]
// Output: 1
 

// Constraints:

// rows == matrix.length
// cols == matrix[i].length
// 1 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.

import java.util.*;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length; // rows
        int m = matrix[0].length;   // cols
        int[] heights = new int[m];
        Arrays.fill(heights,0); 

        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            int area = largestHistogram(heights);
            maxArea= Math.max(area, maxArea);
        }

        /*
            int[][] prefixSumMat = new int[n[m];

            calculate prefix sum matrix
            we will traverse column wise to calculate
            for(int j=0; j<m; j++){
                int sum = 0;
                for(int i =0; i<n; i++){
                    sum += Character.getNumericValue(matrix[i][j]);

                    if(matrix[i][j] == '0')   
                        sum = 0;
                    prefixSumMat[i][j] = sum;
                }
            }

            for(int[] row : prefixSumMat){
                for(int cell: row)
                    System.out.print(cell + " ");
                System.out.println();
            }


            int maxArea = 0;
            for(int i =0 ; i<n; i++){
                maxArea = Math.max(maxArea, largestHistogram(prefixSumMat[i]));
            }
        */

        return maxArea;
    }

    private int largestHistogram(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea =0, nse =0, pse =0;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element = st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int element = st.pop();
            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, arr[element]*(nse - pse -1));
        }

        return maxArea;
    }
}
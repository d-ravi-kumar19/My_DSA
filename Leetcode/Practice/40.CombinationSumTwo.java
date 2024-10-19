// 40. Combination Sum II

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30



import java.util.*;

class combinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        // System.out.println(candidates);
        backtrack(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int ind, int[] arr, int target, List<List<Integer>> result, List<Integer> tempList){
        
            if(target == 0){
                result.add(new ArrayList<>(tempList));
            return;
            }
        
        for( int i = ind; i < arr.length; i++){
            if( i > ind && arr[i] == arr[i-1])
                continue;
            if( arr[i] > target)
                break;

            tempList.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], result, tempList);
            tempList.remove(tempList.size() - 1);
            
        }
        // else{
        //     backtrack(ind, arr,target, result, tempList);
        // }

    }
}
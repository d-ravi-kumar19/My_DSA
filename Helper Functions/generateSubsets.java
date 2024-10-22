import java.util.ArrayList;
import java.util.List;

class SubsetGenerator {

    // iteratively
    public static List<List<Integer>> generateSubsetsIterative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }

        return subsets;
    }

     // recursively
    public static List<List<Integer>> generateSubsetsRecursive(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> current, int[] nums, int index) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            current.add(nums[i]);
            backtrack(subsets, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    // using bit manipulation 
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < (1<<n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th element is included in the i-th subset
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsetsIterative(nums);
        List<List<Integer>> subsets1 = generateSubsetsRecursive(nums);
        List<List<Integer>> subsets2 = generateSubsets(nums);
        System.out.println("Subsets (Iterative)       : " + subsets);
        System.out.println("Subsets (Recursily)       : " + subsets1);
        System.out.println("Subsets (Bit Manipulation): " + subsets2);
    }
}

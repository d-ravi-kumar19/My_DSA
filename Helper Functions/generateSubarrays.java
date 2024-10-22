import java.util.Arrays;

class SubarrayGenerator {

    public static String generateSubarrays(int[] arr) {
        StringBuilder result = new StringBuilder();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int[] subarray = Arrays.copyOfRange(arr, i, j + 1);
                result.append(Arrays.toString(subarray)).append("\n");
            }
        }

        return result.toString(); 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Subarrays of the array: " + Arrays.toString(arr));
        String subarrays = generateSubarrays(arr);
        System.out.print(subarrays); // Print all subarrays
    }

// ---------------------- Output ------------------------------
//               Subarrays of the array: [1, 2, 3]
//              [1]
//              [1, 2]
//              [1, 2, 3]
//              [2]
//              [2, 3]
//              [3]
//
//--------------------------------------------------------------

}

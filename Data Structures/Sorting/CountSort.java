public class CountSort {
    public static void countSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        // Find the maximum element in the array
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Initialize count array
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Build the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countSort(arr);
        System.out.println("Sorted array (Count Sort): " + java.util.Arrays.toString(arr));
    }
}

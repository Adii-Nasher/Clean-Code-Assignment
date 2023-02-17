import java.util.Arrays;

public class reducedArray {

    public static int[] reduceIntArray(int[] inputArray) {
        // Create a copy of the input array
        int[] copyArray = Arrays.copyOf(inputArray, inputArray.length);

        // Iterate through the input array and find the minimum element and its index
        for (int i = 0; i < copyArray.length; i++) {
            int min = copyArray[i];
            int minIndex = i;

            // Search for the smallest element from the current index to the end of the array
            for (int j = i + 1; j < copyArray.length; j++) {
                if (copyArray[j] < min) {
                    min = copyArray[j];
                    minIndex = j;
                }
            }

            // Swap the current element with the smallest element found
            int temp = copyArray[i];
            copyArray[i] = min;
            copyArray[minIndex] = temp;
        }

        // Create a new array to hold the reduced form of the input array
        int[] reducedArray = new int[inputArray.length];

        // Iterate through the input array and find the index of each element in the sorted array
        for (int i = 0; i < inputArray.length; i++) {
            reducedArray[i] = findIndexInSortedArray(copyArray, inputArray[i]);
        }

        return reducedArray;
    }

    /* Finds the index of an element in a sorted integer array */
    private static int findIndexInSortedArray(int[] sortedArray, int value) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sortedArray[mid] == value) {
                return mid;
            } else if (sortedArray[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }

    public static void main(String[] args) {
        int[] inputArray = { 10, 40, 20, 50, 30 };
        int[] reducedArray = reduceIntArray(inputArray);
        System.out.println(Arrays.toString(reducedArray));
    }
}
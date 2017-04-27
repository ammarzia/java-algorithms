package Sorting;

// Average Case: Quadratic. Stable. In-place.
// Use when: Data already nearly sorted.

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7,-1,-10,4,100,200,0,0,0,2};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] arr) {
        int temp;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) { // Change to > for descending order.
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
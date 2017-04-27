package Sorting;

// Average Case: Quadratic. Stable. In-place.
// Use when: Low memory, since constant memory (rare).

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7,-1,-10,4,100,200,0,0,0,2};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) { // Change to < for descending order.
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }
}
package Sorting;

// Average Case: Linearithmic. Not stable! In-place.
// Use when: Implement based on situation.

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, -1, -10, 4, 100, 200, 0, 0, 0, 2};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] arr) {
        buildHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }


    private static void heapify(int[] arr, int n, int i) {
        int child = 2 * i + 1;
        int max = i;

        if (child < n) {
            if (arr[child] > arr[max]) {
                max = child;
            }
        }
        if (child + 1 < n) {
            if (arr[child + 1] > arr[max]) {
                max = child + 1;
            }
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }
}
package Sorting;

// Average Case: Linearithmic. Stable. Not in-place!
// Use when: Implement based on situation.

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7,-1,-10,4,100,200,0,0,0,2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        merge(arr, temp, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        merge(arr, temp, start, middle);
        merge(arr, temp, middle + 1, end);
        helper(arr, temp, start, middle, middle + 1, end);
    }

    private static void helper(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart;
        int j = rightStart;
        int k = leftStart;

        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= leftEnd) {
            temp[k++] = arr[i++];
        }

        while (j <= rightEnd) {
            temp[k++] = arr[j++];
        }

        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
}
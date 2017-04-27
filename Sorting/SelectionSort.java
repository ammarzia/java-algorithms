package Sorting;

// Average Case: Quadratic. Not stable! In-place.
// Use when: Expensive memory writes since linear write operations (SSD).

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7,-1,-10,4,100,200,0,0,0,2};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) { // Change to < for descending order.
                    index = j;
                }
            }

            int smallerNum = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNum;
        }
    }
}
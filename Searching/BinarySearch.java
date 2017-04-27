package Searching;

// Average Case: Logarithmic
// Requires data to already be sorted.

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value to find: ");
        int input = scanner.nextInt();

        System.out.println(binarySearch(array, input));
    }

    private static boolean binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;

            if (key == arr[mid]) {
                return true;
            }
            if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
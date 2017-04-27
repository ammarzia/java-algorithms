package Searching;

// Average Case: Linear

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int array[] = {0,1,2,3,4,5,6,7};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value to find: ");
        int input = scanner.nextInt();

        System.out.println(linearSearch(array, input));
    }

    private static boolean linearSearch(int[] arr, int key) {
        boolean exists = false;

        for (int anArray : arr) {
            if (anArray == key) {
                exists = true;
            }
        }
        return exists;
    }
}
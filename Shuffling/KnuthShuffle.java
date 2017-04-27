package Shuffling;

// Average Case: Linear
// Adapted from the Fisher–Yates shuffle (quadratic time complexity).

import java.util.Arrays;

public class KnuthShuffle {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        shuffle(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shuffle(Object[] obj) {
        int length = obj.length;

        for (int i = 0; i < length; i++) {
            int r = (int) (Math.random() * (i + 1));
            Object swap = obj[r];
            obj[r] = obj[i];
            obj[i] = swap;
        }
    }
}
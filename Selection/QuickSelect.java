package Selection;

// Average Case: Linear

public class QuickSelect {
    public static void main(String[] args) {
        int array[] = {200, -20, 0, 40, 0, 9, 1, 3, 4, 0, -3};
        System.out.println(findNthLargest(array, 2));
    }

    private static int findNthLargest(int[] arr, int n) {
        int start = 0, end = arr.length - 1, index = arr.length - n;

        while (start < end) {
            int pivot = partition(arr, start, end);

            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) {
                end = pivot - 1;
            } else return arr[pivot];
        }
        return arr[start];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = start, temp;

        while (start <= end) {
            while (start <= end && arr[start] <= arr[pivot]) {
                start++;
            }
            while (start <= end && arr[end] > arr[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        temp = arr[end];
        arr[end] = arr[pivot];
        arr[pivot] = temp;
        return end;
    }
}
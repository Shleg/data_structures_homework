package homework2;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        if (leftChildIdx < n && arr[leftChildIdx] > arr[largest]) {
            largest = leftChildIdx;
        }

        if (rightChildIdx < n && arr[rightChildIdx] > arr[largest]) {
            largest = rightChildIdx;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}

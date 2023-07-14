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

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChildIdx = 2 * rootIndex + 1;
        int rightChildIdx = 2 * rootIndex + 2;

        if (leftChildIdx < heapSize && array[leftChildIdx] > array[largest]) {
            largest = leftChildIdx;
        }

        if (rightChildIdx < heapSize && array[rightChildIdx] > array[largest]) {
            largest = rightChildIdx;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }
}

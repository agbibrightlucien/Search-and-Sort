import java.util.Scanner;

/**
 * ALGORITHM: Quick Sort
 *
 * DESCRIPTION:
 * Selects a pivot and partitions the array so that elements < pivot go left, > pivot go right.
 * Recursively sorts left and right subarrays.
 *
 * PSEUDOCODE:
 * quickSort(A, low, high):
 *     if low < high:
 *         pi ← partition(A, low, high)
 *         quickSort(A, low, pi - 1)
 *         quickSort(A, pi + 1, high)
 *
 * TIME COMPLEXITY: O(n log n) average, O(n²) worst
 * SPACE COMPLEXITY: O(log n)
 */

public class QuickSort {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Enter number of elements: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else scanner.next();
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                    break;
                } else scanner.next();
            }
        }

        long start = System.nanoTime();
        quickSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n) average, O(n²) worst");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}

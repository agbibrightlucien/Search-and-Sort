import java.util.Scanner;

/**
 * ALGORITHM: Merge Sort
 *
 * DESCRIPTION:
 * Recursively splits the array in half, sorts each half, then merges the sorted halves.
 *
 * PSEUDOCODE:
 * mergeSort(A, left, right):
 *     if left < right:
 *         mid ← (left + right) / 2
 *         mergeSort(A, left, mid)
 *         mergeSort(A, mid + 1, right)
 *         merge(A, left, mid, right)
 *
 * TIME COMPLEXITY: O(n log n)
 * SPACE COMPLEXITY: O(n)
 */

public class MergeSort {
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
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}

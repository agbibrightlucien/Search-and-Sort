import java.util.Scanner;

/**
 * ALGORITHM: Merge Sort
 *
 * DESCRIPTION:
 * Recursively splits the array in half, sorts each half, then merges the sorted halves.
 *
 * FLOWCHART:
 * ┌─────────────────┐
 * │      START      │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Input array     │
 * │ elements        │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Call mergeSort  │
 * │ (A, 0, n-1)     │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ MERGE SORT      │
 * │ FUNCTION        │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ left < right?│
 *    └─────┬────────┘
 *     YES  │
 *          ▼
 * ┌─────────────────┐
 * │ mid = (left +   │
 * │       right)/2  │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ mergeSort       │
 * │ (A,left,mid)    │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ mergeSort       │
 * │ (A,mid+1,right) │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ MERGE FUNCTION  │
 * │ Combine sorted  │
 * │ left & right    │
 * │ subarrays       │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Create temp     │
 * │ arrays L[], R[] │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Copy data to    │
 * │ L[] and R[]     │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Merge L[] and   │
 * │ R[] back to A[] │
 * │ in sorted order │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Return to       │
 * │ calling function│
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
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

        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble();
                    break;
                } else scanner.next();
            }
        }

        // Start sorting process
        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    private void mergeSort(double[] arr, int left, int right) {
        // Base case: if left < right, divide the array
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int mid = (left + right) / 2;
            
            // Recursively sort both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        // Initial indexes of first and second subarrays, and merged subarray
        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into arr[left..right]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }
        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}

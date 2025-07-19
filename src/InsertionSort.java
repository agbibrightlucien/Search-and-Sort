import java.util.Scanner;

/**
 * ALGORITHM: Insertion Sort
 *
 * DESCRIPTION:
 * Builds the sorted array one item at a time, by inserting each element into its correct position.
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
 * │ Initialize      │
 * │ i = 1           │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ i < n ?      │◄─────────────────┐
 *    └─────┬────────┘                  │
 *     YES  │                           │
 *          ▼                           │
 * ┌─────────────────┐                  │
 * │ key = A[i]      │                  │
 * │ j = i - 1       │                  │
 * └─────────┬───────┘                  │
 *           │                          │
 *           ▼                          │
 *    ┌──────────────┐                  │
 *    │ j >= 0 AND   │◄─────────────┐   │
 *    │ A[j] > key ? │              │   │
 *    └─────┬────────┘              │   │
 *     YES  │                       │   │
 *          ▼                       │   │
 * ┌─────────────────┐              │   │
 * │ A[j+1] = A[j]   │              │   │
 * │ (shift right)   │              │   │
 * └─────────┬───────┘              │   │
 *           │                      │   │
 *           ▼                      │   │
 * ┌─────────────────┐              │   │
 * │ j = j - 1       │──────────────┘   │
 * └─────────────────┘                  │
 *           │                          │
 *          NO                          │
 *           ▼                          │
 * ┌─────────────────┐                  │
 * │ A[j+1] = key    │                  │
 * │ (insert)        │                  │
 * └─────────┬───────┘                  │
 *           │                          │
 *           ▼                          │
 * ┌─────────────────┐                  │
 * │ i = i + 1       │──────────────────┘
 * └─────────────────┘
 *           │
 *          NO
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
 *
 * PSEUDOCODE:
 * for i ← 1 to n-1
 *     key ← A[i]
 *     j ← i - 1
 *     while j ≥ 0 and A[j] > key
 *         A[j + 1] ← A[j]
 *         j ← j - 1
 *     A[j + 1] ← key
 *
 * TIME COMPLEXITY: O(n²)
 * SPACE COMPLEXITY: O(1)
 */

public class InsertionSort {
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

        // Start the sorting process
        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            double key = arr[i];
            // Set the key (current element) and initialize position j for comparison
            int j = i - 1;
            
            // Shift elements larger than key one position to the right
            while (j >= 0 && arr[j] > key) {
                // Move element one position right
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert the key at its correct position
            arr[j + 1] = key;
        }

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

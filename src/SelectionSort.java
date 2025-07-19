import java.util.Scanner;

/**
 * ALGORITHM: Selection Sort
 *
 * DESCRIPTION:
 * Repeatedly finds the minimum element from the unsorted part and moves it to the sorted part.
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
 * │ i = 0           │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ i < n-1 ?    │◄─────────────────┐
 *    └─────┬────────┘                  │
 *     YES  │                           │
 *          ▼                           │
 * ┌─────────────────┐                  │
 * │ min = i         │                  │
 * │ j = i + 1       │                  │
 * └─────────┬───────┘                  │
 *           │                          │
 *           ▼                          │
 *    ┌──────────────┐                  │
 *    │ j < n ?      │◄─────────────┐   │
 *    └─────┬────────┘              │   │
 *     YES  │                       │   │
 *          ▼                       │   │
 *   ┌─────────────────┐            │   │
 *   │ A[j] < A[min] ? │            │   │
 *   └─────┬─────┬─────┘            │   │
 *    YES  │     │ NO               │   │
 *         ▼     ▼                  │   │
 * ┌─────────────────┐ ┌─────────┐  │   │
 * │ min = j         │ │ j = j+1 │──┘   │
 * └─────────┬───────┘ └─────────┘      │
 *           │                          │
 *           ▼                          │
 * ┌─────────────────┐                  │
 * │ j = j + 1       │                  │
 * └─────────┬───────┘                  │
 *           │                          │
 *           └──────────────────────────┘
 *           │
 *          NO
 *           ▼
 * ┌─────────────────┐
 * │ Swap A[i] and   │
 * │ A[min]          │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ i = i + 1       │
 * └─────────┬───────┘
 *           │
 *           └─────────────────────────────┘
 *           │
 *          NO
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
 *
 * PSEUDOCODE:
 * for i ← 0 to n-2
 *     min ← i
 *     for j ← i+1 to n-1
 *         if A[j] < A[min] then min ← j
 *     swap A[i] and A[min]
 *
 * TIME COMPLEXITY: O(n²)
 * SPACE COMPLEXITY: O(1)
 */

public class SelectionSort {
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

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            
            // Swap elements
            double temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

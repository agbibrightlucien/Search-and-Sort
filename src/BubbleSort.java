import java.util.Scanner;

/**
 * ALGORITHM: Bubble Sort
 *
 * DESCRIPTION:
 * Repeatedly steps through the list, compares adjacent elements, and swaps them if in the wrong order.
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
 * │ Initialize      │                  │
 * │ j = 0           │                  │
 * │ swapped = false │                  │
 * └─────────┬───────┘                  │
 *           │                          │
 *           ▼                          │
 *    ┌──────────────┐                  │
 *    │ j < n-i-1 ?  │◄────────────┐    │
 *    └─────┬────────┘             │    │
 *     YES  │                      │    │
 *          ▼                      │    │
 *   ┌─────────────────┐           │    │
 *   │ A[j] > A[j+1] ? │           │    │
 *   └─────┬─────┬─────┘           │    │
 *    YES  │     │ NO              │    │
 *         ▼     ▼                 │    │
 * ┌─────────────────┐ ┌─────────┐ │    │
 * │ Swap A[j] and   │ │ j = j+1 │─┘    │
 * │ A[j+1]          │ └─────────┘      │
 * │ swapped = true  │                  │
 * └─────────┬───────┘                  │
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
 *   ┌─────────────────┐
 *   │ swapped==false? │
 *   └─────┬─────┬─────┘
 *    YES  │     │ NO
 *         ▼     ▼
 * ┌─────────────────┐ ┌─────────┐
 * │ Array sorted    │ │ i = i+1 │─────┘
 * │ BREAK          │ └─────────┘
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
 *
 * PSEUDOCODE:
 * for i ← 0 to n-2
 *     for j ← 0 to n-i-2
 *         if A[j] > A[j+1]
 *             swap A[j] and A[j+1]
 *
 * TIME COMPLEXITY: O(n²)
 * SPACE COMPLEXITY: O(1)
 */

public class BubbleSort {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Enter number of elements: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
        }

        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble();
                    break;
                } else {
                    scanner.next();
                }
            }
        }

        // Ask for visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // consume newline
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Bubble Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            VisualizationUtils.printSeparator();
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            if (visualize) {
                System.out.println("Pass " + (i + 1) + ":");
                System.out.println("Largest " + (i + 1) + " element(s) already in correct position");
            }
            
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (visualize) {
                    VisualizationUtils.printArray(arr, new int[]{j, j + 1}, 
                        "Comparing arr[" + j + "] = " + arr[j] + " and arr[" + (j + 1) + "] = " + arr[j + 1]);
                }
                
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    
                    if (visualize) {
                        System.out.println("✓ Swapped! " + temp + " > " + arr[j]);
                        VisualizationUtils.printArray(arr, new int[]{j, j + 1}, "After swap:");
                    }
                } else {
                    if (visualize) {
                        System.out.println("✗ No swap needed. " + arr[j] + " ≤ " + arr[j + 1]);
                    }
                }
                
                if (visualize && j < n - i - 2) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            if (visualize) {
                VisualizationUtils.printArray(arr, "End of pass " + (i + 1) + ":");
                if (!swapped) {
                    System.out.println("No swaps made - array is sorted!");
                    break;
                }
                VisualizationUtils.printSeparator();
                if (i < n - 2) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            if (!swapped) break; // Optimization: if no swaps, array is sorted
        }

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

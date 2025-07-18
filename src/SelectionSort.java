import java.util.Scanner;

/**
 * ALGORITHM: Selection Sort
 *
 * DESCRIPTION:
 * Repeatedly finds the minimum element from the unsorted part and moves it to the sorted part.
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

        // =================================================================
        // BLOCK 1: INPUT VALIDATION AND ARRAY SETUP
        // =================================================================
        // Get valid array size and populate array with real numbers
        while (true) {
            System.out.print("Enter number of elements: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break; // Valid size received
            } else scanner.next(); // Clear invalid input
        }

        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble();
                    break;
                } else scanner.next(); // Clear invalid input
            }
        }

        // =================================================================
        // BLOCK 2: VISUALIZATION SETUP AND ALGORITHM START
        // =================================================================
        // Configure visualization and start performance timing
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // consume newline
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Selection Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            VisualizationUtils.printSeparator();
        }

        long start = System.nanoTime();

        // =================================================================
        // BLOCK 3: SELECTION SORT ALGORITHM IMPLEMENTATION
        // =================================================================
        // Main algorithm: find minimum element in unsorted portion and place it at the beginning
        for (int i = 0; i < n - 1; i++) {
            int min = i; // Assume first unsorted element is minimum
            
            if (visualize) {
                System.out.println("Pass " + (i + 1) + ": Finding minimum in unsorted portion");
                VisualizationUtils.printArray(arr, new int[]{i}, 
                    "Starting position " + i + " (current minimum candidate: " + arr[i] + ")");
            }
            
            // Search for actual minimum in remaining unsorted elements
            for (int j = i + 1; j < n; j++) {
                if (visualize) {
                    VisualizationUtils.printArray(arr, new int[]{min, j}, 
                        "Comparing arr[" + min + "] = " + arr[min] + " with arr[" + j + "] = " + arr[j]);
                }
                
                // Update minimum index if smaller element found
                if (arr[j] < arr[min]) {
                    min = j;
                    if (visualize) {
                        System.out.println("✓ New minimum found at index " + j + " (value: " + arr[j] + ")");
                    }
                } else {
                    if (visualize) {
                        System.out.println("✗ " + arr[j] + " ≥ " + arr[min] + ", keeping current minimum");
                    }
                }
                
                if (visualize && j < n - 1) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            if (visualize) {
                if (min != i) {
                    System.out.println("Swapping arr[" + i + "] = " + arr[i] + " with arr[" + min + "] = " + arr[min]);
                } else {
                    System.out.println("No swap needed - element at position " + i + " is already minimum");
                }
            }
            
            // Swap minimum element with first unsorted element
            double temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            
            if (visualize) {
                VisualizationUtils.printArray(arr, new int[]{i}, "After placing minimum at position " + i + ":");
                VisualizationUtils.printSeparator();
                if (i < n - 2) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

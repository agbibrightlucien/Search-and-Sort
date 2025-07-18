import java.util.Scanner;

/**
 * ALGORITHM: Insertion Sort
 *
 * DESCRIPTION:
 * Builds the sorted array one item at a time, by inserting each element into its correct position.
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

        // Ask for visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // consume newline
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Insertion Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            System.out.println("First element is considered sorted");
            VisualizationUtils.printSeparator();
        }

        long start = System.nanoTime();

        // =================================================================
        // BLOCK 4: INSERTION SORT ALGORITHM IMPLEMENTATION
        // =================================================================
        // Build sorted array one element at a time by inserting each element into correct position
        for (int i = 1; i < n; i++) {
            double key = arr[i]; // Current element to be inserted into sorted portion
            int j = i - 1; // Start from end of sorted portion
            
            if (visualize) {
                System.out.println("Step " + i + ": Inserting element " + key + " from position " + i);
                VisualizationUtils.printArray(arr, new int[]{i}, 
                    "Key to insert: " + key + " (highlighted position)");
                System.out.println("Sorted portion: [0.." + (i-1) + "], Unsorted: [" + i + ".." + (n-1) + "]");
            }
            
            // Shift elements that are greater than key to make space for insertion
            while (j >= 0 && arr[j] > key) {
                if (visualize) {
                    System.out.println("Comparing key " + key + " with arr[" + j + "] = " + arr[j]);
                    System.out.println("Shifting " + arr[j] + " one position right");
                }
                
                arr[j + 1] = arr[j]; // Move element one position right
                j--; // Move to next element in sorted portion
                
                if (visualize) {
                    VisualizationUtils.printArray(arr, new int[]{j + 2}, "After shifting:");
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            arr[j + 1] = key; // Insert key at correct position in sorted portion
            
            if (visualize) {
                VisualizationUtils.printArray(arr, new int[]{j + 1}, 
                    "Inserted " + key + " at position " + (j + 1) + ":");
                System.out.println("Sorted portion now: [0.." + i + "]");
                VisualizationUtils.printSeparator();
                if (i < n - 1) {
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

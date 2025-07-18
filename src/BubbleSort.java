import java.util.Scanner;

/**
 * ALGORITHM: Bubble Sort
 *
 * DESCRIPTION:
 * Repeatedly steps through the list, compares adjacent elements, and swaps them if in the wrong order.
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

        // =================================================================
        // BLOCK 1: INPUT VALIDATION FOR ARRAY SIZE
        // =================================================================
        // Ensure user enters a valid positive integer for array size
        while (true) {
            System.out.print("Enter number of elements: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break; // Valid positive integer received
            } else {
                scanner.next(); // Clear invalid input from scanner buffer
            }
        }

        // =================================================================
        // BLOCK 2: ARRAY CREATION AND ELEMENT INPUT
        // =================================================================
        // Create array to hold real numbers and collect user input
        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble(); // Store valid real number
                    break; // Move to next element
                } else {
                    scanner.next(); // Clear invalid input from scanner buffer
                }
            }
        }

        // =================================================================
        // BLOCK 3: VISUALIZATION OPTION SELECTION
        // =================================================================
        // Ask user if they want to see step-by-step visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // Consume leftover newline from previous input
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        // Initialize visualization if requested
        if (visualize) {
            System.out.println("\n=== Bubble Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            VisualizationUtils.printSeparator();
        }

        // =================================================================
        // BLOCK 4: PERFORMANCE TIMING START
        // =================================================================
        // Record start time for performance measurement
        long start = System.nanoTime();

        // =================================================================
        // BLOCK 5: BUBBLE SORT ALGORITHM IMPLEMENTATION
        // =================================================================
        // Outer loop: controls the number of passes through the array
        // After each pass, the largest unsorted element "bubbles up" to its correct position
        for (int i = 0; i < n - 1; i++) {
            if (visualize) {
                System.out.println("Pass " + (i + 1) + ":");
                System.out.println("Largest " + (i + 1) + " element(s) already in correct position");
            }
            
            // Flag to track if any swaps occurred in this pass (optimization)
            boolean swapped = false;
            
            // Inner loop: compare adjacent elements and swap if they're in wrong order
            // Reduce range each iteration as largest elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (visualize) {
                    VisualizationUtils.printArray(arr, new int[]{j, j + 1}, 
                        "Comparing arr[" + j + "] = " + arr[j] + " and arr[" + (j + 1) + "] = " + arr[j + 1]);
                }
                
                // Compare adjacent elements and swap if left > right
                if (arr[j] > arr[j + 1]) {
                    // Swap the two elements (bubble larger element towards the end)
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                    
                    if (visualize) {
                        System.out.println("✓ Swapped! " + temp + " > " + arr[j]);
                        VisualizationUtils.printArray(arr, new int[]{j, j + 1}, "After swap:");
                    }
                } else {
                    // Elements are already in correct order, no swap needed
                    if (visualize) {
                        System.out.println("✗ No swap needed. " + arr[j] + " ≤ " + arr[j + 1]);
                    }
                }
                
                // Pause between comparisons for visualization (except last comparison)
                if (visualize && j < n - i - 2) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            // End of pass visualization and early termination check
            if (visualize) {
                VisualizationUtils.printArray(arr, "End of pass " + (i + 1) + ":");
                if (!swapped) {
                    System.out.println("No swaps made - array is sorted!");
                    break; // Early exit from visualization as well
                }
                VisualizationUtils.printSeparator();
                if (i < n - 2) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            // Optimization: if no swaps occurred, array is already sorted
            if (!swapped) break;
        }

        // =================================================================
        // BLOCK 6: PERFORMANCE TIMING END AND RESULT OUTPUT
        // =================================================================
        // Record end time and display results
        long end = System.nanoTime();

        // Display sorted array and performance metrics
        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

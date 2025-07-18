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
    private boolean visualize = false;
    private int step = 1;
    
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
        visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Quick Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            System.out.println("Quick Sort uses divide-and-conquer with partitioning");
            VisualizationUtils.printSeparator();
        }

        // =================================================================
        // BLOCK 4: QUICK SORT ALGORITHM START
        // =================================================================
        // Start recursive quicksort with performance timing
        long start = System.nanoTime();
        quickSort(arr, 0, n - 1); // Sort entire array
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n) average, O(n²) worst");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    // =================================================================
    // RECURSIVE QUICK SORT IMPLEMENTATION
    // =================================================================
    private void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            if (visualize) {
                System.out.println("Step " + step++ + ": Sorting range [" + low + ".." + high + "]");
                printSubarray(arr, low, high, high, "Pivot: arr[" + high + "] = " + arr[high]);
            }
            
            // Partition array and get pivot index
            int pi = partition(arr, low, high);
            
            if (visualize) {
                printSubarray(arr, low, high, pi, "After partitioning - Pivot at index " + pi);
                System.out.println("Elements ≤ " + arr[pi] + " are to the left, elements > " + arr[pi] + " are to the right");
                VisualizationUtils.printSeparator();
                VisualizationUtils.pauseForVisualization();
            }
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);  // Sort left subarray
            quickSort(arr, pi + 1, high); // Sort right subarray
        }
    }

    // =================================================================
    // PARTITION FUNCTION - REARRANGE ARRAY AROUND PIVOT
    // =================================================================
    private int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element

        if (visualize) {
            System.out.println("Partitioning with pivot = " + pivot);
        }

        // Scan through array and rearrange elements relative to pivot
        for (int j = low; j < high; j++) {
            if (visualize) {
                printSubarray(arr, low, high, j, "Comparing arr[" + j + "] = " + arr[j] + " with pivot " + pivot);
            }
            
            // If current element is smaller than or equal to pivot
            if (arr[j] < pivot) {
                i++; // Increment index of smaller element
                if (visualize && i != j) {
                    System.out.println("✓ " + arr[j] + " < " + pivot + ", swapping arr[" + i + "] with arr[" + j + "]");
                }
                
                // Swap elements to move smaller element to left side
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;
                
                if (visualize && i != j) {
                    printSubarray(arr, low, high, i, "After swap:");
                }
            } else {
                if (visualize) {
                    System.out.println("✗ " + arr[j] + " ≥ " + pivot + ", no swap needed");
                }
            }
            
            if (visualize && j < high - 1) {
                VisualizationUtils.pauseForVisualization();
            }
        }

        // Place pivot in its correct final position
        if (visualize) {
            System.out.println("Final step: placing pivot in correct position");
            System.out.println("Swapping pivot arr[" + high + "] = " + arr[high] + " with arr[" + (i + 1) + "] = " + arr[i + 1]);
        }

        // Swap pivot with element at position i+1
        double temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp;
        
        return i + 1; // Return index of pivot in its final position
    }
    
    private void printSubarray(double[] arr, int low, int high, int highlight, String message) {
        System.out.println(message);
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i >= low && i <= high) {
                if (i == highlight) {
                    System.out.print("*" + arr[i] + "*");
                } else {
                    System.out.print(arr[i]);
                }
            } else {
                System.out.print("_");
            }
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Working range: [" + low + ".." + high + "]");
        System.out.println();
    }
}

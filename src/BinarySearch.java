import java.util.Arrays;
import java.util.Scanner;

/**
 * ALGORITHM: Binary Search
 *
 * DESCRIPTION:
 * Searches a sorted array by repeatedly dividing the search interval in half.
 *
 * PSEUDOCODE:
 * low ← 0
 * high ← n - 1
 * while low ≤ high do
 *     mid ← (low + high) / 2
 *     if A[mid] == key return mid
 *     else if key < A[mid] high ← mid - 1
 *     else low ← mid + 1
 * return -1
 *
 * TIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 */

public class BinarySearch {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n;

        // =================================================================
        // BLOCK 1: INPUT VALIDATION FOR ARRAY SIZE
        // =================================================================
        // Ensure user enters a valid positive integer for array size
        while (true) {
            System.out.print("Enter number of elements in the array: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break; // Valid positive integer received
                else System.out.println("Enter a positive number.");
            } else {
                System.out.println("Invalid input!");
                scanner.next(); // Clear invalid input from scanner buffer
            }
        }

        // =================================================================
        // BLOCK 2: ARRAY CREATION AND ELEMENT INPUT
        // =================================================================
        // Create array to hold real numbers and collect user input
        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers (they will be sorted for binary search):");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble(); // Store valid real number
                    break; // Move to next element
                } else {
                    System.out.println("Invalid input!");
                    scanner.next(); // Clear invalid input from scanner buffer
                }
            }
        }

        // =================================================================
        // BLOCK 3: ARRAY SORTING (PREREQUISITE FOR BINARY SEARCH)
        // =================================================================
        // Binary search requires the array to be sorted, so sort it first
        Arrays.sort(arr); // Uses efficient sorting algorithm (typically Dual-Pivot Quicksort)
        System.out.println("Array sorted for binary search: ");
        for (double num : arr) System.out.print(num + " ");
        System.out.println();

        // =================================================================
        // BLOCK 4: SEARCH KEY INPUT AND VALIDATION
        // =================================================================
        // Get the value to search for with input validation
        double key;
        while (true) {
            System.out.print("Enter the search key: ");
            if (scanner.hasNextDouble()) {
                key = scanner.nextDouble(); // Store the search key
                break; // Valid input received
            } else {
                System.out.println("Invalid input!");
                scanner.next(); // Clear invalid input from scanner buffer
            }
        }

        // =================================================================
        // BLOCK 5: VISUALIZATION OPTION SELECTION
        // =================================================================
        // Ask user if they want to see step-by-step visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // Consume leftover newline from previous input
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        // Initialize visualization if requested
        if (visualize) {
            System.out.println("\n=== Binary Search Visualization ===");
            VisualizationUtils.printArray(arr, "Sorted array:");
            System.out.println("Searching for key: " + key);
            VisualizationUtils.printSeparator();
        }

        // =================================================================
        // BLOCK 6: PERFORMANCE TIMING START
        // =================================================================
        // Record start time for performance measurement
        long start = System.nanoTime();

        // =================================================================
        // BLOCK 7: BINARY SEARCH ALGORITHM IMPLEMENTATION
        // =================================================================
        // Initialize search boundaries and result variables
        int low = 0, high = n - 1, mid, index = -1;
        int step = 1; // Step counter for visualization
        
        // Continue searching while there are elements in the search range
        while (low <= high) {
            // Calculate middle index (avoids integer overflow)
            mid = (low + high) / 2;
            
            // Optional visualization: show current search step
            if (visualize) {
                VisualizationUtils.printSearchRange(arr, low, high, mid, 
                    "Step " + step + ": Searching in range [" + low + ", " + high + "]");
                System.out.println("Mid element: arr[" + mid + "] = " + arr[mid]);
                System.out.println("Comparing " + arr[mid] + " with key " + key);
            }
            
            // Check if middle element matches the search key
            // Using epsilon comparison for floating-point numbers
            if (Math.abs(arr[mid] - key) < 1e-9) {
                index = mid; // Found the key at index mid
                if (visualize) {
                    System.out.println("✓ Found! Key " + key + " matches value at index " + mid);
                }
                break; // Exit loop as key is found
            } else if (key < arr[mid]) {
                // Key is smaller than middle element, search left half
                high = mid - 1; // Eliminate right half (including mid)
                if (visualize) {
                    System.out.println("Key " + key + " < " + arr[mid] + ", searching left half");
                }
            } else {
                // Key is larger than middle element, search right half
                low = mid + 1; // Eliminate left half (including mid)
                if (visualize) {
                    System.out.println("Key " + key + " > " + arr[mid] + ", searching right half");
                }
            }
            
            // Pause for visualization if still searching
            if (visualize && low <= high) {
                VisualizationUtils.pauseForVisualization();
            }
            step++; // Increment step counter for next iteration
        }

        // =================================================================
        // BLOCK 8: PERFORMANCE TIMING END AND RESULT OUTPUT
        // =================================================================
        // Record end time and display results
        long end = System.nanoTime();

        // Display search result and performance metrics
        System.out.println(index == -1 ? "Key not found." : "Key found at index: " + index);
        System.out.println("Theoretical Time Complexity: O(log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

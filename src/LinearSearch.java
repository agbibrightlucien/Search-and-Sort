import java.util.Scanner;

/**
 * ALGORITHM: Linear Search
 *
 * DESCRIPTION:
 * Searches for a given key in an unsorted array by checking each element one by one.
 * Returns the index of the first match or -1 if not found.
 *
 * PSEUDOCODE:
 * for i ← 0 to n - 1 do
 *     if A[i] == key then
 *         return i
 * return -1
 *
 * TIME COMPLEXITY:
 * - Best Case: O(1)
 * - Worst Case: O(n)
 * - Average Case: O(n)
 *
 * SPACE COMPLEXITY:
 * - O(1) (constant space)
 */

public class LinearSearch {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // =================================================================
        // BLOCK 1: INPUT VALIDATION FOR ARRAY SIZE
        // =================================================================
        // This block ensures the user enters a valid positive integer for array size
        // It continues looping until valid input is received
        while (true) {
            System.out.print("Enter number of elements in the array: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break; // Valid positive integer received, exit loop
                else System.out.println("Please enter a positive integer.");
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear invalid input from scanner buffer
            }
        }

        // =================================================================
        // BLOCK 2: ARRAY CREATION AND ELEMENT INPUT
        // =================================================================
        // Create array of specified size to hold real numbers (doubles)
        double[] array = new double[n];

        // Input elements with validation for each array position
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    array[i] = scanner.nextDouble(); // Store valid real number in array
                    break; // Exit validation loop for this element
                } else {
                    System.out.println("Invalid input! Please enter a real number.");
                    scanner.next(); // Clear invalid input from scanner buffer
                }
            }
        }

        // =================================================================
        // BLOCK 3: SEARCH KEY INPUT AND VALIDATION
        // =================================================================
        // Get the value to search for in the array with input validation
        double key;
        while (true) {
            System.out.print("Enter the key to search for: ");
            if (scanner.hasNextDouble()) {
                key = scanner.nextDouble(); // Store the search key
                break; // Valid input received, exit validation loop
            } else {
                System.out.println("Invalid input! Please enter a real number.");
                scanner.next(); // Clear invalid input from scanner buffer
            }
        }

        // =================================================================
        // BLOCK 4: VISUALIZATION OPTION SELECTION
        // =================================================================
        // Ask user if they want to see step-by-step visualization of the algorithm
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // Consume leftover newline from previous input
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        // Initialize visualization if requested
        if (visualize) {
            System.out.println("\n=== Linear Search Visualization ===");
            VisualizationUtils.printArray(array, "Initial array:");
            System.out.println("Searching for key: " + key);
            VisualizationUtils.printSeparator();
        }

        // =================================================================
        // BLOCK 5: PERFORMANCE TIMING START
        // =================================================================
        // Record start time for performance measurement
        long startTime = System.nanoTime();

        // =================================================================
        // BLOCK 6: LINEAR SEARCH ALGORITHM IMPLEMENTATION
        // =================================================================
        // The core linear search algorithm - check each element sequentially
        int index = -1; // Initialize result index (-1 means not found)
        
        // Loop through each element in the array from start to end
        for (int i = 0; i < n; i++) {
            // Optional visualization: show current step
            if (visualize) {
                VisualizationUtils.printArray(array, new int[]{i}, 
                    "Step " + (i + 1) + ": Checking index " + i + " (value: " + array[i] + ")");
                
                // Use epsilon comparison for floating-point equality
                if (Math.abs(array[i] - key) < 1e-9) {
                    System.out.println("✓ Found! Key " + key + " matches value at index " + i);
                } else {
                    System.out.println("✗ No match. " + array[i] + " ≠ " + key);
                }
                
                // Pause for user to see the step (except on last iteration)
                if (i < n - 1) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            // Check if current element matches the search key
            // Using epsilon comparison for floating-point numbers to handle precision issues
            if (Math.abs(array[i] - key) < 1e-9) {
                index = i; // Store the found index
                break; // Exit loop immediately when found (first occurrence)
            }
            }
        }

        // =================================================================
        // BLOCK 7: PERFORMANCE TIMING END AND RESULT OUTPUT
        // =================================================================
        // Record end time and calculate total execution time
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // =================================================================
        // BLOCK 8: DISPLAY SEARCH RESULTS AND PERFORMANCE METRICS
        // =================================================================
        // Display whether the key was found or not
        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("Key not found in the array.");
        }

        // Display theoretical complexity and actual runtime performance
        System.out.println("Theoretical Time Complexity: O(n)");
        System.out.println("Empirical Running Time: " + elapsedTime + " nanoseconds");
    }
}

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

        // Validate array size
        while (true) {
            System.out.print("Enter number of elements in the array: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
                else System.out.println("Please enter a positive integer.");
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }

        double[] array = new double[n];

        // Input elements with validation
        System.out.println("Enter " + n + " real numbers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    array[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a real number.");
                    scanner.next();
                }
            }
        }

        // Input key with validation
        double key;
        while (true) {
            System.out.print("Enter the key to search for: ");
            if (scanner.hasNextDouble()) {
                key = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input! Please enter a real number.");
                scanner.next();
            }
        }

        // Ask for visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // consume newline
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Linear Search Visualization ===");
            VisualizationUtils.printArray(array, "Initial array:");
            System.out.println("Searching for key: " + key);
            VisualizationUtils.printSeparator();
        }

        // Start timing
        long startTime = System.nanoTime();

        // Linear Search logic with visualization
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (visualize) {
                VisualizationUtils.printArray(array, new int[]{i}, 
                    "Step " + (i + 1) + ": Checking index " + i + " (value: " + array[i] + ")");
                
                if (Math.abs(array[i] - key) < 1e-9) {
                    System.out.println("✓ Found! Key " + key + " matches value at index " + i);
                } else {
                    System.out.println("✗ No match. " + array[i] + " ≠ " + key);
                }
                
                if (i < n - 1) {
                    VisualizationUtils.pauseForVisualization();
                }
            }
            
            if (Math.abs(array[i] - key) < 1e-9) {
                index = i;
                break;
            }
        }

        // End timing
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Output result
        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("Key not found in the array.");
        }

        // Output time complexity and empirical runtime
        System.out.println("Theoretical Time Complexity: O(n)");
        System.out.println("Empirical Running Time: " + elapsedTime + " nanoseconds");
    }
}

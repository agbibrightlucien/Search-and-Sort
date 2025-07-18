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

        int[] array = new int[n];

        // Input elements with validation
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                }
            }
        }

        // Input key with validation
        int key;
        while (true) {
            System.out.print("Enter the key to search for: ");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
        }

        // Start timing
        long startTime = System.nanoTime();

        // Linear Search logic
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == key) {
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

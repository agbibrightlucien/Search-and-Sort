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

        while (true) {
            System.out.print("Enter number of elements in the array: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
                else System.out.println("Enter a positive number.");
            } else {
                System.out.println("Invalid input!");
                scanner.next();
            }
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers (they will be sorted for binary search):");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input!");
                    scanner.next();
                }
            }
        }

        Arrays.sort(arr); // Binary search requires sorted input
        System.out.println("Array sorted for binary search: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        int key;
        while (true) {
            System.out.print("Enter the search key: ");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input!");
                scanner.next();
            }
        }

        // Ask for visualization
        System.out.print("Enable step-by-step visualization? (y/n): ");
        scanner.nextLine(); // consume newline
        boolean visualize = scanner.nextLine().toLowerCase().startsWith("y");

        if (visualize) {
            System.out.println("\n=== Binary Search Visualization ===");
            VisualizationUtils.printArray(arr, "Sorted array:");
            System.out.println("Searching for key: " + key);
            VisualizationUtils.printSeparator();
        }

        long start = System.nanoTime();

        int low = 0, high = n - 1, mid, index = -1;
        int step = 1;
        
        while (low <= high) {
            mid = (low + high) / 2;
            
            if (visualize) {
                VisualizationUtils.printSearchRange(arr, low, high, mid, 
                    "Step " + step + ": Searching in range [" + low + ", " + high + "]");
                System.out.println("Mid element: arr[" + mid + "] = " + arr[mid]);
                System.out.println("Comparing " + arr[mid] + " with key " + key);
            }
            
            if (arr[mid] == key) {
                index = mid;
                if (visualize) {
                    System.out.println("✓ Found! Key " + key + " matches value at index " + mid);
                }
                break;
            } else if (key < arr[mid]) {
                high = mid - 1;
                if (visualize) {
                    System.out.println("Key " + key + " < " + arr[mid] + ", searching left half");
                }
            } else {
                low = mid + 1;
                if (visualize) {
                    System.out.println("Key " + key + " > " + arr[mid] + ", searching right half");
                }
            }
            
            if (visualize && low <= high) {
                VisualizationUtils.pauseForVisualization();
            }
            step++;
        }

        long end = System.nanoTime();

        System.out.println(index == -1 ? "Key not found." : "Key found at index: " + index);
        System.out.println("Theoretical Time Complexity: O(log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

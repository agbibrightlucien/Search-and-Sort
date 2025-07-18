import java.util.Arrays;
import java.util.Scanner;

/**
 * ALGORITHM: Binary Search
 *
 * DESCRIPTION:
 * Searches a sorted array by repeatedly dividing the search interval in half.
 *
 * FLOWCHART:
 * ┌─────────────────┐
 * │      START      │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Input array and │
 * │ sort it         │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Input search key│
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ low = 0         │
 * │ high = n-1      │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ low <= high? │◄────────────┐
 *    └─────┬────────┘             │
 *     YES  │                      │
 *          ▼                      │
 * ┌─────────────────┐             │
 * │ mid=(low+high)/2│             │
 * └─────────┬───────┘             │
 *           │                     │
 *           ▼                     │
 *   ┌───────────────┐             │
 *   │ A[mid]==key?  │             │
 *   └─────┬─────────┘             │
 *    YES  │                      │
 *         ▼                      │
 * ┌─────────────────┐             │
 * │ Return mid      │             │
 * │    (FOUND)      │             │
 * └─────────┬───────┘             │
 *           │                     │
 *      NO   ▼                     │
 *   ┌───────────────┐             │
 *   │ key < A[mid]? │             │
 *   └─────┬─────────┘             │
 *    YES  │    NO                 │
 *         ▼     ▼                 │
 * ┌─────────┐ ┌─────────┐         │
 * │high=mid-1│ │low=mid+1│─────────┘
 * └─────────┘ └─────────┘
 *           │
 *          NO
 *           ▼
 * ┌─────────────────┐
 * │ Return -1       │
 * │ (NOT FOUND)     │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
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

        double[] arr = new double[n];
        System.out.println("Enter " + n + " real numbers (they will be sorted for binary search):");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextDouble()) {
                    arr[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input!");
                    scanner.next();
                }
            }
        }

        Arrays.sort(arr); // Binary search requires sorted input
        System.out.println("Array sorted for binary search: ");
        for (double num : arr) System.out.print(num + " ");
        System.out.println();

        double key;
        while (true) {
            System.out.print("Enter the search key: ");
            if (scanner.hasNextDouble()) {
                key = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input!");
                scanner.next();
            }
        }

        long start = System.nanoTime();

        int low = 0, high = n - 1, mid, index = -1;
        
        while (low <= high) {
            mid = (low + high) / 2;
            
            if (Math.abs(arr[mid] - key) < 1e-9) {
                index = mid;
                break;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long end = System.nanoTime();

        System.out.println(index == -1 ? "Key not found." : "Key found at index: " + index);
        System.out.println("Theoretical Time Complexity: O(log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

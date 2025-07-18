import java.util.Scanner;

/**
 * ALGORITHM: Merge Sort
 *
 * DESCRIPTION:
 * Recursively splits the array in half, sorts each half, then merges the sorted halves.
 *
 * PSEUDOCODE:
 * mergeSort(A, left, right):
 *     if left < right:
 *         mid ← (left + right) / 2
 *         mergeSort(A, left, mid)
 *         mergeSort(A, mid + 1, right)
 *         merge(A, left, mid, right)
 *
 * TIME COMPLEXITY: O(n log n)
 * SPACE COMPLEXITY: O(n)
 */

public class MergeSort {
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
            System.out.println("\n=== Merge Sort Visualization ===");
            VisualizationUtils.printArray(arr, "Initial array:");
            System.out.println("Merge Sort uses divide-and-conquer approach");
            VisualizationUtils.printSeparator();
        }

        // =================================================================
        // BLOCK 4: MERGE SORT ALGORITHM START
        // =================================================================
        // Start recursive divide-and-conquer sorting
        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1); // Sort entire array
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    // =================================================================
    // RECURSIVE DIVIDE-AND-CONQUER MERGE SORT IMPLEMENTATION
    // =================================================================
    private void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find middle point to divide array
            
            if (visualize) {
                System.out.println("Step " + step++ + ": Dividing array");
                printSubarray(arr, left, right, mid, "Dividing range [" + left + ".." + right + "] at mid = " + mid);
                VisualizationUtils.pauseForVisualization();
            }
            
            // Recursively sort left and right halves
            mergeSort(arr, left, mid);      // Sort left half
            mergeSort(arr, mid + 1, right); // Sort right half
            merge(arr, left, mid, right);   // Merge sorted halves
        }
    }

    // =================================================================
    // MERGE TWO SORTED SUBARRAYS INTO ONE SORTED ARRAY
    // =================================================================
    private void merge(double[] arr, int left, int mid, int right) {
        // Calculate sizes of subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1]; // Left subarray
        double[] R = new double[n2]; // Right subarray

        // Copy data to temporary arrays
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        if (visualize) {
            System.out.println("Merging subarrays:");
            System.out.print("Left subarray: ");
            for (double num : L) System.out.print(num + " ");
            System.out.print("\nRight subarray: ");
            for (double num : R) System.out.print(num + " ");
            System.out.println();
        }

        int i = 0, j = 0, k = left; // Initialize pointers for merging

        // Merge elements from both subarrays in sorted order
        while (i < n1 && j < n2) {
            if (visualize) {
                System.out.println("Comparing L[" + i + "] = " + L[i] + " with R[" + j + "] = " + R[j]);
            }
            
            // Take smaller element and advance corresponding pointer
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
                if (visualize) {
                    System.out.println("Taking " + L[i-1] + " from left subarray");
                }
            } else {
                arr[k++] = R[j++];
                if (visualize) {
                    System.out.println("Taking " + R[j-1] + " from right subarray");
                }
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
            if (visualize) {
                System.out.println("Copying remaining " + L[i-1] + " from left");
            }
        }
        
        while (j < n2) {
            arr[k++] = R[j++];
            if (visualize) {
                System.out.println("Copying remaining " + R[j-1] + " from right");
            }
        }

        if (visualize) {
            printSubarray(arr, left, right, -1, "Merged result for range [" + left + ".." + right + "]:");
            VisualizationUtils.printSeparator();
            VisualizationUtils.pauseForVisualization();
        }
    }
    
    private void printSubarray(double[] arr, int left, int right, int mid, String message) {
        System.out.println(message);
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i >= left && i <= right) {
                if (mid != -1 && i == mid) {
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
        System.out.println("Range: [" + left + ".." + right + "]" + (mid != -1 ? ", Mid: " + mid : ""));
        System.out.println();
    }
}

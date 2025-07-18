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

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element [" + i + "]: ");
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
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

        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            if (visualize) {
                System.out.println("Step " + step++ + ": Dividing array");
                printSubarray(arr, left, right, mid, "Dividing range [" + left + ".." + right + "] at mid = " + mid);
                VisualizationUtils.pauseForVisualization();
            }
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        if (visualize) {
            System.out.println("Merging subarrays:");
            System.out.print("Left subarray: ");
            for (int num : L) System.out.print(num + " ");
            System.out.print("\nRight subarray: ");
            for (int num : R) System.out.print(num + " ");
            System.out.println();
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (visualize) {
                System.out.println("Comparing L[" + i + "] = " + L[i] + " with R[" + j + "] = " + R[j]);
            }
            
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
    
    private void printSubarray(int[] arr, int left, int right, int mid, String message) {
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

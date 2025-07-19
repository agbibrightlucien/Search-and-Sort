import java.util.Scanner;

/**
 * ALGORITHM: Quick Sort
 *
 * DESCRIPTION:
 * Selects a pivot and partitions the array so that elements < pivot go left, > pivot go right.
 * Recursively sorts left and right subarrays.
 *
 * FLOWCHART:
 * ┌─────────────────┐
 * │      START      │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Input array     │
 * │ elements        │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Call quickSort  │
 * │ (A, 0, n-1)     │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ QUICKSORT       │
 * │ FUNCTION        │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ low < high ? │
 *    └─────┬────────┘
 *     YES  │
 *          ▼
 * ┌─────────────────┐
 * │ PARTITION       │
 * │ FUNCTION        │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Choose pivot    │
 * │ (last element)  │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Rearrange array:│
 * │ elements < pivot│
 * │ go to left,     │
 * │ elements > pivot│
 * │ go to right     │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Place pivot in  │
 * │ correct position│
 * │ Return pi       │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ quickSort       │
 * │ (A,low,pi-1)    │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ quickSort       │
 * │ (A,pi+1,high)   │
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ Return to       │
 * │ calling function│
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │      END        │
 * └─────────────────┘
 *
 * PARTITION FLOWCHART:
 * ┌─────────────────┐
 * │ pivot = A[high] │
 * │ i = low - 1     │
 * └─────────┬───────┘
 *           │
 *           ▼
 *    ┌──────────────┐
 *    │ j < high ?   │◄─────────────┐
 *    └─────┬────────┘              │
 *     YES  │                       │
 *          ▼                       │
 *   ┌─────────────────┐            │
 *   │ A[j] < pivot ?  │            │
 *   └─────┬─────┬─────┘            │
 *    YES  │     │ NO               │
 *         ▼     ▼                  │
 * ┌─────────────────┐ ┌─────────┐  │
 * │ i = i + 1       │ │ j = j+1 │──┘
 * │ swap(A[i],A[j]) │ └─────────┘
 * └─────────┬───────┘
 *           │
 *           ▼
 * ┌─────────────────┐
 * │ j = j + 1       │
 * └─────────┬───────┘
 *           │
 *           └─────────────────────────┘
 *           │
 *          NO
 *           ▼
 * ┌─────────────────┐
 * │ swap(A[i+1],    │
 * │      A[high])   │
 * │ return i+1      │
 * └─────────────────┘
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

        // Start sorting process
        long start = System.nanoTime();
        quickSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (double num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n log n) average, O(n²) worst");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }

    private void quickSort(double[] arr, int low, int high) {
        // Base case: if low < high, partition and recursively sort
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(double[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        double pivot = arr[high];
        int i = low - 1; // Index of smaller element

        // Traverse through all elements
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                // Swap elements
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        double temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp;
        
        return i + 1;
    }
}

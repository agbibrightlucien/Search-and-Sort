import java.util.Scanner;

/**
 * ALGORITHM: Selection Sort
 *
 * DESCRIPTION:
 * Repeatedly finds the minimum element from the unsorted part and moves it to the sorted part.
 *
 * PSEUDOCODE:
 * for i ← 0 to n-2
 *     min ← i
 *     for j ← i+1 to n-1
 *         if A[j] < A[min] then min ← j
 *     swap A[i] and A[min]
 *
 * TIME COMPLEXITY: O(n²)
 * SPACE COMPLEXITY: O(1)
 */

public class SelectionSort {
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

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nTime Complexity: O(n²)");
        System.out.println("Empirical Running Time: " + (end - start) + " ns");
    }
}

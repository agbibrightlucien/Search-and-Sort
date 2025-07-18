/**
 * Utility class for algorithm visualization
 * Provides helper methods for displaying array states and highlighting operations
 */
public class VisualizationUtils {
    
    /**
     * Prints an array with optional highlighting of specific indices
     * @param arr The array to display
     * @param highlight Array of indices to highlight (can be null)
     * @param message Optional message to display above the array
     */
    public static void printArray(int[] arr, int[] highlight, String message) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }
        
        // Print array with highlighting
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            boolean isHighlighted = highlight != null && contains(highlight, i);
            
            if (isHighlighted) {
                System.out.print("*" + arr[i] + "*");
            } else {
                System.out.print(arr[i]);
            }
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Print indices
        System.out.print("Index: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println();
    }
    
    /**
     * Prints an array without highlighting
     * @param arr The array to display
     * @param message Optional message to display above the array
     */
    public static void printArray(int[] arr, String message) {
        printArray(arr, null, message);
    }
    
    /**
     * Helper method to check if an array contains a specific value
     */
    private static boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) return true;
        }
        return false;
    }
    
    /**
     * Pauses execution and waits for user input to continue
     */
    public static void pauseForVisualization() {
        System.out.print("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore
        }
        System.out.println();
    }
    
    /**
     * Prints a separator line for visual clarity
     */
    public static void printSeparator() {
        System.out.println("----------------------------------------");
    }
    
    /**
     * Prints range indicators for binary search
     */
    public static void printSearchRange(int[] arr, int low, int high, int mid, String message) {
        System.out.println(message);
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i == mid) {
                System.out.print("*" + arr[i] + "*");
            } else if (i >= low && i <= high) {
                System.out.print(arr[i]);
            } else {
                System.out.print("_");
            }
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Low: " + low + ", Mid: " + mid + ", High: " + high);
        System.out.println();
    }
    
    /**
     * Prints a double array with optional highlighting of specific indices
     * @param arr The array to display
     * @param highlight Array of indices to highlight (can be null)
     * @param message Optional message to display above the array
     */
    public static void printArray(double[] arr, int[] highlight, String message) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
        }
        
        // Print array with highlighting
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            boolean isHighlighted = highlight != null && contains(highlight, i);
            
            if (isHighlighted) {
                System.out.print("*" + arr[i] + "*");
            } else {
                System.out.print(arr[i]);
            }
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Print indices
        System.out.print("Index: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println();
    }
    
    /**
     * Prints a double array without highlighting
     * @param arr The array to display
     * @param message Optional message to display above the array
     */
    public static void printArray(double[] arr, String message) {
        printArray(arr, null, message);
    }
    
    /**
     * Prints range indicators for binary search with double arrays
     */
    public static void printSearchRange(double[] arr, int low, int high, int mid, String message) {
        System.out.println(message);
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i == mid) {
                System.out.print("*" + arr[i] + "*");
            } else if (i >= low && i <= high) {
                System.out.print(arr[i]);
            } else {
                System.out.print("_");
            }
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Low: " + low + ", Mid: " + mid + ", High: " + high);
        System.out.println();
    }
}

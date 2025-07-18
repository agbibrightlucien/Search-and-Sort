import java.util.Scanner;

/**
 * Main Class
 *
 * DESCRIPTION:
 * Provides a menu to allow the user to select a searching or sorting algorithm.
 * After selecting, the program runs the corresponding class implementation.
 * Each algorithm now includes optional step-by-step visualization to help
 * understand how the algorithm works internally.
 *
 * VALID ALGORITHMS:
 * - Searching: Linear Search, Binary Search
 * - Sorting: Bubble, Selection, Insertion, Merge, Quick
 * 
 * FEATURES:
 * - Interactive menu-driven interface
 * - Input validation and error handling
 * - Performance timing measurements
 * - Optional step-by-step visualization for educational purposes
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Algorithm Menu ===");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Merge Sort");
            System.out.println("7. Quick Sort");
            System.out.println("0. Exit");

            System.out.print("Choose an algorithm to run (0–7): ");
            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number between 0 and 7.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Exiting the application.");
                    return;
                case 1:
                    new LinearSearch().run();
                    break;
                case 2:
                    new BinarySearch().run();
                    break;
                case 3:
                    new BubbleSort().run();
                    break;
                case 4:
                    new SelectionSort().run();
                    break;
                case 5:
                    new InsertionSort().run();
                    break;
                case 6:
                    new MergeSort().run();
                    break;
                case 7:
                    new QuickSort().run();
                    break;
                default:
                    System.out.println("Invalid selection. Please choose a number between 0 and 7.");
            }
        }
    }
}

# Complete Algorithm Guide

## Table of Contents
1. [Introduction](#introduction)
2. [Main Class - The Program Controller](#main-class)
3. [Search Algorithms](#search-algorithms)
   - [Linear Search](#linear-search)
   - [Binary Search](#binary-search)
4. [Sorting Algorithms](#sorting-algorithms)
   - [Bubble Sort](#bubble-sort)
   - [Selection Sort](#selection-sort)
   - [Insertion Sort](#insertion-sort)
   - [Merge Sort](#merge-sort)
   - [Quick Sort](#quick-sort)
5. [Common Patterns](#common-patterns)

---

## Introduction

This program is a collection of fundamental computer science algorithms that help you understand how computers search for information and organize data. Think of it like a digital toolbox where each tool (algorithm) has a specific job to do.

**What is an Algorithm?**
An algorithm is like a recipe - it's a step-by-step set of instructions that tells the computer exactly what to do to solve a problem.

**Why Learn These?**
- They're the building blocks of all computer programs
- They help you think logically and solve problems systematically
- They're used in everything from Google searches to organizing your music playlist

---

## Main Class - The Program Controller

The `Main.java` class is like the conductor of an orchestra - it coordinates everything and lets you choose which algorithm to run.

### Line-by-Line Breakdown:

```java
import java.util.Scanner;
```
**What this does:** This line tells Java we want to use a tool called `Scanner` that helps us read input from the keyboard.
**Why we need it:** Without this, we couldn't ask the user for input.

```java
public class Main {
```
**What this does:** Creates a class (think of it as a container) called `Main`.
**Why it's important:** In Java, everything must be inside a class.

```java
public static void main(String[] args) {
```
**What this does:** This is the special method where our program starts running.
**Breaking it down:**
- `public` = everyone can use this
- `static` = belongs to the class itself, not a specific object
- `void` = doesn't return any value
- `main` = the name Java looks for to start the program
- `String[] args` = a way to receive text from the command line (we don't use it here)

```java
Scanner scanner = new Scanner(System.in);
```
**What this does:** Creates a new Scanner object that reads from the keyboard.
**Think of it as:** Setting up a microphone to listen to what the user types.

```java
while (true) {
```
**What this does:** Starts an infinite loop that keeps running until we tell it to stop.
**Why we use it:** So the user can run multiple algorithms without restarting the program.

```java
System.out.println("\n=== Algorithm Menu ===");
System.out.println("1. Linear Search");
// ... more menu options
```
**What this does:** Displays the menu options to the user.
**The `\n`:** Creates a new line for better formatting.

```java
if (scanner.hasNextInt()) {
    choice = scanner.nextInt();
} else {
    System.out.println("Invalid input! Please enter a number between 0 and 7.");
    scanner.next();
    continue;
}
```
**What this does:** Safely reads the user's choice and handles errors.
**Breaking it down:**
- `hasNextInt()` checks if the next input is a number
- If yes, `nextInt()` reads it
- If no, we show an error message and `scanner.next()` clears the bad input
- `continue` jumps back to the start of the loop

```java
switch (choice) {
    case 0:
        System.out.println("Exiting the application.");
        return;
    case 1:
        new LinearSearch().run();
        break;
    // ... more cases
}
```
**What this does:** Acts like a multi-way decision maker.
**How it works:**
- Looks at the value of `choice`
- Jumps to the matching `case`
- `new LinearSearch().run()` creates a new LinearSearch object and runs it
- `break` prevents falling through to the next case
- `return` exits the entire program

---

## Search Algorithms

Search algorithms help you find specific information in a collection of data, like finding a friend's phone number in your contacts.

## Linear Search

Linear Search is like looking for your keys by checking every pocket one by one until you find them.

### How It Works:
1. Start at the first element
2. Check if it matches what you're looking for
3. If yes, you found it! If no, move to the next element
4. Repeat until you find it or reach the end

### Line-by-Line Breakdown:

```java
public class LinearSearch {
    public void run() {
```
**What this does:** Creates the LinearSearch class with a `run()` method that starts the algorithm.

```java
Scanner scanner = new Scanner(System.in);
int n = 0;
```
**What this does:** Sets up input reading and creates a variable `n` to store how many numbers we'll search through.

```java
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
```
**What this does:** Safely gets the array size from the user.
**Why the loop:** Keeps asking until we get a valid positive number.
**The validation:** Checks if input is a number AND if it's positive.

```java
double[] array = new double[n];
```
**What this does:** Creates an array (list) that can hold `n` decimal numbers.
**Why double:** Can store both whole numbers (5) and decimals (5.7).

```java
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
```
**What this does:** Fills the array with numbers from the user.
**The outer loop:** Goes through each position in the array (0, 1, 2, ...)
**The inner loop:** Keeps asking until we get a valid number for each position.

```java
long startTime = System.nanoTime();
```
**What this does:** Records the exact time when we start searching.
**Why nanoseconds:** For very precise timing measurements.

```java
int index = -1;
for (int i = 0; i < n; i++) {
    if (Math.abs(array[i] - key) < 1e-9) {
        index = i;
        break;
    }
}
```
**What this does:** The actual search algorithm!
**Breaking it down:**
- `index = -1` means "not found" initially
- Loop through each position `i`
- `Math.abs(array[i] - key) < 1e-9` checks if numbers are equal (handles decimal precision)
- If found, save the position in `index` and `break` (stop searching)

```java
long endTime = System.nanoTime();
long elapsedTime = endTime - startTime;
```
**What this does:** Calculates how long the search took.

```java
if (index != -1) {
    System.out.println("Key found at index: " + index);
} else {
    System.out.println("Key not found in the array.");
}
```
**What this does:** Reports the result to the user.
**Remember:** Array positions start at 0, so index 0 = first element.

---

## Binary Search

Binary Search is like looking for a word in a dictionary - you open to the middle, see if your word comes before or after, then only search the relevant half.

### Important: Binary Search only works on SORTED data!

### How It Works:
1. Look at the middle element
2. If it's what you want, you're done!
3. If your target is smaller, search the left half
4. If your target is larger, search the right half
5. Repeat until found or no more elements to check

### Line-by-Line Breakdown:

The input validation part is similar to Linear Search, so I'll focus on the search algorithm:

```java
Arrays.sort(array);
System.out.println("Array sorted for binary search.");
```
**What this does:** Sorts the array automatically.
**Why necessary:** Binary search requires sorted data to work correctly.

```java
long startTime = System.nanoTime();

int low = 0;
int high = n - 1;
int index = -1;
```
**What this does:** Sets up the search boundaries.
- `low` = start of search area (position 0)
- `high` = end of search area (last position)
- `index` = result location (-1 means not found)

```java
while (low <= high) {
    int mid = (low + high) / 2;
    
    if (Math.abs(array[mid] - key) < 1e-9) {
        index = mid;
        break;
    } else if (key < array[mid]) {
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
```
**What this does:** The binary search algorithm!
**Step by step:**
1. `while (low <= high)` = keep searching while there's still area to search
2. `mid = (low + high) / 2` = find the middle position
3. `if (Math.abs(array[mid] - key) < 1e-9)` = if middle element equals our target, found it!
4. `else if (key < array[mid])` = if target is smaller, search left half by moving `high`
5. `else` = target is larger, search right half by moving `low`

**Why it's fast:** Each step eliminates half the remaining elements!

---

## Sorting Algorithms

Sorting algorithms arrange data in order (smallest to largest, or alphabetical order). Like organizing your bookshelf or arranging playing cards in your hand.

## Bubble Sort

Bubble Sort is like bubbles rising to the surface - larger elements "bubble" to the end of the array.

### How It Works:
1. Compare adjacent pairs of elements
2. If they're in wrong order, swap them
3. Go through the entire array
4. Repeat until no more swaps are needed

### Line-by-Line Breakdown:

The input part is similar to search algorithms. Here's the sorting logic:

```java
long start = System.nanoTime();

for (int i = 0; i < n - 1; i++) {
    boolean swapped = false;
    
    for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
            // Swap elements
            double temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
        }
    }
    
    if (!swapped) break;
}
```

**Breaking it down:**

**Outer loop:** `for (int i = 0; i < n - 1; i++)`
- Runs n-1 times (each pass puts one element in correct place)
- `i` tracks how many elements are already sorted at the end

**Optimization flag:** `boolean swapped = false;`
- Tracks if we made any swaps in this pass
- If no swaps, the array is already sorted!

**Inner loop:** `for (int j = 0; j < n - i - 1; j++)`
- Compares adjacent elements
- `n - i - 1` because last `i` elements are already sorted

**The comparison:** `if (arr[j] > arr[j + 1])`
- If left element is bigger than right element, they're in wrong order

**The swap:**
```java
double temp = arr[j];
arr[j] = arr[j + 1];
arr[j + 1] = temp;
```
- Like switching two items: put first in temporary box, move second to first position, put temporary item in second position

**Early termination:** `if (!swapped) break;`
- If we went through entire array without swapping, it's sorted!

### Why It's Called "Bubble Sort":
Large elements "bubble" to the end like air bubbles rising in water.

---

## Selection Sort

Selection Sort is like organizing a deck of cards by repeatedly finding the smallest card and putting it in the correct position.

### How It Works:
1. Find the smallest element in the unsorted part
2. Swap it with the first unsorted element
3. Move the boundary between sorted and unsorted parts
4. Repeat until everything is sorted

### Line-by-Line Breakdown:

```java
for (int i = 0; i < n - 1; i++) {
    int minIndex = i;
    
    for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
            minIndex = j;
        }
    }
    
    if (minIndex != i) {
        double temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

**Outer loop:** `for (int i = 0; i < n - 1; i++)`
- `i` represents the boundary between sorted and unsorted parts
- Everything before `i` is sorted, everything from `i` onward needs sorting

**Find minimum:** `int minIndex = i;`
- Assume the first unsorted element is the smallest
- `minIndex` tracks the position of the actual smallest element

**Search for smaller:** `for (int j = i + 1; j < n; j++)`
- Look through all unsorted elements (from `i+1` to end)
- If we find something smaller, update `minIndex`

**Swap if needed:** `if (minIndex != i)`
- If the smallest element isn't already in position `i`, swap them
- The swap puts the smallest unsorted element in its correct position

---

## Insertion Sort

Insertion Sort is like sorting playing cards in your hand - you take each new card and insert it into the correct position among the cards you've already sorted.

### How It Works:
1. Start with the second element (assume first is "sorted")
2. Compare it with elements before it
3. Shift larger elements to the right
4. Insert the current element in the correct position
5. Repeat for all elements

### Line-by-Line Breakdown:

```java
for (int i = 1; i < n; i++) {
    double key = arr[i];
    int j = i - 1;
    
    while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
    }
    
    arr[j + 1] = key;
}
```

**Outer loop:** `for (int i = 1; i < n; i++)`
- Start at index 1 (second element) because we consider first element already "sorted"
- `i` is the element we're currently placing in correct position

**Pick the card:** `double key = arr[i];`
- Store the current element we're trying to place
- Like picking up a card from the unsorted pile

**Prepare to shift:** `int j = i - 1;`
- `j` points to the last element in the sorted portion
- We'll work backwards from here

**Shift larger elements:** `while (j >= 0 && arr[j] > key)`
- Keep going while we're not at the beginning AND current element is larger than our key
- `arr[j + 1] = arr[j];` shifts the larger element one position to the right
- `j--` moves backwards through the sorted portion

**Insert the key:** `arr[j + 1] = key;`
- Place our picked element in its correct position
- Like sliding the card into the right spot in your hand

---

## Merge Sort

Merge Sort uses the "divide and conquer" strategy - break the problem into smaller pieces, solve each piece, then combine the solutions.

### How It Works:
1. Divide the array in half
2. Sort each half (recursively)
3. Merge the two sorted halves into one sorted array

### Line-by-Line Breakdown:

```java
public void mergeSort(double[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }
}
```

**Base case:** `if (left < right)`
- Only sort if there's more than one element
- When `left >= right`, we have 0 or 1 elements (already sorted!)

**Find middle:** `int mid = (left + right) / 2;`
- Split the array in half

**Recursive calls:**
- `mergeSort(arr, left, mid);` sorts the left half
- `mergeSort(arr, mid + 1, right);` sorts the right half
- The algorithm calls itself with smaller problems!

**Combine results:** `merge(arr, left, mid, right);`
- Merge the two sorted halves into one sorted array

### The Merge Function:

```java
private void merge(double[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    double[] L = new double[n1];
    double[] R = new double[n2];
    
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
        
    int i = 0, j = 0, k = left;
    
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```

**Calculate sizes:** 
- `n1 = mid - left + 1` = size of left subarray
- `n2 = right - mid` = size of right subarray

**Create temporary arrays:**
- `L[]` and `R[]` hold copies of the left and right subarrays

**Copy data:**
- Copy elements from original array into temporary arrays

**Merge process:**
- Compare elements from `L[]` and `R[]`
- Put smaller element into original array
- Move pointers forward
- Like merging two sorted piles of cards into one sorted pile

**Handle leftovers:**
- The last two while loops copy any remaining elements
- (One subarray might be exhausted before the other)

---

## Quick Sort

Quick Sort also uses "divide and conquer" but with a different strategy - pick a "pivot" element and partition the array around it.

### How It Works:
1. Choose a pivot element (we use the last element)
2. Partition: put all smaller elements before pivot, larger elements after
3. Recursively sort the elements before and after the pivot

### Line-by-Line Breakdown:

```java
public void quickSort(double[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

**Base case:** `if (low < high)`
- Only sort if there's more than one element

**Partition:** `int pi = partition(arr, low, high);`
- Rearrange array so all elements ≤ pivot are on left, all elements > pivot are on right
- Returns the final position of the pivot

**Recursive calls:**
- Sort elements before pivot: `quickSort(arr, low, pi - 1)`
- Sort elements after pivot: `quickSort(arr, pi + 1, high)`
- Note: pivot is already in correct position, so we don't include it!

### The Partition Function:

```java
private int partition(double[] arr, int low, int high) {
    double pivot = arr[high];
    int i = (low - 1);
    
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    double temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
}
```

**Choose pivot:** `double pivot = arr[high];`
- Use last element as pivot (simple strategy)

**Track boundary:** `int i = (low - 1);`
- `i` tracks the boundary between "≤ pivot" and "> pivot" regions
- Starts at -1 because initially no elements are processed

**Process each element:** `for (int j = low; j < high; j++)`
- Look at each element except the pivot
- If element ≤ pivot, swap it to the "≤ pivot" region
- Increment `i` to expand the "≤ pivot" region

**Place pivot:** Final swap puts pivot in its correct position
- All elements before position `i+1` are ≤ pivot
- All elements after position `i+1` are > pivot

---

## Common Patterns

### Input Validation Pattern
Every algorithm uses this pattern to safely get input:

```java
while (true) {
    System.out.print("Enter something: ");
    if (scanner.hasNextDouble()) {
        value = scanner.nextDouble();
        if (value > 0) break;  // Additional validation if needed
    } else {
        System.out.println("Invalid input!");
        scanner.next();  // Clear the bad input
    }
}
```

### Performance Measurement Pattern
Every algorithm measures how long it takes:

```java
long start = System.nanoTime();
// ... algorithm code ...
long end = System.nanoTime();
System.out.println("Time taken: " + (end - start) + " nanoseconds");
```

### Array Output Pattern
Displaying results:

```java
for (double num : arr) {
    System.out.print(num + " ");
}
```

---

## Time Complexity Summary

**Time Complexity** tells us how the algorithm's speed changes as the input size grows:

- **O(1)** - Constant: Same speed regardless of input size
- **O(log n)** - Logarithmic: Speed decreases slowly as input grows (Binary Search)
- **O(n)** - Linear: Speed decreases proportionally with input size (Linear Search)
- **O(n log n)** - Linearithmic: Faster than O(n²) but slower than O(n) (Merge Sort, Quick Sort average case)
- **O(n²)** - Quadratic: Speed decreases rapidly with input size (Bubble Sort, Selection Sort, Insertion Sort)

**Think of it this way:**
- If you have 10 items vs 100 items:
  - O(1): Takes the same time
  - O(log n): Takes slightly longer
  - O(n): Takes 10 times longer
  - O(n²): Takes 100 times longer!

This is why choosing the right algorithm matters when dealing with large amounts of data!

# Search and Sort Algorithms - AI Assistant Guidelines

## Project Overview
This is an educational Java project demonstrating fundamental search and sorting algorithms with interactive console interfaces. Each algorithm is implemented as a standalone class with comprehensive documentation including flowcharts, pseudocode, and complexity analysis.

## Architecture Patterns

### Algorithm Class Structure
Each algorithm follows a consistent pattern:
- **Documentation Header**: ASCII flowchart, pseudocode, time/space complexity
- **`run()` method**: Interactive console interface with input validation
- **Core algorithm implementation**: Clean, educational-focused code
- **Performance measurement**: Nano-time tracking for empirical analysis

Example from `BubbleSort.java`:
```java
public void run() {
    // Input validation loop
    // Array population with error handling  
    long start = System.nanoTime();
    // Algorithm implementation
    long end = System.nanoTime();
    // Results display with complexity info
}
```

### Menu-Driven Architecture
- `Main.java` provides central menu system (options 0-7)
- Each algorithm is instantiated and executed via `.run()` method
- Consistent user experience across all algorithms

## Code Conventions

### Input Validation Pattern
All classes use robust input validation:
```java
while (true) {
    if (scanner.hasNextInt()) {
        value = scanner.nextInt();
        if (value > 0) break;
    } else {
        scanner.next(); // Clear invalid input
    }
}
```

### Documentation Standards
- **ASCII Flowcharts**: Visual algorithm representation in comments
- **Pseudocode**: Step-by-step algorithm logic
- **Complexity Analysis**: Big-O notation for time and space
- **Algorithm Description**: Clear explanation of approach

### Performance Measurement
Standard pattern using `System.nanoTime()`:
```java
long start = System.nanoTime();
// algorithm execution
long end = System.nanoTime();
System.out.println("Empirical Running Time: " + (end - start) + " ns");
```

## Key Implementation Details

### Data Types
- Uses `double[]` arrays for numerical data to support real numbers
- Console input via `Scanner` with comprehensive error handling
- Menu system uses integer choices (0-7)

### Algorithm Categories
- **Search Algorithms**: `LinearSearch.java`, `BinarySearch.java`
- **Sorting Algorithms**: `BubbleSort.java`, `SelectionSort.java`, `InsertionSort.java`, `MergeSort.java`, `QuickSort.java`

### Optimization Features
- Early termination optimizations (e.g., `swapped` flag in bubble sort)
- Clear separation between algorithm logic and user interface
- Consistent error messaging and user guidance

## Development Workflow

### Adding New Algorithms
1. Create new class in `src/` following naming convention
2. Implement comprehensive documentation header with flowchart
3. Follow the `run()` method pattern for user interaction
4. Add menu option in `Main.java` switch statement
5. Include performance timing and complexity display

### Testing Approach
- Manual testing through interactive console interface
- Test edge cases: empty arrays, single elements, pre-sorted data
- Verify input validation handles all error conditions
- Confirm performance measurements are displayed

This codebase prioritizes educational clarity over production optimization, making algorithm understanding the primary goal.

#include <stdio.h>
#include <stdlib.h> // For malloc/free if a true O(n) temp array was used, but not for this in-place method.

// ---
// Function Prototypes
// ---
void inPlaceMergeSort(int arr[], int left, int right);
void inPlaceMerge(int arr[], int left, int mid, int right);
void printArray(int arr[], int size);

/**
 * @brief Implements an in-place merge sort algorithm.
 *
 * This version aims to minimize additional space usage during the merge step,
 * typically achieving O(1) auxiliary space for the merge operation itself.
 *
 * Time Complexity: O(n log n) - Although the merge step is more complex due
 * to shifting elements, the overall time complexity remains O(n log n).
 * Space Complexity: O(log n) - Due to the recursion stack. True O(1) auxiliary space
 * for merge sort is highly complex or leads to O(n^2) worst-case time for some approaches.
 * This implementation avoids creating new arrays for merging.
 *
 * @param arr The array to be sorted.
 * @param left The starting index of the sub-array.
 * @param right The ending index of the sub-array.
 */
void inPlaceMergeSort(int arr[], int left, int right) {
    if (left < right) {
        // Calculate mid-point to avoid overflow for large `left` and `right`
        int mid = left + (right - left) / 2;

        // Recursively sort the first and second halves
        inPlaceMergeSort(arr, left, mid);
        inPlaceMergeSort(arr, mid + 1, right);

        // Merge the sorted halves in-place
        inPlaceMerge(arr, left, mid, right);
    }
}

/**
 * @brief Merges two sorted sub-arrays in-place: arr[left...mid] and arr[mid+1...right].
 *
 * This function performs an in-place merge. It iterates through the left sub-array.
 * If an element from the left sub-array is greater than an element from the right
 * sub-array, the element from the right sub-array is "inserted" into its correct
 * position in the left sub-array by shifting elements.
 *
 * While this method avoids a large auxiliary array, the shifting operations can be
 * computationally intensive, leading to a higher constant factor in the O(n log n)
 * time complexity compared to out-of-place merge sort.
 *
 * @param arr The array containing the sub-arrays to be merged.
 * @param left The starting index of the first sub-array.
 * @param mid The ending index of the first sub-array (and mid+1 is start of second).
 * @param right The ending index of the second sub-array.
 */
void inPlaceMerge(int arr[], int left, int mid, int right) {
    int i = left;      // Pointer for the first sub-array (left...mid)
    int j = mid + 1;   // Pointer for the second sub-array (mid+1...right)

    // Iterate while both pointers are within their respective sub-array bounds
    while (i <= mid && j <= right) {
        // If the element in the left sub-array is smaller or equal, it's in place
        if (arr[i] <= arr[j]) {
            i++;
        } else {
            // Element arr[j] (from right sub-array) is smaller than arr[i] (from left).
            // This means arr[j] needs to be moved to the position of arr[i].
            // To do this, we save arr[j], then shift elements from arr[i] to arr[j-1]
            // one position to the right to make space, and finally insert arr[j].
            int valueToInsert = arr[j];
            int indexToShift = j;

            // Shift elements to the right to create a slot for `valueToInsert`
            while (indexToShift > i) {
                arr[indexToShift] = arr[indexToShift - 1];
                indexToShift--;
            }
            // Place the `valueToInsert` at the correct spot
            arr[i] = valueToInsert;

            // Adjust pointers and mid-point for the updated sub-arrays
            i++;     // Current element `arr[i]` is now sorted.
            mid++;   // The 'left' sorted part has effectively grown.
            j++;     // The element `arr[j]` has been moved and processed.
        }
    }
}

/**
 * @brief Prints the elements of an array.
 *
 * @param arr The array to print.
 * @param size The number of elements in the array.
 */
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d%s", arr[i], (i == size - 1 ? "" : ", "));
    }
    printf("\n");
}

// ---
// Main function for testing
// ---
int main() {
    // Sample 1: Unsorted Array
    int arr1[] = {5, 2, 8, 1, 9, 4, 7, 3, 6};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    printf("Original Array 1:\n");
    printArray(arr1, n1);
    inPlaceMergeSort(arr1, 0, n1 - 1);
    printf("Sorted Array 1:\n");
    printArray(arr1, n1);

    printf("\n");

    // Sample 2: Small Array
    int arr2[] = {10, 0, 30, 20};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);
    printf("Original Array 2:\n");
    printArray(arr2, n2);
    inPlaceMergeSort(arr2, 0, n2 - 1);
    printf("Sorted Array 2:\n");
    printArray(arr2, n2);

    printf("\n");

    // Sample 3: Already Sorted Array
    int arr3[] = {1, 2, 3, 4, 5};
    int n3 = sizeof(arr3) / sizeof(arr3[0]);
    printf("Original Array 3 (already sorted):\n");
    printArray(arr3, n3);
    inPlaceMergeSort(arr3, 0, n3 - 1);
    printf("Sorted Array 3:\n");
    printArray(arr3, n3);

    printf("\n");

    // Sample 4: Reverse Sorted Array
    int arr4[] = {5, 4, 3, 2, 1};
    int n4 = sizeof(arr4) / sizeof(arr4[0]);
    printf("Original Array 4 (reverse sorted):\n");
    printArray(arr4, n4);
    inPlaceMergeSort(arr4, 0, n4 - 1);
    printf("Sorted Array 4:\n");
    printArray(arr4, n4);

    return 0;
}
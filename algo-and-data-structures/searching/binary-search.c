// Binary Search Implementation in C


#include <stdio.h>

// Binary search function
int binarySearch(int arr[], int size, int key) {
    int left = 0;
    int right = size - 1;

    // Loop until the search space is empty
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if key is present at mid
        if (arr[mid] == key)
            return mid;

        // If key is greater, ignore left half
        if (arr[mid] < key)
            left = mid + 1;

        // If key is smaller, ignore right half
        else
            right = mid - 1;
    }

    // Element was not found
    return -1;
}

// Main function to test the binary search
int main() {
    // Sample sorted array
    int arr[] = {2, 4, 7, 10, 14, 19, 25};
    int size = sizeof(arr) / sizeof(arr[0]);

    // Key to search for
    int key = 10;

    // Perform binary search
    int result = binarySearch(arr, size, key);

    // Display result
    if (result != -1)
        printf("Element found at index %d\n", result);
    else
        printf("Element not found in the array\n");

    return 0;
}

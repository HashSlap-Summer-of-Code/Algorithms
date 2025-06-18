# Bubble Sort Implementation
print("Bubble Sort")


def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr

def main():
    sample = [5, 3, 8, 4, 2]
    print("Original:", sample)
    sorted_list = bubble_sort(sample)
    print("Sorted:", sorted_list)

if __name__ == "__main__":
    main()

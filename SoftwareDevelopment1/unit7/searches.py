import arrays
import array_utils

def linear_search(an_array, target):
    """
    Searches an array for a target value.
    """
    for index in range(len(an_array)):
        if an_array[index] == target:
            return index
    return None

def increasing_comparator(a,b):
    return a <= b

def decreasing_comparator(a,b):
    return a >= b

def binary_search(an_array, target, comparator=increasing_comparator, start=None, end=None):
    if start is None:
        start = 0
    if end is None:
        end = len(an_array) - 1

    if start > end:
        return None
    else:
        mid = (start + end) // 2
        # print("target =", target, "start =", start, "end =", end,
        #     "mid =", mid, "value =", an_array[mid])
        if an_array[mid] == target:
            return mid
        elif comparator(an_array[mid],target):
            start = mid + 1
            return binary_search(an_array, target, comparator, start, end)
        else:
            end = mid - 1
            return binary_search(an_array, target, comparator, start, end)

def main():

    print("Increasing Array:")
    an_array = array_utils.range_array(1, 10000001)
    print(binary_search(an_array, 1, increasing_comparator))
    print(binary_search(an_array, 5000000, increasing_comparator))
    print(binary_search(an_array, 10000000, increasing_comparator))
    print(binary_search(an_array, 0, increasing_comparator))

    print("\nDecreasing Array:")
    an_array = array_utils.range_array(10000000, 0, -1)
    print(binary_search(an_array, 1, decreasing_comparator))
    print(binary_search(an_array, 5000000, decreasing_comparator))
    print(binary_search(an_array, 10000000, decreasing_comparator))
    print(binary_search(an_array, 0, decreasing_comparator))


if __name__ == "__main__":
    main()
import arrays
import array_utils

def split(an_array):
    evens = arrays.Array((len(an_array) + 1) // 2)
    odds = arrays.Array(len(an_array) // 2)

    evens_index = 0
    odds_index = 0

    for index in range(len(an_array)):
        if index % 2 == 0:
            evens[evens_index] = an_array[index]
            evens_index += 1
        else:
            odds[odds_index] = an_array[index]
            odds_index += 1
    
    return evens, odds

def swap(an_array, index_a, index_b):
    """
    Swaps two values in an array, taken from sorts.py
    """
    value_a = an_array[index_a]
    value_b = an_array[index_b]
    an_array[index_a] = value_b
    an_array[index_b] = value_a

def merge(half1, half2):
    merged = arrays.Array(len(half1) + len(half2))
    i1 = 0
    i2 = 0
    index = 0

    while i1 < len(half1) and i2 < len(half2):
        if half1[i1] <= half2[i2]:
            merged[index] = half1[i1]
            i1 += 1
        else:
            merged[index] = half2[i2]
            i2 += 1
        index += 1
    
    if i1 == len(half1):
        for i21 in range(i2, len(half2)):
            merged[index] = half2[i21]
            index += 1
    else:
        for i11 in range(i1, len(half1)):
            merged[index] = half1[i11]
            index += 1

    return merged

def swap_merge(array1, array2):
    """
    Takes a sorted array and a sorted reverse array, swap values and returns the combination of the two in one array
    """
    swapindex_start = 0
    swap_index_end = len(array2) - 1
    while swapindex_start <= len(array2) // 2 and swap_index_end >= len(array2) // 2:
        swap(array2, swapindex_start, swap_index_end)
        swapindex_start += 1
        swap_index_end -= 1
    return merge(array1, array2)

def merge_sort(an_array):
    if len(an_array) <= 1:
        return an_array
    half1, half2 = split(an_array)
    merged1 = merge_sort(half1)
    merged2 = merge_sort(half2)
    return merge(merged1, merged2)

def is_sorted_merge_sort(an_array, comparator = array_utils.increasing_comparator):
    """
    Determines is an_array is sorted, if so the recursion stops
    """
    if len(an_array) <= 1:
        return an_array
    elif array_utils.is_sorted(an_array):
        return an_array
    half1, half2 = split(an_array)
    merged1 = is_sorted_merge_sort(half1, comparator)
    merged2 = is_sorted_merge_sort(half2, comparator)
    return merge(merged1, merged2)

def main():
    """
    calls the other functions, organization purposes
    """
    #sorted array test
    array1 = array_utils.range_array(0, 100, 5)
    print(array1)
    print(is_sorted_merge_sort(array1))
    #unsorted array test
    array2 = array_utils.random_array(25, 0, 10)
    print(array2)
    print(is_sorted_merge_sort(array2))

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
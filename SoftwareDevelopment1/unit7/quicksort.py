import array_utils
import arrays
import random
import math
import sorts

def partition(pivot, an_array):
    less_count = 0
    same_count = 0
    more_count = 0
    for index in range(len(an_array)):
        if an_array[index] < pivot:
            less_count += 1
        elif an_array[index] == pivot:
            same_count += 1
        else:
            more_count += 1

    less = arrays.Array(less_count)
    same = arrays.Array(same_count)
    more = arrays.Array(more_count)

    less_index = 0
    same_index = 0
    more_index = 0
    for index in range(len(an_array)):
        if an_array[index] < pivot:
            less[less_index] = an_array[index]
            less_index += 1
        elif an_array[index] == pivot:
            same[same_index] = an_array[index]
            same_index += 1
        else:
            more[more_index] = an_array[index]
            more_index += 1

    return less, same, more

def quick_sort(an_array):
    if len(an_array) <= 1:
        return an_array

    pivot = an_array[0]
    less, same, more = partition(pivot, an_array)
    sorted_less = quick_sort(less)
    sorted_more = quick_sort(more)

    first = array_utils.array_cat(sorted_less, same)

    return array_utils.array_cat(first, sorted_more)

def quick_sort_mid(an_array):
    if len(an_array) <= 1:
        return an_array

    pivot = an_array[len(an_array) // 2]
    less, same, more = partition(pivot, an_array)
    sorted_less = quick_sort_mid(less)
    sorted_more = quick_sort_mid(more)

    first = array_utils.array_cat(sorted_less, same)

    return array_utils.array_cat(first, sorted_more)

def quick_sort_random(an_array):
    if len(an_array) <= 1:
        return an_array

    pivot = an_array[random.randint(0, len(an_array) - 1)]
    less, same, more = partition(pivot, an_array)
    sorted_less = quick_sort_random(less)
    sorted_more = quick_sort_random(more)

    first = array_utils.array_cat(sorted_less, same)

    return array_utils.array_cat(first, sorted_more)

def quick_insertion_sort(an_array, depth_change = None):
    if depth_change == None:
        depth_change = 2 * math.log2(len(an_array))

    if len(an_array) <= 1:
        return an_array
    elif depth_change < 0:
        sorts.insertion_sort(an_array)
        return an_array
    else:
        pivot = an_array[0]
        less, same, more = partition(pivot, an_array)
        first = array_utils.array_cat(quick_insertion_sort(less, depth_change - 1), same)
        return array_utils.array_cat(first, quick_insertion_sort(more, depth_change - 1))

def main():
    print(quick_insertion_sort(array_utils.random_array(10000)))

if __name__ == "__main__":
    main()
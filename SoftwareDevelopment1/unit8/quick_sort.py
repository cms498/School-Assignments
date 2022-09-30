import arrays
import array_utils
import random

def quick_sort (an_array):
    if len (an_array) < 2:
        return an_array
    else:
        pivot = an_array[0]
        less, same, more = partition (pivot, an_array)
        new_array = array_utils.cat_array (quick_sort(less), same)
        new_array = array_utils.cat_array (new_array, quick_sort(more))
        return new_array

def quicksort_middle (an_array):
    if len (an_array) < 2:
        return an_array
    else:
        pivot = an_array[len (an_array) // 2]
        less, same, more = partition (pivot, an_array)
        new_array = array_utils.cat_array (quicksort_middle(less), same)
        new_array = array_utils.cat_array (new_array, quicksort_middle(more))
        return new_array

def quicksort_random (an_array):
    if len (an_array) < 2:
        return an_array
    else:
        pivot = an_array[random.randint (0, len (an_array) - 1)]
        less, same, more = partition (pivot, an_array)
        new_array = array_utils.cat_array (quicksort_random(less), same)
        new_array = array_utils.cat_array (new_array, quicksort_random(more))
        return new_array

def partition (pivot, an_array):
    less = arrays.Array (len(an_array))
    same = arrays.Array (len(an_array))
    more = arrays.Array (len(an_array))
    less_index = 0
    same_index = 0
    more_index = 0

    for i in range (len (an_array)):
        if an_array[i] < pivot:
            less [less_index] = an_array[i]
            less_index += 1
        elif an_array[i] > pivot:
            more[more_index] = an_array[i]
            more_index += 1
        else:
            same[same_index] = an_array[i]
            same_index += 1

    return array_utils.copy_array (less, less_index), \
           array_utils.copy_array (same, same_index), \
           array_utils.copy_array (more, more_index)


def alt_partition(pivot, an_array):
    """
    This is an alternative implementation of the quicksort partition function
    that eschews overallocating and then copying arrays by looping through the
    original array twice: once to count the values, and once to copy them.

    Instructors should use whichever function they are most comfortable with.
    """
    length = len(an_array)
    less_count = 0
    same_count = 0
    more_count = 0
    for index in range(length):
        value = an_array[index]
        if value < pivot:
            less_count += 1
        elif value > pivot:
            more_count += 1
        else:
            same_count += 1

    print("less =", less_count)
    print("same =", same_count)
    print("more =", more_count)
    
    less = arrays.Array(less_count)
    same = arrays.Array(same_count)
    more = arrays.Array(more_count)

    less_index = 0
    same_index = 0
    more_index = 0

    for index in range(length):
        value = an_array[index]
        if value < pivot:
            less[less_index] = value
            less_index += 1
        elif value > pivot:
            more[more_index] = value
            more_index += 1
        else:
            same[same_index] = value
            same_index += 1
    
    return less, same, more

def alt_quick_sort(an_array):
    """
    Virtually identical to quick_sort, but uses the alt_partition function.
    """
    if len(an_array) < 2:
        return an_array
    else:
        pivot = an_array[0]
        less, same, more = alt_partition(pivot, an_array)
        new_array = array_utils.cat_array(alt_quick_sort(less), same)
        new_array = array_utils.cat_array(new_array, alt_quick_sort(more))
        return new_array

# Q4, Assignment 7.3
import math
import sorts

def quick_insertion_sort (an_array, recursions = None):
    if recursions == None:
        recursions = 2*math.log2(len(an_array))
    if len (an_array) < 2:
        return an_array 
    elif recursions < 0:
        sorts.insertion_sort(an_array)
        return an_array
    else:
        pivot = an_array[0]
        less, same, more = partition (pivot, an_array)
        new_array = array_utils.cat_array (quick_insertion_sort(less, recursions-1), same)
        new_array = array_utils.cat_array (new_array, quick_insertion_sort(more, recursions-1))
        return new_array

def main ():
    an_array = array_utils.range_array(0, 1000)
    print("sorted", quick_insertion_sort(an_array))
    
if __name__ == "__main__":
    main ()


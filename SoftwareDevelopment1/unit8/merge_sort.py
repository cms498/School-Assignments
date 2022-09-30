"""
An implementation of the Merge Sort algorithm provided for the homework in this
unit.

@author GCCIS faculty.
"""

import arrays
import array_utils

def merge_sort(an_array):
    if len (an_array) <= 1:
        return an_array
    else:
        (half1, half2) = split (an_array)
        sorted_half1 = merge_sort(half1)
        sorted_half2 = merge_sort(half2)
        return merge (sorted_half1, sorted_half2)

def split (an_array):
    evens_count = (len (an_array) + 1) // 2
    odds_count = len (an_array) // 2
    evens = arrays.Array (evens_count)
    odds = arrays.Array (odds_count)
    isEven = True

    for i in range (len (an_array)):
        if isEven:
            evens [i // 2] = an_array [i]
        else:
            odds [i // 2] = an_array [i]
        isEven = not isEven

    return (evens, odds)

def merge(sorted1, sorted2):
    result = arrays.Array (len (sorted1) + len (sorted2))
    i1 = 0
    i2 = 0
    while i1 < len (sorted1) and i2 < len (sorted2):
        if sorted1[i1] <= sorted2[i2]:
            result[i1 + i2] = sorted1 [i1]
            i1 = i1 + 1
        else:
            result[i1 + i2] = sorted2[i2]
            i2 = i2 + 1
  
    if i1 < len (sorted1):
        for i in range (i1, len(sorted1)):
            result [i + i2] = sorted1 [i]
    elif i2 < len (sorted2):
        for i in range (i2, len(sorted2)):
            result [i + i1] = sorted2 [i]
  
    return result

def swap(an_array, a, b):
    temp = an_array[a]
    an_array[a] = an_array[b]
    an_array[b] = temp

def swap_merge(array1, array2):
    for i in range(len(array2)//2):
        swap(array2, i, len(array2)-1-i)
    return merge(array1, array2) 

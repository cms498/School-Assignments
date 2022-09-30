import arrays
import array_utils

def linear_search(array, target):
    for index in range(len(array)):
        if target == array[index]:
            return index
    return None

def binary_search(an_array, target, start = None, end = None):
    if start == None:
        start = 0
        end = len(an_array) - 1
    elif start > end:
        return None
    else:
        midpoint = (start + end) // 2
        midpoint_value = an_array[midpoint]
        if midpoint_value == target:
            return midpoint
        elif midpoint < target:
            return binary_search(an_array, target, midpoint + 1, end)
        else:
            return binary_search(an_array, target, start, midpoint - 1)
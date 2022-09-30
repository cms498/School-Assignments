"""
Various useful array utilities. Provided for use on the homework in this unit.

@author GCCIS Faculty
"""

import arrays
import random

def range_array(start, stop, step=1):
    a_range = range(start, stop, step)
    length = len(a_range)
    an_array = arrays.Array(length, 0)
    for index in range(length):
        an_array[index] = a_range[index]
    return an_array

def random_array(size, min_value=0, max_value=None):
    an_array = arrays.Array(size, 0)
    if max_value is None:
        max_value = size

    for index in range(size):
        an_array[index] = random.randint(min_value, max_value)
    
    return an_array

def cat_array(array1, array2):
    new_array = arrays.Array (len (array1) + len (array2))
    for i in range (len (array1)):
        new_array [i] = array1[i]
    for i in range (len (array1), len (new_array)):
        new_array [i] = array2 [i - len(array1)]
    return new_array

def main():
    random.seed(1)
    rand_array = random_array(10)
    print(rand_array)

if __name__ == "__main__":
    main()
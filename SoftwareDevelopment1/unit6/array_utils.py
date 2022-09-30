import arrays
import random

def random_array(size, min_value = 0, max_value = None):
    an_array = arrays.Array(size)

    if max_value == None:
        max_value = size

    for index in range(size):
        an_array[index] = random.randint(min_value, max_value)
    
    return an_array

def range_array(start, stop, step = 1):
    a_range = range(start, stop, step)

    an_array = arrays.Array(len(a_range))
    
    for index in range(len(a_range)):
        an_array[index] = a_range[index]

    return an_array
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

def array_cat(array1, array2):
    cat_array = arrays.Array(len(array1) + len(array2))

    index = 0

    for i1 in range(len(array1)):
        cat_array[index] = array1[i1]
        index += 1

    for i2 in range(len(array2)):
        cat_array[index] = array2[i2]
        index += 1
        
    return cat_array

def increasing_comparator(a,b):
    return a <= b

def decreasing_comparator(a,b):
    return a >= b

def is_sorted(an_array, comparator = increasing_comparator):
    for index in range(len(an_array) - 1):
        if comparator(an_array[index], an_array[index + 1]):
            continue
        else:
            return False
    return True

def main():
    array1 = [20, 10, 30]
    array2 = [30, 20, 10]
    print(is_sorted(array1))
    print(is_sorted(array1, decreasing_comparator))
    print(is_sorted(array2, increasing_comparator))
    print(is_sorted(array2, decreasing_comparator))

if __name__ == "__main__":
    main()
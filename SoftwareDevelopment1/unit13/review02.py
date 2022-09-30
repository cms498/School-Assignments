import arrays

def is_power(a, b):
    if a < 1 or b < 1:
        raise ValueError("a and b must be > 0")
    if a == 1:
        return True
    if a % b != 0:
        return False
    
    return is_power(a / b, b)

def what_power(a, b):
    if a < 1 or b < 1:
        raise ValueError("a and b must be > 0")
    if a == 1:
        return 0
    if a % b != 0:
        raise ValueError("a is not a power of b")

    return 1 + what_power(a / b, b)

def fill_array(an_array, start = 0, step = 1, index = 0):
    if index == len(an_array):
        return
    an_array[index] = start
    return fill_array(an_array, start + step, step, index + 1)

def arrays_equal(array1, array2, index = 0):
    if len(array1) != len(array2):
        return False
    if index == len(array1):
        return True
    if array1[index] != array2[index]:
        return False
    return arrays_equal(array1, array2, index + 1)

"""
Linear Search     Best = 1      Worst = n      Expected = n
Binary Search     Best = 1      Worst = logn   Expected = logn

Insertion Sort    Best = n      Worst = n^2    Expected = n^2
Merge Sort        Best = nlogn  Worst = nlogn  Expected = nlogn
Quicksort         Best = nlogn  Worst = n^2    Expected = nlogn
"""

def tupilfy():
    first = input("Enter your first name: ")
    middle = input("Enter your middle name: ")
    last = input("Enter your last name: ")
    if middle == "":
        return (first, last)
    return (first, middle, last)

def cubed(a_list):
    for value in range(len(a_list)):
        a_list[value] **= 3
    return a_list

def cubed_lc(a_list):
    return [value ** 3 for value in a_list]

def reversal(a_list):
    counter = len(a_list) - 1
    reverse_list = []
    while counter >= 0:
        reverse_list.append(a_list[counter])
        counter -= 1
    return reverse_list

def multiples(rows, columns):
    table = []
    for i in range(1, rows + 1):
        row_list = []
        for j in range(1, columns + 1):
            row_list.append("{:2d}".format(i * j))
        table.append(row_list)
    return table

def multiples_lc(rows, columns):
    return [["{:2d}".format(i * j) for j in range(1, columns + 1)] for i in range(1, rows + 1)]

def main():
    # print(is_power(27, 3))
    # print(is_power(101, 4))
    # print(is_power(1, 20))

    # print(what_power(27, 3))
    # try:
    #     print(what_power(101, 4))
    # except ValueError as ve:
    #     print(ve)
    # print(what_power(1, 20))

    # an_array = arrays.Array(10)
    # fill_array(an_array)
    # print(an_array)
    # fill_array(an_array, 1, 3)
    # print(an_array)

    # array1 = arrays.Array(10)
    # array2 = arrays.Array(10)
    # print(arrays_equal(array1, array2))
    # array2 = [1, 2, 3]
    # print(arrays_equal(array1, array2))
    # array2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 10]
    # print(arrays_equal(array1, array2))

    # print(tupilfy())

    # print(cubed([1, 2, 3, 4, 5]))
    # print(cubed_lc([1, 2, 3, 4, 5]))

    # a_list = [1, 2, 3, 4, 5]
    # print(reversal(a_list))

    table = multiples(3, 4)
    for row in table:
        print(row)

    table = multiples_lc(3, 4)
    for row in table:
        print(row)

if __name__ == "__main__":
    main()
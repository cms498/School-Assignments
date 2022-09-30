"""
This program houses 3 functions that use the principles of list comprehension and 2d arrays
"""

def in_place_reverse(a_list):
    """
    Reverse sorts a list in place using built in insert and pop commands
    """
    value = len(a_list) - 1
    for index in range(len(a_list)):
        a_list.insert(index, a_list.pop(value))
    return a_list

def make_multiplication_table():
    return [[row * col for row in range(1, 11)] for col in range(1, 11)]

def my_slice(a_list, start, stop, step = 1):
    """
    Recreates the slicing function but uses list comprehension
    """
    if stop > len(a_list):
        stop = len(a_list)
    return [a_list[index] for index in range(start, stop, step)]

def main():
    """
    Calls the other functions, organization purposes
    """
    #testing for in_place_reverse
    list1 = []
    list2 = [1]
    list3 = [False, 3.14, "String", 4, 5]
    print(in_place_reverse(list1))
    print(in_place_reverse(list2))
    print(in_place_reverse(list3))
    
    print()
    #testing for make_multiplication table
    for index in range(10):
        print(make_multiplication_table()[index])

    print()
    #testing for my_slice
    a_list = [0, 10, 20, 30, 40, 50]
    print(my_slice(a_list, 2, 4))
    print(my_slice(a_list, 1, 8, 2))
    print(my_slice(a_list, 5, 1, -1))

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
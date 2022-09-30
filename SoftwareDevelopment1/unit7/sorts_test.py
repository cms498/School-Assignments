"""
Houses all of the tests for the insertion_sort_backwards function
"""

import sorts
import array_utils

def test_shift_backwards1():
    #setup
    an_array = [5, 3, 7, 1, 4]
    index = 2
    expected = "[5, 3, 1, 4, 7]"

    #invoke
    actual = sorts.shift_backwards(an_array, index)

    #analyze
    assert str(actual) == expected

def test_shift_backwards2():
    #setup
    an_array = [5, 3, 1, 4, 7]
    index = 1
    expected = "[5, 1, 3, 4, 7]"

    #invoke
    actual = sorts.shift_backwards(an_array, index)

    #analyze
    assert str(actual) == expected

def test_insertion_increasing_comparator():
    #setup
    an_array = [1, 10, 10, 9, 3, 4, 5, 7, 7]
    expected = [1, 3, 4, 5, 7, 7, 9, 10, 10]

    #invoke
    actual = sorts.insertion_sort(an_array)

    #analyze
    assert str(expected) == str(actual)

def test_insertion_decreasing_comparator():
    #setup
    an_array = [1, 10, 10, 9, 3, 4, 5, 7, 7]
    expected = [10, 10, 9, 7, 7, 5, 4, 3, 1]

    #invoke
    actual = sorts.insertion_sort(an_array, array_utils.decreasing_comparator)

    #analyze
    assert str(expected) == str(actual)
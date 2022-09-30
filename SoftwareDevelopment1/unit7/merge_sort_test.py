import array_utils
import arrays
import merge_sort

def test_merge_sort_empty():
    #setup
    empty_array = arrays.Array(0)

    #invoke
    sorted_array = merge_sort.merge_sort(empty_array)

    #analyze
    assert str(sorted_array) == "[]"

def test_merge_sort_even_elems():
    #setup
    unsorted_array = arrays.Array(4)
    unsorted_array[0] = 5
    unsorted_array[1] = 2
    unsorted_array[2] = 1
    unsorted_array[3] = 4

    #invoke
    sorted_array = merge_sort.merge_sort(unsorted_array)

    #analyze
    assert str(sorted_array) == "[1, 2, 4, 5]"

def test_merge_sort_odd_elems():
    #setup
    unsorted_array = arrays.Array(5)
    unsorted_array[0] = 5
    unsorted_array[1] = 2
    unsorted_array[2] = 1
    unsorted_array[3] = 4
    unsorted_array[4] = 3

    #invoke
    sorted_array = merge_sort.merge_sort(unsorted_array)

    #analyze
    assert str(sorted_array) == "[1, 2, 3, 4, 5]"

def test_merge_empty_array():
    #setup
    half1 = arrays.Array(0)
    half2 = array_utils.range_array(1,4,2)

    #invoke
    merged = merge_sort.merge(half1,half2)

    #analzye
    assert str(merged) == "[1, 3]"

def test_merge():
    #setup
    half1 = array_utils.range_array(0,3,2)
    half2 = array_utils.range_array(1,4,2)

    #invoke
    merged = merge_sort.merge(half1,half2)

    #analyze
    assert str(merged) == "[0, 1, 2, 3]"

def test_split_even_elems():
    #setup
    an_array = arrays.Array(4)
    an_array[0] = 0
    an_array[1] = 1
    an_array[2] = 2
    an_array[3] = 3

    #invoke
    evens, odds = merge_sort.split(an_array)

    #analyze
    assert str(evens) == "[0, 2]"
    assert str(odds) == "[1, 3]"

def test_split_odd_elems():
    #setup
    an_array = arrays.Array(3)
    an_array[0] = 0
    an_array[1] = 1
    an_array[2] = 2

    #invoke
    evens, odds = merge_sort.split(an_array)

    #analyze
    assert str(evens) == "[0, 2]"
    assert str(odds) == "[1]"


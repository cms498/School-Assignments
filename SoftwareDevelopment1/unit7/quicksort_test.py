import array_utils
import arrays
import quicksort

def test_quick_sort_empty():
    #setup
    empty_array = arrays.Array(0)

    #invoke
    sorted_array = quicksort.quick_sort(empty_array)

    #analyze
    assert str(sorted_array) == "[]"

def test_quick_sort_even_num_elems():
    #setup
    unsorted_array = arrays.Array(6)
    unsorted_array[0] = 4
    unsorted_array[1] = 3
    unsorted_array[2] = 6
    unsorted_array[3] = 9
    unsorted_array[4] = 1
    unsorted_array[5] = 6

    #invoke
    sorted_array = quicksort.quick_sort(unsorted_array)

    #analyze
    assert str(sorted_array) == "[1, 3, 4, 6, 6, 9]"

def test_quick_sort_odd_num_elems():
    #setup
    unsorted_array = arrays.Array(5)
    unsorted_array[0] = 5
    unsorted_array[1] = 2
    unsorted_array[2] = 1
    unsorted_array[3] = 4
    unsorted_array[4] = 3

    #invoke
    sorted_array = quicksort.quick_sort(unsorted_array)

    #analyze
    assert str(sorted_array) == "[1, 2, 3, 4, 5]"

def test_partition():
    #setup
    an_array = arrays.Array(5)
    an_array[0] = 3
    an_array[1] = 9
    an_array[2] = 1
    an_array[3] = 2
    an_array[4] = 3

    #invoke
    actual_less, actual_same, actual_more = quicksort.partition(an_array[0],an_array)

    #analyze
    assert str(actual_less) == "[1, 2]"
    assert str(actual_same) == "[3, 3]"
    assert str(actual_more) == "[9]"

def test_empty_partition():
    #setup
    an_array = arrays.Array(4)
    an_array[0] = 3
    an_array[1] = 1
    an_array[2] = 2
    an_array[3] = 3

    #invoke
    actual_less, actual_same, actual_more = quicksort.partition(an_array[0],an_array)

    #analyze
    assert str(actual_less) == "[1, 2]"
    assert str(actual_same) == "[3, 3]"
    assert str(actual_more) == "[]"
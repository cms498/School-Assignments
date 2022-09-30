import array_utils
import arrays

def test_array_cat():
    #setup
    array1 = arrays.Array(3)
    array1[0] = 0
    array1[1] = 2
    array1[2] = 4

    array2 = arrays.Array(2)
    array2[0] = 6
    array2[1] = 8

    #invoke
    cat_array = array_utils.array_cat(array1, array2)

    #analyze
    assert str(cat_array) == "[0, 2, 4, 6, 8]"

def test_array_cat_empty_1():
    #setup
    array1 = arrays.Array(0)

    array2 = arrays.Array(2)
    array2[0] = 6
    array2[1] = 8

    #invoke
    cat_array = array_utils.array_cat(array1, array2)

    #analyze
    assert str(cat_array) == "[6, 8]"

def test_array_cat_empty_2():
    #setup
    array1 = arrays.Array(3)
    array1[0] = 0
    array1[1] = 2
    array1[2] = 4

    array2 = arrays.Array(0)

    #invoke
    cat_array = array_utils.array_cat(array1, array2)

    #analyze
    assert str(cat_array) == "[0, 2, 4]"

def test_array_cat_empty_both():
    #setup
    array1 = arrays.Array(0)

    array2 = arrays.Array(0)

    #invoke
    cat_array = array_utils.array_cat(array1, array2)

    #analyze
    assert str(cat_array) == "[]"
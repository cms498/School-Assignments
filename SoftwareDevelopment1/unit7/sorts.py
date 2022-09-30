import array_utils
import arrays

def swap(an_array, index_a, index_b):
    value_a = an_array[index_a]
    value_b = an_array[index_b]
    an_array[index_a] = value_b
    an_array[index_b] = value_a

def shift(an_array, index, comparator):
    while index > 0 and comparator(an_array[index], an_array[index - 1]):
        swap(an_array, index - 1, index)
        index -= 1

def insertion_sort(an_array, comparator = array_utils.increasing_comparator):
    for index in range(1, len(an_array)):
        shift(an_array, index, comparator)
    return an_array

def shift_wo_swap(an_array, index):
    target_value = an_array[index]
    target_index = index
    while target_index > 0 and an_array[target_index - 1] > target_value:
        an_array[target_index] = an_array[target_index - 1]
        target_index -= 1
    
    an_array[target_index] = target_value

def insertion_sort_wo_swap(an_array):
    for value in range(1, len(an_array)):
        shift_wo_swap(an_array, value)

def shift_backwards(an_array, index):
    """
    Shifts elements in an array forwards until they are in a sorted section
    """
    while index < len(an_array) - 1 and an_array[index] >= an_array[index + 1]:
        swap(an_array, index, index + 1)
        index += 1
    return an_array

def insertion_sort_backwards(an_array):
    """
    Uses the insertion sort concepts but does the process backwards through the arry instead of forwards
    """
    for index in range(len(an_array) - 2, -1, -1):
        shift_backwards(an_array, index)
        print(an_array)

def main():
    print("\nInsertion sort")
    an_array_1 = array_utils.random_array(10, 1, 10)
    print(an_array_1)
    print("Increasing Comparator")
    insertion_sort(an_array_1, array_utils.increasing_comparator)
    print(an_array_1)
    print("Decreasing Comparator")
    insertion_sort(an_array_1, array_utils.decreasing_comparator)
    print(an_array_1)

if __name__ == "__main__":
    main()
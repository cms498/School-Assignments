import random
import arrays
import array_utils

def tuples(a_tuple):
    print(len(a_tuple))
    print(a_tuple)
    for index in a_tuple:
        print(index)

def lists():
    a_list = [True, 1, 3.15, "abc", (1,2,3)]
    for index in range(len(a_list)):
        print(a_list[index])
    a_list[0] = 99
    return a_list

def make_list(a_sequence):
    a_lists = []
    for value in a_sequence:
        a_lists.append(value)
        print(a_lists)
    return a_lists

def scale(a_list, scalar):
    for index in range(len(a_list)):
        a_list[index] *= scalar

def mutator(a_list, a_int):
    print(a_list, a_int)
    a_int *= 5
    a_list[0] *= 5
    print(a_list, a_int)

def cat(a_list, b_list):
    return a_list + b_list

def extender(a_list, b_list):
    a_list += b_list
    return a_list

def inserter(a_list, value):
    middle = len(a_list) // 2
    a_list.insert(middle, value)

def popper(a_list):
    for _ in range(len(a_list)):
        value = a_list.pop(random.randint(0, len(a_list) - 1))
        print(a_list, value)

def popper_rec(a_list):
    if len(a_list) == 0:
        return
    value = a_list.pop()
    print(a_list, value)
    popper_rec(a_list)

def array_insert(an_array, index, value):
    new_array = arrays.Array(len(an_array) + 1)

    for i1 in range(0, index):
        new_array[i1] = an_array[i1]
    
    new_array[index] = value

    for i2 in range(index, len(an_array)):
        new_array[i2 + 1] = an_array[i2]

    return new_array
    
def array_pop(an_array, index):
    new_array = arrays.Array(len(an_array) - 1)
    i1 = 0

    for i in range(0, len(an_array)):
        if i != index:
            new_array[i1] = an_array[i]
            i1 += 1
        else:
            popped = an_array[i]

    return new_array, popped

def main():
    an_array = array_utils.range_array(0, 11)
    print(an_array)
    print(array_pop(an_array, 5))

if __name__ == "__main__":
    main()
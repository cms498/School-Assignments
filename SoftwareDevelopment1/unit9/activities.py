import time
import arrays
import random
import re

def unique_array(an_array, value):
    for index in range(len(an_array)):
        if an_array[index] == None:
            an_array[index] = value
            return
        if an_array[index] == value:
            return

def fill_array(length):
    an_array = arrays.Array(length, None)
    start = time.perf_counter()
    for index in range(length):
        unique_array(an_array, index)
    end = time.perf_counter()
    return end - start

def unique_list(a_list, value):
    for elem in a_list:
        if elem == value:
            return
    a_list.append(value)

def fill_list(length):
    a_list = []
    start = time.perf_counter()
    for index in range(length):
        unique_list(a_list, index)
    end = time.perf_counter()
    return end - start

def sets():
    a_set = {111, 3, 57, 42}
    print(a_set)
    a_set.add(5)
    print(a_set)
    b_set = set("mississippi")
    print(b_set)

def unique_set(a_set, value):
    if not (value in a_set):
        a_set.add(value)

def fill_set(length):
    a_set = set()
    start = time.perf_counter()
    for index in range(length):
        unique_set(a_set, index)
    end = time.perf_counter()
    return end - start

def coupon_collector(n):
    coupons = set()
    boxes = 0
    while len(coupons) < n:
        number = random.randint(1, n)
        coupons.add(number)
        boxes += 1
    return boxes

def mixup():
    a_set = set("James Bond")
    for char in a_set:
        print(char, end = " ")
    print()

def unique_words(filename):
    a_set = set()
    with open(filename) as file:
        for line in file:
            # splitted = line.strip().lower().split()
            # for words in splitted:
            #     a_set.add(words)
            words = re.findall("[\w]+", line.strip().lower())
            for word in words:
                a_set.add(word)
    return a_set

def superset(a_set, b_set):
    for b in b_set:
        if not (b in a_set):
            return False
    return True

def intersection(a_set, b_set):
    c_set = set()

    for a in a_set:
        if a in b_set:
            c_set.add(a)

    return c_set

def minus(a_set, b_set):
    for b in b_set:
        if b in a_set:
            a_set.remove(b)

def main():
    # print("Unique Array: ", fill_array(5000))

    # print("Unique List: ", fill_list(5000))

    # #sets()
    # print("Unique Set", fill_set(5000))

    # print(coupon_collector(500000))

    # mixup()
    # mixup()
    # mixup()

    # print(unique_words("data/alice.txt"))

    a_set = {1, 2, 3, 4, 5}
    b_set = {1, 2, 3}
    print(superset(a_set, b_set))
    print(intersection(a_set, b_set))
    print(minus(a_set, b_set))
    print(a_set)

if __name__ == "__main__":
    main()
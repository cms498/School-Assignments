"""
This program looks at various types of hashing functions, as well as using concepts from ascii codes
Author: Chris Shepard
"""
import time

def make_myset(length, hash_func = hash):
    """
    Created in class, creates a set within a set for hashing purposes
    """
    table = [[] for _ in range(length)]
    return (hash_func, table)

def add(myset, element):
    """
    Created in class, adds elements to the set
    """
    if contains(myset, element):
        return
    func = myset[0]
    table = myset[1]
    index = func(element) % len(table)
    row = table[index]
    row.append(element)

def contains(myset, element):
    """
    Created in class, determines in elements are in a set, helps with DRY
    """
    func = myset[0]
    table = myset[1]
    index = func(element) % len(table)
    row = table[index]
    for e in row:
        if e == element:
            return True
    return False

def hash_bad(a_string):
    """
    Sums the ascii values of characters in a string and returns the total
    """
    total = 0
    for char in a_string:
        total += ord(char)
    return total

def hash_good(a_string):
    """
    Uses a formula and creates a better hashing total, reduces collisions
    """
    total = 0
    for char in range(len(a_string)):
        total += ord(a_string[char]) * 31 ** (len(a_string) - (char + 1))
    return total

def read_data(hash_func):
    """
    creates a set of words from words.txt and is able to hash them using various ones
    """
    words_set = make_myset(466547, hash_func)
    with open("data/words.txt") as file:
        for line in file:
            word = line.lower()
            add(words_set, word)
    return words_set

def quality_hash_function(myset):
    """
    tests the quality of various hasing functions, calculates #of collisions and empty list spots
    """
    print("The quality of", myset[0].__name__)

    col_set = myset[1]
    max_col_count = 0
    for list in col_set:
        if len(list) > max_col_count:
            max_col_count = len(list)
    final_max_col_count = max_col_count - 1 #max col count

    empty_count = 0
    for index in col_set:
        if len(index) == 0:
            empty_count += 1
    final_empty_count = empty_count

    return final_max_col_count, final_empty_count

def test_hash():
    """
    Helper function for hash function
    """
    start = time.perf_counter()
    myset = read_data(hash)
    end = time.perf_counter()
    max_collisions, empty_rows = quality_hash_function(myset)
    print("Maximum collisions:", max_collisions)
    print("Number of empty slots", empty_rows)
    print("Elapsed time to build a set:", round(end - start, 2))

def test_hash_good():
    """
    Helper function for hash_good function
    """
    start = time.perf_counter()
    myset = read_data(hash_good)
    end = time.perf_counter()
    max_collisions, empty_rows = quality_hash_function(myset)
    print("Maximum collisions:", max_collisions)
    print("Number of empty slots", empty_rows)
    print("Elapsed time to build a set:", round(end - start, 2))

def test_hash_bad():
    """
    Helper function for hash_bad function
    """
    start = time.perf_counter()
    myset = read_data(hash_bad)
    end = time.perf_counter()
    max_collisions, empty_rows = quality_hash_function(myset)
    print("Maximum collisions:", max_collisions)
    print("Number of empty slots", empty_rows)
    print("Elapsed time to build a set:", round(end - start, 2))

def main():
    """
    Calls the three testing hashing functions, organization purposes
    """
    test_hash()
    print()
    test_hash_good()
    print()
    test_hash_bad()
    """The higher the quality of the hash function the faster it is able to go through the calculations, for
    example the hash_bad function takes about 3-4 times as long as the hash_good, this is the case as in the 
    more advanced hashes, the number of collisions is reduced, so it is closer to o(c) compared to o(n) time
    """

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
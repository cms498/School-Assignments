import arrays
import random
import array_utils
import searches
import time
import turtle
import math

def making_arrays():
    array_5 = arrays.Array(5)
    print(array_5)
    
    array_1 = arrays.Array(1, 0)
    print(array_1)

    array_10 = arrays.Array(10, "")
    print(array_10)

    array_20 = arrays.Array(20, False)
    print(array_20)

def while_fill(an_array):
    index = 0
    length = len(an_array)

    while index < length:
        an_array[index] = index
        index += 1

def for_fill(an_array):
    length = len(an_array)
    for index in range(length):
        an_array[index] = index

def roll_the_die(sides):
    return random.randint(1, sides)

def linear_search_time(array, target):
    begin = time.perf_counter()
    searches.linear_search(array, target)
    end = time.perf_counter()
    return end - begin

def linear_time():
    an_array = array_utils.range_array(1, 10000001)
    print("First:", linear_search_time(an_array, 1))
    print("Middle:", linear_search_time(an_array, 5000000))
    print("Last:", linear_search_time(an_array, 10000000))

def binary_search_time(array, target):
    begin = time.perf_counter()
    searches.binary_search(array, target)
    end = time.perf_counter()
    return end - begin

def binary_time():
    an_array = array_utils.range_array(1, 10000001)
    print("First:", binary_search_time(an_array, 1))
    print("Middle:", binary_search_time(an_array, 5000000))
    print("Last:", binary_search_time(an_array, 10000000))

def print_odds(an_array):
    for index in range(len(an_array)):
        if index % 2 == 1:
            print(an_array[index], end=" ")
    print()

def print_odds_rec(an_array, index = 0):
    if index >= len(an_array):
        return
    if index % 2 == 1:
        print(an_array[index],end = " ")
    print_odds_rec(an_array, index + 1)

def countdown(n):
    if n < 0:
        return None
    elif n == 0:
        print(n)
        return 0
    else:
        print(n)
        return n + countdown(n - 1)

def factorial(n):
    if n < 0:
        return None
    elif n == 0:
        return 1
    elif n == 1:
        return 1
    else:
        return n * factorial(n - 1)

def circles(radius, depth):
    if depth == 0:
        return 0
    elif depth == 1:
        turtle.circle(radius)
        return 2 * math.pi * radius
    else:
        total_circumference = 2 * math.pi * radius
        for _ in range(4):
            turtle.circle(radius, 90)
            total_circumference += circles(radius / 2, depth - 1)
        return total_circumference

def count_up(num):
    if num == 0:
        print(0)
    else:
        count_up(num - 1)
        print(num)

def main():
    linear_time()
    binary_time()
    #count_up(5)

if __name__ == "__main__":
    main()
"""
The program has two functions, one that uses a liner search algorithm recursively to find values in an array and the other
uses recursion to find vowels in a string
Author: Chris Shepard
"""

import arrays

def linear_recursive(arr, i, target):
    """
    This function searches for a target value in an array using linear search, but in a recursive style
    it returns the first index that value is found at or none if the value is never found
    """

    if i >= len(arr):
        return None
    if arr[i] != target:
        return linear_recursive(arr, i + 1, target)
    return i

def count_vowels(s, index = 0):
    if s == "":
        return 0
    if index >= len(s):
        return 0
    if s[index] == "a" or s[index] == "e" or s[index] == "i" or s[index] == "o" or s[index] == "u":
        return 1 + count_vowels(s, index + 1)
    else:
        return 0 + count_vowels(s, index + 1)

def main():
    print("Linear_recursive function output below")
    a = arrays.Array(5, 0)
    res = linear_recursive(a, 0, 4)
    print(res)
    a[3] = 4
    res = linear_recursive(a, 0, 4)
    print(res)
    
    print("\nCount_vowels function output below")
    print(count_vowels("code commentary is useful"))
    print(count_vowels("thr3 b33 n0 vwls h33r3"))
    print(count_vowels(""))
    print(count_vowels("u"))

if __name__ == "__main__":
    main()
"""
The program plots the average time to find a value in a sorted array using a binary search algorithm
Author: Chris Shepard
"""

import plotter
import time
import array_utils
import searches

def average_binary_search(size, runs):
    """
    Creates a sorted list of a given size, and returns the average time to find all the values in that
    array using binary search
    """
    an_array = array_utils.range_array(0, size)
    total_time = 0
    count = 0

    for index in range(runs):
        start = time.perf_counter()
        searches.binary_search(an_array, int(len(an_array) // runs) * index)
        end = time.perf_counter()
        total_time += (end - start)
        count += 1

    return total_time / count

def plot_average_binary(min_size, max_size, runs):
    """
    Uses plotter to add data and plot it using the returned time from average_binary_search
    """
    #create array size min to max, size being difference being max / runs + min
    for index in range(runs):
        array_different_sizes = array_utils.range_array(0, min_size + index * (max_size // runs))
        plotter.add_data_point(average_binary_search(len(array_different_sizes), runs))

def main():
    plotter.init("Binary Search", "Size", "Time")
    plot_average_binary(100, 100000, 25)
    plotter.plot()
    input("Press enter to continue: ")

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
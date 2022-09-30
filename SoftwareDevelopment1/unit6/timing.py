"""
This program times how long it takes to linearly search through an array of a given size
Author: Chris Shepard
"""

import plotter
import time
import array_utils
import searches

def linear_plot(size, runs):
    """
    This function uses the plotter and plots the time it takes to linearly search through an array
    given a size and an amount of runs through it should do
    """
    plotter.init("Linear Search", "Length", "Time")

    an_array = array_utils.range_array(0, size)

    index = 0

    while index <= runs:
        start = time.perf_counter()
        searches.linear_search(an_array, index * runs)
        end = time.perf_counter()
        plotter.add_data_point(end - start)
        index += 1

    plotter.plot()

def main():
    """
    Loops and asks the user for various inputs, quits out if inputs are empty, calls linear_plot function
    """
    while True:
        size_input = input("Enter a value for the size of the array: ")
        if size_input == "":
            break
        runs_input = input("Enter a value for the number of runs: ")
        if runs_input == "":
            break
        linear_plot(int(size_input), int(runs_input))
        input("Press enter to continue: ")

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
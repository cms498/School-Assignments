"""
Sort timing untility. Provided for the homework in this unit.

@author GCCIS Faculty
"""

import time
import array_utils
import plotter

SIZES  = array_utils.range_array(200, 2001, 300) #[200, 500, 800, 1100, 1400, 1700, 2000]

def sort_timer(sort_function, an_array):
    start = time.perf_counter()
    sort_function(an_array)
    end = time.perf_counter()
    return end - start

def plot_sort_time_using_random_arrays(sort_function):    
    print("timing", sort_function.__name__, "using random arrays ...")
    plotter.new_series()
    for index in range(len(SIZES)):
        size = SIZES[index]
        an_array = array_utils.random_array(size)
        elapsed = sort_timer(sort_function, an_array)
        plotter.add_data_point(elapsed)

def plot_sort_time_using_duplicate_random_arrays(sort_function):    
    print("timing", sort_function.__name__, "using duplicate random arrays ...")
    plotter.new_series()
    for index in range(len(SIZES)):
        size = SIZES[index]
        an_array = array_utils.random_array(size, 0, size//100)
        elapsed = sort_timer(sort_function, an_array)
        plotter.add_data_point(elapsed)

def plot_sort_time_using_sorted_arrays(sort_function):    
    print("timing", sort_function.__name__, "using sorted arrays ...")
    plotter.new_series()
    for index in range(len(SIZES)):
        size = SIZES[index]
        an_array = array_utils.range_array(0, size)
        elapsed = sort_timer(sort_function, an_array)
        plotter.add_data_point(elapsed)

def main():
    input("Press enter to continue...")

if __name__ == "__main__":
    main()
     

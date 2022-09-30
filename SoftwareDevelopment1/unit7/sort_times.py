import sorts
import time
import array_utils
import plotter
import merge_sort
import quicksort

SIZES = array_utils.range_array(200, 2001, 300)

def insertion_sort_function_timer(an_array):
    start = time.perf_counter()
    sorts.insertion_sort(an_array)
    end = time.perf_counter()
    return end - start

def sort_function_timer(sort_function, an_array):
    """
    times all of the sorting functions created in class dependent on parameters given
    """
    if sort_function == "insertion_sort":
        start = time.perf_counter()
        sorts.insertion_sort(an_array)
        end = time.perf_counter()
        return end - start
    elif sort_function == "insertion_sort_wo_swap":
        start = time.perf_counter()
        sorts.insertion_sort_wo_swap(an_array)
        end = time.perf_counter()
        return end - start
    elif sort_function == "quick_insertion_sort":
        start = time.perf_counter()
        quicksort.quick_insertion_sort(an_array)
        end = time.perf_counter()
        return end - start
    else:
        start = time.perf_counter()
        merge_sort.merge_sort(an_array)
        end = time.perf_counter()
        return end - start

def plot_sort_time_using_random_arrays(sort_function):
    """
    Plots how long it takes to sort through random arrays of given sizes using the various sorting function
    """
    plotter.new_series()
    for index in range(len(SIZES)):
        an_array = array_utils.random_array(SIZES[index])
        plotter.add_data_point(sort_function_timer(sort_function, an_array))

def plot_sort_time_using_sorted_arrays(sort_function):
    """
    Similar to plot_sort_time_using_random_arrays but instead uses already sorted arrays
    """
    plotter.new_series()
    for index in range(len(SIZES)):
        an_array = array_utils.range_array(0, SIZES[index])
        plotter.add_data_point(sort_function_timer(sort_function, an_array))

def plot_sort_time_using_duplicate_random_arrays(sort_function):
    plotter.new_series()
    for index in range(len(SIZES)):
        an_array = array_utils.random_array(SIZES[index], 0, SIZES[index] // 100)
        plotter.add_data_point(sort_function_timer(sort_function, an_array))

def main():
    """
    Calls the other function for organization pruposes
    """
    plotter.init("Insertion, Merge, Quick sort", "Array Size", "Time")

    # plot_sort_time_using_random_arrays("insertion_sort")
    # plot_sort_time_using_random_arrays("insertion_sort_wo_swap")
    # plot_sort_time_using_random_arrays("merge_sort")
    # plot_sort_time_using_random_arrays("quick_insertion_sort")
    # plot_sort_time_using_sorted_arrays("insertion_sort")
    # plot_sort_time_using_sorted_arrays("merge_sort")
    # plot_sort_time_using_sorted_arrays("quick_insertion_sort")
    plot_sort_time_using_duplicate_random_arrays("insertion_sort")
    plot_sort_time_using_duplicate_random_arrays("merge_sort")
    plot_sort_time_using_duplicate_random_arrays("quick_insertion_sort")

    plotter.plot()
    input("Press enter to continue: ")

if __name__ == "__main__":
    main()
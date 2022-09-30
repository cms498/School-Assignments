import quicksort
import array_utils
import arrays
import time

def run_one(qs_func,an_array):
    start = time.perf_counter()
    qs_func(an_array)
    end = time.perf_counter()
    return end - start

def run_all(an_array):
    print("Pivot First:",run_one(quicksort.quick_sort,an_array))
    print("Pivot Mid:",run_one(quicksort.quick_sort_mid,an_array))
    print("Pivot Random:",run_one(quicksort.quick_sort_random,an_array))

def main():
    size = 900
    an_array = array_utils.range_array(0,size)
    print("Ordered Array:")
    run_all(an_array)

    an_array = array_utils.random_array(size)
    print("\nRandom Array:")
    run_all(an_array)

    an_array = array_utils.range_array(size,0,-1)
    print("\nReversed Array:")
    run_all(an_array)

if __name__ == "__main__":
    main()
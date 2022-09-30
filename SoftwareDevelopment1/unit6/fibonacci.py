import plotter
import time

def fibonacci_naive(n):
    """
    This function returns the nth value in the fibonacci sequence using recursion, implemented using TDD
    """
    if n <= 0:
        return None
    elif n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        return fibonacci_naive(n - 1) + fibonacci_naive(n - 2)

def naive_timer(n):
    """
    This function plots the time it takes in order to calculate various elements in the fibonacci sequence
    """
    for num in range(n):
        start = time.perf_counter()
        fibonacci_naive(num)
        end = time.perf_counter()
        elapsed = end - start
        plotter.add_data_point(elapsed)
    plotter.plot()

def fibonacci_fast(n, fn_minus_1 = 1, fn_minus_2 = 0):
    """
    This functions computes the fibonacci sequence much faster, it does this by going forward
    instead of backwards, this answer was found on stackoverflow
    https://stackoverflow.com/questions/13826810/fast-fibonacci-recursion
    """
    if n == 0:
        return fn_minus_2
    else:
        return fibonacci_fast(n - 1, fn_minus_2, fn_minus_2 + fn_minus_1)

def fast_timer(n):
    """
    This function plots the time it takes in order to calculate various elements in the fibonacci sequence
    using the faster fibonacci algorithm
    """
    for num in range(n):
        start = time.perf_counter()
        fibonacci_fast(num)
        end = time.perf_counter()
        elapsed = end - start
        plotter.add_data_point(elapsed)
    plotter.plot()

def main():
    """
    calls all of the other functions, organization purposes
    """
    n_value = int(input("Enter a value of N for the fibonacci naive algorithm: "))
    plotter.init("Naive Fibonacci", "N", "Time")
    naive_timer(n_value)
    input("Press enter to continue: ")

    n_value_2 = int(input("Enter a value of N for the fibonacci fast algorithm: "))
    plotter.init("Fast Fibonacci", "N", "Time")
    fast_timer(n_value_2)
    input("Press enter to continue: ")

    n_value_3 = int(input("Enter a value N for both fibonacci algorithms: "))
    plotter.init("Both Fibonacci", "N", "Time")
    naive_timer(n_value_3)
    plotter.new_series()
    fast_timer(n_value_3)
    input("Press enter to continue: ")

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
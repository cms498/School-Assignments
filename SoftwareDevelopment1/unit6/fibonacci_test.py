import fibonacci

def test_fibonacci_naive_1():
    #setup
    n = 1
    expected = 0

    #invoke
    actual = fibonacci.fibonacci_naive(n)

    #analyze
    assert expected == actual

def test_fibonacci_naive_2():
    #setup
    n = 2
    expected = 1

    #invoke
    actual = fibonacci.fibonacci_naive(n)

    #analyze
    assert expected == actual

def test_fibonacci_naive_zero():
    #setup
    n = 0
    expected = None

    #invoke
    actual = fibonacci.fibonacci_naive(n)

    #analyze
    assert expected == actual
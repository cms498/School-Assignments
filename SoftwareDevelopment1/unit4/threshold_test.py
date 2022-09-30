"""
This program implements TDD and Incremental development to return true or false depending if two values difference are in a threshold
Author: Chris Shepard
"""

def within_threshold(a, b, threshold):
    """
    Houses the conditionals for the tests, check for inside and outside of threshold, as well as negative thresholds
    """
    if threshold < 0:
        return None
    if (a - b) > threshold:
        return False
    return True

def test_within_threshold():
    """
    Tests for values inside of the threshold, threshold is a positive number
    """
    #setup
    a = 7
    b = 3
    threshold = 4
    expected = True

    #invoke
    actual = within_threshold(a , b, threshold)

    #analyze
    assert expected == actual

def test_not_in_threshold():
    """
    Tests values that are greater than the threshold, threshold is a positive number
    """
    #setup
    a = 7
    b = 3
    threshold = 3
    expected = False

    #invoke
    actual = within_threshold(a , b, threshold)
    
    #analyze
    assert expected == actual

def test_negative_threshold():
    """
    Tests thresholds that are negative
    """
    #setup
    a = 7
    b = 3
    threshold = -1
    expected = None

    #invoke
    actual = within_threshold(a , b, threshold)

    #analyze
    assert expected == actual
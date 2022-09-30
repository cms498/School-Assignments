"""
Tests for practice13_2.py module
"""
import practice13_2

def test_recursive_3_5_base_case():
    #setup
    n = 1
    expected = []
    #invoke
    actual = practice13_2.recursive_3_5(n)
    #analyze
    assert expected == actual

def test_recursive_3_5_no_3_and_5():
    #setup
    n = 12
    expected = [3, 5, 6, 9, 10, 12]
    #invoke
    actual = practice13_2.recursive_3_5(n)
    #analyze
    assert expected == actual

def test_find_words_q():
    #setup
    filename = "words.txt"
    letter = "q"
    number = 5
    expected = ["quarry", None, None, None, None]
    #invoke
    actual = practice13_2.find_words(filename, letter, number)
    #analyze
    assert str(expected) == str(actual)

def test_find_words_s():
    #setup
    filename = "words.txt"
    letter = "s"
    number = 5
    expected = ["sonant", "sonny", "sackful", "spectacle", None]
    #invoke
    actual = practice13_2.find_words(filename, letter, number)
    #analyze
    assert str(expected) == str(actual)

def test_make_calendar():
    #setup
    weekday = 2
    days = 5
    expected = [["  ", "  ", "01", "02", "03", "04", "05"]]
    #invoke
    actual = practice13_2.make_calendar(weekday, days)
    #analyze
    assert str(expected) == str(actual)

def test_make_calendar_2_weeks():
    #setup
    weekday = 2
    days = 6
    expected = [["  ", "  ", "01", "02", "03", "04", "05"], ["06", "  ", "  ", "  ", "  ", "  ", "  "]]
    #invoke
    actual = practice13_2.make_calendar(weekday, days)
    #analyze
    assert str(expected) == str(actual)
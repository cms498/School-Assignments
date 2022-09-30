"""
Test functions for practice 13_1.py module
"""
import practice13_1

def test_pig_latin_no_vowels():
    #setup
    a_string = "bcfgh"
    expected = "bcfghay"
    #invoke
    actual = practice13_1.pig_latin_translator(a_string)
    #analyze
    assert expected == actual

def test_pig_latin_vowel_first():
    #setup
    a_string = "apple"
    expected = "appleay"
    #invoke
    actual = practice13_1.pig_latin_translator(a_string)
    #analyze
    assert expected == actual

def test_pig_latin_2_chars():
    #setup
    a_string = "smile"
    expected = "ilesmay"
    #invoke
    actual = practice13_1.pig_latin_translator(a_string)
    #analyze
    assert expected == actual
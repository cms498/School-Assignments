import turtle
import cross_maker
import math

def test_move_to_element_0():
    #setup
    x_expected = -300
    y_expected = 300

    #invoke
    cross_maker.move_to_element(0, 0)

    #analyze
    assert x_expected == turtle.xcor()
    assert y_expected == turtle.ycor()

def test_move_to_element_19():
    #setup
    x_expected = 270
    y_expected = -270

    #invoke
    cross_maker.move_to_element(19, 19)

    #analyze
    assert x_expected == turtle.xcor()
    assert y_expected == turtle.ycor()

def test_write_single_letter():
    #setup
    str = "B"

    #analyze - visually
    cross_maker.write_single_letter(str)

def test_validate_in_range_horizontal():
    x = 10
    y = 10
    word = "computer"
    is_horizontal = True
    expected = True

    #invoke
    actual = cross_maker.validate_word(x, y, word, is_horizontal)

    assert expected == actual

def test_validate_out_range_horizontal():
    x = 10
    y = 10
    word = "computersandstuffoutofrange"
    is_horizontal = True
    expected = False

    #invoke
    actual = cross_maker.validate_word(x, y, word, is_horizontal)

    assert expected == actual

def test_validate_in_range_vertical():
    x = 10
    y = 10
    word = "computer"
    is_horizontal = False
    expected = True

    #invoke
    actual = cross_maker.validate_word(x, y, word, is_horizontal)

    assert expected == actual

def test_validate_in_range_vertical():
    x = 10
    y = 10
    word = "computerandstuffoutofrange"
    is_horizontal = False
    expected = False

    #invoke
    actual = cross_maker.validate_word(x, y, word, is_horizontal)

    assert expected == actual

def test_write_horizontal():
    x_expected = -60
    y_expected = 300

    cross_maker.write_horizontal(0, 0, "computer")

    assert math.isclose(turtle.xcor(), x_expected)
    assert math.isclose(turtle.ycor(), y_expected)

def test_write_word():
    x = 21
    y = 7
    str = "comp"
    is_horizontal = False
    expected = "Word out of range"

    actual = cross_maker.write_word(x, y, str, is_horizontal)

    assert expected == actual
    
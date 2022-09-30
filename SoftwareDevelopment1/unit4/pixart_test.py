import turtle
import pixart
import math

def assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor):
    assert turtle.speed() == expected_speed
    assert math.isclose(turtle.xcor(),expected_xcor)
    assert math.isclose(turtle.ycor(),expected_ycor)
    assert turtle.isdown() == expected_isdown
    assert turtle.pencolor() == expected_pencolor
    assert turtle.fillcolor() == expected_fillcolor

def test_init():
    #setup
    expected_speed = pixart.INIT_SPEED
    expected_xcor = pixart.LEFT
    expected_ycor = pixart.TOP
    expected_isdown = False
    expected_pencolor = "black"
    expected_fillcolor = "white"

    #invoke
    pixart.init()

    #analyze
    assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor)

def test_draw_pixel():
    #setup
    expected_speed = pixart.INIT_SPEED
    expected_xcor = pixart.LEFT + pixart.PIXEL_SIZE
    expected_ycor = pixart.TOP
    expected_isdown = False
    expected_pencolor = "black"
    expected_fillcolor = "red"

    #invoke
    pixart.draw_pixel(expected_fillcolor)

    #analyze
    assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor)


def test_color_tester():
    """
    Tests values that are numbers as characters
    """
    #setup
    index = 0
    while index <= 9:
        code = str(index)
        if code == "0":
            expected_fillcolor = "black"
        if code == "1":
            expected_fillcolor = "white"
        if code == "2":
            expected_fillcolor = "red"
        if code == "3":
            expected_fillcolor = "yellow"
        if code == "4":
            expected_fillcolor = "orange"
        if code == "5":
            expected_fillcolor = "green"
        if code == "6":
            expected_fillcolor = "yellowgreen"
        if code == "7":
            expected_fillcolor = "sienna"
        if code == "8":
            expected_fillcolor = "tan"
        if code == "9":
            expected_fillcolor = "gray"

        #invoke
        response = pixart.one_color(code)

        #analyze
        assert expected_fillcolor == response

        #increment by 1
        index += 1

def test_color_tester_letter():
    """
    Tests letters
    """
    #setup
    code = "A"
    expected_fillcolor = "darkgray"

    #invoke
    response = pixart.one_color(code)

    #analyze
    assert expected_fillcolor == response

def test_move():
    #setup
    expected_speed = 0
    expected_xcor = -180
    expected_ycor = 150
    expected_isdown = False
    expected_pencolor = "black"
    expected_fillcolor = "red"
    
    #invoke
    pixart.move(5, 4)

    #analyze
    assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor)

def test_draw_row():
    #setup
    expected_speed = 0
    expected_xcor = 60
    expected_ycor = 150
    expected_isdown = False
    expected_pencolor = "black"
    expected_fillcolor = "red"
    
    #invoke
    pixart.draw_row(5, 4, 8, expected_fillcolor)

    #analyze
    assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor)

def test_draw_square():
    #setup
    expected_speed = 0
    expected_xcor = 90
    expected_ycor = -30
    expected_isdown = False
    expected_pencolor = "black"
    expected_fillcolor = "green"
    
    #invoke
    pixart.draw_square(4, 5, 8)

    #analyze
    assertle(expected_speed, expected_xcor, expected_ycor, expected_isdown, expected_pencolor, expected_fillcolor)
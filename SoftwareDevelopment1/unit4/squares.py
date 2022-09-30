"""
This program draws a square inside of a square... 6 times, each being 45 degrees rotated, all with different colors
Author: Chris Shepard
"""

import turtle

def single_square(length, f_color):
    """
    Draws a single square with a fill color, also turns turtle at end to set up for the next square
    """
    turtle.speed(0)
    turtle.fillcolor(f_color)
    turtle.begin_fill()
    turtle.forward(length)
    turtle.left(90)
    turtle.forward(length)
    turtle.left(90)
    turtle.forward(length)
    turtle.left(90)
    turtle.forward(length)
    turtle.left(90)
    turtle.end_fill()
    turtle.forward(length / 2)
    turtle.left(45)

def length_factor(length):
    """
    Eliminates code reuse, formula for each square being smaller then the next, using 45 45 90 triangle rules
    """
    return (length / 2) * (2 ** .5)

def draw_squares(length):
    """
    Draws the 6 squares inside of eachother
    """
    single_square(length, "red")
    single_square(length_factor(length), "orange")
    length = length_factor(length)
    single_square(length_factor(length), "yellow")
    length = length_factor(length)
    single_square(length_factor(length), "green")
    length = length_factor(length)
    single_square(length_factor(length), "blue")
    length = length_factor(length)
    single_square(length_factor(length), "purple")
    return length_factor(length)

def main():
    """
    Calls and prints the return values of draw_squares, organization purposes
    """
    print(draw_squares(750))
    input("Press enter to continue: ")

main()
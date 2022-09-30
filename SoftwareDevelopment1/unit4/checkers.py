"""
This program draws a 20 x 20 checkerboard with alternating colors
Author: Chris Shepard
"""

import turtle
import pixart

def one_line_red_first():
    """
    Draws one line of alternating colors, either red or black, red first
    """
    index = 0
    while index < 20:
        if index % 2 == 0:
            pixart.draw_pixel("red")
        else:
            pixart.draw_pixel("black")
        
        index += 1

def one_line_black_first():
    """
    Draws one line of alternating colors, either red or black, black first
    """
    index = 0
    while index < 20:
        if index % 2 == 0:
            pixart.draw_pixel("black")
        else:
            pixart.draw_pixel("red")
        
        index += 1

def move_next_row(scale):
    """
    Moves turtle to the next row
    """
    turtle.penup()
    turtle.goto(pixart.LEFT, pixart.TOP - (pixart.PIXEL_SIZE * scale))
    #print(pixart.LEFT)
    #print(pixart.TOP - (pixart.PIXEL_SIZE * scale))

def draw_checkerboard():
    """
    Draws the checkerboard
    """
    index = 0
    scale = 1

    pixart.init()

    while index < 20:
        if index % 2 == 0:
            one_line_red_first()
            move_next_row(scale)
            scale += 1
        else:
            one_line_black_first()
            move_next_row(scale)
            scale += 1
        index += 1

def main():
    """
    calls the checkerboard function, prompts user to help keep screen open
    """
    #draw_checkerboard()
    #input("Press enter to continue")

#main()
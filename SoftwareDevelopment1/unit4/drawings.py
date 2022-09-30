"""
This program draws a line of pixels given a string of characters
Author: Chris Shepard
"""

import pixart
import checkers

def draw_line_from_code(a_string):
    """
    Draws a line of pixels given a string, returns true if all characters are valid, false if not
    """
    index = 0

    while index < len(a_string):
        char = a_string[index]
        if char != "0" and char != "1" and char != "2" and char != "3" and char != "4" and char != "5" and char != "6" and char != "7" and char != "8" and char != "9" and char != "A":
            return False
        else:
            pixart.draw_pixel_by_code(a_string[index])
            index += 1
        
    return True

def draw_full_picture():
    """
    Draws a full picture based on user string inputs
    """
    index = 0
    scale = 1
    pixart.init()

    while index < pixart.ROWS:
        string = input("Enter a list of characters: ")
        if draw_line_from_code(string) == False:
            return False
        if string == "":
            break
        checkers.move_next_row(scale)
        scale += 1

        index += 1

def main():
    """
    Calls the draw full picture function, organization purposes
    """
    draw_full_picture()
    input("Press enter to continue:")

main()
"""
This program will draw a crossword puzzle based on user inputs
Author: Chris Shepard
"""
import turtle

PIXEL_SIZE = 30
ROWS = 20
COLUMNS = 20
LEFT = -(COLUMNS / 2) * PIXEL_SIZE
TOP = (ROWS / 2) * PIXEL_SIZE

def move_to_element(x, y):
    """
    Moves the turtle to the upper left hand corner of the element in the grid
    """
    turtle.penup()
    x_pos = LEFT + (x * PIXEL_SIZE)
    y_pos = TOP - (y * PIXEL_SIZE)
    turtle.goto(x_pos, y_pos)

def write_single_letter(str):
    """
    Writes a single character inside of a colored square at its center
    """

    turtle.pendown()
    turtle.fillcolor("red")
    turtle.begin_fill()

    index = 0
    while index < 4:
        turtle.forward(PIXEL_SIZE)
        turtle.left(90)
        index += 1

    turtle.end_fill()
    turtle.forward(PIXEL_SIZE / 2)
    turtle.write(str, align='center', font=("Arial", 19, "normal"))

def validate_word(x, y, str, is_horizontal):
    """
    Validates if the word can be drawn inside of the screen
    """
    if x < 0 or x >= COLUMNS:
        return False
    if y < 0 or y >= ROWS:
        return False
    if is_horizontal == True:
        return (x + len(str)) <= COLUMNS
    if is_horizontal == False:
        return (y + len(str)) <= ROWS

def write_horizontal(x, y, str):
    """
    Writes the word horizontally
    """
    move_to_element(x, y)
    for i in str:
        write_single_letter(i)
        turtle.forward(PIXEL_SIZE / 2)

def write_vertical(x, y, str):
    """
    Writes the word vertically
    """
    move_to_element(x, y)
    for i in str:
        write_single_letter(i)
        if i == str[-1]:
            break
        turtle.forward(-1 * PIXEL_SIZE / 2)
        turtle.right(90)
        turtle.forward(PIXEL_SIZE)
        turtle.left(90)

def write_word(x, y, str, is_horizontal):
    """
    Writes the word with paramter values, either horizontal or vertical
    """
    if validate_word(x, y, str, is_horizontal) == False:
        a = print("Word out of range")
        return a
    if is_horizontal == True:
        write_vertical(x, y, str)
    else:
        write_vertical(x, y, str)

def crossword_game():
    """
    Plays a crossword style game with the user
    """
    while True:

        a_string = input("Enter the <x> <y> <string> <H|V> ") # user input

        if a_string == "": # if empty string break out and stop
            break
    
        parts = a_string.split() # splits the string by spaces and assigns variables
        x = int(parts[0])
        y = int(parts[1])
        string = parts[2]
        direction = parts[3] ==  "H"

        for i in string: #loop through the string, if direction is H increase x by 1, goes in grid
            write_word(x, y, i, direction)
            if direction == True:
                x+=1
            else:
                y+=1


def main():
    """
    Organizes all functions, calls crossword_game functions
    """
    #write_horizontal(0, 0, "computer")
    #write_vertical(0, 0, "computer")
    #write_word(11, 5, "computer", False) #testing only
    crossword_game()

main()
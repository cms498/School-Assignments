"""
This program takes various inputs in inches and kilometers and simplifies those to imperial units rounded down
it also draws a proportional snowman
Author: Chris Shepard
"""

import turtle

def convert_height():
    """
    Prompts the user for their height in inches, prints out the same height but in feet and inches
    This is done through floor division and the mod operator
    """
    height = int(input("Enter your height in inches: "))
    feet_calculation = height // 12
    inches_calculation = height % 12
    print("You are ", feet_calculation, "' ", inches_calculation, '"', " tall", sep="")

def convert_distance(kilometers):
    """
    Takes an input in kilometers and provides the same distance but to the nearest
    mile, foot, and inch, all rounded down
    """
    miles = (kilometers * 39370.1) / 63360 # converts km to in then to mi
    feet = 5280 * (miles % 1) # converts the decimal remainder in miles to feet
    inches = (feet % 1 / (1/12)) # converts the decimal remainder in feet to inches
    
    miles = int(miles // 1) #rounds miles down, converts to int
    feet = int(feet // 1) #rounds feet down, converts to int
    inches = int(inches // 1) # rounds inches down, converts to int

    print(kilometers, "kilometers is", miles, "miles,", feet, "feet,", inches, "inches")

def snow_man(x, y, radius):
    """
    Draws a snow man on the screen with all of the sections being proportional to eachother
    """
    turtle.bgcolor("cyan")
    one_ball(x, y, radius, "white")
    one_ball(x, y + radius * 2, radius * .75, "white")
    prev_radius = radius * 2
    radius *= .75
    one_ball(x, y + prev_radius + radius * 2, radius * .75, "white")

def one_ball(x, y, radius, f_color):
    """
    Draws one ball of a snowman with specific parameters
    """
    turtle.penup()
    turtle.goto(x, y)
    turtle.fillcolor(f_color)
    turtle.begin_fill()
    turtle.pendown()
    turtle.circle(radius)
    turtle.end_fill()
    
def main():
    """
    Main function, stores all functions for code clarity
    """
    convert_height()
    convert_distance(96.56061)
    snow_man(0, -200, 100)
    input("Press enter to continue: ")

main()

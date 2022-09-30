"""
This program uses rectangles, triangles, and circle of various sizes and colors
to draw a skyline determined by user input and order
Author: Chris Shepard
"""

import turtle

def rectangle(height, width, p_color, f_color, x_pos, y_pos):
    """
    Draws a rectangle with various colors and heights determined by user input
    """
    turtle.pencolor(p_color)
    turtle.fillcolor(f_color)
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()
    turtle.begin_fill()
    turtle.forward(width)
    turtle.left(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.forward(width)
    turtle.left(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.end_fill()


def triangle(base, p_color, f_color, x_pos, y_pos):
    """
    Draws a triangle with various color and heights determined by user input
    """
    turtle.pencolor(p_color)
    turtle.fillcolor(f_color)
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()
    turtle.begin_fill()
    turtle.forward(base / 2)
    turtle.left(120)
    turtle.forward(base)
    turtle.left(120)
    turtle.forward(base)
    turtle.left(120)
    turtle.forward(base / 2)
    turtle.end_fill()


def circle(radius, p_color, f_color, x_pos, y_pos):
    """
    Draws a circle with various colors and sizes determined by user input
    """
    turtle.pencolor(p_color)
    turtle.fillcolor(f_color)
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()
    turtle.begin_fill()
    turtle.circle(radius)
    turtle.end_fill()


def main():
    """
    Steps in the drawing process determined by the user, organizes all 3 functions above
    """
    #Background
    rectangle(70, 760, "darkslateblue", "darkslateblue", -382, 288)
    rectangle(70, 760, "darkorchid", "darkorchid", -382, 218)
    rectangle(70, 760, "mediumvioletred", "mediumvioletred", -382, 148)
    rectangle(70, 760, "deeppink", "deeppink", -382, 78)
    rectangle(70, 760, "orangered", "orangered", -382, 8)
    rectangle(70, 760, "orange", "orange", -382, -62)
    rectangle(70, 760, "gold", "gold", -382, -132)
    rectangle(150, 760, "goldenrod", "goldenrod", -382, -350)
    #Moon
    circle(150, "grey", "grey", 360, 200)
    circle(20, "black", "grey", 350, 220)
    circle(15, "black", "grey", 340, 270)
    circle(15, "black", "grey", 320, 320)
    circle(20, "black", "grey", 280, 270)
    #Clouds
    circle(35, "white", "white", -250, 220)
    circle(35, "white", "white", -210, 200)
    circle(35, "white", "white", -280, 200)
    circle(35, "white", "white", -250, 180)
    circle(35, "silver", "silver", 80, 180)
    circle(35, "silver", "silver", 40, 160)
    circle(35, "silver", "silver", 110, 160)
    circle(35, "silver", "silver", 80, 140)
    #Small pyramid
    triangle(300, "peru", "peru", 300, -200)
    #Buildings
    rectangle(300, 75, "darkslategrey", "darkslategrey", 120, -200)
    rectangle(150, 75, "darkslategrey", "darkslategrey", 45, -200)
    rectangle(270, 75, "darkslategrey", "darkslategrey", -30, -200)
    rectangle(100, 75, "darkslategrey", "darkslategrey", -105, -200)
    rectangle(375, 75, "darkslategrey", "darkslategrey", -180, -200)
    #Windows 1
    rectangle(20, 10, "yellow", "yellow", -150, -140)
    rectangle(20, 10, "yellow", "yellow", -150, -100)
    rectangle(20, 10, "yellow", "yellow", -150, -60)
    rectangle(20, 10, "yellow", "yellow", -150, -20)
    rectangle(20, 10, "yellow", "yellow", -150, 20)
    rectangle(20, 10, "yellow", "yellow", -150, 60)
    rectangle(20, 10, "yellow", "yellow", -150, 100)
    rectangle(20, 10, "yellow", "yellow", -150, 140)
    #Windows 2
    rectangle(20, 10, "yellow", "yellow", -75, -180)
    rectangle(20, 10, "yellow", "yellow", -75, -140)
    #Windows 3
    rectangle(20, 10, "yellow", "yellow", 0, -180)
    rectangle(20, 10, "yellow", "yellow", 0, -140)
    rectangle(20, 10, "yellow", "yellow", 0, -100)
    rectangle(20, 10, "yellow", "yellow", 0, -60)
    rectangle(20, 10, "yellow", "yellow", 0, -20)
    rectangle(20, 10, "yellow", "yellow", 0, 20)
    #Windows 4
    rectangle(20, 10, "yellow", "yellow", 75, -180)
    rectangle(20, 10, "yellow", "yellow", 75, -140)
    rectangle(20, 10, "yellow", "yellow", 75, -100)
    #Windows 5
    rectangle(20, 10, "yellow", "yellow", 150, -180)
    rectangle(20, 10, "yellow", "yellow", 150, -140)
    rectangle(20, 10, "yellow", "yellow", 150, -100)
    rectangle(20, 10, "yellow", "yellow", 150, -60)
    rectangle(20, 10, "yellow", "yellow", 150, -20)
    rectangle(20, 10, "yellow", "yellow", 150, 20)
    rectangle(20, 10, "yellow", "yellow", 150, 60)
    #Big pyramid
    triangle(400, "peru", "peru", -300, -200)
    #Bushes
    circle(10, "forestgreen", "forestgreen", 80, -270)
    circle(10, "forestgreen", "forestgreen", 70, -260)
    circle(10, "forestgreen", "forestgreen", 90, -270)
    circle(10, "forestgreen", "forestgreen", 80, -260)

    circle(10, "forestgreen", "forestgreen", -80, -290)
    circle(10, "forestgreen", "forestgreen", -70, -280)
    circle(10, "forestgreen", "forestgreen", -90, -290)
    circle(10, "forestgreen", "forestgreen", -80, -280)

    circle(10, "forestgreen", "forestgreen", 180, -300)
    circle(10, "forestgreen", "forestgreen", 170, -290)
    circle(10, "forestgreen", "forestgreen", 190, -300)
    circle(10, "forestgreen", "forestgreen", 180, -290)

    circle(10, "forestgreen", "forestgreen", -200, -260)
    circle(10, "forestgreen", "forestgreen", -190, -250)
    circle(10, "forestgreen", "forestgreen", -190, -260)
    circle(10, "forestgreen", "forestgreen", -180, -250)
    input("Press enter to continue: ")#Keeps window open

main()
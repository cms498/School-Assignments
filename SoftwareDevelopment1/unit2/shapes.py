"""
This program calculates the area or volume of various shapes based on data provided by the user 
Author: Chris Shepard
"""

def area_circle():
    """
    This function asks a user for a radius and calculates the area of a circle
    based off of that input
    """
    radius = float(input("Enter a radius: "))
    area = 3.14159 * (radius ** 2)
    print("Circle: r = ", radius, ", area = ", area, sep="")
    print()


def sphere_volume():
    """
    Asks user for an input and calculates the volume of a sphere based on that input
    """
    radius = float(input("Enter a radius: "))
    volume = (4/3) * 3.14159 * (radius**3)
    print("Sphere: r = ", radius, ", volume = ", volume, sep="")
    print()


def area_rectangle():
    """
    Asks user for two inputs and calculates the area of a rectangle based on that input
    """
    height = float(input("Enter a height: "))
    width = float(input("Enter a width: "))
    area = height * width
    print("Rectangle: height = ", height, ", width = ", width, ", area = ", area, sep="")
    print()


def area_square():
    """
    Asks user for an input and calculates the area of a square based on that input
    """
    side = float(input("Enter a side length: "))
    area = side ** 2
    print("Square: side length = ", side, ", area = ", area, sep="")
    print()


def area_isoceles_triangle():
    """
    Calculates the area of an isoceles triangle based on user inputs
    """
    side_length = float(input("Enter a side length: "))
    height = float(input("Enter a height: "))
    base = ((side_length ** 2) - (height ** 2)) ** 0.5
    area = (base * 2 * height) / 2
    print("Isoceles Triangle: side = ", side_length, ", height = ", height, ", area = ", area, sep="")
    print()


def area_equilateral_triangle():
    """
    Calculates the area of an equilateral triangle based on user inputs
    """
    side_length = float(input("Enter a side length: "))
    area = ((3 ** 0.5) / 4) * (side_length ** 2)
    print("Equilateral Triangle: side = ", side_length, ", area = ", area, sep="")
    print()


def area_trapezoid():
    """
    Calculates the area of a trapezoid based of user inputs for the 2 bases and the height
    """
    base1 = float(input("Enter base 1: "))
    base2 = float(input("Enter base 2: "))
    height = float(input("Enter a height: "))
    area = ((base1 + base2) / 2) * height
    print("Trapezoid: base 1 = ", base1, ", base 2 = ", base2, ", height = ", height, ", area = ", area, sep="")
    print()

def main():
    """
    This is where all of the area / volume functions will be housed
    Organizational purpose
    """
    area_circle()
    sphere_volume()
    area_rectangle()
    area_square()
    area_isoceles_triangle()
    area_equilateral_triangle()
    area_trapezoid()

main()

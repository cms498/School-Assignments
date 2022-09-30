"""
Draws a sky filled with stars and planets.

@author: Chris Shepard
"""

import random
import turtle

# for random_move function, no "magic numbers"
'''
Semantic error
Previous values of -1000 and 1000 were too large for the screen, values have been adjusted down

Visual debugging using turtle
'''
X_MAX = 370
X_MIN = -370
Y_MAX = 320
Y_MIN = -320

# draw star function, no "magic numbers"
LEFT_TURN = 72
RIGHT_TURN = 144

def tweak(speed, tracer):
    """
    Adjust the turtle's speed and tracer settings so that it can be sped up
    or slowed down as needed for visual debugging.
    """
    turtle.speed(speed)
    turtle.tracer(tracer)

def random_yellow():
    """
    Sets the turtle's fill color to a random shade of yellow using RGB values.
    """
    # the random.random() function returns a floating point value between
    # 0.1 and 1.0. This expression guarantees that the red value will be
    # between 0.5 and 1.0.
    red = 0.5 + random.random() * 0.5
    green = red
    blue = red / 2

    # the turtle color can be set using RGB values ranging from 0.0 to 1.0. In
    #  this case the red and green values are between 0.5 and 1.0 and the blue
    # value is half the value - this guarantees a shade of yellow.
    turtle.color(red, green, blue)
    '''
    Semantic error
    The actual fill color was purple instead of yellow, the blue and green arguement are swapped producing the wrong color

    Visual debugging using turtle
    '''
    turtle.fillcolor(red, green, blue)

def random_move():
    """
    Moves the turtle to a random location and orientation on the screen.
    """
    x = random.randint(X_MIN, X_MAX)
    '''
    Syntax Error
    Missing ',' after first argument in y = random.randint(-1000 1000)

    VS code put a red underline under the second arguement, when the code ran it also gave an invalid syntax error
    '''
    y = random.randint(Y_MIN, Y_MAX)
    '''
    Semantic error
    turtle.goto(x, x) should be turtle.goto(x, y), otherwise the star will be drawn on the same horizontal line

    Visual debugging using turtle
    '''
    turtle.goto(x, y) 

    angle = random.randint(0, 360)
    turtle.setheading(angle)

'''
Syntax Error
Missing ':' after function definition

VS code highlited the error, running the code produce an invalid syntax error, with an indicator pointing
at the end of the function declaration
'''
def draw_star(length):
    """
    Draws a star at the turtle's current location and orientation.
    """
    random_yellow()
    turtle.down()
    turtle.begin_fill()
    '''
    Semantic error
    Turtle angles for turning left and right were not correct

    I just did the math again to figure out to turn left 72 degrees and then from that end point go back 144 degrees 
    and then repeat for the other sides. Lots of visual debugging with help from the turtle.
    '''
    star_side(length)
    star_side(length)
    star_side(length)
    star_side(length)
    star_side(length)

    turtle.end_fill()    

def star_side(length):
    turtle.forward(length)
    turtle.left(LEFT_TURN)
    turtle.forward(length)
    turtle.right(RIGHT_TURN)

def random_star():
    """
    Moves the turtle to a random location on the screen with a random orientation, then draws a star with a random
    length between 5 and 10
    """
    turtle.up()
    random_move()
    draw_star(random.randint(5, 10))

def draw_world(x, y, radius, color):
    turtle.up()
    turtle.setheading(0)
    turtle.goto(x, y)
    turtle.color("black")
    turtle.fillcolor(color)
    turtle.down()
    turtle.begin_fill()
    turtle.circle(radius)
    turtle.end_fill()

def draw_celestial_bodies():
    """
    Draws 100 stars in random locations, and draws 3 planets
    """
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    random_star()
    draw_world(-200, -200, 150, "red")
    draw_world(200, 150, 30, "grey")
    draw_world(150, -75, 75, "orange")

def main():
    """
    Should ultimately draw a night sky filled with stars and planets.
    """
    turtle.bgcolor("black")
    '''
    Semantic error
    tweak function has 2 parameters, speed and then tracer status, the function here takes those in the opposite order
    they need to be switched
    
    VS code didn't produce any error, but i noticed that for tweak, the speed parameter was taking a boolean value
    instead of an integer, same as tracer was taking and integer instead of a boolean
    '''
    tweak(0, False)
    '''
    Runtime error
    length was cast as a string instead of an int, from the turtle it was trying to move forward by a string instead of a number

    VS code produced a stack trace in the terminal, it pointed to line 101 where the input was, as well
    as told me the type of input it was, in this case it was a string, which the turtle.forward() can't accept
    '''
    #length = int(input("Enter length of star to draw (e.g. 100): "))
    #draw_star(length)
    draw_celestial_bodies()
    '''
    Semantic error
    tweak function has 2 parameters, speed and then tracer status, the function here takes those in the opposite order
    they need to be switched
    
    VS code didn't produce any error, but i noticed that for tweak, the speed parameter was taking a boolean value
    instead of an integer, same as tracer was taking and integer instead of a boolean
    '''
    #tweak(1, True)
    '''
    Attribute error
    turtle.hide() is not a command

    VS code printed in the terminal that turtle has no attribute 'hide'
    '''
    #turtle.hide()
    input("Press enter to continue...")

main()
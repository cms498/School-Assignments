import turtle

angle = 45


def test_drive():
    turtle.forward(100)
    turtle.left(90)
    turtle.forward(100)
    turtle.setheading(135)
    turtle.forward(71)
    turtle.left(90)
    turtle.forward(71)
    turtle.setheading(270)
    turtle.forward(100)
    turtle.right(90)
    turtle.circle(45)


def turtle_state():
    print("Pen is down:", turtle.isdown())
    print("Heading:", turtle.heading())
    print("X:", turtle.xcor(), "Y:", turtle.ycor())


def square(size, angle, pen_color, fill_color):
    turtle.pensize(4)
    turtle.color(pen_color)
    turtle.fillcolor(fill_color)
    turtle.begin_fill()
    turtle.left(angle)
    turtle.pendown()
    turtle.forward(size)
    turtle.right(90)
    turtle.forward(size)
    turtle.right(90)
    turtle.forward(size)
    turtle.right(90)
    turtle.forward(size)
    turtle.right(90 + angle)
    turtle.end_fill()


def main():
    turtle.bgcolor("pink")
    turtle_state()
    #test_drive()
    square(100, 90, "red", "blue")
    square(75, 150, "green", "purple")
    square(50, 180, "yellow", "magenta")
    turtle_state()
    input("Press enter to continue...")


main()

import turtle

PIXEL_SIZE = 30
ROWS = 20
COLUMNS = 20
LEFT = -(COLUMNS / 2) * PIXEL_SIZE
TOP = (ROWS / 2) * PIXEL_SIZE
INIT_SPEED = 0

def init():
    turtle.reset()
    turtle.speed(INIT_SPEED)
    turtle.penup()
    turtle.goto(LEFT, TOP)
    turtle.pencolor("black")
    turtle.fillcolor("white")

def draw_pixel(color):
    turtle.speed(0)
    turtle.pendown()
    turtle.pencolor("black")
    turtle.fillcolor(color)
    turtle.begin_fill()

    i = 4
    while i > 0:
        turtle.forward(PIXEL_SIZE)
        turtle.right(90)
        i -= 1

    turtle.end_fill()
    turtle.penup()
    turtle.forward(PIXEL_SIZE)

def draw_pixel_by_code(code):
    """
    Draws a pixel of color dependent on a string code
    """
    color = one_color(code)
    draw_pixel(color)

def one_color(code):
    if code == "0":
        return "black"
    if code == "1":
        return "white"
    if code == "2":
        return "red"
    if code == "3":
        return "yellow"
    if code == "4":
        return "orange"
    if code == "5":
        return "green"
    if code == "6":
        return "yellowgreen"
    if code == "7":
        return "sienna"
    if code == "8":
        return "tan"
    if code == "9":
        return "gray"
    if code == "A":
        return "darkgray"

def move(row, col):
    turtle.penup()
    x = LEFT + (col * PIXEL_SIZE)
    y = TOP - (row * PIXEL_SIZE)
    turtle.goto(x, y)

def draw_row(row, col, pixel_num, color = "red"):
    move(row, col)
    for _ in range(pixel_num):
        draw_pixel(color)

def draw_square(row, column, size, color = "green"):
    for row_count in range(size):
        draw_row(row + row_count, column, size, color)

def main():
    init()
    draw_pixel("red")
    input("Hit enter")

if __name__ == "main":
    main()
import turtle

def draw_circle(x_pos, y_pos, radius, f_color):
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.fillcolor(f_color)
    turtle.pendown()
    turtle.begin_fill()
    turtle.circle(radius)
    turtle.end_fill()


def draw_centered_circle(x_pos, y_pos, radius, f_color):
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.fillcolor(f_color)
    turtle.begin_fill()
    turtle.forward(radius) #move turtle forward by radius
    turtle.pendown()
    turtle.left(90) #turn left 90 degrees
    turtle.circle(radius) #circle by radius
    turtle.left(90)#turn left 90 degrees
    turtle.end_fill()
    turtle.penup()
    turtle.forward(radius)#move forward by radius
    turtle.left(180)#turn left 180 degrees


def draw_smiley(x_pos, y_pos, head_radius, head_color, nose_color, eye_color, mouth_color):
    draw_centered_circle(x_pos, y_pos, head_radius, head_color)
    draw_centered_circle(x_pos, y_pos, head_radius / 8, nose_color)
    eye_h_distance = head_radius * .40
    eye_v_distance = head_radius * .30
    eye_radius = head_radius * .25
    draw_eye(x_pos - eye_h_distance, y_pos + eye_v_distance, eye_radius, eye_color)
    draw_eye(x_pos + eye_h_distance, y_pos + eye_v_distance, eye_radius, eye_color)
    mouth_radius = head_radius * .60
    mouth_v_distance = head_radius * .25
    draw_mouth(x_pos, y_pos - mouth_v_distance, mouth_radius, mouth_color)


def tweak(speed, tracer):
    turtle.speed(speed)
    turtle.tracer(tracer)


def draw_eye(x_pos, y_pos, outside_radius, iris_color):
    draw_centered_circle(x_pos, y_pos, outside_radius, "white")
    draw_centered_circle(x_pos, y_pos, outside_radius / 2, iris_color)
    draw_centered_circle(x_pos, y_pos, outside_radius / 4, "black")


def draw_mouth(x_pos, y_pos, radius, f_color):
    heading = turtle.heading()
    turtle.penup()
    turtle.fillcolor(f_color)
    turtle.goto(x_pos, y_pos)
    turtle.setheading(180)
    turtle.pendown()
    turtle.begin_fill()
    turtle.forward(radius)
    turtle.left(90)
    turtle.circle(radius, 180)
    turtle.goto(x_pos, y_pos)
    turtle.setheading(heading)
    turtle.end_fill()


def main():
    #draw_circle(0, 0, 50, "blue")
    #draw_circle(100, 100, 25, "red")
    #draw_circle(-200, -200, 75, "green")
    #draw_centered_circle(100, 100, 50, "red")
    tweak(0, True)
    draw_smiley(-100, -100, 200, "yellow", "lightsalmon", "blue", "black")
    draw_smiley(200, 100, 100, "yellow", "brown", "green", "lightblue")
    draw_smiley(-150, 300, 150, "yellow", "lightsalmon", "purple", "red")
    draw_smiley(300, -100, 20, "yellow", "lightgreen", "orange", "grey")
    #draw_eye(100, 100, 50, "blue")
    #turtle.setheading(90)
    #draw_mouth(50, 50, 50, "green")
    input("Press enter to continue: ")

main()
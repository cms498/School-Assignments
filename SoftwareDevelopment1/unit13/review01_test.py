import review01
import turtle

def test_distance():
    #setup
    x1 = 0
    y1 = 3
    x2 = 4
    y2 = 0
    expected = 5
    #invoke
    actual = review01.distance(x1, y1, x2, y2)
    #analyze
    assert actual == expected

def test_triangle():
    #setup
    x1 = 0
    y1 = 0
    x2 = 0
    y2 = 300
    x3 = 400
    y3 = 0
    color = "red"
    #invoke
    actual_perimeter = review01.triangle(x1, y1, x2, y2, x3, y3, color)
    #analyze
    assert turtle.xcor() == x1
    assert turtle.ycor() == y1
    assert turtle.isdown() == False
    assert turtle.speed() == 5
    assert turtle.fillcolor() == color
    assert actual_perimeter == 1200
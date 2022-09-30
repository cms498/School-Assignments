# E:/Users/Optimus/Primes.txt
# E:/Users/Optimus/hello.py
# E:/Program Files/Python/python.exe
# E:/Program Files/Git/git-bash.exe
# cd Users/Optimus
# cd ..
# ls E:/Program Files/
# notepad info.txt
# rm hello.py

"""
git status
git add
git commit
git push
git pull
"""
import math
import turtle
import csv

def deets():
    print("Chris Shepard")
    print("Cheshire CT")
    print("GCIS-123 --> 4 Credits\nITDS-189 --> 3 Credits\nISTE-140 --> 3 Credits\nYOPS-49 --> 0 Credits\nCINT-101 --> 1 Credit\nMATH-181A --> 4 Credits\nCSEC-140 --> 3 Credits")

def mathematics():
    x = float(input("Enter a number: "))
    y = float(input("Enter another number: "))
    print(x ** y)
    print(y ** x)
    print(3.14159 * (x + y / 2) ** 2)
    print((x * y) / 2)

def circles(radius):
    print(radius)
    print(radius * 2)
    print(3.14159 * radius ** 2)
    print(2 * radius * 3.14159)
    print((4 / 3) * 3.14159 * radius ** 3)

def distance(x1, y1, x2, y2):
    return math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)

def triangle(x1, y1, x2, y2, x3, y3, color = "blue"):
    total_perimeter = 0
    turtle.speed(5)
    turtle.goto(x1, y1)
    turtle.pendown()
    turtle.fillcolor(color)
    turtle.begin_fill()
    turtle.goto(x2, y2)
    turtle.goto(x3, y3)
    turtle.goto(x1, y1)
    total_perimeter += distance(x1, y1, x2, y2)
    total_perimeter += distance(x2, y2, x3, y3)
    total_perimeter += distance(x3, y3, x1, y1)
    turtle.end_fill()
    turtle.penup()
    return total_perimeter

def chop_chop(a_string):
    even_string = ""
    odd_string = ""
    index = 0
    while index < len(a_string):
        if index % 2 == 0:
            even_string += a_string[index]
        else:
            odd_string += a_string[index]
        index += 1
    return even_string + odd_string

def unchop(a_string):
    even_index = 0
    odd_index = len(a_string) - len(a_string) // 2
    final_string = ""
    switch = 0
    for _ in a_string:
        if switch % 2 == 0:
            final_string += a_string[even_index]
            even_index += 1
        else:
            final_string += a_string[odd_index]
            odd_index += 1
        switch += 1
    return final_string

def starts_with(filname, letter):
    count = 0
    with open(filname) as file:
        for line in file:
            for word in line.strip().lower().split():
                if word[0] == letter:
                    count += 1
    return count

def zip_lookup(filename, zip_code):
    try:
        with open(filename) as file:
            csv_reader = csv.reader(file)
            for record in csv_reader:
                if record[0] == zip_code:
                    return record[1]
        raise ValueError("Zipcode not found")
    except FileNotFoundError:
        print("File Not Found")

def main():
    # deets()
    # mathematics()
    # circles(9)
    # print(chop_chop("Making Sausage!"))
    # print(unchop("Mkn asg!aigSuae"))
    # print(starts_with("data/atotc.txt", "z"))
    zip_lookup("no file", "06410")

    while True:
        zip_code = input("Enter zipcode: ")
        if zip_code == "":
            break
        try:
            print(zip_lookup("data/zip_codes.csv", zip_code))
        except ValueError as ve:
            print(ve)

if __name__ == "__main__":
    main()
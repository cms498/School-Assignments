"""
These are the review questions for section 1-5
Author: Chris Shepard
"""
import turtle
import csv

def pig_latin_translator(word):
    """
    Translates a given word into piglatin
    """
    front_string = ""
    final_string = ""
    index = 0
    for char in word:
        if char != "A" and char != "a" and char != "E" and char != "e" \
            and char != "I" and char != "i" and char != "O" and char != "o" and char != "U" and char != "u":
            front_string += char
            index += 1
            print(front_string)
        else:
            break
    for char in range(len(front_string), len(word)):
        final_string += word[char]
    return final_string + front_string + "ay"

def polygon(side_length, sides, color = "green"):
    """
    Draws a polygon of given sidelength and sides, raises valuerror if sides is less then 3
    """
    turtle.fillcolor(color)
    if sides < 3:
        raise ValueError()
    turtle.begin_fill()
    for _ in range(sides):
        turtle.forward(side_length)
        turtle.right(360 / sides)
    turtle.end_fill()
    input("Press Enter to continue: ")

def find_streets(filename, street_name):
    """
    Prints out all of the street names in a file given a filename and street_name
    """
    try:
        found = False
        with open(filename) as file:
            csv_reader = csv.reader(file)
            next(csv_reader)
            for record in csv_reader:
                if record[0].lower() == street_name:
                    if len(record) == 3:
                        print(record[0], record[1], record[2])
                    else:
                        print(record[0], record[1])
                    found = True
            if found == False:
                print("No Streets found")
    except FileNotFoundError:
        print("File Not Found")

def find_most_popular(filename):
    """
    returns the most popular street name given a file, n^2 complexity as we have a loop inside of a loop 
    iterating over the entire list lenth (n)
    """
    maxcount = 0
    max_street = ""
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            count = 0
            with open(filename) as file2:
                csv_reader2 = csv.reader(file2)
                next(csv_reader2)
                for record2 in csv_reader2:
                    if record[0] == record2[0]:
                        count += 1
                if count > maxcount:
                    maxcount = count
                    max_street = record[0]
    return max_street

def main():
    """
    Calls other functions, organization purposes
    """
    # try:
    #     polygon(50, 4)
    # except ValueError:
    #     print("Not enough sides, must be more then 3")
    # find_streets("data/streets.csv", "mission bay")
    print(find_most_popular("data/streets.csv"))

if __name__ == "__main__":
    """
    Pytest purposes, prevents main from being called from other files
    """
    main()
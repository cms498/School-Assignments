import csv
import re
from typing import ClassVar

def opener(filename):
    try:
        with open(filename) as file:
            return True
    except:
        print("File not found", filename)
        return False

def names_and_addresses(filename):
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for line in csv_reader:
            print("name:", line[0], ", address:", line[1])

def first_field(filename):
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            print(record[0])

def average(filename, column):
    sum = 0
    count = 0
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            sum += float(record[column])
            count += 1
    return sum / count

def zip_check(filename):
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            if re.findall("[7-9]\d{4}", record[1]):
                print("Found match:", record[1])
            else:
                print("No match:", record[1])

def main():
    #filename = input("Enter a filename: ")
    #print("Opened", filename, ":", opener(filename))
    #names_and_addresses("data/full_grades_010.csv")
    #first_field("data/full_grades_010.csv")
    #print(average("data/full_grades_010.csv", 26))
    zip_check("data/full_grades_010.csv")

if __name__ == "__main__":
    main()
"""
This program uses csv.reader in combination with more complicated csv files to plot students grades
Author: Chris Shepard
"""

import csv
import plotter
import re

def plot_grades(filename, firstname, lastname):
    """
    Given a file and student name, will plot grades using turtle
    """
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        plotter.init(firstname + " " + lastname, "Gradeitem", "Score")
        for line in csv_reader:
            if re.findall(lastname + ",.*" + firstname, line[0]):
                location = 3
                while location < len(line):
                    plotter.add_data_point(float(line[location]))
                    location += 1
                plotter.plot()
                input("Press enter to continue: ")

def get_average(filename, column):
    """
    Given a filename and column, it will return the average score for that section
    """
    sum = 0
    count = 0
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            try:
                sum += float(record[column])
                count += 1
            except ValueError:
                sum += 0
                count += 0

    return sum / count

def plot_class_average(filename):
    """
    Uses the get_average function and plots the average score for each assignment
    """
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        plotter.init("Class Average - " + filename, "Gradeitem", "Average")
        for record in csv_reader:
            index = 3
            while index < len(record):
                plotter.add_data_point(get_average(filename, index))
                index += 1
            plotter.plot()
            input("Press enter to continue: ")
            break

def main():
    """
    Calls other functions, organization purposes
    """
    plot_grades("data/full_grades_100.csv", "Normandy", "Curet")
    plot_grades("data/full_grades_100.csv", "Vikram", "Coldivar")
    plot_class_average("data/full_grades_999.csv")

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
"""
This program plots student grade data as well as prompts the user to enter their own commands and give appropriate responses
Catches errors such as filenotfound and indexerrors
Author: Chris Shepard
"""

import plotter

def quit():
    """
    Prompts the user if they want to quit, return true if so
    """
    status = input("Are you sure? (y/n) ")
    if status == "y" or status == "Y":
        return True
    return False

def main():
    """
    All calls to other functions happen here, plot students grades and quits program
    """
    print(">> \nEnter a command or 'quit' to Quit")
    while True:
        status = input(">> ")
        tokens = status.split()
        try:
            if tokens[0] == "quit":
                if quit() == True:
                    print("Goodbye!")
                    break
            if tokens[0] == "stu":
                student_grades(status)
            if tokens[0] == "help":
                help()
        except IndexError:
            print("Enter a command or 'quit' to quit")

def plot_grades(filename, firstname, lastname):
    """
    Given a filename first and last name will add data to a chart and plot it, if student does not exist
    it will return false, returns true if student is found and all data is plotted
    """
    with open(filename) as file:
        plotter.init(firstname + " " + lastname, "Grade Item", "Grade")
        for name in file:
            token = name.split(",")
            if token[1] == firstname and token[0] == lastname:
                location = 2
                while location < len(token):
                    try:
                        plotter.add_data_point(float(token[location]))
                        location += 1
                    except ValueError:
                        plotter.add_data_point(0.0) 
                plotter.plot()
                return True
    return False

def student_grades(a_string):
    """
    Connects to main function, taken in a string and tokenizes it, calls plot_grades with those token, catches errors
    """
    fields = a_string.split()
    try:
        filename = fields[1]
        firstname = fields[2]
        lastname = fields[3]
        if plot_grades(filename, firstname, lastname) == True:
            print("Plot finished (window may be hidden).")
        else:
            print("Plot failed (no such student).")
    except IndexError:
        print("Usage: stu <filename> <firstname> <lastname>")
    except FileNotFoundError:
        print("No such file:", filename)

def help():
    """
    Prints messages to the user, gives them the avaliable commands
    """
    print("stu <filename> <firstname> <lastname> - plot student grades")
    print("quit - quits")
    print("help - displays this message")

if __name__ == "__main__":
    """
    Calls main, pytest purposes
    """
    main()
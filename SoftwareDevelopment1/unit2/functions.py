"""
This program calculates the users age in months based on the input data
Author: Chris Shepard
"""

def day_of_month():
    """
    This function asks the user for various inputs and will use those integer 
    values to calculate the total number of months
    """
    current_year = int(input("Enter the current year: "))
    current_month = int(input("Enter the current month as a number: "))
    birth_year = int(input("Enter your birth year: "))
    birth_month = int(input("Enter the month you were born is as a number: "))

    print("Your age in months:", (current_year - birth_year) * 12 + (current_month - birth_month))#actual calculation


def day_of_year():
    """
    This function asks the user for various inputs and uses those values
    to determine what day of the year it is
    """
    month = int(input("Enter the month as a number: "))
    day = int(input("Enter the day of the current month: "))

    print("The approximate day of the year is:", int((month - 1) * 30.4) + day)


def main():
    """
    Main function for organization, will house the user_questions function
    """
    day_of_month()
    day_of_year()


main()
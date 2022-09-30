"""
This program tests the users ability to list 100 decimal digits of PI
Author: Chris Shepard
"""

def pi_tester():
    """
    This function loops through a string of the first 100 decimal digits of PI and compares them to user input
    If they don't equal the function returns the number of correct digits inputed
    """
    digits_string = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679"
    count = 0
    for digit in digits_string:
        num = input("Enter the next decimal digit of PI: ")
        if digit == num:
            count += 1
        else:
            print("Incorrect, the next digit was:", digit)
            return count
    return count

def display_score(score):
    """
    This functions takes in an integer parameter and prints a statement to the console depends on where it
    falls in a certain range
    """
    if score >= 0 and score <= 4:
        print("Score:", score, "You are a PI Neophyte")
    elif score >= 5 and score <= 9:
        print("Score:", score, "You are a PI Novice")
    elif score >= 10 and score <= 24:
        print("Score:", score, "You are a PI Journeyman")
    elif score >= 25 and score <= 49:
        print("Score:", score, "You are a PI Enthusiast")
    elif score >= 50 and score <= 96:
        print("Score:", score, "You are a PI Connoisseur")
    elif score >= 97 and score <=100:
        print("Score:", score, "You are a PI Expert")
    else:
        print("Score:", score, "You are a PI Imposter")

def main():
    """
    Calls the other functions, organization purposes
    """
    display_score(pi_tester())

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
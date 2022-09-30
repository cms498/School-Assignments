"""
This program uses long division principles and prints a value do a certain specified decimal value
Author: Chris Shepard
"""

def precise_division(numerator, denominator, precision):
    """
    Calculates long division with a remainder to a certain precision
    """
    whole_part = str(numerator // denominator)

    index = 0

    remainder = numerator % denominator

    answer_string = whole_part + "."

    while index < precision:
        remainder *= 10
        top_remainder = remainder // denominator
        digit = remainder % denominator
        string_remainder = str(top_remainder)
        answer_string = answer_string + string_remainder
        remainder = digit
        index += 1

    return answer_string

def main():
    """
    Calls division function, asks user for inputs and splits them by white space
    """
    parameters = input("Enter division parameters: ")
    splitted = parameters.split()
    numerator = int(splitted[0])
    demoninator = int(splitted[1])
    precision = int(splitted[2])
    print(precise_division(numerator, demoninator, precision))

if __name__ == "__main__":
    main()
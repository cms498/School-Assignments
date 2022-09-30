def variable_practice():
    age_in_months = 225
    print("Age in months =" , age_in_months)
    days_in_year = 365
    print("Months in a year =", days_in_year)
    pet_name = "Lucy"
    print("First pets name =", pet_name)
    pi_5_digits = "3.14159"
    print("First 5 digits of pi =", pi_5_digits)


def expressions_practice():
    literal_var = "Rainbows"
    print("Literal Variable =" , literal_var)
    addition_var = 5 + 3
    print("Addition Expression =", addition_var)
    exponent_var = 5 ** 2
    print("Exponent math =", exponent_var)
    floor_var = 7 // 2
    print("Floor division =", floor_var)
    mod_var = 7 % 2
    print("Modulus operator =", mod_var)
    parenthesis_var = (8 + 9) * 2
    print("PEMDAS =", parenthesis_var)
    complex_expression = 7 // 1 * 8 - 3
    print("Complex Expression =", complex_expression)


def prompt_and_print():
    """
    Takes two user inputs and performs various mathematical operations on them
    Prints out the result

    Result: Doesn't seem to work, an error message pops up, the additon occurs but everything else causes an error
    """
    num1 = int(input("Enter a number: "))
    num2 = int(input("Enter another: "))
    print(num1 + num2)
    print(num1 - num2)
    print(num1 * num2)
    print(num1 / num2)

def main():
    prompt_and_print()
    expressions_practice()
    variable_practice()

main()
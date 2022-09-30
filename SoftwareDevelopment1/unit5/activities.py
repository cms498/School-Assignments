def numbers():
    total_sum = 0
    while True:
        file_name = input("Enter a filename: ")
        if file_name == "":
            break
        
        sum = 0
        try:
            with open(file_name) as a_file:
               for line in a_file:
                   try:
                       num = int(line.strip())
                       sum += num
                   except:
                       print("Skipping non numeric data:", line) 
               print("Sum of numbers:", sum)
               total_sum += sum
        except FileNotFoundError:
            print("File does not Exist:", file_name)

    print("Total Sum:",total_sum)

def division():
    num_errors = 0
    while True:
        str_numerator = input("Enter a numerator: ")

        if str_numerator == "":
            break

        str_denominator = input("Enter a denominator: ")

        if str_denominator == "":
            break

        try:
            numerator = float(str_numerator)
            denominator = float(str_denominator)
            try:
                result = numerator / denominator
                print("Result of division", result)
            except ZeroDivisionError as zde:
                num_errors += 1
                if num_errors == 3:
                    raise zde
                print("Can't divide by zero")
        except ValueError as ve:
            num_errors += 1
            if num_errors == 3:
                raise ve
            print("Non-numeric data entered")

def password():
    password_1 = input("Enter a password: ")
    if len(password_1) < 10 or len(password_1) > 20:
        raise ValueError("Password must be between 10 - 20 characters")
    password_2 = input("Confirm your password: ")
    if password_1 != password_2:
        raise ValueError("Passwords do not match")
    
    return password_1

def exponent(base, power):
    if power < 0:
        raise ValueError("Exponent must be greater than or equal to zero")
    result = 1
    for i in range(power):
        result *= base

    return result

def main():
    #numbers()
    division()
    #password()

if __name__ == "__main__":
    main()
import random

def is_correct(answer, guess):
    return answer == guess

def main():
    answer = random.randint(1, 10)
    str_guess = input("Enter your guess 1-10: ")
    guess = int(str_guess)
    result = check_guess(answer, guess)
    
    if result == 0:
        print("You guess the number!")
    else:
        print("Your guess was", result, "away from the number")

def check_guess(answer, guess):
    if answer == guess:
        return 0
    elif answer > guess:
        return answer - guess
    else:
        return guess - answer

if __name__ == "__main__":
        main()
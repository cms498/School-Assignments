"""
Plays a number guessing game with the user, telling them if their guess was too high or low depending on what the 
randomly generated answer is
Author: Chris Shepard
"""

import random

def check_guess(answer, guess):
    """
    Where values are checked and outputs are given based on the user guess, such as being too low, or out of range, or even correct
    """
    if answer == guess:
        return "Correct!"
    if guess < answer and guess > 0:
        return "Too Low!"
    if guess > answer and guess < 11:
        return "Too High!"
    if guess > 10:
        return "Guess out of Range."
    return "Guess out of Range."

def test_check_guess_range_low():
    """
    Tests numbers that are below the range 1, 10
    """
    assert check_guess(5, 0) == "Guess out of Range."

def test_check_guess_correct():
    """
    tests if the guess and the answer are the same
    """
    assert check_guess(5, 5) == "Correct!"

def test_check_guess_in_range_low():
    """
    Tests if the guess is in the range and is lower then the answer
    """
    assert check_guess(5, 1) == "Too Low!"

def test_check_guess_in_range_high():
    """
    Tests if the guess is in the range and is higher then the answer
    """
    assert check_guess(5, 10) == "Too High!"

def test_check_guess_range_high():
    """
    Tests numbers that are above the range 1, 10
    """
    assert check_guess(5, 11) == "Guess out of Range."

def value_check(answer, guess):
    """
    Eliminates code repeating in main function, checks to see if the answer and guess are the same
    """
    if answer == guess:
        print("Game Over!")
        return True

def main():
    """
    Where the game is actually played, inputs are based on user, outputs are formed based on that
    """
    answer = random.randint(1, 10)
    print(answer)
    guess1 = int(input("Enter guess: "))
    print(check_guess(answer, guess1))
    if value_check(answer, guess1) == True:
        return None
    
    guess2 = int(input("Enter guess: "))
    print(check_guess(answer, guess2))
    if value_check(answer, guess2) == True:
        return None

    guess3 = int(input("Enter guess: "))
    print(check_guess(answer, guess3))
    if value_check(answer, guess3) == True:
        return None

    if answer != guess3:
        print("The correct number was", answer)

    print("Game Over!")
    return None

main()
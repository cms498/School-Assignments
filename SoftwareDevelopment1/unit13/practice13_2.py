"""
Practice problems for units 6 - 8
Author: Chris Shepard
"""
import arrays

def recursive_3_5(n, k = 3,int_list = []):
    """
    Returns a list of integers from 3 to n, if the integers are divisible by 3 or 5 but not both, uses recursion
    """
    if k > n:
        return int_list
    if k % 3 == 0 and k % 5 != 0:
        int_list.append(k)
    if k % 5 == 0 and k % 3 != 0:
        int_list.append(k)
    return recursive_3_5(n, k + 1)

def find_words(filename, letter, number):
    """
    returns an array of the first number of words in the filename given a letter
    """
    word_array = arrays.Array(number)
    with open(filename) as file:
        for line in file:
            stripped = line.strip().split()
            for word in stripped:
                if word[0].lower() == letter and word.lower() not in word_array:
                    for spot in range(len(word_array)):
                        if word_array[spot] == None:
                            word_array[spot] = word.lower()
                            break
    return word_array

def make_calendar(weekday, days):
    """
    Returns a 2d array in the form of a calender given a starting day and number of days
    """
    table = []
    week = []
    current_day = 1

    for day in range(7):
        if day >= weekday:
            week.append("0" + str(current_day))
            current_day += 1
        else:
            week.append("  ")
    table.append(week)
    week = []
    for day in range(current_day, days + 1):
        if len(week) == 6:
            if day < 10:
                week.append("0" + str(day))
            else:
                week.append(str(day))
            table.append(week)
            week = []
        elif day < 10:
            week.append("0" + str(day))
        else:
            week.append(str(day))
    while len(week) != 7:
        if len(week) == 0:
            return table
        week.append("  ")
    table.append(week)
    return table

def main():
    """
    Organizational purposes, calls other functions
    """
    print(recursive_3_5(20))
    print(find_words("data/atotc.txt", "j", 5))
    for row in make_calendar(0, 31):
        print(row)

if __name__ == "__main__":
    """
    Pytest purposes, prevents main from being called from other modules
    """
    main()
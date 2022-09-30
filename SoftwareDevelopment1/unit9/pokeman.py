"""
This program simulates opening a pack of pokemon cards using various types of data structures
Author: Chris Shepard
"""
import csv
import random

def make_database(filename):
    """
    reads a file and creates a database of pokemon cards, using dictionaries, and tuples
    """
    database = dict()
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for line in csv_reader:
            database[int(line[1])] = (int(line[1]), line[0], line[2])
    return database

def make_pack(database):
    """
    Returns a "pack" of 10 unique pokemon cards drawn from the database
    """
    pack = set()
    while len(pack) < 10:
        number = random.randint(1, len(database))
        pack.add(database[number])
    return pack

def build_basic_collection(database):
    """
    Builds a full set of cards, and returns the number of packs "bought" to fill that set
    """
    collection = set()
    set_count = 0
    while True:
        if len(collection) == len(database):
            break
        for card in make_pack(database):
            collection.add(card)
        set_count += 1
    return set_count

def build_counting_collection(database):
    """
    Returns the complete card collection, along with how many of each card were collected when "opening" packs
    """
    collection = dict()
    while True:
        if len(collection) == len(database):
            break
        for card in make_pack(database):
            if card in collection:
                collection[card] += 1
            else:
                collection[card] = 1
    return collection

def main():
    """
    Calls other functions, organization purposes, builds the card collection
    """
    database = make_database("pokemon.csv")
    print()

    print("Cards in database:",len(database))
    print()

    print("Cards in pack:")
    for line in make_pack(database):
        print(line)
    print()

    total = 0
    for _ in range(1000):
        total += build_basic_collection(database)
    print("Average packs opened to complete a set:", total / 1000)
    print()

    print("Cards purchased to complete set:")
    a_dict = build_counting_collection(database)
    sorted_list = sorted(a_dict.keys())
    largest_card = ()
    largest_value = 0
    for index in range(len(sorted_list)):
        for key in a_dict:
            if key == sorted_list[index]:
                value = a_dict[key]
                if value > largest_value:
                    largest_card = key
                    largest_value = value
                print(sorted_list[index], ":", value)
    print("Most:", largest_card, ":", largest_value)
    print()

    count = 0
    for key in a_dict:
        value = a_dict[key]
        count += value
    print("Total:", count)

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
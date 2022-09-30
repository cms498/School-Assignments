"""
This program uses various classes and special methods to simulate having a pokemon battle
Author: Chris Shepard
"""
import csv
import pokemon
import random

class Pokedex:
    """
    Creates an outline for a pokedex object which is a collection of pokemon
    """
    __slots__ = ["__pokemon_list"]

    def __init__(self):
        self.__pokemon_list = []

    def load(self, filename):
        """
        Creates a list of pokemon objects given a filename
        """
        with open(filename) as file:
            csv_reader = csv.reader(file)
            next(csv_reader)
            for record in csv_reader:
                self.__pokemon_list.append(pokemon.Pokemon(record[0], record[1], record[2], record[3]))

    def create_parties(self):
        """
        Creates two random different sets of pokemon and returns those sets
        """
        random.shuffle(self.__pokemon_list)
        set1 = set()
        set2 = set()
        set_counter = 0
        for pokemon in range(len(self.__pokemon_list)):
            if set_counter == 12:
                break
            if set_counter % 2 == 0:
                set1.add(self.__pokemon_list[pokemon])
            else:
                set2.add(self.__pokemon_list[pokemon])
            set_counter += 1
        return set1, set2

def main():
    """
    Calls the other functions, organization purposes
    """
    pass

if __name__ == "__main__":
    """
    Prevents main from being run from other programs, pytest purposes
    """
    main()
import random

# Field Numbers
NAME = 0
SOUND = 1
COLOR = 2

ANIMALS = [
    ["tiger","roar","orange/black"],
    ["parrot","squawk","green"],
    ["shark","chomp","grey"],
    ["dog","ruff","brown"],
    ["snake","hiss","red/black"],
    ["sheep","bleat","white"],
    ["cat","meow","black"],
    ["mouse","squeak","grey"]
]

class Animal:
    __slots__ = ["__name", "__sound", "__color"]

    def __init__(self, name, sound, color):
        self.__name = name
        self.__sound = sound
        self.__color = color

    def __repr__(self):
        return self.__color + " " +self.__name + " says " + self.__sound

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__name == other.__name and self.__sound == other.__sound and self.__color == other.__color
        return False

    def __hash__(self):
        return hash(self.__name)

    def get_name(self):
        return self.__name

    def get_sound(self):
        return self.__sound

    def get_color(self):
        return self.__color

def fill_ark():
    expected_count = len(ANIMALS) * 2
    actual_count = 0
    ark_dict = dict()
    while expected_count != actual_count:
        choice = random.randint(0, len(ANIMALS) - 1)
        animal = Animal(ANIMALS[choice][NAME], ANIMALS[choice][SOUND], ANIMALS[choice][COLOR])
        if animal not in ark_dict:
            ark_dict[animal] = 1
            actual_count += 1
        elif ark_dict[animal] >= 2:
            continue
        else:
            ark_dict[animal] += 1
            actual_count += 1
    print(ark_dict)

def main():
    fill_ark()

if __name__ == "__main__":
    main()
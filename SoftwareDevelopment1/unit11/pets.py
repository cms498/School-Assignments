class Pet:
    __slots__ = ["__species", "__name", "__weight", "__fur_color", "__age"]

    def __init__(self, species, name, weight, fur_color, age = 0):
        self.__species = species
        self.__name = name
        self.__weight = weight
        self.__fur_color = fur_color
        self.__age = age

    def feed(self, calories):
        self.__weight += calories / 3000

    def walk(self, miles):
        self.__weight -= (miles * 100) / 3000

    def get_name(self):
        return self.__name

    def get_weight(self):
        return self.__weight
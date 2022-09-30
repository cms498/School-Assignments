"""
This program uses various classes and special methods to simulate having a pokemon battle
Author: Chris Shepard
"""
class Pokemon:
    """
    Create the outline for a pokemon object
    """
    __slots__ = ["__name", "__type", "__health_points", "__damage_points"]

    def __init__(self, name, type, health_points, damage_points):
        self.__name = name
        self.__type = type
        self.__health_points = int(health_points)
        self.__damage_points = damage_points

    def __str__(self):
        return self.__name

    def __repr__(self):
        return self.__name + ":" + self.__type + ":" + str(self.__health_points)

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__type == other.__type and self.__health_points == other.__health_points
        else:
            return False

    def __gt__(self, other):
        if type(self) != type(other):
            return False

        if self.__type == "Water" and other.__type == "Fire":
            return True
        elif self.__type == "Fire" and other.__type == "Grass":
            return True
        elif self.__type == "Grass" and other.__type == "Water":
            return True
        elif self.__type == other.__type:
            if self.__health_points > other.__health_points:
                return True
        else:
            return False

    def __hash__(self):
        return hash(self.__name)

    def get_damage_points(self):
        """
        Returns the damage points for any pokemon
        """
        return int(self.__damage_points)

    def lose_round(self, damage_points):
        """
        Takes away health points from one pokemon, given the damage points of another
        """
        self.__health_points -= damage_points

    def is_fainted(self):
        """
        Determines is the pokemons health is below or equal to zero, returns true if so
        """
        if int(self.__health_points) <= 0:
            return True
        else:
            return False

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
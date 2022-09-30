"""
This program simulates assembling droids using queues and stacks
Author: Chris Shepard
"""
import random

PROTOCOL = "Protocol"
ASTROMECH = "Astromech"

PROTOCOL_PARTS = ["p_head", "p_chassis", "p_left_arm", "p_right_arm", "p_left_leg", "p_right_leg"]
ASTROMECH_PARTS = ["a_dome", "a_body", "a_left_leg", "a_center_leg", "a_right_leg"]

class Droid:
    """
    Constructor for creating a droid object as well as other methods
    """
    __slots__ = ["__number", "__type", "__parts"]

    def __init__(self, type):
        self.__number = type[0] + str(random.randint(100, 999))
        self.__type = type
        self.__parts = {}
        if type == PROTOCOL:
            parts_list = PROTOCOL_PARTS
        else:
            parts_list = ASTROMECH_PARTS

        for part in parts_list:
            self.__parts[part] = False

    def needs_part(self, part):
        """
        Returns true if a droid needs a part, false if otherwise
        """
        return part in self.__parts and self.__parts[part] == False

    def install_part(self, part):
        """
        Installs a part on a droid, raises valuerror is droid doesn't needs part or is for the other type of droid
        """
        if part not in self.__parts:
            raise ValueError(part + " not valid for" + self.__type)
        if self.__parts[part] == True:
            raise ValueError(part + " already installed")
        self.__parts[part] = True

    def is_complete(self):
        """
        Returns true is the droid has all of its parts, false if otherwise
        """
        for part in self.__parts:
            if self.__parts[part] == False:
                return False
        return True

    def get_type(self):
        return self.__type

    def __repr__(self):
        status = []
        for part in self.__parts:
            if self.needs_part(part) == True:
                status.append("missing")
            else:
                status.append("installed")
        if self.get_type() == PROTOCOL:
            parts_list = PROTOCOL_PARTS
        else:
            parts_list = ASTROMECH_PARTS

        string = self.__type + " Droid:" + "\n Serial Number " + str(self.__number)
        for index in range(len(parts_list)):
            string += "\n " + parts_list[index] + ": " + status[index]
        return string

    def __str__(self):
        if self.is_complete() == True:
            return str(self.__number) + " (complete)"
        else:
            return str(self.__number) + " (incomplete)"

def main():
    """
    Calls other functions, pytest purposes
    """
    pass

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
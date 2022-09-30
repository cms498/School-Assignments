import math

class Sphere:
    __slots__ = ["__radius"]

    def __init__(self, radius):
        self.__radius = radius

    def get_radius(self):
        return self.__radius

    def get_circumference(self):
        return round(self.__radius * 2 * math.pi, 2)

    def get_surface_area(self):
        return round((self.__radius ** 2) * 4 * math.pi, 2)

    def get_volume(self):
        return round((4/3) * math.pi * (self.__radius) ** 3, 2)

    def __str__(self):
        return "Sphere: R=" + str(self.get_radius()) + " C=" + str(self.get_circumference()) + " A=" + str(self.get_surface_area()) + " V=" + str(self.get_volume())

    def __eq__(self, other):
        if type(self) == type(other):
            return self.get_radius() == other.get_radius()
        return False

    def __gt__(self, other):
        if type(self) == type(other):
            return self.get_radius() > other.get_radius()
        return False

    def __ge__(self, other):
        if type(self) == type(other):
            return self.get_radius() >= other.get_radius()
        return False

    def __lt__(self, other):
        if type(self) == type(other):
            return self.get_radius() < other.get_radius()
        return False

    def __le__(self, other):
        if type(self) == type(other):
            return self.get_radius() <= other.get_radius()
        return False

def main():
    print(Sphere(8))
    print(Sphere(3) > Sphere(8))
    print(Sphere(8) > Sphere(3))

if __name__ == "__main__":
    main()
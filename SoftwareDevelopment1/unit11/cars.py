class Car:
    __slots__ = ["__vin", "__make", "__model", "__year", "__mileage", "__fuel"]

    def __init__(self, vin, make, model, year):
        self.__vin = vin
        self.__make = make
        self.__model = model
        self.__year = year
        self.__mileage = 0
        self.__fuel = 0

    def __repr__(self):
        return "Car: " \
            + "\n\tVIN = " + self.__vin \
            + "\n\tMake = " + self.__make \
            + "\n\tModel = " + self.__model \
            + "\n\tYear = " + str(self.__year) \
            + "\n\tMileage = " + str(self.__mileage) \
            + "\n\tFuel = " + str(self.__fuel)
    
    def __str__(self):
        return "Car: VIN = " + self.__vin \
            + " Make = " + self.__make \
            + " Model = " + self.__model

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__vin == other.__vin
        else:
            return False

    def __lt__(self, other):
        if type(self) == type(other):
            return self.__vin < other.__vin
        else:
            return False

    def __le__(self, other):
        if type(self) == type(other):
            return self.__vin <= other.__vin
        else:
            return False

    def __gt__(self, other):
        if type(self) == type(other):
            return self.__vin > other.__vin
        else:
            return False

    def __le__(self, other):
        if type(self) == type(other):
            return self.__vin >= other.__vin
        else:
            return False

    def __hash__(self):
        return hash(self.__vin)

    def print_car(self):
        print("VIN =", self.__vin, ", Make =", self.__make, ", Model =", self.__model, ", Year =", self.__year,
            ", Mileage", self.__mileage, ", Fuel =", self.__fuel)

    def filler_up(self, gallons):
        self.__fuel += gallons
        if self.__fuel > 15:
            self.__fuel = 15

    def drive(self, miles):
        range = self.__fuel * 30
        if miles > range:
            miles = range
        self.__mileage += miles
        self.__fuel -= miles / 30
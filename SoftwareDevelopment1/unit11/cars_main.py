import cars

def main():
    car1 = cars.Car("A123", "Ford", "Edge", 2014)
    car2 = cars.Car("A124", "Chevy", "Corvette", 2020)

    car1.print_car()
    car2.print_car()
    
    car1.filler_up(10)
    car2.filler_up(16)

    car1.print_car()
    car2.print_car()

    car1.drive(30)
    car2.drive(600)

    car1.print_car()
    car2.print_car()

    str_car = str(car1)
    print(str_car)
    print(repr(car2))

    car3 = cars.Car("A123", "Buick", "Encore", 2016)
    print(car1 == car2)
    print(car2 == car3)
    print(car1 == car3)

    car_list = [car1, car2, car3, 
                    cars.Car("A125", 'Chevy', "Corvette", 2018), 
                    cars.Car("A126", "Ford", "Mustang", 1965)]
    car_list.sort()
    print(car_list)

    car_set = set(car_list)

    print(car_set)

if __name__ == "__main__":
    main()
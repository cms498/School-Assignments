"""
This program uses various data structures and classes to simulate buying pizzas
Author: Chris Shepard
"""
class Toppings:
    __slots__ = ["name", "code", "price"]

    def __init__(self, name, code, price):
        self.name = name
        self.code = code
        self.price = price

class Pizza:
    __slots__ = ["cheese", "veggies", "meats", "price"]

    def __init__(self):
        self.cheese = ""
        self.veggies = set()
        self.meats = set()
        self.price = 5.00

CHEESES = {"f": Toppings("Fresh Mozzarella", "f", 1.0), "s": Toppings("Shredded Cheese", "s", 0.0), "c": Toppings("Cheddar", "c", 0.5)}
MEATS = {"p": Toppings("Pepperoni", "p", 1.5), "s": Toppings("Sausage", "s", 1.5), "b": Toppings("Bacon", "b", 1.0), 
        "m": Toppings("Meatball", "m", 2.0), "n": Toppings("None", "n", 0.0)}
VEGGIES = {"m": Toppings("Mushrooms", "m", 1.0), "b": Toppings("Bell Peppers", "b", 1.0), "j": Toppings("Jalapeno Peppers", "j", 1.0), 
            "p": Toppings("Pineapple", "p", 1.5), "n": Toppings("None", "n", 0.0)}

def print_options(dictionary):
    """
    Prints all of the options out for toppings, including name, code, and price
    """
    string = ""
    for key in dictionary:
        name = dictionary[key].name
        code = dictionary[key].code
        price = dictionary[key].price
        string += name + "(" + code + "): $" + str(price) + " "
    stripped = string.strip()
    print(stripped)
    return stripped

def order_pizza():
    """
    Orders a single pizza, with all toppings, return a total price and a pizza with those toppings
    """
    while True:
        cheese_order = str(input("Choose one type of cheese (O for options): "))
        if cheese_order != "O":
            break
        else:
            print_options(CHEESES)
    while True:
        meat_order = str(input("Choose your meats (O for options): "))
        if meat_order != "O":
            break
        else:
            print_options(MEATS)
    while True:
        veg_order = str(input("Choose your veggies (O for options): "))
        if veg_order != "O":
            break
        else:
            print_options(VEGGIES)

    a_pizza = Pizza()
    total_price = a_pizza.price

    meat_order = meat_order.strip().split()
    veg_order = veg_order.strip().split()

    for topping in meat_order:
        if topping != "n":
            a_pizza.meats.add(MEATS[topping])
            total_price += MEATS[topping].price

    for topping in veg_order:
        if topping != "n":
            a_pizza.veggies.add(VEGGIES[topping])
            total_price += VEGGIES[topping].price

    a_pizza.cheese = CHEESES[cheese_order]
    total_price += CHEESES[cheese_order].price
    a_pizza.price = total_price

    return a_pizza

def print_pizza(pizza):
    """
    Prints out a pizza with toppings and price
    """
    total_price = 5
    cheese = CHEESES[pizza.cheese.code]
    toppings = cheese.name + ", "
    total_price += cheese.price

    for value in pizza.meats:
        meat = MEATS[value.code]
        toppings = toppings + meat.name + ", "
        total_price += meat.price

    for value in pizza.veggies:
        veg = VEGGIES[value.code]
        toppings = toppings + veg.name + ", "
        total_price += veg.price

    toppings = toppings.strip().strip(",")
    print("One pizza with", toppings, ": ${:.2f}".format(total_price))

def main():
    """
    Calls the other functions, organization purposes
    """
    print("Welcome to Pizza Factory, where all orders include two Pizzas!")
    print()
    print("For your first pizza...")
    pizza1 = order_pizza()
    print()
    print("For your second pizza...")
    pizza2 = order_pizza()
    print()
    print_pizza(pizza1)
    print_pizza(pizza2)
    total_price = pizza1.price + pizza2.price
    print()
    print("Total Price: ${:.2f}".format(total_price))

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
"""
Testing functions for pizza_pizza.py file
Author: Chris Shepard
"""

import pizza_pizza

CHEESES = {"f": pizza_pizza.Toppings("Fresh Mozzarella", "f", 1.0), "s": pizza_pizza.Toppings("Shredded Cheese", "s", 0.0), "c": pizza_pizza.Toppings("Cheddar", "c", 0.5)}
MEATS = {"p": pizza_pizza.Toppings("Pepperoni", "p", 1.5), "s": pizza_pizza.Toppings("Sausage", "s", 1.5), "b": pizza_pizza.Toppings("Bacon", "b", 1.0), 
        "m": pizza_pizza.Toppings("Meatball", "m", 2.0), "n": pizza_pizza.Toppings("None", "n", 0.0)}
VEGGIES = {"m": pizza_pizza.Toppings("Mushrooms", "m", 1.0), "b": pizza_pizza.Toppings("Bell Peppers", "b", 1.0), "j": pizza_pizza.Toppings("Jalapeno Peppers", "j", 1.0), 
            "p": pizza_pizza.Toppings("Pineapple", "p", 1.5), "n": pizza_pizza.Toppings("None", "n", 0.0)}

def test_print_options_cheese():
    #setup
    expected = "Fresh Mozzarella(f): $1.0 Shredded Cheese(s): $0.0 Cheddar(c): $0.5"

    #invoke
    actual = pizza_pizza.print_options(CHEESES)

    #analyze
    assert expected == actual

def test_print_options_meat():
    #setup
    expected = "Pepperoni(p): $1.5 Sausage(s): $1.5 Bacon(b): $1.0 Meatball(m): $2.0 None(n): $0.0"

    #invoke
    actual = pizza_pizza.print_options(MEATS)

    #analyze
    assert expected == actual

def test_print_options_veggie():
    #setup
    expected = "Mushrooms(m): $1.0 Bell Peppers(b): $1.0 Jalapeno Peppers(j): $1.0 Pineapple(p): $1.5 None(n): $0.0"

    #invoke
    actual = pizza_pizza.print_options(VEGGIES)

    #analyze
    assert expected == actual

def test_print_pizza():
    a_pizza = pizza_pizza.Pizza()
    a_pizza.cheese = "f"
    a_pizza.meats = {"b", "m"}
    a_pizza.veggies = {"j", "p"}
    expected = "One pizza with Fresh Mozzarella, Bacon, Meatball, Pineapple, Jalapeno Peppers : $8.50"

    #visual testing as nothing is returned


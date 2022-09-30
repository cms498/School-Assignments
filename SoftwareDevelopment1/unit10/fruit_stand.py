class Fruit:
    __slots__ = ["type", "price"]

    def __init__(self, type, price):
        self.type = type
        self.price = price

APPLE = Fruit("apple", 1.35)
ORANGE = Fruit("orange", 2.00)
BANANA = Fruit("banana", 0.99)

def add_to_basket(basket, item):
    if item == "apple":
        basket.append(APPLE)
    elif item == "orange":
        basket.append(ORANGE)
    elif item == "banana":
        basket.append(BANANA)

def total_price(basket):
    price = 0
    for fruit in basket:
        price += fruit.price
    return price

def fruit_count(basket, fruit):
    count = 0
    for index in basket:
        if index == fruit:
            count += 1
    return count

def main():
    basket = []
    while True:
        item = input("Enter a fruit to add to basket, or enter to stop shopping: ")
        if item == "":
            break
        add_to_basket(basket, item.lower())
    print("Total Price:", "${:.2f}".format(total_price(basket)))
    print("You have", fruit_count(basket, APPLE), APPLE.type)
    print("You have", fruit_count(basket, ORANGE), ORANGE.type)
    print("You have", fruit_count(basket, BANANA), BANANA.type)

if __name__ == "__main__":
    main()
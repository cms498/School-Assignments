"""
*Average Case*
                Access/Updates          Insert/Delete           is orderable            Value must be unique
Array                O(C)                    O(N)                    Y                           N
List                 O(C)                    O(N)                    Y                           N
Dictionary           O(C)                    O(C)                    N                         Keys
Set                  O(C)                    O(C)                    N                           Y
Stack                O(C)                    O(C)                 Ordered                        N
Queue                O(C)                    O(C)                 Ordered                        N
"""

import random
import array_queue
import node_stack

class Item:
    __slots__ = ["__name", "__weight", "__price"]

    def __init__(self, name, weight, price):
        self.__name = name
        self.__weight = weight
        self.__price = price

    def __repr__(self):
        return self.__name + " " + str(self.__weight) + "lb $" + str(self.__price)

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__name == other.__name
        return False

    def __hash__(self):
        return hash(self.__name)

    def __lt__(self, other):
        if type(self) == type(other):
            return self.__weight < other.__weight
        return False

    def get_name(self):
        return self.__name

    def get_price(self):
        return self.__price

class Customer:
    __slots__ = ["__list", "__cart", "__bags"]

    def __init__(self, list):
        self.__list = list
        self.__cart = set()
        self.__bags = []

    def add_bag(self, bag):
        self.__bags.append(bag)

    def shop(self, store):
        for item_name in self.__list:
            self.__cart.add(store[item_name])

    def unload(self, belt):
        for item in self.__cart:
            belt.enqueue(item)

    def unpack(self):
        bag_num = 1
        for bag in self.__bags:
            print("Bag #" + str(bag_num))
            bag_num += 1
            while bag.is_empty() == False:
                item = bag.pop()
                print("\t" + repr(item))

def make_item(item_number):
    return Item("Item #" + str(item_number), random.randint(1, 10), random.randint(1, 20))

MAX_STORE_ITEMS = 100
def fill_store():
    store = dict()
    for i in range(MAX_STORE_ITEMS):
        item = make_item(i)
        store[item.get_name()] = item
    return store

def cashier(belt, customer):
    total_price = 0
    bag = node_stack.Stack()
    while belt.is_empty() == False:
        item = belt.dequeue()
        total_price += item.get_price()
        if bag.is_empty() == False:
            if item < bag.peek():
                bag.push(item)
            else:
                customer.add_bag(bag)
                bag = node_stack.Stack()
                bag.push(item)
        else:
            bag.push(item)
    if bag.is_empty() == False:
        customer.add_bag(bag)
    return total_price

def main():
    random.seed(99)
    # item_set = set()
    # for num in range(5):
    #     item_set.add(make_item(num))
    # print(item_set)
    # print(sorted(item_set))
    store = fill_store()
    shopping_list = list(store.keys())
    random.shuffle(shopping_list)
    customer = Customer(shopping_list[:25])
    belt = array_queue.Queue()
    customer.shop(store)
    customer.unload(belt)
    cashier(belt, customer)
    customer.unpack()

if __name__ == '__main__':
    main()
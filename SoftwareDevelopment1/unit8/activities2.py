import random

def rgb_tuple():
    return (random.random(), random.random(), random.random())

def tuple_equality(tuple1, tuple2):
    print(tuple1, tuple2)
    print(tuple1 is tuple2)
    print(tuple1 == tuple2)

def reverse_sequence(sequence):
    a_list = []
    for index in range(len(sequence) - 1, -1, -1):
        a_list.append(sequence[index])
    return a_list

def slices():
    quote = "Hello Mr. Bond, I've been expecting you"
    a_list = list(quote)
    start = 0
    for index in range(0, len(a_list) - 1):
        if a_list[index] == " ":
            print(a_list[start:index])
            start = index + 1
    print(a_list[start:])

def dices(a_list):
    if len(a_list) == 0:
        return
    index = random.randint(0, len(a_list) - 1)
    print(a_list[index : index + 1])
    dices(a_list[:index] + a_list[index + 1:])
    
def random_list(size):
    a_list = []
    for _ in range(size):
        a_list.append(random.randint(0, 100))
    return a_list

def sorted_test(a_list, backwards = False):
    print(a_list)
    b_list = sorted(a_list, reverse = backwards)
    print(a_list, b_list)

def sort_test(a_list, backwards = False):
    print(a_list)
    a_list.sort(reverse = backwards)
    print(a_list)

def sort_cards(hand):
    print(hand)
    hand.sort(key = suit_key)
    print(hand)

def suit_key(card):
    if card[1] == "C":
        key_value = 100
    elif card[1] == "D":
        key_value = 200
    elif card[1] == "H":
        key_value = 300
    else:
        key_value = 400
    return key_value + card[0]

def main():
    # print(rgb_tuple())
    # print(rgb_tuple())
    # print(rgb_tuple())

    # list = [1, False, "book"]
    # tup1 = tuple(list)
    # tup2 = tuple(list)
    # tup3 = ("book", 1, False)
    # tuple_equality(tup1, tup1)
    # tuple_equality(tup1, tup2)
    # tuple_equality(tup1, tup3)

    # sequence1 = [1, 2, 3, 4, 5, 6, 7]
    # sequence2 = [False, 1, "string", 3.14]
    # print(reverse_sequence(sequence1))
    # print(reverse_sequence(sequence2))

    # slices()

    # dices([4, 3, 2, 1])

    # a_list = random_list(10)
    # sorted_test(a_list, True)
    # sort_test(a_list, True)

    hand = [(10, "D"), (10, "H"), (5, "S"), (11, "C"), (14, "S")]
    sort_cards(hand)

if __name__ == "__main__":
    main()
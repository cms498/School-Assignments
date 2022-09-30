"""
This program creates a deck of cards, shuffles and deals them, all using tuples and lists
Author: Chris Shepard
"""
import random

def make_card(rank, suit):
    """
    Creates and returns a card given a rank and suit in a tuple
    """
    name = str(rank) + " of " + suit
    if rank  < 10:
        shorthand = " " + str(rank) + suit[0]
    elif rank == 10:
        shorthand = str(rank) + suit[0]
    elif rank == 11:
        name = "Jack of " + suit
        shorthand = " J" + suit[0]
    elif rank == 12:
        name = "Queen of " + suit
        shorthand = " Q" + suit[0]
    elif rank == 13:
        name = "King of " + suit
        shorthand = " K" + suit[0]
    else:
        name = "Ace of " + suit
        shorthand = " A" + suit[0]
    if suit == "Clubs" or suit == "Spades":
        shorthand = "\033[34m" + shorthand + "\033[37m"
    else:
        shorthand = "\033[31m" + shorthand + "\033[37m"
    card = (rank, suit, name, shorthand)
    return card

def make_deck():
    deck = []
    for rank in range(2, 15):
        for suit in ("Clubs", "Diamonds", "Hearts", "Spades"):
            deck.append(make_card(rank, suit))
    return deck

def shuffle(a_deck):
    for index in range(0, len(a_deck) - 1):
        j = random.randint(index, len(a_deck) - 1)
        a_deck[index], a_deck[j] = a_deck[j], a_deck[index]
    return a_deck

def draw(a_deck, hand = []):
    if len(a_deck) == 0:
        return None
    hand.append(a_deck[len(a_deck) - 1])
    return a_deck.pop()

def deal(a_deck, num_cards):
    hand1 = []
    hand2 = []
    for index in range(num_cards * 2):
        if index % 2 == 0:
            hand1.append(a_deck[index])
        else:
            hand2.append(a_deck[index])
    return hand1, hand2

def cut(a_deck):
    if len(a_deck) == 0 or len(a_deck) == 1:
        raise ValueError()
    mid = len(a_deck) // 2
    if len(a_deck) % 2 != 0:
        half1 = a_deck[:mid + 1]
        half2 = a_deck[mid + 1:]
    else:
        half1 = a_deck[:mid]
        half2 = a_deck[mid:]
    return half1, half2

def main():
    pass

if __name__ == "__main__":
    main()
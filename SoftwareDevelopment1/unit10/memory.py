import random

class Card:
    __slots__ = ["rank", "suit"]

    def __init__(self, rank, suit):
        self.rank = rank
        self.suit = suit

class Flippable:
    __slots__ = ["is_flipped", "card"]

    def __init__(self, card):
        self.is_flipped = False
        self.card = card

BOARD_DIM = 4
def make_board(deck):
    count = (BOARD_DIM * BOARD_DIM) // 2
    random.shuffle(deck)
    cards = deck[:count] + deck[:count]
    random.shuffle(cards)
    board = [[ Flippable(cards[r * BOARD_DIM + column]) for column in range(BOARD_DIM)] for r in range(BOARD_DIM)]
    for r in range(BOARD_DIM):
        for c in range(BOARD_DIM):
            print(board[r][c].card.rank, board[r][c].card.suit, end = ", ")
        print()

def print_deck(deck):
    for card in deck:
        print("Card: R=", card.rank,", S = ", card.suit)

SUITS = ["Clubs", "Diamonds", "Hearts", "Spades"]
def main():
    deck = []
    for suit in SUITS:
        for rank in range(1, 11):
            deck.append(Card(rank, suit))
    make_board(deck)

if __name__ == "__main__":
    main()
"""
Test the functions in cards.py
"""
import cards
import random

def test_make_card_under10():
    #setup
    rank = 9
    suit = "Clubs"
    expected = (rank, suit, "9 of Clubs", "\x1b[34m 9C\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_card_10():
    #setup
    rank = 10
    suit = "Spades"
    expected = (rank, suit, "10 of Spades", "\x1b[34m10S\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_card_11():
    #setup
    rank = 11
    suit = "Diamonds"
    expected = (rank, suit, "Jack of Diamonds", "\x1b[31m JD\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_card_12():
    #setup
    rank = 12
    suit = "Hearts"
    expected = (rank, suit, "Queen of Hearts", "\x1b[31m QH\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_card_13():
    #setup
    rank = 13
    suit = "Clubs"
    expected = (rank, suit, "King of Clubs", "\x1b[34m KC\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_card_14():
    #setup
    rank = 14
    suit = "Spades"
    expected = (rank, suit, "Ace of Spades", "\x1b[34m AS\x1b[37m")

    #invoke
    actual = cards.make_card(rank, suit)

    #analyze
    assert actual == expected

def test_make_deck5():
    #setup
    expected = (5, "Clubs", "5 of Clubs", "\x1b[34m 5C\x1b[37m")

    #invoke
    actual = cards.make_deck()

    #
    assert actual[12] == expected

def test_make_deck2():
    #setup
    expected = (2, "Spades", "2 of Spades", "\x1b[34m 2S\x1b[37m")

    #invoke
    actual = cards.make_deck()

    #
    assert actual[3] == expected

def test_make_deck3():
    #setup
    expected = (3, "Hearts", "3 of Hearts", "\x1b[31m 3H\x1b[37m")

    #invoke
    actual = cards.make_deck()

    #
    assert actual[6] == expected

def test_make_deck4():
    #setup
    expected = (4, "Diamonds", "4 of Diamonds", "\x1b[31m 4D\x1b[37m")

    #invoke
    actual = cards.make_deck()

    #
    assert actual[9] == expected

def test_shuffle_pos0():
    #setup
    a_list = [1, 2, 3, 4]
    random.seed(1)
    expected = 2

    #invoke
    actual = cards.shuffle(a_list)

    #assert
    assert expected == actual[0]

def test_shuffle_poslen():
    #setup
    a_list = [1, 2, 3, 4]
    random.seed(1)
    expected = 1

    #invoke
    actual = cards.shuffle(a_list)

    #assert
    assert expected == actual[len(a_list) - 1]

def test_draw_empty_deck():
    #setup
    deck = []
    hand = []
    expected = None

    #invoke
    actual = cards.draw(deck, hand)

    #analyze
    assert expected == actual

def test_draw_remove_end():
    #setup
    deck = [1, 2, 3]
    hand = []
    expected = 3

    #invoke
    actual = cards.draw(deck, hand)

    #analyze
    assert expected == actual

def test_deal():
    #setup
    a_deck = [1, 2, 3, 4, 5, 6]
    num_cards = 3
    hand1 = [1, 3, 5]
    hand2 = [2, 4, 6]
    
    #invoke
    actual = cards.deal(a_deck, num_cards)

    #analyze
    assert actual == (hand1, hand2)

def test_deal2():
    #setup
    a_deck = [1, 2, 3, 4, 5, 6]
    num_cards = 2
    hand1 = [1, 3]
    hand2 = [2, 4]
    
    #invoke
    actual = cards.deal(a_deck, num_cards)

    #analyze
    assert actual == (hand1, hand2)

def test_cut_size0_1():
    #setup
    a_deck = []
    
    try:
        cards.cut(a_deck)
    except ValueError:
        assert "Deck is empty or has 1 valye"

def test_cut_oddlen():
    #setup
    a_deck = [1, 2, 3, 4, 5]
    expected = ([1, 2, 3],[4, 5])

    #invoke
    actual = cards.cut(a_deck)

    assert actual == expected

def test_cut_evenlen():
     #setup
    a_deck = [1, 2, 3, 4]
    expected = ([1, 2],[3, 4])

    #invoke
    actual = cards.cut(a_deck)

    assert actual == expected
"""
Tests some of the functions written in the blackjack module
"""
import blackjack
import cards

def test_hand_score_noace():
    #setup
    hand = [cards.make_card(2, "Hearts"), cards.make_card(10, "Diamonds")]
    expected = 12

    #invoke
    actual = blackjack.hand_score(hand)

    #analyze
    assert actual == expected

def test_hand_score_oneace_():
    #setup
    hand = [cards.make_card(10, "Spades"), cards.make_card(14, "Spades")]
    expected = 21

    #invoke
    actual = blackjack.hand_score(hand)

    #analyze
    assert actual == expected

def test_hand_score_change_ace_to_1():
    #setup
    hand = [cards.make_card(5, "Hearts"), cards.make_card(10, "Spades"), cards.make_card(14, "Spades")]
    expected = 16

    #invoke
    actual = blackjack.hand_score(hand)

    #analyze
    assert expected == actual

def test_hand_score_multiple_aces():
    #setup
    hand = [cards.make_card(14, "Spades"), cards.make_card(14, "Clubs")]
    expected = 12

    #invoke
    actual = blackjack.hand_score(hand)

    #analyze
    assert expected == actual

def test_hand_score_facecards():
    #setup
    hand = [cards.make_card(12, "Spades"), cards.make_card(5, "Clubs")]
    expected = 15

    #invoke
    actual = blackjack.hand_score(hand)

    #analyze
    assert actual == expected
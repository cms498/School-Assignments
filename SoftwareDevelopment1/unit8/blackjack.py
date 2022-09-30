"""
Plays a modified version of blackjack in the console
Author: Chris Shepard
"""
import cards

def hand_score(hand):
    """
    Calculates the score associated with a given hand, aces are either 11 or 1 depending
    """
    score = 0
    hasAce = False
    for index in range(len(hand)):
        if hand[index][0] == 14:
            hasAce = True
        elif hand[index][0] == 11 or hand[index][0] == 12 or hand[index][0] == 13:
            score += 10
        else:
            score += hand[index][0]
        if hasAce == True:
            if score + 11 > 21:
                score += 1
            else:
                score += 11
        hasAce = False
    return score

def print_hand_score(name, hand):
    """
    Prints the name, hand, and hand score of a player
    """
    print(name)
    
    hand_string = ""
    for index in range(len(hand)):
        if hand[index][0] != 10:
            hand_string += hand[index][3]
        else:
            hand_string += " " + hand[index][3]
    print(hand_string)

    score = hand_score(hand)
    if score > 21:
        print("Score: " + str(score) + " (busted)")
    else:
        print("Score: " + str(score))

def win_lose_or_draw(player_score, dealer_score):
    """
    Prints a message to the console depending on who wins the game
    """
    if player_score > 21 and dealer_score > 21:
        print("Game ends in a draw")
    elif player_score == dealer_score:
        print("Game ends in a draw")
    elif player_score > 21 and dealer_score <=21:
        print("Dealer Wins")
    elif player_score <= 21 and dealer_score > 21:
        print("Player Wins")
    elif player_score > dealer_score:
        print("Player Wins")
    else:
        print("Dealer Wins")

def dealer_hit_or_stand(player_hand, dealer_hand):
    """
    Determines if the dealer will hit for another card or stay, returning true or false accordingly
    """
    if hand_score(dealer_hand) < 17 or hand_score(dealer_hand) < hand_score(player_hand):
        return True
    return False

def player_hit_or_stand():
    while True:
        choice = input("Enter H(h) to hit or S(s) to stand: ")
        if choice == "S" or choice == "s":
            return False
        elif choice == "H" or choice == "h":
            return True
        else:
            print("Invalid input try again: ")

def main():
    """
    Calls the other functions, used for organization purposes
    """
    #setup names
    player_name = input("Enter your name: ")
    dealer_name = "Dealer"
    print(player_name)
    print()

    #make shuffled deck
    deck = cards.make_deck()
    shuffled_deck = cards.shuffle(deck)
    
    #deal 2 card to player and deal from bottom half of the deck
    bottom_deck = cards.cut(shuffled_deck)[1]
    deal_card = cards.deal(bottom_deck, 2)
    player_hand = deal_card[0]
    dealer_hand = deal_card[1]

    #prints hands
    print_hand_score(player_name, player_hand)
    print()
    print_hand_score(dealer_name, dealer_hand)
    print()

    #prompt for hit or stand
    if player_hit_or_stand() == True:
        print("Player Hits")
        cards.draw(bottom_deck, player_hand)
        print_hand_score(player_name, player_hand)
        print()
    else:
        print("Player Stands")
     
    if dealer_hit_or_stand(player_hand, dealer_hand) == True:
        print()
        print("Dealer Hits")
        cards.draw(bottom_deck, dealer_hand)
        print_hand_score(dealer_name, dealer_hand)
        print()
    else:
        print()
        print("Dealer Stands")
        print()

    #calculate winner
    win_lose_or_draw(hand_score(player_hand), hand_score(dealer_hand))

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
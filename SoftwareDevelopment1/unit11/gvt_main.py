import gvt

def display_commands():
    print("H # = Display a cards details in players hand")
    print("B # = Display a cards details in players battalion")
    print("E # = Display a cards details in enemies battalion")
    print("P # = Play a card from your hand onto the battalion")
    print("Q = end turn and attack")
    print("I = Display commands")

def main():
    p1 = str(input("Player 1 please enter your name: "))
    p2 = str(input("Player 2 please enter your name: "))
    player1 = gvt.Player(p1, gvt.make_deck("Goat"))
    player2 = gvt.Player(p2, gvt.make_deck("Troll"))
    player1.create_hand()
    player2.create_hand()
    print(repr(player1))
    print(repr(player2))
    while True:
        while True:
            print(p1)
            player1.start_turn()
            choice = str(input(" >>> "))
            stripped = choice.strip().split()
            if stripped[0] == "I":
                display_commands()
            elif stripped[0] == "H":
                index = int(stripped[1])
                print(repr(player1.get_hand()[index]))
            elif stripped[0] == "B":
                index = int(stripped[1])
                print(repr(player1.get_battalion()[index]))
            elif stripped[0] == "E":
                index = int(stripped[1])
                print(repr(player2.get_battalion()[index]))
            elif stripped[0] == "P":
                try:
                    player1.play_cards(int(stripped[1]))
                    print(repr(player1))
                    print(repr(player2))
                except:
                    print("Invalid Card")
                    continue
            elif stripped[0] == "Q":
                player1.opposing_atack(player2)
                break
            else:
                print("Invalid Input")
        while True:
            print(p2)
            player2.start_turn()
            choice = str(input(" >>> "))
            stripped = choice.strip().split()
            if stripped[0] == "I":
                display_commands()
            elif stripped[0] == "H":
                index = int(stripped[1])
                print(repr(player2.get_hand()[index]))
            elif stripped[0] == "B":
                index = int(stripped[1])
                print(repr(player2.get_battalion()[index]))
            elif stripped[0] == "E":
                index = int(stripped[1])
                print(repr(player1.get_battalion()[index]))
            elif stripped[0] == "P":
                try:
                    player2.play_cards(int(stripped[1]))
                    print(repr(player1))
                    print(repr(player2))
                except:
                    print("Invalid Card")
                    continue
            elif stripped[0] == "Q":
                player2.opposing_atack(player1)
                break
            else:
                print("Invalid Input")
                
        if player1.is_defeated():
            print("Player 2 Wins")
            break
        elif player2.is_defeated():
            print("Player 1 Wins")
            break
        else:
            continue

if __name__ == "__main__":
    main()
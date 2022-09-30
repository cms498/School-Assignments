"""
This program uses various classes and special methods to simulate having a pokemon battle
Author: Chris Shepard
"""
import pokedex

def battle(party1, party2):
    """
    Simulates a pokemon battle until one of the parties has none left, prints winner at end
    """
    round_count = 1
    while len(party1) > 0 and len(party2) > 0:
        print("Round:", round_count)
        print("Party 1:", party1)
        print("Party 2:", party2)
        pokemon1 = party1.pop()
        pokemon2 = party2.pop()
        if pokemon1 == pokemon2:
            print(pokemon1, "and", pokemon2, "battle to draw")
            party1.add(pokemon1)
            party2.add(pokemon2)
        elif pokemon1 > pokemon2:
            print(pokemon1, "has won the round over", pokemon2)
            party1.add(pokemon1)
            pokemon2.lose_round(pokemon1.get_damage_points())
            if pokemon2.is_fainted() == True:
                print(pokemon2, "has fainted and is out of the battle")
            else:
                party2.add(pokemon2)
        else:
            print(pokemon2, "has won the round over", pokemon1)
            party2.add(pokemon2)
            pokemon1.lose_round(pokemon2.get_damage_points())
            if pokemon1.is_fainted() == True:
                print(pokemon1, "has fainted and is out of battle")
            else:
                party1.add(pokemon1)

        input("\nPress enter to move onto the next round: ")
        round_count += 1

    if len(party1) == 0:
        print("Winning Party", party2)
    else:
        print("Winning Party", party1)

def main():
    """
    Calls the other functions, organization purposes
    """
    dex = pokedex.Pokedex()
    dex.load("data/pokemon.csv")
    parties = dex.create_parties()
    battle(parties[0], parties[1])

if __name__ == "__main__":
    """
    Prevents main from being run from other programs, pytest purposes
    """
    main()
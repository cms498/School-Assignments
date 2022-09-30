"""
This program assembles a team of avengers, using various classes and data structures
Author: Chris Shepard
"""
class Superhero:
    """
    Outline for creating a superhero, has a name, id, powers, weapons, and leaderstatus
    """
    __slots__ = ["name", "identity", "powers", "weapons", "leader_status"]

    def __init__ (self, name, identity, leader_status = False):
        self.name = name
        self.identity = identity
        self.powers = []
        self.weapons = []
        self.leader_status = leader_status

class Avengers:
    """
    Outline for creating the avengers
    """
    __slots__ = ["superhero"]

    def __init__ (self):
        self.superhero = set()

def print_bio(superhero):
    """
    Prints the bio for one superhero
    """
    if superhero.leader_status == False:
        print(superhero.name, "(", superhero.identity, "):")
    else:
        print("[LEADER]", superhero.name, "(", superhero.identity, "):")
    print("Abilities")
    for power in superhero.powers:
        print("\t", power)
    print("Weapons")
    for weapon in superhero.weapons:
        print("\t", weapon)

def print_roster(avengers):
    """
    Prints a roster of avengers, without bios
    """
    print("Print Roster: ")
    for hero in avengers.superhero:
        if hero.leader_status == False:
            print("\t", hero.name)
        else:
            print("\t [LEADER]", hero.name)
    print()

def get_avenger(avengers, name):
    """
    Finds a specific member on the team
    """
    print("Found Avenger Bio: \n")
    for hero in avengers.superhero:
        if hero.name == name:
            print_bio(hero)
            print()
            return hero
    print("No Avenger Found \n")
    return None

def get_leader(avengers):
    """
    Finds and prints the leader of the avengers
    """
    print("Leader Bio: \n")
    for hero in avengers.superhero:
        if hero.leader_status == True:
            print_bio(hero)
            print()
            return hero
    print("No Leader")
    return None

def print_roster_bios(avengers):
    """
    Prints out the roster of avengers with bios, leader marked
    """
    print("Roster with Bios: \n")
    for hero in avengers.superhero:
        print_bio(hero)
        print()

def main():
    """
    Calls other functions, organization purposes
    """
    a_team = Avengers() #creates a_team object of avengers

    hero1 = Superhero("Ironman", "Tony Stark", True)
    hero1.powers.append("Technical Genius")
    hero1.weapons.append("Mark VII Armor Suit")
    a_team.superhero.add(hero1) #adds ironman to avengers set

    hero2 = Superhero("Thor", "Thor")
    hero2.powers.append("Extreme Super Strength")
    hero2.powers.append("Can control lightining")
    hero2.weapons.append("Mjolnir")
    a_team.superhero.add(hero2) #adds Thor to avengers set

    hero3 = Superhero("Captain America", "Steve Rodgers")
    hero3.powers.append("Super Strength")
    hero3.powers.append("Super relfexes")
    hero3.weapons.append("Vibranium Shield")
    a_team.superhero.add(hero3) #adds CA to avengers set

    hero4 = Superhero("Black Widow", "Natasha Romanoff")
    hero4.powers.append("Enhanced fighting techniques")
    hero4.powers.append("Super Reflexes")
    hero4.weapons.append("Electroshock Bracelets")
    a_team.superhero.add(hero4) #adds BW to avengers set

    get_avenger(a_team, "Thor") # finding a specific team member on the team, printing results
    get_leader(a_team) #finding the leader on the team, printing results
    print_roster(a_team) #prints the roster of avengers without bios
    print_roster_bios(a_team) #prints the roster of avengers with bios

    #print_bio functions used in others, prints out one avenger with name, id, powers, and weapons

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
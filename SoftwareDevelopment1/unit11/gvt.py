import goatils
import random

COMMON = 1
UNCOMMON = 2
RARE = 3
LEGENDARY = 4

RESET = "\u001b[0m"
WHITE = "\u001b[38;5;7m"
LIGHT_GREEN = "\u001b[38;5;10m"
BLUE = "\u001b[38;5;26m"
ORANGE = "\u001b[38;5;130m"
GREEN = "\u001b[38;5;28m"
RED = "\u001b[38;5;9m"
YELLOW = "\u001b[38;5;11m"

RARITY_STRINGS = {
    COMMON : WHITE + "C", 
    UNCOMMON : LIGHT_GREEN + "U", 
    RARE : BLUE + "R", 
    LEGENDARY : ORANGE + "L"}

TROLL_NAMES = ["Troll", "Trolling", "Trollzord", "Trollzard", "Spike", "Snarl", "Grim", "Greeny", "Tim", "Tom", "Terry", "TJ"]

class Card:
    __slots__ = ["__name", "__resource_cost", "__rarity", "__faction", "__attack_power", "__health"]

    def __init__(self, name, resource_cost, rarity, faction, attack_power, health):
        self.__name = name
        self.__resource_cost = resource_cost
        self.__rarity = rarity
        self.__faction = faction
        self.__attack_power = attack_power
        self.__health = health

    def __repr__(self):
        return self.__name + "\nRarity: " + RARITY_STRINGS[self.__rarity] + RESET + "\nFaction: " + self.__faction + "\nResource Cost: " + str(self.__resource_cost) + "\nAttack Power: " + \
                str(self.__attack_power) + "\nHealth Points: " + str(self.__health)

    def __str__(self):
        return "[" + self.__faction[0] + self.__name[0] + " " + "{:02d}".format(self.__resource_cost) + \
             " " + "{:02d}".format(self.__attack_power) + " " + "{:02d}".format(self.__health) + "]"

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__faction == other.__faction and self.__rarity == other.__rarity \
                and self.__attack_power == other.__attack_power and self.__resource_cost == other.__resource_cost
        else:
            return False

    def __lt__(self, other):
        if type(self) == type(other):
            if self.__resource_cost == other.__resource_cost:
                return self.__name < other.__name
            else:
                return self.__resource_cost < other.__resource_cost
        return False

    def get_name(self):
        return self.__name

    def get_resource_cost(self):
        return self.__resource_cost

    def get_rarity(self):
        return self.__rarity

    def get_faction(self):
        return self.__faction

    def get_attack_power(self):
        return self.__attack_power

    def get_health(self):
        return self.__health

    def damage(self, damage):
        if damage <= self.__health:
            self.__health -= damage
            return 0
        else:
            excess = damage - self.__health
            self.__health = 0
            return excess

    def is_conscious(self):
        return self.__health >= 1

class Player:
    """
    Blueprint for making a player and manipulating their cards
    """
    __slots__ = ["__name", "__score", "__resource_points", "__deck", "__hand", "__battalion", "__discard"]

    def __init__(self, name, deck):
        self.__name = name
        self.__score = 20
        self.__resource_points = 0
        self.__deck = deck
        self.__hand = []
        self.__battalion = []
        self.__discard = []

    def __repr__(self):
        string_hand = ""
        string_battalion = ""
        for card in self.__hand:
            string_hand += str(card)
        for card in self.__battalion:
            string_battalion += str(card)
        return "Player: " + self.__name \
            + "\nScore: " + str(self.__score) \
            + "\nResource Points: " + str(self.__resource_points) + "/" + str(self.__resource_points) \
            + "\nDeck: " + str(len(self.__deck)) \
            + "\nDiscarded: " + str(len(self.__discard)) \
            + "\nBattalion: " + string_battalion \
            + "\nHand: " + string_hand

    def __str__(self):
        return "Player: " + self.__name

    def get_hand(self):
        return self.__hand

    def get_battalion(self):
        return self.__battalion

    def create_hand(self):
        for _ in range(5):
            self.__hand.append(self.__deck.pop())

    def start_turn(self):
        self.__resource_points += 1
        if self.__resource_points > 10:
            self.__resource_points = 10
        self.__hand.append(self.__deck.pop())

    def play_cards(self, number):
        if self.__hand[number].get_resource_cost() < self.__resource_points:
            self.__resource_points -= self.__hand[number].get_resource_cost()
        else:
            print("Not enough resource points")
        self.__battalion.append(self.__hand.pop())

    def total_power(self):
        power = 0
        for card in self.__battalion:
            power += card.get_attack_power()
        return power

    def is_defeated(self):
        return self.__score <= 0

    def opposing_atack(self, player):
        total_left = player.total_power()
        for card in range(0, len(self.__battalion), -1):
            if len(self.__battalion) == 0:
                player.__score -= total_left
                if player.is_defeated():
                    print(player.__name, "has been defeated")
                    break
            card.damage(total_left)
            if card.is_conscious():
                continue
            else:
                self.__discard.append(self.__battalion.pop())

def make_deck(faction):
    """
    Makes a deck of cards and returns it
    """
    deck = []
    for card in range(20):
        if faction == "Goat":
            name = goatils.make_goat_name()
        else:
            name = TROLL_NAMES[random.randint(0, len(TROLL_NAMES) - 1)]
        health = random.randint(1, 8)
        attack = 8 - health
        cost = random.randint(1, 3)
        a_card = Card(name, cost, COMMON, faction, attack, health)
        deck.append(a_card)

    for card in range(10):
        if faction == "Goat":
            name = goatils.make_goat_name()
        else:
            name = TROLL_NAMES[random.randint(0, len(TROLL_NAMES) - 1)]
        health = random.randint(1, 12)
        attack = 12 - health
        cost = random.randint(2, 5)
        a_card = Card(name, cost, UNCOMMON, faction, attack, health)
        deck.append(a_card)

    for card in range(8):
        if faction == "Goat":
            name = goatils.make_goat_name()
        else:
            name = TROLL_NAMES[random.randint(0, len(TROLL_NAMES) - 1)]
        health = random.randint(1, 16)
        attack = 16 - health
        cost = random.randint(4, 7)
        a_card = Card(name, cost, RARE, faction, attack, health)
        deck.append(a_card)

    for card in range(2):
        if faction == "Goat":
            name = goatils.make_goat_name()
        else:
            name = TROLL_NAMES[random.randint(0, len(TROLL_NAMES) - 1)]
        health = random.randint(1, 24)
        attack = 24 - health
        cost = 10
        a_card = Card(name, cost, LEGENDARY, faction, attack, health)
        deck.append(a_card)

        random.shuffle(deck)
    return deck
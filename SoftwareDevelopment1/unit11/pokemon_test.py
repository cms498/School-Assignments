"""
Testing functions for pokemon_battle, pokedex, and pokemon
"""
import random
import pokemon
import pokedex
import pokemon_battle

def test_pokemon_get_damage_points():
    #setup
    a_pokemon = pokemon.Pokemon("test", "Grass", 18, 13)
    expected = 13
    #invoke
    actual = a_pokemon.get_damage_points()
    #analyze
    assert expected == actual

def test_pokemon_lose_round(): #visual test in main
    #setup
    pokemon1 = pokemon.Pokemon("test", "Grass", 18, 13)
    pokemon2 = pokemon.Pokemon("test", "Fire", 21, 7)
    expected = None
    #invoke
    actual = pokemon1.lose_round(pokemon2.get_damage_points())
    #analyze
    assert expected == actual

def test_pokemon_is_fainted():
    #setup
    pokemon1 = pokemon.Pokemon("test", "Water", 0, 11)
    expected = True
    #invoke
    actual = pokemon1.is_fainted()
    #analyze
    assert expected == actual

def test_pokemon_gt():
    #setup
    pokemon1 = pokemon.Pokemon("test", "Water", 20, 20)
    pokemon2 = pokemon.Pokemon("test", "Fire", 20, 20)
    expected = True
    #invoke
    actual = pokemon1 > pokemon2
    #analyze
    assert expected == actual

def test_pokemon_gt_false():
    #setup
    pokemon1 = pokemon.Pokemon("test", "Water", 20, 20)
    pokemon2 = pokemon.Pokemon("test", "Grass", 20, 20)
    expected = False
    #invoke
    actual = pokemon1 > pokemon2
    #analyze
    assert expected == actual

def test_pokemon_equal_type():
    #setup
    pokemon1 = pokemon.Pokemon("test", "Water", 20, 20)
    pokemon2 = pokemon.Pokemon("test", "Water", 20, 20)
    expected = True
    #invoke
    actual = pokemon1 == pokemon2
    #analyze
    assert expected == actual

def test_pokedex_create_parties():
    #setup
    random.seed(1)
    dex = pokedex.Pokedex()
    dex.load("data/pokemon.csv")
    expected = 6
    #invoke
    actual = dex.create_parties()
    #analyze
    assert expected == len(actual[0])
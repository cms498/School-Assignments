import practice12_1_ark

def test_ark_eq():
    #setup
    name1 = "AAA"
    sound1 = "BBB"
    color1 = "CCC"
    name2 = "AAA"
    sound2 = "BBB"
    color2 = "CCC"
    ark1 = practice12_1_ark.Animal(name1, sound1, color1)
    ark2 = practice12_1_ark.Animal(name2, sound2, color2)
    expected = True
    #invoke
    actual = ark1 == ark2
    #analyze
    assert expected == actual

def test_ark_not_eq():
    #setup
    name1 = "111"
    sound1 = "222"
    color1 = "333"
    name2 = "AAA"
    sound2 = "BBB"
    color2 = "CCC"
    ark1 = practice12_1_ark.Animal(name1, sound1, color1)
    ark2 = practice12_1_ark.Animal(name2, sound2, color2)
    expected = False
    #invoke
    actual = ark1 == ark2
    #analyze
    assert expected == actual
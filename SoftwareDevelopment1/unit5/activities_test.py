import activities

def test_exponent():
    #setup
    base = 2
    power = 3
    expected = 8

    #invoke
    actual = activities.exponent(base, power)

    #analyze
    assert expected == actual

def test_exponent_negative():
    #setup
    base = 2
    power = -1

    #invoke
    try:
        activities.exponent(base, power)
        assert False
    #analyze
    except ValueError:
        assert True
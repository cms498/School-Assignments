import review02

def test_is_power_true():
    #setup
    a = 27
    b = 3
    expected = True
    #invoke
    actual = review02.is_power(a, b)
    #analyze
    assert expected == actual

def test_is_power_false():
    #setup
    a = 28
    b = 3
    expected = False
    #invoke
    actual = review02.is_power(a, b)
    #analyze
    assert expected == actual

def test_is_power_base_case():
    #setup
    a = 1
    b = 3
    expected = True
    #invoke
    actual = review02.is_power(a, b)
    #analyze
    assert expected == actual

def test_is_power_exception():
    #setup
    a = -1
    b = 20
    #invoke
    try:
        review02.is_power(a, b)
        assert False
    #analyze
    except ValueError as ve:
        assert True
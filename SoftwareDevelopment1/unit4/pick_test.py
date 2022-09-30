import pick

def test_check_guess_correct():
    # setup
    guess = 5
    answer = 5
    expected = 0

    #invoke
    actual = pick.check_guess(answer, guess)

    #analyze
    assert expected == actual

def test_check_guess_too_high():
    #setup
    guess = 5
    answer = 4
    expected = 1

    #invoke
    actual = pick.check_guess(answer, guess)

    #analyze
    assert expected == actual
    
def test_check_guess_too_low():
    #setup
    guess = 4
    answer = 5
    expected = 1

    #invoke
    actual = pick.check_guess(answer, guess)

    #analyze
    assert expected == actual
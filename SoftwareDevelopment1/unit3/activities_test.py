def test_square_area_8():
    length = 8
    expected_area = 64
    actual_area = square_area(length)
    assert expected_area == actual_area

def test_square_area_6():
    length = 6
    expected_area = 36
    actual_area = square_area(length)
    assert expected_area == actual_area

def test_square_area_negative_1():
    length = -1
    expected_area = None
    actual_area = square_area(length)
    assert expected_area == actual_area

def test_square_area_negative_2():
    length = -2
    expected_area = None
    actual_area = square_area(length)
    assert expected_area == actual_area

def square_area(length):
    if length < 0:
        return None
    return length ** 2
"""
All testing functions for droids.py and droid_factory.py
"""
import droids, droid_factory, random, pytest, array_queue

def test_needs_part():
    #setup
    a_droid = droids.Droid("Astromech")
    part = "a_body"
    expected = True
    #invoke
    actual = a_droid.needs_part(part)
    #analyze
    assert expected == actual

def test_needs_part_wrong_type():
    #setup
    a_droid = droids.Droid("Astromech")
    part = "p_head"
    expected = False
    #invoke
    actual = a_droid.needs_part(part)
    #analyze
    assert expected == actual

def test_install_part():
    #setup
    a_droid = droids.Droid("Protocol")
    part = "p_head"
    expected = False
    #invoke
    a_droid.install_part(part)
    actual = a_droid.needs_part(part)
    #analyze
    assert expected == actual

def test_install_part_wrong_type():
    #setup
    a_droid = droids.Droid("Protocol")
    part = "a_body"
    with pytest.raises(ValueError) as v:
    #invoke
        a_droid.install_part(part)
    #analyze
    assert str(v.value) == "a_body not valid forProtocol"

def test_install_part_already_installed():
    #setup
    a_droid = droids.Droid("Protocol")
    part = "p_head"
    a_droid.install_part(part)
    with pytest.raises(ValueError) as v:
    #invoke
        a_droid.install_part(part)
    #analyze
    assert str(v.value) == "p_head already installed"

def test_is_complete_true():
    #setup
    a_droid = droids.Droid("Astromech")
    a_droid.install_part("a_dome")
    a_droid.install_part("a_body")
    a_droid.install_part("a_left_leg")
    a_droid.install_part("a_center_leg")
    a_droid.install_part("a_right_leg")
    expected = True
    #invoke
    actual = a_droid.is_complete()
    #analyze
    assert expected == actual

def test_is_complete_false():
    #setup
    a_droid = droids.Droid("Astromech")
    a_droid.install_part("a_dome")
    a_droid.install_part("a_body")
    expected = False
    #invoke
    actual = a_droid.is_complete()
    #analyze
    assert expected == actual

def test_print_droid_repr(): #visual test
    #setup
    a_droid = droids.Droid("Astromech")
    expected = None
    #invoke
    actual = None
    #analyze
    assert actual == expected

def test_print_droid_str(): #visual test
    #setup
    a_droid = droids.Droid("Astromech")
    expected = None
    #invoke
    actual = None
    #analyze
    assert actual == expected

def test_unload_shipment():
    #setup
    belt = array_queue.Queue()
    filename = "parts_0001_0001.txt"
    expected = str(['p_right_arm', 'p_head', 'a_body', 'a_dome', 'a_left_leg', 'p_left_arm', 'p_chassis', 'p_left_leg', 'a_right_leg', 'a_center_leg', 'p_right_leg'])
    #invoke
    actual = str(droid_factory.unload_shipment(filename, belt))
    #analyze
    assert expected == actual

def test_install_part_droid_factory():
    #setup
    droid = droids.Droid("Protocol")
    worker_belt = array_queue.Queue()
    worker_belt.enqueue("p_head")
    coworker_belt = array_queue.Queue()
    droid_factory.install_part(droid, worker_belt, coworker_belt)
    expected = False
    #invoke
    actual = droid.needs_part("p_head")
    #analyze
    assert expected == actual
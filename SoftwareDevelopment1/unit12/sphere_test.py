import practice12_1_sphere

def test_sphere_circumference():
    #setup
    radius = 8
    expected_circumference = 50.27
    a_sphere = practice12_1_sphere.Sphere(radius)
    #invoke
    actual = a_sphere.get_circumference()
    #analyze
    assert expected_circumference == actual

def test_sphere_surface_area():
    #setup
    radius = 8
    expected_area = 804.25
    a_sphere = practice12_1_sphere.Sphere(radius)
    #invoke
    actual = a_sphere.get_surface_area()
    #analyze
    assert expected_area == actual

def test_sphere_volume():
    #setup
    radius = 8
    expected_volume = 2144.66
    a_sphere = practice12_1_sphere.Sphere(radius)
    #invoke
    actual = a_sphere.get_volume()
    #analyze
    assert expected_volume == actual

def test_sphere_eq():
    #setup
    radius1 = 8
    radius2 = 8
    sphere1 = practice12_1_sphere.Sphere(radius1)
    sphere2 = practice12_1_sphere.Sphere(radius2)
    expected = True
    #invoke
    actual = sphere1 == sphere2
    #analyze
    assert expected == actual

def test_sphere_lt():
    #setup
    radius1 = 7
    radius2 = 8
    sphere1 = practice12_1_sphere.Sphere(radius1)
    sphere2 = practice12_1_sphere.Sphere(radius2)
    expected = True
    #invoke
    actual = sphere1 < sphere2
    #analyze
    assert expected == actual

def test_sphere_gt():
    #setup
    radius1 = 8
    radius2 = 7
    sphere1 = practice12_1_sphere.Sphere(radius1)
    sphere2 = practice12_1_sphere.Sphere(radius2)
    expected = True
    #invoke
    actual = sphere1 > sphere2
    #analyze
    assert expected == actual

def test_sphere_le():
    #setup
    radius1 = 8
    radius2 = 8
    sphere1 = practice12_1_sphere.Sphere(radius1)
    sphere2 = practice12_1_sphere.Sphere(radius2)
    expected = True
    #invoke
    actual = sphere1 <= sphere2
    #analyze
    assert expected == actual

def test_sphere_ge():
    #setup
    radius1 = 8
    radius2 = 8
    sphere1 = practice12_1_sphere.Sphere(radius1)
    sphere2 = practice12_1_sphere.Sphere(radius2)
    expected = True
    #invoke
    actual = sphere1 >= sphere2
    #analyze
    assert expected == actual
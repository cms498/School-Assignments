"""
This program simulates creating particles with xyz values, the forming of mega particles and weight calculations
Author: Chris Shepard
"""
import random

def fusion(a_list):
    """
    Converts "clusters" of numbers into key value pairs, returns a dictionary, value is the length of the cluster
    """
    sorted_list = sorted(a_list)
    copy_list = sorted_list[:]
    a_dict = dict()
    for index in range(len(sorted_list) - 1):
        if sorted_list[index + 1] == sorted_list[index] + 1:
            copy_list[index + 1] = copy_list[index]
    for value in copy_list:
        if value in a_dict:
            a_dict[value] += 1
        else:
            a_dict[value] = 1
    return a_dict

def create_particles(max_coordinate):
    """
    creates a returns a set of particles with xyz coordinates between 0 and max_coordinate
    """
    particle_set = set()
    n = max_coordinate ** 3
    for _ in range(n):
        x = random.randint(0, max_coordinate)
        y = random.randint(0, max_coordinate)
        z = random.randint(0, max_coordinate)
        particle_set.add((x, y, z))
    return particle_set

def build_dict_xy(particle_set):
    """
    Creates a dictionary of particles, where the matching xy are key and z is the value
    """
    particle_dict = dict()
    for tuple in particle_set:
        if tuple[:2] not in particle_dict:
            particle_dict[tuple[:2]] = [tuple[2]]
        else:
            particle_dict[tuple[:2]] += [tuple[2]]
    return particle_dict

def fusioned_particles(dictionary):
    """
    Creates mega particles at xyz coordinates and calculates there masses
    """
    mega_dict = dict()
    for key in dictionary:
        a_dict = fusion(dictionary[key])
        for index in a_dict:
            mega_dict[key[0], key[1], index] = a_dict[index]
    return mega_dict

def main():
    """
    tests other functions, organization purposes
    """
    random.seed(1)
    max_coordinate = 20
    particles = create_particles(max_coordinate)
    print("Total Number of Particles:", len(particles))
    a_dict = build_dict_xy(particles)
    fusioned_dict = fusioned_particles(a_dict)
    print("Mega Particles whose weight is larger then 10:")
    for key in fusioned_dict:
        if fusioned_dict[key] > 10:
            print(key, ":", fusioned_dict[key])

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()
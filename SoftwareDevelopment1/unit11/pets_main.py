import pets

def main():
    a_pet = pets.Pet("Husky", "Jonathan", 100, "Silver", 11)
    print(a_pet.get_name(), ", weight =", a_pet.get_weight())
    a_pet.feed(1800)
    print(a_pet.get_name(), ", weight =", a_pet.get_weight())
    a_pet.walk(1.5)
    print(a_pet.get_name(), ", weight =", a_pet.get_weight())

if __name__ == "__main__":
    main()
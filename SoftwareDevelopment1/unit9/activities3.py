import arrays

def find_maximum(dictionary):
    largest_value = None
    largest_key = None
    for key in dictionary:
        if largest_key == None:
            largest_key = key
            largest_value = dictionary[key]
        elif dictionary[key] >largest_value:
            largest_key = key
            largest_value = dictionary[key]
    return largest_key, largest_value

def hashes():
    print(hash("Hello World!"))
    print(hash("Hello world!"))
    print(hash("A"*100000))
    print(hash("A"*10000000000))

def collisions(filename, length, hash_func = hash):
    an_array = arrays.Array(length, None)
    with open(filename) as file:
        count = 0
        for line in file:
            line = line.strip()
            if line != "":
                hash_code = hash_func(line)
                index = hash_code % length
                if an_array[index] != None:
                    return count
                else:
                    an_array[index] = line
                    count += 1

def make_myset(length, hash_func = hash):
    table = [[] for _ in range(length)]
    return (hash_func, table)

def add(myset, element):
    if contains(myset, element):
        return
    func = myset[0]
    table = myset[1]
    index = func(element) % len(table)
    row = table[index]
    row.append(element)

def contains(myset, element):
    func = myset[0]
    table = myset[1]
    index = func(element) % len(table)
    row = table[index]
    for e in row:
        if e == element:
            return True
    return False

def ascii_codes(a_string):
    for index in a_string:
        print(index, ":", ord(index))

def string_hash(a_string):
    largest_value = 0
    for index in a_string:
        if ord(index) > largest_value:
            largest_value = ord(index)
    return largest_value

def string_hash2(a_string):
    largest_value = 0
    for index in a_string:
        if ord(index) > largest_value:
            largest_value = ord(index)
    return largest_value * len(a_string)

def main():
    # a_dict = {"a":1, "b":99,"c":-1,"d":62,"e":5,}
    # print(find_maximum(a_dict))

    # hashes()

    # my_set = make_myset(7)
    # add(my_set, "one")
    # add(my_set,"two")
    # add(my_set,"three")
    # add(my_set,"two")
    # print(my_set)
    # print(contains(my_set, "one"))
    # print(contains(my_set, "four"))

    # ascii_codes("hello")

    print(string_hash("zoo"))
    print(string_hash("pizza"))
    print(collisions("data/words.txt", 10000, string_hash))
    print(collisions("data/words.txt", 10000, string_hash2))

if __name__ == "__main__":
    main()
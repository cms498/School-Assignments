def packer():
    return 4, 3.14, False, "Blue"

def swapper(a_list):
    half1 = []
    half2 = []
    for index in range(0, len(a_list) // 2):
        half1.append(a_list[index])
    for index in range(len(a_list) // 2, len(a_list)):
        half2.append(a_list[index])
    return half2 + half1

def chunky(a_list, size):
    start = 0
    stop = size
    chunk = a_list[start:stop]
    while len(chunk) > 0:
        print(chunk)
        start = stop
        stop = start + size
        chunk = a_list[start:stop]

def sevens_key(number):
    if str(number)[0] == "7":
        return 0
    return 100

def lucky_7s(a_list):
    print(a_list)
    a_list.sort(key = sevens_key)
    print(a_list)

def comprehension():
    print([char for char in "foobar"])
    print([0 for _ in range(15)])
    print([x for x in range(13)])
    print([x for x in range(21) if x % 2 == 0])
    print([x for x in range(50) if x % 3 == 0 or x % 5 == 0])

def make_table(rows, columns, value):
    table = [[value for _ in range(columns)] for _ in range(rows)]
    
    for _ in range(rows):
        print(table[_])

    return table

def main():
    # packed = packer()
    # print(packed)
    # print(packed[0])
    # print(packed[1])
    # print(packed[2])
    # print(packed[3])

    # print(swapper([]))
    # print(swapper([1]))
    # print(swapper(["a", "b", "c"]))
    # print(swapper([0, 1, 2, 3, 4, 5, 6, 7, 8, 9]))

    # chunky(list(range(10)), 3)

    # lucky_7s(list(range(0, 100, 7)))

    # comprehension()

    make_table(3, 4, 0)

if __name__ == "__main__":
    main()
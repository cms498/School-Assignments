import re

def names():
    a_dict = dict()
    a_dict["C"] = "Chris"
    a_dict["M"] = "Martin"
    a_dict["S"] = "Shepard"

    a_dict["A"] = "Aimee"
    a_dict["S"] = "Shepard"

    a_dict["D"] = "John"
    a_dict["S"] = "Shepard"

    a_dict["M"] = "Heather"
    a_dict["S"] = "Shepard"
    print(a_dict)
    print(a_dict["C"])
    print(a_dict["M"])
    print(a_dict["S"])
    print(a_dict["D"])
    print(a_dict["A"])

    for key in a_dict:
        name = a_dict[key]
        print(key, ":", name)

def count_words(filename):
    a_dict = dict()
    with open(filename) as file:
        for line in file:
            words = re.findall("[\w]+", line.strip().lower())
            for word in words:
                if word in a_dict:
                    a_dict[word] += 1
                else:
                    a_dict[word] = 1
    return a_dict

def main():
    #names()
    word_counts = count_words("data/alice.txt")
    freq = []
    for word in word_counts:
        freq += [(word_counts[word], word)]

    freq.sort(reverse = True)
    print(freq[:20])

if __name__ == "__main__":
    main()
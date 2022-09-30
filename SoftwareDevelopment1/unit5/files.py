import plotter

def print_lines(file_name):
    my_file = open(file_name)

    for line in my_file:
        print(line.strip())

def words_search(file_name):
    #prompt user for word
    original_word = input("Enter a word: ")
    lc_word = original_word.strip().lower()

    #open the file
    my_file = open(file_name)

    #for eachline
        #compare line to word, if equal
            #print match found
    for original_line in my_file:
        lc_line = original_line.strip().lower()
        if lc_word == lc_line:
            print("Found the word:", original_word)
            my_file.close()
            return None
        
    #print not found
    print("Did not find word")
    my_file.close()
    
def longest_word(a_line):
    #split line by spaces
    words = a_line.strip().split()
    #initialize longest word to empty string
    long_word = ""
    #for each word
    for word in words:
        #get length
            #if current word > longest word
        if len(word) > len(long_word):
                #current word equal to longest word
                long_word = word
    #print longest
    print("Longest word:", long_word)

def longest_words(file_name):
    my_file = open(file_name)
    for line in my_file:
        longest_word(line.strip())
    
    my_file.close()

def print_names(file_name):
    csv_file = open(file_name)
    next(csv_file)
    for record in csv_file:
        fields = record.split(",")
        print(fields[1], fields[0])

    csv_file.close()

def class_average(file_name, column):
    with open(file_name) as csv_file:
        next(csv_file)
        sum = 0
        count = 0
        for record in csv_file:
            fields = record.split(",")
            sum += float(fields[column])
            count += 1

    print("Class average: ", sum / count)

def plot_grades(file_name, column):
    with open(file_name) as csv_file:
        header = next(csv_file)
        h_fields = header.split(",")
        plotter.init(h_fields[column], "Students", "Grades")
        for record in csv_file:
            fields = record.split(",")
            plotter.add_data_point(float(fields[column]))

    plotter.plot()
    input("Press enter to continue: ")
            

def main():
    #print_lines("data/alice.txt")
    #words_search("data/words.txt")
    #longest_word("The quick brown fox")
    #longest_words("data/alice.txt")
    #print_names("data/grades_010.csv")
    #class_average("data/grades_010.csv", 2)
    plot_grades("data/grades_010.csv", 2)

if __name__ == "__main__":
    main()
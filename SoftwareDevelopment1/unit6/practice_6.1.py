import csv

def find_alice ():
    """
    Function that returns the number of times the word
    "Alice" appears in the story, 'Alice and Wonderland'.

    See Assignment 6.1 for requirement details.
    """
    with open("data/alice.txt") as file:
        count = 0
        for line in file:
            split_file = line.split()
            index = 0
            while index < len(split_file):
                if split_file[index] == "Alice":
                    count += 1
                index += 1
    return count

def calculate_average (record, start_col, count):
    """
    Function to calculate the average of count fields
    in a record, starting at start_col.

    Update to handle issues that might occur. Refer to 
    Assignment 6.1 for more details.
    """
    sum = 0
    for index in range (start_col, start_col + count):
        try:
            sum += int (record [index])
        except ValueError:
            try:
                sum += round(float(record[index]))
            except:
                sum += 0
    try:
        average = sum / count
    except ZeroDivisionError:
        return 0

    return average



def deans_list (filename, min_grade):
    """
    Function that prints the names of all students
    that are above the specified minimum grade average
    for all of their assignment.

    See Assignment 6.1 for requirement details.
    """
    with open(filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        start_column = 3
        for line in csv_reader:
            if calculate_average(line, start_column, len(line) - start_column) > min_grade:
                print(line[0])


def main ():
    # Simple find_alice test
    print ("Found Alice", find_alice (), "times.")

    # Sample records that can be used to test calculate_avearge
    clean_record = 'Student,80,68,75,81,85,93'.split (',')
    dirty_record = 'Student,80,97.8,75,,85.4,a'.split (',')

    # calculate_average tests
    print (calculate_average (clean_record, 1, 6)) # 80.3333333333
    print (calculate_average (dirty_record, 1, 6)) # 56.3333333333

    # Test for deans_list
    deans_list ("data/full_grades_999.csv", 89)

if __name__ == "__main__":
    main ()
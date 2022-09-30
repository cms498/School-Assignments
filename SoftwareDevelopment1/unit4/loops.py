from pixart import draw_pixel


def countdown(number):
    count = 0
    while number >= 0:
        print(number)
        count += number
        number -= 1
    return count

def countup(number):
    count = 0
    start = 0
    while start <= number:
        print(start)
        count += start
        start += 1
    return count

def quotes():
    print("She said \"I dont like broccolor.\"")
    print("A\tB\tC\tD\tE")
    print("This/is\\a/test.\\")

def string_countdown(a_string):
    i = 0
    while i < len(a_string):
        print(a_string[i])
        i += 1

def string_countup(a_string):
    i = len(a_string) - 1
    while i >= 0:
        print(a_string[i])
        i -= 1

def sum_odd_numbers():
    sum = 0

    while True:
        number = int(input("Enter a number: "))
        if number == 0:
            break

        if number % 2 == 0:
            continue
        
        sum += number

    print("Sum:", sum)

def print_range(a_range):
    index = 0
    while index < len(a_range):
        print(a_range[index], end =" ")
        index += 1
    print()

def print_range_for(a_range):
    for each_num in a_range:
        print(each_num, end= " ")
    print()

def reverse_string(a_string):
    reverse_string = ""
    for letter in a_string:
        reverse_string = letter + reverse_string
    return reverse_string

def split_string(a_string, delim):
    tokens = a_string.split(delim)
    for token in tokens:
        print(token)


def main():
   # print(countdown(5))
   # print(countup(5))
   # quotes()
   # string_countdown("Yoda")
   # string_countup("Yoda")
   #sum_odd_numbers()
   #print_range(range(11))

   print(reverse_string(""))
   print(reverse_string("a"))
   print(reverse_string("Hello, World"))
   print(reverse_string("Chris"))
   split_string("Hello|World!", "|")

main()
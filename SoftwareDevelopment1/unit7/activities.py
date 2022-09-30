def evens(n):
    sum = 0
    while n > 0:
        if n % 2 == 0:
            sum += n
        n -= 1
    return sum

def runner(function, num):
    print(function.__name__)
    print(function(num))

def main():
    runner(evens, 10)

if __name__ == "__main__":
    main()
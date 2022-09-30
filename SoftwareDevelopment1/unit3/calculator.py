PI = 3.14159

def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    return a / b

def circumference(r):
    return 2 * PI * r

def area(r):
    return PI * (r ** 2)

def main():
    a = int(input("Enter your first number: "))
    b = int(input("Enter your second number: "))
    print(add(a, b))
    print(subtract(a, b))
    print(multiply(a, b))
    print(divide(a, b))
    print(circumference(a))
    print(area(a))

main()

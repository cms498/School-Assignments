class Student:
    __slots__ = ["id", "name", "credits", "gpa"]

    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.credits = 0
        self.gpa = 0

def print_student(student):
    print("Student:", student.id, ",", student.name, ",",student.credits,",", student.gpa)

def add_student(population, name, id):
    student = Student(id, name)
    population.append(student)

def get_student(population, id):
    for student in population:
        if student.id == id:
            return student
    return None

def print_population(population):
    for student in population:
        print_student(student)

def add_credits(populaton, id, credits):
    student = get_student(populaton, id)
    if student != None:
        student.credits += credits

def main():
    # student1 = Student("A123", "Joe")
    # student1.credits = 24
    # student1.gpa = 3.4
    # print_student(student1)

    # student2 = Student("No ID", "Student")
    # print_student(student2)

    population = []
    add_student(population, "Chris" ,"100")
    add_student(population, "Anne" ,"101")
    add_student(population, "Alice" ,"102")
    add_student(population, "Bob" ,"103")
    print_population(population)

    print()
    student = get_student(population, "100")
    if student != None:
        print_student(student)

    print()
    add_credits(population, "100", 10)
    print_population(population)

if __name__ == "__main__":
    main()
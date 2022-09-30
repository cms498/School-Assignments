ID = 0
NAME = 1
CREDITS = 2
GPA = 3

def make_student(id, name):
    return [id, name, 0, 0.0]

def add_student(population, id, name):
    population[id] = make_student(id, name)

def get_student(population, id):
    if id in population:
        return population[id]
    return None
    
def add_credits(population, id, credits):
    student = get_student(population, id)
    if student != None:
        student[CREDITS] += credits

def get_credits(population, id):
    student = get_student(population, id)
    if student != None:
        return student[CREDITS]
    return None

def main():
    population = dict()
    add_student(population, "A1", "Bob")
    add_student(population, "A2", "Sally")
    add_student(population, "A3", "Jill")
    add_student(population, "A4", "Fred")

    print(population)

    print(get_student(population, "A2"))
    print(get_student(population, "A99"))

    add_credits(population, "A3", 4)
    print(get_credits(population, "A3"))

    print(population)

if __name__ == "__main__":
    main()
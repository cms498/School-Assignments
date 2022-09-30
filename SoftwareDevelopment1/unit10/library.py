import csv

class Book:
    __slots__ = ["title", "author", "copies"]

    def __init__(self, title, author, copies = 1):
        self.title = title
        self.author = author
        self.copies = copies

class Patron:
    __slots__ = ["id", "name", "want_list", "has"]

    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.want_list = []
        self.has = []

class CardCatalog:
    __slots__ = ["author", "title"]

    def __init__(self):
        self.author = dict()
        self.title = dict()

TITLE = 0
AUTHOR = 1
COPIES = 2

class Library:
    __slots__ = ["shelves", "catalog", "patrons"]

    def __init__(self, filename):
        self.patrons = []
        self.shelves = []
        self.catalog = CardCatalog()

        with open(filename) as file:
            csv_reader = csv.reader(file)
            next(csv_reader)
            for record in csv_reader:
                book = Book(record[TITLE], record[AUTHOR], int(record[COPIES]))
                self.shelves.append(book)
                if book.title in self.catalog.title:
                    self.catalog.title[book.title].append(book)
                else:
                    self.catalog.title[book.title] = [book]

                if book.author in self.catalog.author:
                    self.catalog.author[book.author].append(book)
                else:
                    self.catalog.author[book.author] = [book]

LIBRARY = Library("data/books.csv")

def find_book(book_dict, key):
    if key in book_dict:
        return list(book_dict[key])
    return[]

def find_book_by_author(author):
    return find_book(LIBRARY.catalog.author, author)

def find_book_by_title(title):
    return find_book(LIBRARY.catalog.title, title)

def checkout(patron, book):
    if book.copies > 0 and len(patron.has) < 3:
        book.copies -= 1
        patron.has.append(book)
    else:
        patron.want_list.append(book)

def main():
    book = Book("American Pastoral", "Philip Roth" , 5)
    patron = Patron("A123", "Chris")
    print(find_book_by_author("Philip Roth"))
    print(find_book_by_title("American Pastoral"))

if __name__ == "__main__":
    main()
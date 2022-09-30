import datetime
import unittest
from src.library import *

class TestLibrary(unittest.TestCase):

    """Rebuilds the data tables after each test"""
    def setUp(self):
        build_tables()

    """Build the user table with data"""
    def test_build_user_tables(self):
        table = select_users_table()
        self.assertEqual([(1, 'Ada Lovelace', 'alovelace@gmail.com', '123-456-7890', True),
                            (2, 'Mary Shelley', 'mshelley@gmail.com', '111-222-3333', True),
                            (3, 'Jackie Gleason', 'jgleason@gmail.com', '222-333-4444', True),
                            (4, 'Art Garfunkel', 'agarfunkel@gmail.com', '333-444-5555', True)], table)

    """Count the number of rows in the books table"""
    def test_books_row_count(self):
        row_count = count_books_rows()
        self.assertEqual(25, row_count)

    """Count the number of rows in the user table"""
    def test_users_row_count(self):
        row_count = count_users_table_rows()
        self.assertEqual(4, row_count)

    """Count the number of rows in the checked out table"""
    def test_checked_out_row_count(self):
        row_count = count_checked_out_rows()
        self.assertEqual(8, row_count)

    """Lists arts checked out books"""
    def test_list_arts_books(self):
        books_list = list_users_checked_out_books('Art Garfunkel')
        self.assertEqual([], books_list)

    """Lists jackies checked out books"""
    def test_list_jackies_books(self):
        books_list = list_users_checked_out_books('Jackie Gleason')
        self.assertEqual(['Alexander Hamilton', 'Joan', 'Unbroken'], books_list)

    """lists all of the checked out books ordered by author"""
    def test_list_checked_out_books(self):
        result = list_all_checked_out_books()
        self.assertEqual([('Ada Lovelace', datetime.date(2022, 9, 11), datetime.date(2022, 9, 12), 4), ('Mary Shelley', datetime.date(2022, 9, 8), None, 2), ('Ada Lovelace', datetime.date(2022, 9, 9), datetime.date(2022, 9, 11), 2),
                            ('Mary Shelley', datetime.date(2022, 9, 7), datetime.date(2022, 9, 13), 4), ('Jackie Gleason', datetime.date(2022, 9, 6), None, 2), ('Ada Lovelace', datetime.date(2022, 9, 10), None, 2),
                            ('Jackie Gleason', datetime.date(2022, 9, 5), None, 2), ('Jackie Gleason', datetime.date(2022, 9, 4), None, 4)], result)

    """lists all nonfiction books and how many copies their are"""
    def test_list_nonfiction_books(self):
        result = list_all_books_by_type('non-fiction')
        self.assertEqual([('An Immense World', 4), ('Alexander Hamilton', 5), ('Unbroken', 3), ("Cosmos", 6),
                            ("A Brief History of Time", 1), ("In Cold Blood", 1), 
                            ("The Sixth Extinction: An Unnatural History", 3), ("On the Clock: What Low-Wage Work Did to Me and How It Drives America Insane", 4), 
                            ("The Nutmeg's Curse: Parables for a Planet in Crisis", 4), ("A Planet to Win: Why We Need a Green New Deal", 4)], result)

    """lists all of the fiction books and how many copies their are"""
    def test_list_fiction_books(self):
        result = list_all_books_by_type('fiction')
        self.assertEqual([('1984', 3), ('Joan', 3), ('Lord of the Rings', 4), ('Nicholas Nickleby', 2), ('Oliver Twist', 3),
                            ('2001: A Space Odyssey', 5), ('Do Androids Dream of Electric Sheep', 2), ('I, Robot', 4),
                            ('A Hitchhikers Guide to the Galaxy', 42), ('Roots: The Saga of an American Family', 4), ('A Study In Scarlet', 7),
                            ('Nightfall and other stories', 3), ('Foundation', 3), ('The Invisible Man', 4), ('The Invisible Man', 2)], result)

    """lists all of marys books"""
    def test_list_marys_books(self):
        books_list = list_users_checked_out_books('Mary Shelley')
        self.assertEqual(['1984', 'Lord of the Rings'], books_list)

    """lists all of ads books"""
    def test_list_adas_books(self):
        books_list = list_users_checked_out_books('Ada Lovelace')
        self.assertEqual(['1984', 'An Immense World', 'Unbroken'], books_list)

    """Attempt to reserve a book but copies still are avaliable"""
    def test_jackie_reserve_fail(self):
        result = reserve_book("Joan", "Jackie Gleason")
        self.assertEqual(None, result)

    """Reserve a book successfully where no more copies are avaliable"""
    def test_jackie_reserve_success(self):
        check_out_book("Unbroken", "Person1", "0006-06-06")
        check_out_book("Unbroken", "Person2", "4567-12-30")
        result = reserve_book("Unbroken", "Jackie Gleason")
        self.assertEqual((1, 5, "Jackie Gleason", "RESERVED"), result)

    """Create a new user called Christopher Marlowe"""
    def test_create_marlowe(self):
        users = create_new_user('Christopher Marlowe', 'cmarlowe@gmail.com', '999-999-9999')
        self.assertEqual((5, 'Christopher Marlowe', 'cmarlowe@gmail.com', '999-999-9999', True), users)

    """Create a new user called Francis Bacon"""
    def test_create_bacon(self):
        users = create_new_user('Francis Bacon', 'fbacon@gmail.com', '888-888-8888')
        self.assertEqual((5, 'Francis Bacon', 'fbacon@gmail.com', '888-888-8888', True), users)

    """Return a book to the library three days later"""
    def test_return_book(self):
        add_book_to_library("Frankenstein", "fiction", "1818-01-01", "Mary Shelley", 2, "Green Guy??", 2)
        check_out_book("Frankenstein", "Art Garfunkel", "2002-02-02")
        result = return_book("Frankenstein", "Art Garfunkel", "2002-02-05")
        self.assertEqual((None), result)

    """Search for a book in the database, don't find it, then delete account"""
    def test_search_and_delete(self):
        result = search_for_book("The Last Man")
        if result == None:
            deleted = delete_user("mshelley@gmail.com")
            self.assertEqual(None, deleted)
        return False

    """Insert three copies of The winds of winter into the fairport library"""
    def test_insert_winds_of_winter(self):
        add_book_to_library("The Winds of Winter", "fiction", "2023-11-23", "George R.R. Martin", 3, "A long wait", 2)
        result = list_checked_out_books_count_by_library("Fairport")
        self.assertEqual([(2, 'An Immense World', 4, 'Fairport'), (6, 'Lord of the Rings', 4, 'Fairport'),
                            (8, 'Oliver Twist', 3, 'Fairport'), (12, 'A Hitchhikers Guide to the Galaxy', 42, 'Fairport'),
                            (16, 'In Cold Blood', 1, 'Fairport'),  (20, 'Nightfall and other stories', 3, 'Fairport'),
                            (24, "The Nutmeg's Curse: Parables for a Planet in Crisis", 4, 'Fairport'), (26, 'The Winds of Winter', 3, 'Fairport')], result)

    """Insert 2 copies into both Henrietta and pittsford"""
    def test_insert_wines_of_winter(self):
        add_book_to_library('The Wines of Winter', "non-fiction", "2025-12-25", "Wine Express", 2, "Fun", 3)
        add_book_to_library('The Wines of Winter', "non-fiction", "2025-12-25", "Wine Express", 2, "Fun", 4)
        henrietta_result = list_checked_out_books_count_by_library("Henrietta")
        pittsford_result = list_checked_out_books_count_by_library("Pittsford")
        self.assertEqual([(3, 'Joan', 3, 'Henrietta'), (9, '2001: A Space Odyssey', 5, 'Henrietta'), (13, 'Roots: The Saga of an American Family', 4, 'Henrietta'),
                            (17, 'The Sixth Extinction: An Unnatural History', 3, 'Henrietta'), (21, 'Foundation', 3, 'Henrietta'),
                            (25, 'A Planet to Win: Why We Need a Green New Deal', 4, 'Henrietta'), (26, 'The Wines of Winter', 2, 'Henrietta')], henrietta_result)
        self.assertEqual([(4, 'Alexander Hamilton', 5, 'Pittsford'), (10, 'Do Androids Dream of Electric Sheep', 2, 'Pittsford'),(14, 'Cosmos', 6, 'Pittsford'),
                        (18, 'On the Clock: What Low-Wage Work Did to Me and How It Drives America Insane', 4, 'Pittsford'),
                            (22, 'The Invisible Man', 4, 'Pittsford'), (27, 'The Wines of Winter', 2, 'Pittsford')], pittsford_result)

    """list all books avaliable to be checked out by so copies left > 0"""
    def test_list_avaliable_books(self):
        check_out_book('A Brief History of Time', 'name', '1999-12-25')
        penfield_result = list_all_avaliable_books_by_library("Penfield")
        self.assertEqual([('1984', 'Penfield'), ('Unbroken', 'Penfield'), ('Nicholas Nickleby', 'Penfield'), 
                            ('I, Robot', 'Penfield'), ('A Study In Scarlet', 'Penfield'), 
                            ('The Invisible Man', 'Penfield')], penfield_result)
    
    """list all books in all libraries"""
    def test_list_all_books_order_by_library_and_title(self):
        result = list_all_books_in_all_libraries()
        self.assertEqual([('A Hitchhikers Guide to the Galaxy', 42, 'Fairport'), ('An Immense World', 4, 'Fairport')
                        ,('In Cold Blood', 1, 'Fairport'), ('Lord of the Rings', 4, 'Fairport'), 
                        ('Nightfall and other stories', 3, 'Fairport'), ('Oliver Twist', 3, 'Fairport')
                        ,("The Nutmeg's Curse: Parables for a Planet in Crisis", 4, 'Fairport'), ('2001: A Space Odyssey', 5, 'Henrietta')
                        , ('A Planet to Win: Why We Need a Green New Deal', 4, 'Henrietta'), ('Foundation', 3, 'Henrietta')
                        , ('Joan', 3, 'Henrietta'), ('Roots: The Saga of an American Family', 4, 'Henrietta')
                        ,('The Sixth Extinction: An Unnatural History', 3, 'Henrietta'), ('1984', 3, 'Penfield')
                        ,('A Brief History of Time', 1, 'Penfield'), ('A Study In Scarlet', 7, 'Penfield')
                        , ('I, Robot', 4, 'Penfield'), ('Nicholas Nickleby', 2, 'Penfield'), ('The Invisible Man', 2, 'Penfield')
                        , ('Unbroken', 3, 'Penfield'), ('Alexander Hamilton', 5, 'Pittsford'), ('Cosmos', 6, 'Pittsford')
                        , ('Do Androids Dream of Electric Sheep', 2, 'Pittsford'), ('On the Clock: What Low-Wage Work Did to Me and How It Drives America Insane', 4, 'Pittsford')
                        , ('The Invisible Man', 4, 'Pittsford')], result)

    """check out book, deactivate account, list overdue account, scenerio in docs"""
    def test_check_out_scenerio(self):
        add_book_to_library('The Winds of Winter', 'Fiction', '1212-12-12', 'George R R Martin', 1, 'Long Wait', 2)
        check_out_book('The Winds of Winter', 'Mary Shelley', '2022-01-02')
        return_book('The Winds of Winter', 'Mary Shelley', '2022-01-10')
        shelley_books = get_checkout_history('Mary Shelley')[2]
        self.assertEqual(('Fairport', 'The Winds of Winter', 'Mary Shelley', datetime.date(2022, 1, 2), datetime.date(2022, 1, 10), datetime.date(2022, 1, 16), 1), shelley_books)
        check_out_book('The Winds of Winter', 'Ada Lovelace', '2022-01-13')
        ada_deactivated = check_out_book('Lord of the Rings', 'Ada Lovelace', '2022-01-28')
        self.assertEqual("Account deactivated, no more books may be checked out", ada_deactivated)
        return_book('The Winds of Winter', 'Ada Lovelace', '2022-01-31')
        check_out_book('The Winds of Winter', 'Jackie Gleason', '2022-03-01')
        jackie_deactivated = return_book('The Winds of Winter', 'Jackie Gleason', '2022-03-31')
        self.assertEqual("You returned your book 16 late. You have a late fee of $19.75", jackie_deactivated)
        all_overdue_books_list = list_overdue_books()
        self.assertEqual([('The Winds of Winter', 'Ada Lovelace', datetime.date(2022, 1, 13), datetime.date(2022, 1, 31), datetime.date(2022, 1, 27)),
        ('The Winds of Winter', 'Jackie Gleason', datetime.date(2022, 3, 1), datetime.date(2022, 3, 31), datetime.date(2022, 3, 15))], all_overdue_books_list)

    """tests if the fees for late books is correct"""
    def test_print_fees(self):
        message = return_book('Alexander Hamilton', 'Jackie Gleason', '2022-09-27')
        self.assertEqual('You returned your book 9 late. You have a late fee of $5.75', message)
        message2 = return_book('Unbroken', 'Jackie Gleason', '2022-09-11')
        self.assertEqual(None, message2)

    """prints a list of all checked out books including late fees"""
    def test_print_checked_out(self):
        print("\n{:<35} |{:<20} |{:<15} |{:<15} |{:<3}".format('book', 'name', 'check_out_date', 'returned_date', 'late_fees'))
        table = return_formatted_checkout_table()
        for line in table:
            print("{:<35} |{:<20} |{:<15} |{:<15} |{:<3}".format(line[0][0], line[1], str(line[2]), str(line[3]), str(line[4])))

    """prints a list of all checked out books with the number of days borrowed and avg"""
    def test_print_borrowed(self):
        table = list_days_borrowed_with_avg()
        print("\n{:<20} {:<20} {:<15} {:<15} {:<3}".format('Title', 'User', 'Checkout', 'Return', 'Days Borrowed'))
        for line in table:
            print("{:<20} {:<20} {:<15} {:<15} {:<3}".format(line[0], line[1], str(line[2]), str(line[3]), str(line[4])))
        print("\n\nAverage return time = " + str(calculate_average_days_borrowed())[11:-5] + "\n")
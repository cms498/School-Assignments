from src.swen344_db_utils import *
import csv
import os

def build_tables():
    """
    Build all of the tables and populate them with data from Library.csv and library_data.sql

    Keyword Arguments:
    None

    Access Controls:
    Should only be used by the admin

    Returned:
    Nothing
    """
    exec_sql_file("library_data.sql")
    full_path = os.path.join(os.path.dirname(__file__), f'{"Library.csv"}')
    with open(full_path) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        library_id = 1
        for line in csv_reader:
            if library_id > 4: #only 4 libraries in the system, each book will distributed to 1 out of the 4 libraries
                library_id = 1 #if we give a book to the last library in the system, start back at the begining
            title = line[0]
            author = line[1]
            summary = line[2]
            type = line[3].lower()
            copies = int(line[5])
            exec_commit("INSERT INTO books (title, book_type, publish_date, author, copies, summary, library_id) VALUES(%s, %s, %s, %s, %s, %s, %s);", (title, type, "01-02-0003", author, copies, summary, library_id))
            library_id += 1

def select_users_table():
    """
    Select the users table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    psycopg2 list of tuples of all rows and columns from the user table
    """
    return exec_get_all('SELECT * FROM users')

def select_books_table():
    """
    Select the books table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    psycopg2 list of tuples of all rows and columns from the book table
    """
    return exec_get_all('SELECT * FROM books')

def select_checked_out_table():
    """
    Select the checked_out table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    psycopg2 list of tuples of all rows and columns from the checked_out table
    """
    return exec_get_all('SELECT * FROM checked_out')

def count_users_table_rows():
    """
    Counts the number of rows in the users table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    integer of the number of rows
    """
    result = exec_get_one('SELECT COUNT(id) FROM users')
    return int(str(result)[1:-2])

def count_checked_out_rows():
    """
    Counts the number of rows in the checked_out table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    integer of the number of rows
    """
    result = exec_get_one('SELECT COUNT(id) FROM checked_out')
    return int(str(result)[1:-2])

def count_books_rows():
    """
    Counts the number of rows in the books table

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    integer of the number of rows
    """
    result = exec_get_one('SELECT COUNT(id) FROM books')
    return int(str(result)[1:-2])

def list_users_checked_out_books(username):
    """
    Lists a users checked out books is alphabetical order

    Keyword Arguments:
    username -- the name of the user you would like find their books

    Access Controls:
    Should only be used by the librarian

    Returned:
    A list of the users books, an empty list if no books checked out
    """
    result = exec_get_all('SELECT title FROM books INNER JOIN checked_out on books.id = checked_out.books_id WHERE checked_out.checked_out_by = %s ORDER BY books.title ASC', (username,))
    books = []
    for item in result:
        books.append(str(item)[2:-3])
    return books

def list_all_checked_out_books():
    """
    Lists all checked out books in the library by checked out authors name

    Keyword Arguments:
    None

    Access Controls:
    should only be used by the librarian

    Returned:
    tuple of all the books in the checked_out data bale
    """
    result = exec_get_all('SELECT checked_out_by, checked_out_date, returned_date, remaining_copies FROM checked_out INNER JOIN books on books.id = checked_out.books_id ORDER BY books.author ASC;')
    return result

def list_all_books_by_type(book_type):
    """
    lists all books and copies given a type of books

    Keyword Arguments:
    book_type -- the type of book you would like to list, either fiction or nonfiction

    Access Controls:
    should only be used by the librarian

    Returned:
    list of tuples with all of the books title and number of copies
    """
    sql = 'SELECT title, copies FROM books WHERE books.book_type = %s;'
    result = exec_get_all(sql, (book_type,))
    return result;

def create_new_user(name, email, phone):
    """
    Creates a new user in the database

    Keyword Arguments:
    name -- the new users name
    email -- the new users email
    phone -- the new users phone number

    Access Controls:
    should only be used by the librarian

    Returned:
    tuple of the last user to be added
    """
    sql = 'INSERT INTO users (username, email, phone) VALUES (%s, %s, %s);'
    args = (name, email, phone)
    exec_commit(sql, args)
    result = exec_get_one("SELECT * FROM users WHERE email = %s", (email,))
    return result

def delete_user(email):
    """
    deletes a user from the database

    Keyword Arguments:
    email -- the email of the user to be deleted

    Access Controls:
    should only be used by the librarian

    Returned:
    None if the user no longer exists or a tuple if they still do
    """
    sql = "DELETE FROM users where users.email = %s"
    exec_commit(sql, (email,))
    result = exec_get_one('SELECT (username, email, phone) FROM users WHERE users.username = %s', (email,))
    return result

def add_book_to_library(book_title, book_type, publish_date, author, copies, summary, library_id):
    """
    adds a new book to the library

    Keyword Arguments:
    book_title -- the name of the book to be added
    book_type -- either fiction or non-fiction
    publish_date -- the date the book was published
    author -- who wrote the book
    copies -- how many copies are avaliable for withdrawl
    summary -- a short summary of the book

    Access Controls:
    should only be used by the librarian

    Returned:
    Nothing
    """
    sql = "INSERT INTO books (title, book_type, publish_date, author, copies, summary, library_id) VALUES (%s, %s, %s, %s, %s, %s, %s)"
    exec_commit(sql, (book_title, book_type, publish_date, author, copies, summary, library_id))

def return_book(book_name, username, returned_date):
    """
    Returns a book in the library, updates copies

    Keyword Arguments:
    book_id -- the id of the book
    username -- the username of who checked out the book
    returned_date -- the day the book was returned

    Access Controls:
    should only be used by the librarian

    Returned:
    a tuple of the last returned book
    """
    book_id = exec_get_one("SELECT id FROM books WHERE title = %s", (book_name,))
    update_copies = "UPDATE checked_out SET remaining_copies = remaining_copies + 1 WHERE books_id = %s"
    exec_commit(update_copies, (book_id,))
    update_books = "UPDATE books SET copies = copies + 1 WHERE id = %s"
    exec_commit(update_books, (book_id,))
    update_date = "UPDATE checked_out SET returned_date = %s where books_id = %s and checked_out_by = %s"
    exec_commit(update_date, (returned_date, book_id, username))

    total_fee = calculate_late_fee(book_id, username)
    update_fee = 'update checked_out set late_fees = %s where checked_out_by = %s and books_id = %s and returned_date = %s'
    exec_commit(update_fee, (total_fee, username, book_id, returned_date))

    days = exec_get_one('select returned_date - due_date from checked_out where checked_out_by = %s and books_id = %s', (username, book_id))
    days =int(str(days)[1:-2])

    if total_fee == 0:
        return

    return 'You returned your book ' + str(days) + ' late. You have a late fee of $' + str(total_fee)

def check_out_book(book_name, username, checked_out_date):
    """
    check out a book from the library, update copies

    Keyword Arguments:
    book_id -- the id of the book
    username -- the username of the user checking out the book
    checked_out_date -- the date the book was checked out

    Access Controls:
    should only be used by the librarian

    Returned:
    a tuple of the last book to be checked out
    """
    book_id = exec_get_one("SELECT id FROM books WHERE title = %s", (book_name,))
    select = "SELECT copies FROM books WHERE books.id = %s"
    copies = exec_get_one(select, (book_id,))
    copies_int = int(str(copies)[1:-2]) - 1

    overdue_status = determine_if_user_has_overdue(username, checked_out_date)
    if overdue_status == True:
        deactivate_account(username)
        return "Account deactivated, no more books may be checked out"

    update_checked_out = "UPDATE checked_out SET remaining_copies = remaining_copies - 1 WHERE books_id = %s"
    exec_commit(update_checked_out, (book_id,))

    update_books = "UPDATE books SET copies = copies - 1 WHERE books.id = %s"
    exec_commit(update_books, (book_id,))

    args = (book_id, username, checked_out_date, copies_int)
    insert_checked_out = "INSERT INTO checked_out (books_id, checked_out_by, checked_out_date, remaining_copies) VALUES (%s, %s, %s, %s)"
    exec_commit(insert_checked_out, args)

    due_date = exec_get_one("select checked_out_date + 14 from checked_out where checked_out_by = %s and books_id = %s", (username, book_id))
    exec_commit('UPDATE checked_out set due_date = %s where checked_out_by = %s and books_id = %s', (due_date, username, book_id))    
    
    return exec_get_one("SELECT * FROM checked_out WHERE books_id = %s AND checked_out_by = %s AND checked_out_date = %s", (book_id, username, checked_out_date))

def search_for_book(book_name):
    """
    the ability to search the database for a book

    Keyword Arguments:
    book_name -- the name of the book to be searched

    Access Controls:
    None

    Returned:
    a tuple of the book in the libary, none of the book doesn't exist
    """
    return exec_get_one("SELECT * FROM books WHERE title = %s", (book_name,))

def reserve_book(book_name, username):
    """
    reserve a book if all copies are checked out, request fails if copies exist

    Keyword Arguments:
    book_id -- the id of the book to be reserved
    username -- the name of the user that wants to reserve the book

    Access Controls:
    should only be used by the librarian

    Returned:
    a tuple of the last added reserved book
    """
    book_id = exec_get_one("SELECT id FROM books WHERE title = %s", (book_name,))
    get_copies_left = "SELECT remaining_copies FROM checked_out WHERE books_id = %s"
    copies = exec_get_one(get_copies_left, (book_id,))
    if copies == None:
        return None
    copies_int = int(str(copies)[1:-2])
    if copies_int > 0:
        return None
    add_to_reserve_list = "INSERT INTO reserved_list (books_id, username, reserved_status) VALUES (%s, %s, %s)"
    args = (book_id, username, "RESERVED")
    exec_commit(add_to_reserve_list, args)
    return exec_get_one("SELECT * FROM reserved_list WHERE books_id = %s AND username = %s", (book_id, username))

def list_checked_out_books_count_by_library(library_name):
    """
    list the count of all books at a specific library

    Keyword Arguments:
    library_name -- library you would like to search in

    Access Controls:
    None

    Returned:
    a list of all the books and their number of copies
    """
    sql = "SELECT books.id, title, copies, library_name FROM books INNER JOIN libraries on books.library_id = libraries.id WHERE libraries.library_name = %s"
    result = exec_get_all(sql, (library_name,))
    return result

def list_all_avaliable_books_by_library(library_name):
    """
    list all books that can be checked out in a specific library

    Keyword Arguments:
    library_name -- the specific library you would like to search through

    Access Controls:
    None

    Returned:
    a list of all the avaliable books
    """
    sql = 'SELECT title, library_name FROM books INNER JOIN libraries on books.library_id = libraries.id WHERE library_name = %s AND books.copies > 0'
    result = exec_get_all(sql, (library_name,))
    return result

def list_all_books_in_all_libraries():
    """
    list all books in all of the libraries

    Keyword Arguments:
    None

    Access Controls:
    None

    Returned:
    a list of all of the books 
    """
    return exec_get_all('select title,copies,library_name from books inner join libraries on books.library_id = libraries.id order by library_name asc, title asc; ')

def get_checkout_history(username):
    """
    get checkout history for a given user

    Keyword Arguments:
    username -- the name of the user you would like to get the history for

    Access Controls:
    should only be used by the librarian

    Returned:
    a list of the users checkout history, including late books
    """
    return exec_get_all('select library_name, title, checked_out_by, checked_out_date, returned_date, due_date, remaining_copies from checked_out inner join books on checked_out.books_id = books.id inner join libraries on books.library_id = libraries.id where checked_out_by = %s', (username,))

def deactivate_account(username):
    """
    deactivate a users account, so they can't checkout anymore books

    Keyword Arguments:
    username -- the name of the user to be deactivated

    Access Controls:
    should only be used by the library

    Returned:
    None
    """
    exec_commit('UPDATE users SET active=FALSE where username = %s', (username,))

def determine_if_user_has_overdue(username, checked_out_date):
    """
    see if a user has an overdue book, this is used when checking out a book

    Keyword Arguments:
    username -- the name of the user to check
    checked_out_date -- the date of the book trying to get checked_out

    Access Controls:
    should only be used by the librarian

    Returned:
    true if the user is overdue, false if not
    """
    result = exec_get_all("select id, checked_out_by from checked_out where %s > due_date and checked_out_by = %s and returned_date is null", (checked_out_date, username))
    if (len(result)) > 0:
        return True
    return False

def determine_if_over_due_on_return(username, returned_date):
    """
    determine if the user is overdue when returning a book

    Keyword Arguments:
    username -- the name of the user to be checked
    returned_date -- the date the book is being returned

    Access Controls:
    should only be used by the librarian

    Returned:
    true if the book is overdue, false if not
    """
    result = exec_get_all("select * from checked_out where returned_date is not null and %s > due_date and checked_out_by = %s", (returned_date, username))
    if (len(result)) > 0:
            return True
    return False

def list_overdue_books():
    """
    list all overdue books for every user

    Keyword Arguments:
    None

    Access Controls:
    should only be used by the librarian

    Returned:
    a list of all overdue books, ordered by username
    """
    return exec_get_all("select title, checked_out_by, checked_out_date, returned_date, due_date from checked_out inner join books on books.id = books_id where returned_date > due_date order by checked_out_by ASC")

def calculate_late_fee(book_id, username):
    """
    calculates the late fees on a specific book for a specific user

    Keyword Arguments:
    books_id -- the id of the book to be search
    username -- the name of the user to be searched

    Access Controls:
    Should only be used by the librarian or in returning a book

    Returned:
    a double of the total fee owned on a late book
    """
    days = exec_get_one('select returned_date - due_date from checked_out where checked_out_by = %s and books_id = %s', (username, book_id))
    days =int(str(days)[1:-2])
    count = 0
    total_fee = 0
    while(count < days and count < 7):
        total_fee += .25
        count += 1
    while(count < days):
        total_fee += 2
        count += 1
    return total_fee

def return_formatted_checkout_table():
    """
    return a formatted check out table with the book and author combine

    Keyword Arguments:
    None

    Access Controls:
    Should only be used by the librarian

    Returned:
    a formated list of tuples
    """
    sql = 'select array_agg(title || ' + "' by '" + ' || author) as book, checked_out_by as name, checked_out_date as checkout_date, returned_date, late_fees from checked_out inner join books on books.id = books_id group by checked_out.id'
    return exec_get_all(sql)

def list_full_info():
    """
    list full info for all users in checked_out including late fees

    Keyword Arguments:
    None

    Access Controls:
    Should only be used by the librarian

    Returned:
    a formatted list of tuples
    """
    return exec_get_all("select title, checked_out_by, returned_date, due_date, late_fees, library_name from checked_out inner join books on books.id = books_id inner join libraries on libraries.id = library_id order by library_name asc, checked_out_by asc, due_date asc")

def calculate_average_days_borrowed():
    """
    Calculates the average days all books have been borrowed for all users

    Keyword Arguments:
    None

    Access Controls:
    Should only be used by the librarian

    Returned:
    a double of the average days
    """
    return exec_get_all("select round(avg(returned_date - checked_out_date), 2) as days_borrowed from checked_out; ")

def list_days_borrowed_with_avg():
    """
    list all checked out books with the days borrowed on the end

    Keyword Arguments:
    None

    Access Controls:
    Should only be used by the librarian

    Returned:
    a list of tuples
    """
    return exec_get_all("select title, checked_out_by, checked_out_date, returned_date, returned_date - checked_out_date as days_borrowed from checked_out inner join books on books_id = books.id")
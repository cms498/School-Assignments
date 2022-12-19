from datetime import date, datetime
import json
import unittest
from src.db import library
from tests.test_utils import *
from src.db.library import *

class TestExample(unittest.TestCase):

    def setUp(self):
        """
        Called each time to reset the tables
        """
        rebuild_tables()

    def test_users_count(self):
        """
        Tests to make sure all of the users are returned
        """
        print("Print the total number of users")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/users')
        actual = count_rows(json_object)
        print("Total Count = " + str(actual))

    def test_books_count(self):
        """
        Tests to make sure all of the books are returned
        """
        print("Print the total number of books")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books')
        actual = count_rows(json_object)
        print("Total Count = " + str(actual))

    def test_fiction_return(self):
        print("List all fiction books")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?type=fiction')
        print(json_object)
        print()

    def test_penfield_return(self):
        print("List all books in the penfield library")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?library=Penfield')
        print(json_object)
        print()

    def test_joan_return(self):
        print("List all books with the name Joan")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?title=Joan')
        print(json_object)
        print()

    def test_multiple_book_criteria(self):
        print("List books that are fiction and at the penfield library, multiple criteria")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?library=Penfield&type=fiction')
        print(json_object)
        print()

    def test_empty_title(self):
        print("List all books, where the title doesn't exists")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?title=fakebook')
        print("List = " + str(json_object))
        print()

    def test_empty_author(self):
        print("List all books, but the author doesn't exists")
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/books/specify?author=fakeauthor')
        print("List = " + str(json_object))
        print()

    def test_add_user_not_exists(self):
        print("Adds a new user that doesn't exist")
        data = dict(username= "Ada Locelace", email= "alovelace@gmail.com", phone= "123-456-7890", password="banana")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        print("Making a post call to http://127.0.0.1:5000/users")
        post_rest_call(self, 'http://127.0.0.1:5000/users', jdata, hdr)
        json_object = get_rest_call(self, 'http://127.0.0.1:5000/users')
        print("json object with user Ada Locelace")
        print(json_object)
        print()

    def test_add_user_already_exists(self):
        print("Attempts to add a new user, but the user already exists")
        data = dict(username= "Ada Lovelace", email= "alovelace@gmail.com", phone= "123-456-7890", password="banana")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        print("Making a post call to http://127.0.0.1:5000/users")
        result = post_rest_call(self, 'http://127.0.0.1:5000/users', jdata, hdr)
        print("Server response :" + str(result))
        print()

    def test_update_user_not_exist(self):
        print("Attempt to update a users information, but the user does not exist")
        data = dict(username= "Test", oldemail= "Test@gmail.com", newemail="Testing@gmail.com", phone= "123-456-7890", password="banana")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        print("Making a put call to http://127.0.0.1:5000/users")
        result = put_rest_call(self, 'http://127.0.0.1:5000/users', jdata, hdr)
        print("Server response :" + str(result))
        print()

    def test_update_user_success(self):
        print("Update a users information success")
        print("Old information")        
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Session key = " + str(session_key))
        print(library.list_user_information("New user"))
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        data = dict(username = "New user", oldemail = "nu@gmail.com", newemail = "ab@gmail.com", phone = "987-654-1234", password="banana")
        jdata = json.dumps(data)
        
        put_rest_call(self, 'http://127.0.0.1:5000/users', jdata, hdr)
        print("New information")
        print(library.list_user_information("New user"))
        print()
    
    def test_login_no_user(self):
        print("Attempt to login, but the user doesn't exists")
        data = dict(username="Fake user", password="fake password")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        print("Making a post call to http://127.0.0.1:5000/login")
        result = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Session Key = " + str(result))
        print()

    def test_login_wrong_password(self):
        print("Attempt to login, but the password is wrong")
        print("Actual password = Apple")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        data = dict(username = "New user", password = "Appl")
        print("Attempted password = Appl")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        print("Making the post call to http://127.0.0.1:5000/login")
        result = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Server response :" + str(result))
        print()

    def test_login_pass(self):
        print("Attempt to login to account, with success")
        print("Actual password = Apple")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        data = dict(username = "New user", password = "Apple")
        print("Attempted password = Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Session Key")
        print(result)
        print()

    def test_delete_user_not_exist(self):
        print("Attempt to delete a user, but they don't exist")
        _username = "Fake user"
        session_key = "asd123123"
        hdr = {"session_key" : session_key, 'content-type': 'application/json', 'username' : _username}
        result = delete_rest_call(self, 'http://127.0.0.1:5000/users', hdr)
        print("Server response :" + str(result))
        print()

    def test_delete_user_wrong_session_key(self):
        print("Attempt to delete a user, but with the wrong session key")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Actual key = " + str(session_key))
        hdr = {"session_key" : session_key[:-2], 'content-type': 'application/json', 'username' : _username}
        print("Attempted key = " + str(session_key[:-2]))
        data = dict(username=_username)
        jdata = json.dumps(data)
        result = delete_rest_call(self, 'http://127.0.0.1:5000/users', hdr)
        print("Server response :" + str(result))
        print()

    def test_delete_user_pass(self):
        print("Attempt to delete a user, with success")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Actual session key = " + str(session_key))
        hdr = {"session_key" : session_key, 'content-type': 'application/json', 'username' : _username}
        print("Attempted session key = " + str(session_key))
        data = dict(username= _username)
        jdata = json.dumps(data)
        print("Making the delete call")
        delete_rest_call(self, 'http://127.0.0.1:5000/users', hdr)
        result = library.list_user_information(username= _username)
        print("User data with name :" + _username + ' = ')
        print(result)
        print()

    def test_logout_incorrect_session_key(self):
        print("Attempt to logout, incorrect session key")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        incorrect_key = session_key[:-2]
        print("Actual key = " + str(session_key))
        print("Attempted key = " + str(incorrect_key))
        data = dict(username=_username)
        jdata = json.dumps(data)
        hdr = {"session_key" : incorrect_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/logout', jdata, hdr)
        print("Server response :" + str(result))
        print()

    def test_logout_pass(self):
        print("Attempt to logout, with success")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        _email = "nu@gmail.com"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        data = dict(username=_username, email=_email)
        jdata = json.dumps(data)
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        post_rest_call(self, 'http://127.0.0.1:5000/logout', jdata, hdr)
        new_session_key = library.list_users_hashed_password_and_session_key(_username)[0][1]
        if session_key != new_session_key:
            print("Log out successful, session key changed, login to recieve new session key")
        else:
            print("Log out failed")
        print()

    def test_checkout_incorrect_session_key(self):
        print("Attempt to checkout a book, but session key is wrong")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Actual session key = " + str(session_key))
        altered_key = session_key[:-2]
        print("Attempted key = " + str(altered_key))
        hdr = {"session_key" : altered_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/checkout?username=New user&book_name=Joan&checked_out_date="2022-10-19"', {}, hdr)
        print("Server response :" + str(result))
        print()

    def test_checkout_acount_disabled(self):
        print("Attempt to checkout a book, but account is disabled")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        library.deactivate_account(_username)
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        library.check_out_book("Unbroken", _username, '2022-06-01')
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/checkout?username=New user&book_name=Joan', {}, hdr)
        print("Server response :" + str(result))
        print()

    def test_checkout_pass(self):
        print("Attempt to checkout a book, with success")
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/checkout?username=New user&book_name=Joan', {}, hdr)
        print("All checkout books")
        print(result)
        print()

    def test_reserve_incorrect_session_key(self):
        print("Attempt to reserve a book, but session key is wrong")
        library.add_book_to_library("Test book", "fiction", '2022-01-01', 'me', 0, "fake book", 1)
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        print("Actual key = " + str(session_key))
        incorrect_key = session_key[:-2]
        print("Attempted key = " + str(incorrect_key))
        hdr = {"session_key" : incorrect_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/reserve?username=New user&book_name=Test book', {}, hdr)
        print("Server response :" + str(result))
        print()

    def test_reserve_failure(self):
        print("Attempt to reserve a book, but copies still exist, so it fails")
        library.add_book_to_library("Test book", "fiction", '2022-01-01', 'me', 1, "fake book", 1)
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/reserve?username=New user&book_name=Test book', {}, hdr)
        print("Server response :" + str(result))
        print()

    def test_reserve_pass(self):
        print("Attempt to reserve a book, with success")
        library.add_book_to_library("Test book", "fiction", '2022-01-01', 'me', 0, "fake book", 1)
        library.create_new_user("New user", "nu@gmail.com", "123-123-1234", "Apple")
        _username = "New user"
        data = dict(username = _username, password = "Apple")
        jdata = json.dumps(data)
        hdr = {'content-type': 'application/json'}
        session_key = post_rest_call(self, 'http://127.0.0.1:5000/login', jdata, hdr)
        hdr = {"session_key" : session_key, 'content-type': 'application/json'}
        result = post_rest_call(self, 'http://127.0.0.1:5000/books/reserve?username=New user&book_name=Test book', {}, hdr)
        print("Server response :" + str(result))
        print()
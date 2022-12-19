from datetime import date
import hashlib
from flask_restful import Resource, reqparse, request
from flask import jsonify
from db import library
from db.swen344_db_utils import exec_get_all

class Books(Resource):
    """
    This api method lists all of the books out
    """
    def get(self):
        data = library.select_books_table()
        return jsonify(data)

class Users(Resource):
    """
    This api method lists all of the users
    """
    def get(self):
        data = library.select_users_table()
        return jsonify(data)

    def put(self):
        session_key = request.headers.get('session_key')
        parser = reqparse.RequestParser()
        parser.add_argument('username', type=str)
        parser.add_argument('oldemail', type=str)
        parser.add_argument('phone', type=str)
        parser.add_argument('password', type=str)
        parser.add_argument('newemail', type=str)
        args = parser.parse_args()
        username = args['username']
        oldemail = args["oldemail"]
        phone = args['phone']
        password = args['password']
        newemail = args['newemail']
        returned_hashed_password_and_key = exec_get_all("SELECT hashed_password, session_key from users where email = %s", (oldemail,))
        if session_key == None:
            return "User does not exist, please create then try again"
        if session_key != returned_hashed_password_and_key[0][1]:
            return "Incorrect Session Key"
        data = library.update_user_info(oldemail, username, newemail, phone, password)
        if data == None:
            return "User does not exist, please create then try again"
        else:
            return jsonify(data)

    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument('username', type=str)
        parser.add_argument('email', type=str)
        parser.add_argument('phone', type=str)
        parser.add_argument('password', type=str)
        args = parser.parse_args()
        username = args['username']
        email = args["email"]
        phone = args['phone']
        password = args['password']
        data = library.create_new_user(username, email, phone, password)
        if data == None:
            return "User already exists, try logging in"
        else:
            return jsonify(data)

    def delete(self):
        session_key = request.headers.get('session_key')
        username = request.headers.get('username')
        username_check = library.list_user_information(username)
        if username_check == []:
            return "User doesn't exist"
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        if session_key != returned_hashed_password_and_key[0][1]:
            return "Incorrect Session Key"
        library.delete_user(username)
        
class BooksUrl(Resource):
    """
    This api method lists all of the books based on search criteria passed into the url
    either the type, author, title, or library name
    """
    def get(self):
        book_type = request.args.get('type', default = '%')
        author = request.args.get('author', default = '%')
        title = request.args.get('title', default = '%')
        library_name = request.args.get('library', default = '%')
        data = library.list_all_books_by_criteria(book_type, author, title, library_name)
        return jsonify(data)

class ViewCheckoutBooks(Resource):
    def get(self):
        username = request.args.get('username')
        data = library.list_users_checked_out_books(username)
        return jsonify(data)

class CheckoutBook(Resource):
    def post(self):
        session_key = request.headers.get('session_key')
        book_name = request.args.get('book_name')
        username = request.args.get('username')
        checked_out_date = date.today()
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        if session_key != returned_hashed_password_and_key[0][1]:
            return "Checkout failed, incorrect session key"
        result = library.check_out_book(book_name, username, checked_out_date)
        if result == "Account deactivated, no more books may be checked out":
            return "Account deactivated, no more books may be checked out"
        else:
            return jsonify(result)

class ReserveBook(Resource):
    def post(self):
        session_key = request.headers.get('session_key')
        book_name = request.args.get('book_name')
        username = request.args.get('username')
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        if session_key != returned_hashed_password_and_key[0][1]:
            return "Checkout failed, incorrect session key"
        result = library.reserve_book(book_name, username)
        if result == None:
            return "Reservation failed"
        else:
            return jsonify(result)

class Login(Resource):
    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument('username', type=str)
        parser.add_argument('password', type=str)
        args = parser.parse_args()
        username = args['username']
        password = args['password']
        user_exists = library.list_user_information(username)
        if user_exists == []:
            return "Account with this username does not exists"
        hashed_password = hashlib.sha512(bytes(password, 'ascii')).hexdigest()
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        if hashed_password != returned_hashed_password_and_key[0][0]:
            return "Incorrect Password"
        library.update_session_key(username, user_exists[0][1])
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        return returned_hashed_password_and_key[0][1]

class Logout(Resource):
    def post(self):
        session_key = request.headers.get('session_key')
        parser = reqparse.RequestParser()
        parser.add_argument('username')
        parser.add_argument('email')
        args = parser.parse_args()
        username = args['username']
        email = args['email']
        returned_hashed_password_and_key = library.list_users_hashed_password_and_session_key(username)
        if session_key != returned_hashed_password_and_key[0][1]:
            return "Logout failed, incorrect session key"
        library.update_session_key(username, email)
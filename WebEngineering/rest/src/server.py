from flask import Flask
from flask_restful import Resource, Api
from db.swen344_db_utils import exec_sql_file
from api.methods import *

app = Flask(__name__)
api = Api(app)

api.add_resource(Users, "/users") #add, update, list, delete users
api.add_resource(Books, "/books") #list all books
api.add_resource(BooksUrl, "/books/specify") # list books with specific criteria, library, type, author, title
api.add_resource(ViewCheckoutBooks, "/books/checkedOutBy") #list checkedout books by username
api.add_resource(CheckoutBook, "/books/checkout") #checkout a book if possible
api.add_resource(ReserveBook, "/books/reserve") # reserve a book if possible
api.add_resource(Login, "/login") #login into the app to generate a session key
api.add_resource(Logout, "/logout")

if __name__ == '__main__':
    exec_sql_file("schema.sql")
    app.run(debug=True)
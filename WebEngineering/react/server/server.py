from flask import Flask
from flask_restful import Api
from flask_cors import CORS

from api.swen_344_db_utils import *
from api.club_api import *

app = Flask(__name__) #create Flask instance
CORS(app) #Enable CORS on Flask server to work with Nodejs pages
api = Api(app) #api router

api.add_resource(Clubs,'/clubs')
api.add_resource(Club, '/clubs/<string:clubName>&<string:clubLocation>&<string:clubMusic>')
api.add_resource(DeleteClub, '/clubs/delete/<string:id>')
api.add_resource(EditClubs, '/editClubs')
api.add_resource(FilteredClubs, "/filterClubs/<string:word>")

if __name__ == '__main__':
    print("Loading db")
    exec_sql_file('clubs.sql')
    print("Starting flask")
    app.run(debug=True) #starts Flask
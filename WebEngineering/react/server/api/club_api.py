from flask_restful import Resource, reqparse, request
from .swen_344_db_utils import *

class Clubs(Resource):
    def get(self):
        return exec_get_all("SELECT * FROM clubs")

    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument('clubName', type=str)
        parser.add_argument('clubLocation', type=str)
        parser.add_argument('clubMusic', type=str)
        parser.add_argument('lowerBound')
        parser.add_argument('upperBound')
        args = parser.parse_args()
        clubName = args['clubName']
        clubLocation = args['clubLocation']
        clubMusic = args['clubMusic']
        lowerBound = args['lowerBound']
        upperBound = args['upperBound']
        exec_commit('INSERT INTO clubs (clubName, clubLocation, clubMusic, lowerBound, upperBound) VALUES (%s, %s, %s, %s, %s)', (clubName, clubLocation, clubMusic, lowerBound, upperBound))

    def put(self):
        parser = reqparse.RequestParser()
        parser.add_argument('clubName', type=str)
        parser.add_argument('clubLocation', type=str)
        parser.add_argument('clubMusic', type=str)
        parser.add_argument('add')
        parser.add_argument('sub')
        args = parser.parse_args()
        add = args['add']
        clubName = args['clubName']
        clubLocation = args['clubLocation']
        clubMusic = args['clubMusic']
        if(add == None):
            exec_commit('UPDATE clubs set currentCount = currentCount - 1 where clubName = %s and clubLocation = %s and clubMusic = %s', (clubName, clubLocation, clubMusic))
        else:
            exec_commit('UPDATE clubs set currentCount = currentCount + 1 where clubName = %s and clubLocation = %s and clubMusic = %s', (clubName, clubLocation, clubMusic))
        return exec_get_all('SELECT currentCount from clubs where clubName = %s and clubLocation = %s and clubMusic = %s', (clubName, clubLocation, clubMusic))


class Club(Resource):
    def get(self, clubName, clubLocation, clubMusic):
        return exec_get_all("SELECT * FROM clubs where clubName = %s and clubLocation = %s and clubMusic = %s", (clubName, clubLocation, clubMusic))

class DeleteClub(Resource):
    def delete(self, id):
        exec_commit('DELETE FROM clubs where id = %s', (id,))

class EditClubs(Resource):
    def put(self):
        parser = reqparse.RequestParser()
        parser.add_argument('clubName', type=str)
        parser.add_argument('clubLocation', type=str)
        parser.add_argument('clubMusic', type=str)
        parser.add_argument('lowerBound')
        parser.add_argument('upperBound')
        parser.add_argument('previousName', type=str)
        args = parser.parse_args()
        clubName = args['clubName']
        clubLocation = args['clubLocation']
        clubMusic = args['clubMusic']
        lowerBound = args['lowerBound']
        upperBound = args['upperBound']
        previousName = args['previousName']
        exec_commit('UPDATE clubs set clubName = %s, clubLocation = %s, clubMusic = %s, lowerBound = %s, upperBound = %s where clubName = %s', (clubName, clubLocation, clubMusic, lowerBound, upperBound, previousName))
        return exec_get_all('SELECT * FROM clubs where clubName = %s', (clubName,))

class FilteredClubs(Resource):
    def get(self, word):
        low = word.lower()
        return exec_get_all('SELECT * FROM clubs where LOWER(clubLocation) like %s', ('%' + low + '%',))
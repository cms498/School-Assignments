"""
This program simulates creating an album full of songs
Author: Chris Shepard
"""
class Time:
    """
    Creates a class for a time object with hours, minutes and seconds
    """
    __slots__ = ["hours", "minutes", "seconds"]

    def __init__(self, hours, minutes, seconds):
        self.hours = hours
        self.minutes = minutes
        self.seconds = seconds

class Song:
    """
    Create a class for a song object with a title, artist name, and running duration
    """
    __slots__ = ["title", "artist", "duration"]

    def __init__(self, title, artist, duration): #duration is in seconds
        self.title = title
        self.artist = artist
        self.duration = duration

class Album:
    """
    Create a class for an album object, with a title, artists, the number of tracks, and total duration
    """
    __slots__ = ["title", "artist", "tracks", "total_duration"]

    def __init__(self, title):
        self.title = title
        self.artist = set()
        self.tracks = set()
        self.total_duration = 0

def get_time(time):
    """
    returns a string given a time object, in colon seperated format
    """
    return '{}:{:02}:{:02}'.format (time.hours, time.minutes, time.seconds) 

def add_song(album, song):
    """
    Adds a new song to an album
    """
    album.artist.add(song.artist)
    album.tracks.add(song)
    album.total_duration += song.duration

def print_album(album):
    """
    Prints out an album, with each song appearing on its own line
    """
    print(album.title)
    print()
    for artist in album.artist:
        print(artist)
    print()
    for song in album.tracks:
        print(song.title)
    print()
    album.total_duration = album.total_duration % (24 * 3600)
    hours = album.total_duration // 3600
    album.total_duration %= 3600
    minutes = album.total_duration // 60
    seconds = album.total_duration % 60
    print("Total Time:", get_time(Time(hours, minutes, seconds)))
      
def main():
    """
    Calls other functions, organization purposes
    """
    album = Album("Legends of Rock and Roll: Fats Domino")
    song = Song("Blueberry Hill", "Fats Domino", 140)
    add_song(album, song)
    song = Song("I'm Walkin", "Fats Domino", 134)
    add_song(album, song)
    song = Song("Be My Guest", "Fats Domino", 135)
    add_song(album, song)
    song = Song("Aint that a Shame", "Fats Domino", 144)
    add_song(album, song)
    song = Song("Jambalaya", "Fats Domino", 141)
    add_song(album, song)
    song = Song("I'm Ready", "Fats Domino", 141)
    add_song(album, song)
    song = Song("Country Boy", "Fats Domino", 136)
    add_song(album, song)
    song = Song("Blue Monday", "Fats Domino", 145)
    add_song(album, song)

    print_album(album)

if __name__ == "__main__":
    """
    Pytest purposes, main isn't called when running other programs
    """
    main()
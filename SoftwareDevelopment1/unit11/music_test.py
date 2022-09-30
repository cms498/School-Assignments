"""
Tests the functions in music.py
"""
import music

def test_get_time():
    #setup
    expected = "3:12:36"
    #invoke
    actual = music.get_time(music.Time(3, 12, 36))
    #analyze
    assert expected == actual

def test_song_class():
    #setup
    title = "abc"
    artist = "cba"
    duration = 60
    expected = "abc", "cba", 60
    #invoke
    a_song = music.Song(title, artist, duration)
    actual = a_song.title, a_song.artist, a_song.duration
    #analyze
    assert expected == actual

def test_album_class():
    #setup
    title = "testing"
    artist = {"abc"}
    tracks = {"track1", "track2"}
    duration = 60
    duration2 = 60
    expected = "testing", {"abc"}, {"track1", "track2"}, 120
    #invoke
    an_album = music.Album(title)
    an_album.artist.add("abc")
    an_album.tracks.add("track1")
    an_album.tracks.add("track2")
    an_album.total_duration += duration
    an_album.total_duration += duration2
    actual = an_album.title, an_album.artist, an_album.tracks, an_album.total_duration
    #analyze
    assert expected == actual

def test_add_song():
    #setup
    song1 = music.Song("abc", "cba", 60)
    song2 = music.Song("song2", "song2", 45)
    album = music.Album("testing")
    expected = {song1, song2}
    #invoke
    music.add_song(album, song1)
    music.add_song(album, song2)
    actual = album.tracks
    #analyze
    assert expected == actual

def main():
    pass

if __name__ == "__main__":
    main()
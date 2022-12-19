DROP TABLE if EXISTS clubs;

CREATE TABLE clubs (
        id SERIAL PRIMARY KEY,
        clubName TEXT,
        clubLocation TEXT,
        clubMusic TEXT,
        lowerBound INTEGER,
        upperBound INTEGER,
        currentCount INTEGER DEFAULT (0)
);

INSERT INTO clubs(clubName, clubLocation, clubMusic, lowerBound, upperBound, currentCount) VALUES
        ('Club Arcane', 'New York City', 'Punk', 70, 100, 0),
        ('Club Underground', 'London', 'Rock', 30, 50, 0),
        ('Club Soda', 'Dubai', 'Hip-Hop', 12, 20, 0),
        ('Studio 52', 'Las Vegas', 'Country', 32, 52, 0);
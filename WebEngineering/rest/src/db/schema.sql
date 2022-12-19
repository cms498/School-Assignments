DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS checked_out;
DROP TABLE IF EXISTS reserved_list;
DROP TABLE IF EXISTS libraries;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username TEXT,
    email TEXT, 
    phone VARCHAR(12),
    active BOOLEAN NOT NULL DEFAULT true,
    hashed_password TEXT NOT NULL DEFAULT '',
    session_key TEXT NOT NULL DEFAULT ''
);

INSERT INTO users(username, email, phone) VALUES
    ('Ada Lovelace', 'alovelace@gmail.com', '123-456-7890'),
    ('Mary Shelley', 'mshelley@gmail.com', '111-222-3333'),
    ('Jackie Gleason', 'jgleason@gmail.com', '222-333-4444'),
    ('Art Garfunkel', 'agarfunkel@gmail.com', '333-444-5555');

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title TEXT,
    book_type TEXT, 
    publish_date DATE,
    author TEXT, 
    copies INTEGER,
    summary TEXT,
    library_id INTEGER
);

INSERT INTO books(title, book_type, publish_date, author, copies, summary, library_id) VALUES 
    ('1984', 'fiction', '1949-06-08', 'George Orwell', 3, 'A good party member, in complete conformance with the wishes of Big Brother-the leader of the Inner Party', 1), 
    ('An Immense World', 'non-fiction', '2022-06-21', 'Ed Yong', 4, 'in order to understand our world we dont need to travel to other worlds, we need to see through other eyes', 2),
    ('Joan', 'fiction', '2022-07-05', 'Katherine Chen', 3, 'Joan is the dreamer of Domremy, and when she announces that she hears voices that tell her to free France', 3),
    ('Alexander Hamilton', 'non-fiction', '2004-04-26', 'Penguin Books', 5, 'A play and a book', 4),
    ('Unbroken', 'non-fiction', '2010-01-01', 'Laura Hillenbrand', 3, 'A World War II Story of Survival, Resilience, and Redemption is a biography by Laura Hillenbrand that tells the life story of Louie Zamperini', 1),
    ('Lord of the Rings', 'fiction', '1954-07-29', 'J.R.R Tolkien', 4, 'A book that has been turned into many, many, many movies', 2);

CREATE TABLE checked_out(
    id SERIAL PRIMARY KEY,
    books_id INTEGER,
    checked_out_by TEXT,
    checked_out_date DATE,
    returned_date DATE DEFAULT NULL,
    due_date DATE,
    remaining_copies INTEGER DEFAULT NULL,
    late_fees decimal(5, 2) DEFAULT 0.0
);

INSERT INTO checked_out(books_id, checked_out_by, checked_out_date, returned_date, due_date, remaining_copies) VALUES 
    (2, 'Ada Lovelace', '2022-09-11', '2022-09-12', '2022-09-25',3),
    (5, 'Ada Lovelace', '2022-09-10', NULL, '2022-09-24',2),
    (1, 'Ada Lovelace', '2022-09-09', '2022-09-11', '2022-09-23', 2),
    (1, 'Mary Shelley', '2022-09-08', NULL,'2022-09-22', 2),
    (6, 'Mary Shelley', '2022-09-07', '2022-09-13', '2022-09-21',4),
    (3, 'Jackie Gleason', '2022-09-06', NULL, '2022-09-20', 2),
    (5, 'Jackie Gleason', '2022-09-05', NULL, '2022-09-19', 2),
    (4, 'Jackie Gleason', '2022-09-04', NULL, '2022-09-18', 4);

CREATE TABLE reserved_list(
    id SERIAL PRIMARY KEY,
    books_id INTEGER,
    username TEXT,
    reserved_status TEXT
);

CREATE TABLE libraries(
    id SERIAL PRIMARY KEY,
    library_name TEXT
);

INSERT INTO libraries(library_name) VALUES 
    ('Penfield'), 
    ('Fairport'), 
    ('Henrietta'), 
    ('Pittsford');
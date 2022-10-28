CREATE SCHEMA IF NOT EXISTS db_jdbc_IMDB;
USE `db_jdbc_IMDB`;

DROP TABLE IF EXISTS filmactors;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS rewievers;
DROP TABLE IF EXISTS raitings;
DROP TABLE IF EXISTS news;
DROP TABLE IF EXISTS cash_collection;
DROP TABLE IF EXISTS budget;
DROP TABLE IF EXISTS nominations;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS films;

CREATE TABLE films(
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) NOT NULL,
	date varchar(100) NOT NULL
);

CREATE TABLE actors(
	id int AUTO_INCREMENT  PRIMARY KEY,
	full_name VARCHAR(250) NOT NULL,
	age int NOT NULL
);

CREATE TABLE filmactors(
	id int AUTO_INCREMENT  PRIMARY KEY,
	film_id int NOT NULL, FOREIGN KEY(film_id) REFERENCES films(id),
	actor_id int NOT NULL,
    CONSTRAINT FOREIGN KEY(actor_id) REFERENCES actors(id)
);

CREATE TABLE reviewers(
	id int AUTO_INCREMENT PRIMARY KEY,
	info varchar(1000) NOT NULL,
	film_id int NOT NULL, 
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id)
);

CREATE TABLE raitings(
	id int AUTO_INCREMENT  PRIMARY KEY,
	raiting int NOT NULL,
	film_id int NOT NULL,  
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id)
);

CREATE TABLE news(
	id int AUTO_INCREMENT PRIMARY KEY,
	news varchar(1000) NOT NULL,
	film_id int NOT NULL,
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id)
);

CREATE TABLE countries(
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) NOT NULL
);

CREATE TABLE cash_collection(
	id int AUTO_INCREMENT PRIMARY KEY,
	price int NOT NULL,
	film_id int NOT NULL,
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id),
	country_id int NOT NULL, 
    CONSTRAINT FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE budget(
	id int AUTO_INCREMENT PRIMARY KEY,
    price int NOT NULL,
    film_id int NOT NULL,
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id)
);

CREATE TABLE nominations(
	id int AUTO_INCREMENT PRIMARY KEY,
    nomination varchar(1000) NOT NULL,
    film_id int NOT NULL,
    CONSTRAINT FOREIGN KEY(film_id) REFERENCES films(id)
);

INSERT INTO `films`
VALUES(1, 'Pirates of the Caribian', '2003-07-09'),
(2, 'Joker', '2019-10-04'),
(3, 'The dark knight', '2008-07-18'),
(4, 'Pixels', '2014-06-13'),
(5, 'Rokky', '1980-11-27'),
(6, 'Harry Potter', '2001-12-18'),
(7, 'Hobbit', '2002-06-03'),
(8, 'Harry Potter 2', '2003-04-11'),
(9, 'Titanic', '1991-03-14'),
(10, 'Sherlok', '2012-05-17');

INSERT INTO `actors`
VALUES(1, 'Jonny Depp', 50),
(2, 'Orlando Bloom', 35),
(3, 'Deniel Redcliffe', 33),
(4, 'Leonardo Dicaprio', 49),
(5, 'Martin Freemam', 51),
(6, 'Joaquin Phoenix', 47),
(7, 'Rianna', 38),
(8, 'Emma Watson', 31),
(9, 'Kate Winslet', 47),
(10, 'Benedict Cumberbetch', 46),
(11, 'Silwester Stalone', 76),
(12, 'Heath Ledger', 28);

INSERT INTO `filmactors`
VALUES(1, 1, 1),
(2, 1, 2),
(3, 5, 11),
(4, 6, 3),
(5, 10, 10),
(6, 3, 12),
(7, 9, 4),
(8, 8, 8),
(9, 10, 10),
(10, 9, 9),
(11, 2, 6),
(12, 8, 3);

INSERT INTO `reviewers`
VALUES(1, 'Cool film', 2),
(2, 'Great', 5),
(3, 'I like this film', 1),
(4, 'Cool', 7),
(5, 'I dont like this film', 4),
(6, 'Good', 8),
(7, 'Not bad', 10),
(8, 'Love this fil', 2),
(9, 'Cool film',  9),
(10, 'My favourite', 10);

INSERT INTO `raitings`
VALUES(1, 50, 2),
(2, 41, 1),
(3, 22, 2),
(4, 77, 8),
(5, 60, 4),
(6, 100, 9),
(7, 90, 10),
(8, 66, 3),
(9, 43, 7),
(10, 79, 5);

INSERT INTO `news`
VALUES(1, 'smth interesting', 3),
(2, 'smth interesting', 7),
(3, 'smth interesting', 4),
(4, 'smth interesting', 1),
(5, 'smth interesting', 2),
(6, 'smth interesting', 9),
(7, 'smth interesting', 6),
(8, 'smth interesting', 5),
(9, 'smth interesting', 10),
(10, 'smth interesting', 8);

INSERT INTO `countries`
VALUES(1, 'Ukraine'),
(2, 'France'),
(3, 'UK'),
(4, 'USA'),
(5, 'Germany'),
(6, 'Poland'),
(7, 'Spain'),
(8, 'Italy'),
(9, 'Mexico'),
(10, 'Brasil'),
(11, 'China');

INSERT INTO `cash_collection`
VALUES(1, 150000, 3, 2),
(2, 200000, 6, 1),
(3, 123000, 4, 8),
(4, 300000, 10, 5),
(5, 540000, 7, 3),
(6, 90000, 5, 2),
(7, 1200000, 1, 10),
(8, 200000, 8, 4),
(9, 66600, 7, 2),
(10, 744000, 7, 11),
(11, 800000, 3, 10);

INSERT INTO `budget`
VALUES(1, 100000, 5),
(2, 30000, 2),
(3, 50000, 1),
(4, 20000, 8),
(5, 120000, 10),
(6, 70000, 4),
(7, 34000, 9),
(8, 10000, 3),
(9, 200000, 7),
(10,29000, 6);

INSERT INTO `nominations`
VALUES(1, 'Best Picture',  2),
(2, 'Best Directing', 6),
(3, 'Costume Design', 1),
(4, 'Actress in a Supporting Role', 9),
(5, 'Film Editing', 3),
(6, 'Visual Effects', 8),
(7, 'Documentary Feature', 10),
(8, 'Music (Original Score)', 4),
(9, 'Cinematography', 5),
(10, 'Production Design', 7);


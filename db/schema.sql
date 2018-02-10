CREATE SEQUENCE users_seq START 1 INCREMENT 1;

CREATE TABLE users (
	id int primary key default nextval('users_seq'),
	login varchar(20),
	password varchar(30),
	first_name varchar(20),
	last_name varchar(30)
);

CREATE SEQUENCE books_seq START 1 INCREMENT 1;

CREATE TABLE books(
	id int primary key default nextval('books_seq'),
	title varchar(100),
	author varchar(100),
	page_count int
);

CREATE SEQUENCE loans_seq START 1 INCREMENT 1;

CREATE TABLE loans(
	id int primary key default nextval('loans_seq'),
	id_book int REFERENCES books(id),
	id_user int REFERENCES users(id),
	loan_start TIMESTAMP WITHOUT TIME ZONE,
	loan_end TIMESTAMP WITHOUT TIME ZONE
)
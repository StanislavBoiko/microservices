CREATE TABLE USERS
(
    id serial primary key,
    name varchar,
    surname varchar,
    address varchar
);

CREATE TABLE PRODUCTS
(
    id serial primary key,
    name varchar,
    price double precision
);

INSERT INTO USERS (name, surname, address)
    values('Viktor', 'Yanukovych', 'Rostov-on-Don'),
    ('Volodymyr', 'Zelenskyi', 'Bankova str.'),
    ('Kyrylo', 'Budanov', 'Elektrykiv str.');

INSERT INTO PRODUCTS (name, price)
    values('Zhyvchyk', 14),
    ('Lvivske 1715', 13),
    ('BlackBox', 228);

create table messages
(
    id                    serial primary key,
    message_text          varchar not null,
    message_date          timestamp default current_timestamp

);
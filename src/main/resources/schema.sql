drop table if exists books;
drop table if exists users;
create table users
(
    id        int auto_increment
        primary key,
    name      varchar(255)           null,
    last_name varchar(255)           null,
    email     varchar(255)           null,
    password  varchar(255)           null,
    user_role enum ('ADMIN', 'USER') null
);

create table books
(
    id          int auto_increment
        primary key,
    book_name   varchar(255) null,
    author_name varchar(255) null,
    user_id     int          null,
    constraint books_ibfk_1
        foreign key (user_id) references users (id)
);


create index IF NOT EXISTS user_id
    on books (user_id);


insert into users (id, name, last_name, email, password, user_role)
values
(1, 'Anna', 'Ananyan', 'anna@mail.ru', 'anna', 'USER'),
(2, 'admin', 'admin', 'admin@mail.ru', 'admin', 'ADMIN'),
(3, 'Liana', 'Petrosyan', 'liana@mail.ru', 'anna', 'USER');

insert into books (id, book_name, author_name, user_id)
values
(1, 'The Silent Patient', 'Alex Michaelides', 2),
(2, 'Clean Code', 'Robert C. Martin', 2),
(3, 'Grokking Algorithms', 'Aditya Y. Bhargava', 2);


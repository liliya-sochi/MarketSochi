create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values ('Bread', 20),
       ('Milk', 30),
       ('Cheese', 80),
       ('Sugar', 35),
       ('Tomato', 100),
       ('Apple', 120),
       ('Salt', 25),
       ('Whiskey', 999);
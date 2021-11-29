CREATE TABLE users
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(32)  NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
    role     VARCHAR(10)  NOT NULL,
    ban      VARCHAR(12)

);

CREATE TABLE brands
(
    brand VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE cars
(
    id     INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand  VARCHAR(64)  NOT NULL,
    class  VARCHAR(2)   NOT NULL,
    model  VARCHAR(250) NOT NULL,
    price  VARCHAR(64)  NOT NULL,
    status VARCHAR(24)  NOT NULL

);

CREATE TABLE rentform
(
    id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    carid     INT         NOT NULL,
    username  VARCHAR(32) NOT NULL,
    passport  VARCHAR(10) NOT NULL,
    price     VARCHAR(64) NOT NULL,
    status    VARCHAR(64) NOT NULL,
    driver    VARCHAR(10) NOT NULL,
    from_date DATE DEFAULT NULL,
    to_date   DATE DEFAULT NULL
);

CREATE TABLE ticket
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    carid      INT,
    username   VARCHAR(32) NOT NULL,
    price      INT,
    status     VARCHAR(32)  DEFAULT 'UNPAYED'
);

INSERT INTO users
VALUES (1, 'admin', '$2a$10$RJIA57DIY0sz6EfedlE0qOAxewlY4Wqn2QJ8f.OqnvS5xWRkSV.KK', 'ADMIN', 'PERMITTED');

INSERT INTO users
VALUES (2, 'user', '$2a$10$iBc5fRlaM0py9Fh.OtMOB.qF4x7mP9CiUXlCuXmxt3gSs7jRYNcla', 'USER', 'PERMITTED');

INSERT INTO users
VALUES (3, 'manager', '$2a$10$kGL6i.tXRkL5qmLXCgADZeSJGybrqhPa5Y.JC3y0IX2zKeKIQuDRq', 'MANAGER', 'PERMITTED');

INSERT INTO cars
VALUES (1, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE');

INSERT INTO cars
VALUES (2, 'NISSAN', 'C', 'Rogue', '200.00', 'AVAILABLE');

INSERT INTO cars
VALUES (3, 'MITSUBISHI', 'B', 'aCVASfafv', '200.00', 'AVAILABLE');

INSERT INTO cars
VALUES (4, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE');

INSERT INTO cars
VALUES (5, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE');

INSERT INTO cars
VALUES (6, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE');

INSERT INTO cars
VALUES (7, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE');

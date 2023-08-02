DROP TABLE IF EXISTS users;

--DROP TABLE IF EXISTS trade;
--DROP TABLE IF EXISTS security;
--DROP TABLE IF EXISTS counterparty;
--DROP TABLE IF EXISTS book_user;
--DROP TABLE IF EXISTS book;


CREATE TABLE users (
    id INT AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL
);

--CREATE TABLE security (
--    id INT AUTO_INCREMENT,
--    isin VARCHAR(20) DEFAULT NULL,
--    cusip VARCHAR(50) DEFAULT NULL,
--    issuer_name VARCHAR(250) NOT NULL,
--    maturity_date datetime NOT NULL,
--    coupon float NOT NULL,
--    type VARCHAR(250) NOT NULL,
--    face_value float NOT NULL,
--    currency VARCHAR(32) DEFAULT NOT NULL,
--    status VARCHAR(32) DEFAULT NULL,
--    PRIMARY KEY (id)
--);
--
--
--CREATE TABLE counterparty (
--    id INT AUTO_INCREMENT,
--    name VARCHAR(250) NOT NULL,
--    PRIMARY KEY (id)
--);
--
--CREATE TABLE book_user(
--    book_id  INT NOT NULL,
--    user_id INT NOT NULL,
--    FOREIGN KEY(book_id) references book(id),
--    FOREIGN KEY(user_id) references users(id)
--);
--
--
--CREATE TABLE book(
--    id INT NOT NULL AUTO_INCREMENT,
--    name VARCHAR(250) NOT NULL,
--    PRIMARY KEY(id);
--);
--
--CREATE TABLE trade (
--    id INT AUTO_INCREMENT,
--    book_id INT NOT NULL,
--    security_id INT NOT NULL,
--    counterparty_id INT NOT NULL,
--    currency VARCHAR(10) NOT NULL,
--    status VARCHAR(30) NOT NULL,
--    quantity INT NOT NULL,
--    unit_price float NOT NULL,
--    buy_sell VARCHAR(32) NOT NULL,
--    trade_date datetime NOT NULL,
--    settlement_date datetime NOT NULL,
--    PRIMARY KEY(id),
--    FOREIGN KEY(security_id) references security(id),
--    FOREIGN KEY(counterparty_id) references counterparty(id),
--    FOREIGN KEY(book_id) references book(id)
--);



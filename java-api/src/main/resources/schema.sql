-- Drop existing tables if they exist
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counterparty;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS users;

-- Create 'users' table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL
);

-- Create 'security' table
CREATE TABLE security (
    id INT AUTO_INCREMENT PRIMARY KEY,
    isin VARCHAR(20) DEFAULT NULL,
    cusip VARCHAR(50) DEFAULT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon FLOAT NOT NULL,
    type VARCHAR(250) NOT NULL,
    face_value FLOAT NOT NULL,
    currency VARCHAR(32) NOT NULL DEFAULT '',
    status VARCHAR(32) DEFAULT NULL
);

-- Create 'counterparty' table
CREATE TABLE counterparty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

-- Create 'book' table
CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

-- Create 'book_user' table
CREATE TABLE book_user (
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    PRIMARY KEY (book_id, user_id)
);

-- Create 'trade' table
CREATE TABLE trade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counterparty_id INT NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    unit_price FLOAT NOT NULL,
    buy_sell VARCHAR(32) NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (security_id) REFERENCES security(id),
    FOREIGN KEY (counterparty_id) REFERENCES counterparty(id)
);
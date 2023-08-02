DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS trades;


CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);


CREATE TABLE trades (
    id INT NOT NULL AUTO_INCREMENT,
    currency VARCHAR(250) NOT NULL,
    trade_type VARCHAR(250) NOT NULL,
    quantity VARCHAR(250) NOT NULL
);





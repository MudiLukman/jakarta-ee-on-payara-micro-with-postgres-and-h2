CREATE TABLE groceries (
    id VARCHAR(38) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    is_sold BOOLEAN NOT NULL,
    added_at TIMESTAMP WITHOUT TIME ZONE
);
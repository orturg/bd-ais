CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(50) NOT NULL,
                           surname VARCHAR(50) NOT NULL,
                           patronymic VARCHAR(50),
                           phone_number VARCHAR(15) UNIQUE NOT NULL,
                           city VARCHAR(50) NOT NULL,
                           street VARCHAR(100) NOT NULL,
                           zip_code VARCHAR(10) NOT NULL,
                           percent INT CHECK (percent >= 0 AND percent <= 100) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           password VARCHAR(255) NOT NULL
);

INSERT INTO customers (name, surname, patronymic, phone_number, city, street, zip_code, percent, email, password) VALUES
    ('John', 'Doe', 'Michael', '+1234567890', 'New York', '5th Avenue 123', '10001', 10, 'email@gmail.com', 'hashed_password');
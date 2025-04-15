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
    ('John', 'Doe', 'Michael', '+1234567890', 'New York', '5th Avenue 123', '10001', 10, 'email2@gmail.com', 'hashed_password1'),
    ('Alice', 'Smith', 'Ann', '+1987654321', 'Los Angeles', 'Sunset Blvd 456', '90001', 15, 'email3@gmail.com', 'hashed_password2'),
    ('Robert', 'Brown', 'James', '+1122334455', 'Chicago', 'Michigan Ave 789', '60601', 5, 'email4@gmail.com', 'hashed_password3'),
    ('Emily', 'Davis', 'Grace', '+1223344556', 'Houston', 'Main Street 321', '77001', 12, 'email5@gmail.com', 'hashed_password4'),
    ('Michael', 'Wilson', 'Lee', '+1334455667', 'Phoenix', 'Camelback Rd 147', '85001', 8, 'email6@gmail.com', 'hashed_password5'),
    ('Olivia', 'Johnson', 'Marie', '+1445566778', 'Philadelphia', 'Market Street 258', '19101', 20, 'email7@gmail.com', 'hashed_password6'),
    ('William', 'Taylor', 'Andrew', '+1556677889', 'San Antonio', 'Broadway St 369', '78201', 18, 'email8@gmail.com', 'hashed_password7'),
    ('Sophia', 'Anderson', 'Claire', '+1667788990', 'San Diego', 'Palm Ave 159', '92101', 9, 'email9@gmail.com', 'hashed_password8');
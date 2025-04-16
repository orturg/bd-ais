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


CREATE TABLE employees (
                           id_employee SERIAL PRIMARY KEY,
                           emlp_name VARCHAR(50) NOT NULL,
                           emlp_surname VARCHAR(50) NOT NULL,
                           emlp_patronymic VARCHAR(50),
                           emlp_role VARCHAR(50) NOT NULL,
                           salary DECIMAL(13, 4) CHECK (salary >= 0) NOT NULL,
                           date_of_birth DATE,
                           date_of_start DATE,
                           phone_number VARCHAR(13) NOT NULL,
                           city VARCHAR(50) NOT NULL,
                           street VARCHAR(100) NOT NULL,
                           zip_code VARCHAR(9) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           password VARCHAR(255) NOT NULL
);

INSERT INTO employees (emlp_name, emlp_surname, emlp_patronymic, emlp_role,
                       salary, date_of_birth, date_of_start, phone_number, city,
                       street, zip_code, email, password) VALUES
                                                              ('John', 'Doe', 'Michael', 'CASHIER', 50000.00, '1985-06-15', '2020-01-10', '+1234567890', 'New York', '5th Avenue 123', '10001', 'john.doe@example.com', 'hashed_password1'),
                                                              ('Alice', 'Smith', 'Ann', 'CASHIER', 40000.00, '1990-03-22', '2021-05-15', '+1987654321', 'Los Angeles', 'Sunset Blvd 456', '90001', 'alice.smith@example.com', 'hashed_password2'),
                                                              ('Robert', 'Brown', 'James', 'CASHIER', 45000.00, '1988-11-10', '2019-09-01', '+1122334455', 'Chicago', 'Michigan Ave 789', '60601', 'robert.brown@example.com', 'hashed_password3'),
                                                              ('Emily', 'Davis', 'Grace', 'CASHIER', 55000.00, '1982-07-08', '2018-03-20', '+1223344556', 'Houston', 'Main Street 321', '77001', 'emily.davis@example.com', 'hashed_password4'),
                                                              ('Michael', 'Wilson', 'Lee', 'MANAGER', 42000.00, '1995-01-15', '2022-07-10', '+1334455667', 'Phoenix', 'Camelback Rd 147', '85001', 'michael.wilson@example.com', 'hashed_password5');
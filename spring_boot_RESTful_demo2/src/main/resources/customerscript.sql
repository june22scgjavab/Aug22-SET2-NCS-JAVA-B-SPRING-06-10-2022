DROP DATABASE IF EXISTS customerDB;
CREATE DATABASE customerDB;
USE customerDB;

CREATE TABLE customer_details(
cust_id INT PRIMARY KEY,
name VARCHAR(30),
email_id VARCHAR(40)
);

INSERT INTO customer_details VALUES(1,'Rohan','rohan@gmail.com');
COMMIT;
SELECT * FROM customer_details;
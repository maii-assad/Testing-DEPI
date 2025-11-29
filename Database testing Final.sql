CREATE DATABASE testing1;

CREATE TABLE customers (
    customer_id INT IDENTITY(1,1) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    last_modified DATETIME DEFAULT GETDATE()
);


CREATE TABLE products (
    product_id INT IDENTITY(1,1) PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    quantity INT NOT NULL CHECK (quantity >= 0),
    brand VARCHAR(50)
);


CREATE TABLE orders (
    order_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0),
    order_date DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
        ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE TABLE cart (
    cart_id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    added_date DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


INSERT INTO customers (first_name, last_name, email, phone)
VALUES 
('Yasmin', 'Ali', 'yasmin@example.com', '01012345678'),
('Sara', 'Mostafa', 'sara@example.com', '01098765432');


INSERT INTO products (product_name, price, quantity, brand)
VALUES
('Laptop', 15000, 10, 'Lenovo'),
('Headphones', 800, 50, 'Sony'),
('Keyboard', 300, 25, 'Logitech');


INSERT INTO orders (customer_id, product_id, quantity, total)
VALUES
(1, 1, 1, 15000),
(2, 3, 2, 600);


-- Test Case 1: Manual Customer_ID insert (should fail)
INSERT INTO customers (customer_id, first_name, email)
VALUES (10, 'Mina', 'mina@test.com');


-- Test Case 2: Updating primary key (should fail)
UPDATE customers
SET customer_id = 20
WHERE customer_id = 1;


-- Test Case 3: Check new customer exists
SELECT * FROM customers;


-- Test Case 4: Duplicate email (should fail)
INSERT INTO customers (first_name, last_name, email)
VALUES ('Nour', 'Hassan', 'yasmin@example.com');


-- Test Case 5: Required field empty (should fail)
INSERT INTO customers (first_name, email)
VALUES (NULL, 'test@example.com');


-- Test Case 6: Cascade delete 
DELETE FROM customers WHERE customer_id = 1;
SELECT * FROM orders WHERE customer_id = 1;


-- Test Case 7: Invalid FK in orders (should fail)
INSERT INTO orders (customer_id, product_id, quantity, total)
VALUES (999, 1, 1, 15000);


-- Test Case 8: Price must be numeric (should fail)
INSERT INTO products (product_name, price, quantity)
VALUES ('Tablet', 'ABC', 5);


-- Test Case 9: Negative quantity (should fail)
UPDATE products
SET quantity = -5
WHERE product_id = 2;


-- Test Case 10: Order total calculation
INSERT INTO orders (customer_id, product_id, quantity, total)
VALUES (2, 2, 3, (SELECT price FROM products WHERE product_id = 2) * 3);
SELECT * FROM orders WHERE customer_id = 2 AND product_id = 2;


-- Test Case 11: Delete product linked to orders (should fail)
DELETE FROM products WHERE product_id = 3;


-- Test Case 12: Count customers
SELECT COUNT(*) AS total_customers FROM customers;


-- Test Case 13: Timestamp update
INSERT INTO cart (customer_id, product_id, quantity)
VALUES (2, 2, 1);


-- Test Case 14: Long product names (should fail)
INSERT INTO products (product_name, price, quantity)
VALUES ('This is a very long product name that exceeds the maximum allowed length for product names in our database system', 100, 5);


-- Test Case 15: LIKE search
SELECT * FROM customers WHERE first_name LIKE '%a%' OR last_name LIKE '%a%';


-- Test Case 16: JOIN customers + orders
SELECT c.customer_id, c.first_name, c.email, o.order_id, p.product_name, o.quantity, o.total
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN products p ON o.product_id = p.product_id;


-- Test Case 17: Order without Product_ID (should fail)
INSERT INTO orders (customer_id, product_id, quantity, total)
VALUES (2, NULL, 3, 900);


-- Test Case 18: Delete all cart records
DELETE FROM cart;
SELECT COUNT(*) AS remaining_cart_items FROM cart;


-- Test Case 19: Performance insert
BEGIN TRANSACTION
DECLARE @i INT = 1
WHILE @i <= 1000
BEGIN
    INSERT INTO customers (first_name, last_name, email, phone)
    VALUES ('Test' + CAST(@i AS VARCHAR), 'User' + CAST(@i AS VARCHAR), 
            'test' + CAST(@i AS VARCHAR) + '@example.com', 
            '010' + RIGHT('0000000' + CAST(@i AS VARCHAR), 7));
    SET @i = @i + 1
END
COMMIT TRANSACTION
SELECT COUNT(*) AS total_customers_after_performance_test FROM customers;
-- What are the categories of products in the database?
SELECT category FROM products;

-- What products are made by Dell?
SELECT *  from products p where product_name = 'Dell Inspirion';

-- List all the orders shipped to Pennsylvania.
SELECT * FROM orders o where ship_state = "Pennsylvania";

-- List the first name and last name of all employees with last names that start with the letter W.
SELECT first_name,last_name  from employees e where last_name LIKE 'W%';

-- List all customers from zip codes that start with 55.\
Select * FROM  customers c where postal_code like '55%';

-- List all customers from zip codes that end with 0.
Select * FROM  customers c where postal_code like '%0';

-- List the first name, last name, and email for all customers with a ".org" email address.
Select first_name,last_name,email FROM  customers c where email like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code.
Select first_name,last_name,phone  FROM  customers c where phone like '___202%';

-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
Select first_name,last_name,phone  FROM  customers c where phone like '___202%' ORDER BY last_name asc, first_name asc;






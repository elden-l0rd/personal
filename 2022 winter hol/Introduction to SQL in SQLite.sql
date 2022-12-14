--Introduction to SQL in SQLite--


--Retrieving data with SELECT statement--
SELECT prod_name,
        prod_name2,
        prod_name3
FROM Products
LIMIT 5; --fetch first x rows only

--filter records that fulfills clause--
Select 
    CustomerId,
    BillingAddress
From Invoices
Where CustomerId=31;


--Creating Tables--
CREATE TABLE Shoes (
    Id      char(10)        PRIMARY KEY,
    Brand   char(10)        NOT NULL,
    Color   char(250)       NOT NULL,
    Price   decimal(8,2)    NOT NULL,
    Descr   Varchar(750)    NULL
    /*  PRIMARY_KEY & NOT NULL won't be
                  to accept null values */
);


--Adding Data to table--
--mtd #1--
INSERT INTO Shoes
VALUES ('123445',
        'Gucci',
        'Pink',
        '695.60',
        NULL);

--mtd #2 (RECOMMENDED for clarity)
INSERT INTO Shoes (
    Id,
    Brand,
    Color,
    Price,
    Descr
)
VALUES ('123445',
        'Gucci',
        'Pink',
        '695.60',
        NULL);


--Creating Temporary tables(deleted once session terminates)--
CREATE TEMPORARY TABLE Sandals AS
    (
        SELECT *
        FROM shoes
        WHERE shoe_type = 'sandals'
    )



--Filtering, Sorting and Calculating Data in SQL--
--Clauses and Operators--
WHERE       NOT
BETWEEN     LIKE
IN          ORDER BY
OR          GROUP BY

--IN Operator example--
Select 
    CustomerId,
    BillingAddress,
    SupplierId
From Products
Where SupplierId IN (9,10,11);
        --same as BETWEEN but looking for certain values

= Equal
<> Not equal: also some versions of SQL -> !=
> Greater than
< Less than
>= Greater or equal to
<= Less than or equal to
BETWEEN
IS NULL

--wildcards (can only be used with Strings)--
% Wildcard
'%Pizza'    Grabs anything ending with pizza
'Pizza%'    Grabs anything after pizza
'%Pizza%'   Grabs anything before and after pizza
eg. 't%@gmail.com'  Grabs email address starting with 't' and
                                is a @gmail.com address
-ve: Wildcards have a longer running time, other operators are preferred.
** USE WILDCARD FOR INT
Select
job_code,
pay_type
FROM salary_range_by_job_classification
WHERE job_code LIKE '03%';

/*
Exist but may not be supported by all versions of SQL
_ Wildcard
[] Wildcard
*/

--Sorting with ORDER BY--
** Must be the last clause in SELECT statement!
** Can sort by a column not retrieved!
Sort direction:
DESC / ASC

--math operators--
SELECT 
    ProductId,
    Quantity,
    UnitPrice,
    Discount,
    (UnitPrice-Discount)/Quantity AS Total_Cost
FROM OrderDetails;

--aggregate functions(summarises data)--
functions:
AVG()
COUNT()
MIN()
MAX()
SUM()

eg.
SELECT AVG(UnitPrice) AS avg_price
FROM products;      --same for other functions

--Using DISTINCT on aggregate functions (to ignore duplicates)--
** cannot be used with COUNT(*)
SELECT COUNT(DISTINCT CustomerId)
FROM Customers;

--Grouping Data--
GROUP BY - does not sort **needed only if calculating aggregates by group
ORDER BY - sort
eg.
SELECT SupplierID,
        COUNT(*) AS Num_Prod
FROM Products
WHERE UnitPrice >= 4
GROUP BY SupplierID
HAVING COUNT(*) >= 2;

WHERE - filters before data is grouped
vs
HAVING - filters after data is groupeds


--Subquery Best practices and Considerations--
** selects can only select a single column
SELECT COUNT(*) AS orders
FROM Orders
WHERE customer_id = '143569';

SELECT customer_name,
        customer_state,
        (SELECT COUNT(*) AS orders
        FROM Orders
        WHERE Orders.customer_id) AS orders
FROM customers
ORDER BY Customer_name

--Joining Tables--
1. Cartesian(Cross) Join
SELECT product_name,
        unit_price,
        company_name
FROM suppliers/*Table 1*/ CROSS JOIN products/*Table 2*/;

2. Inner Joins(Select records that have matching values in both tables)
SELECT suppliers.CompanyName,
        product_name,
        unit_price,
FROM Supppliers INNER JOIN  Products
ON Suppliers.supplierid = Products.supplierid
    --prequalify; similar to declaration
SELECT o.OrderID, c.CompanyName, e.LastName
FROM ((Orders o INNER JOIN Customers c ON o.CustomerID = c.CustomerID)
INNER JOIN Employees e ON o.EmployeeID = e.EmployeeID);

3. Self Joins(Use alias when joining table with itself)
SELECT A.CustomerName AS CustomerName1,
        B.CustomerName AS CustomerName2,
        A.City
FROM Customers A, Customers B
WHERE A.CustomerID = B.CustomerID AND A.City = B.City
ORDER BY A.City;

--Advanced Joins: Left, Right and Full Outer Joins--
--only left join is avail in SQLite
*Left Join - returns all information from left table
Table A and Table B intersect for some values
left join gives -> B' & A(intersect)B
right join gives -> A(intersect)B & A'
full outer join gives -> records with a match in EITHER table!

--left JOIN
SELECT C.CustomerName, O.OrderID
FROM Customers C
LEFT JOIN Orders O ON C.CustomerID = O.CustomerID
ORDER BY C.CustomerName;

--right JOIN -- *same as switching tables around and doing LEFT JOIN
SELECT Orders.OrderID
Employees.LastName,
Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;

--Union JOIN
*columns must be in the same order
*data types must be the same

SELECT City, Country FROM Customers
WHERE Country='Germany'             -- WHERE Statement not required
UNION                               -- only exists here to limit to 'Germany'
SELECT City, Country FROM Suppliers
WHERE Country='Germany'
ORDER BY City;

--Working with Text Strings--
**String functions:
1. concatenate
SELECT CompanyName, ContactName,
        CompanyName || '('|| ContactName||')'
FROM customers
/* SQL server supports '+' for concat instead of '||' */

2. TRIM, RTRIM, LTRIM (removes whitespace)
SELECT TRIM("    You the best    ") AS TrimmedString;

3. substring
** SUBSTR(string name, string pos, no. of char to be returned);
** string pos does not start with 0, range = (0,length of string]
SELECT first_name, SUBSTR(first_name, 2, 3)
FROM employees
WHERE department_id=60;

4. upper,lower
SELECT UPPER(col_name) FROM table_name;
SELECT LOWER(col_name) FROM table_name;
SELECT UCASE(col_name) FROM table_name; --does the same as UPPER

--Working with Date and Time Strings--
**check DBMS format

5 SQLite Date  Time Functions:

DATE(timestring, modifier, modifier, ...)
TIME(timestring, modifier, modifier, ...)
DATETIME(timestring, modifier, modifier, ...)
JULIANDAY(timestring, modifier, modifier, ...)
STRFTIME(format, timestring, modifier, modifier, ...) --string formst time function
                                                    -- to extract certain elements of a date/time strin

eg.
SELECT Birthdate,
        STRFTIME('%Y', Birthdate) AS Year,
        STRFTIME('%m', Birthdate) AS Month,
        STRFTIME('%d', Birthdate) AS Day,
        DATE(('now') - Birthdate) AS Age
FROM employees

--compute current date
SELECT DATE('now')
SELECT STRFTIME('%Y %m %d', 'now')
SELECT STRFTIME('%H %M %S %s', 'now')

--Case Statements--
**mimics if-else statements
**used in SELECT, INSERT, UPDATE, DELETE

CASE input_expression
WHEN C1 THEN E1
WHEN C2 THEN E2
...
ELSE [result else]
END

example1:
SELECT employeeid, firstname, lastname, city,
        CASE City
            WHEN 'Calgary' THEN 'Calgary'
        ELSE 'Other' --(else's result)
            END calgary --(col name)
FROM Employees
ORDER BY LastName, FirstName;

example2:
SELECT trackid, name, bytes,
        CASE
        WHEN bytes < 300000 THEN 'small'
        WHEN bytes >= 300001 AND bytes <= 500000 THEN 'medium'
        WHEN bytes >= 500001 THEN 'large'
        ELSE 'Other'
        END bytescategory
FROM tracks;

--Views--
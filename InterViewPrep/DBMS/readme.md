# What is Data:-
- Data is nothing but the Raw Facts. 

# What is information?

- When we process a Data that form a meaningful data that is information
- or else we also called process data is called information.

# what is Database
- database is nothing but the storing or collections of the large amount of data

# what is DBMS

- Database management System readymade s/w that help you to manage your data.
- for eg.- MS. Excel

# 📘 SQL & NoSQL Basics

This document summarizes the fundamental concepts of SQL and NoSQL databases, including constraints and SQL command categories (DDL & DML).

---

## 🔹 What is SQL?
- **SQL (Structured Query Language)** is used in **Relational Databases (RDBMS)**.
- Data is stored in **tables (rows & columns)** with a fixed schema.
- Examples: **MySQL, PostgreSQL, Oracle, SQL Server**.

✅ Best for **structured data, transactions, and complex queries**.

---

## 🔹 What is NoSQL?
- **NoSQL (Not Only SQL)** databases are **non-relational** and store data in flexible formats.
- Data models:
  - **Document** → MongoDB
  - **Key-Value** → Redis
  - **Column** → Cassandra
  - **Graph** → Neo4j

✅ Best for **unstructured/big data, real-time apps, high scalability**.

---

## 🔹 SQL vs NoSQL (Comparison)

| Feature       | SQL (Relational DB)             | NoSQL (Non-Relational DB)      |
|--------------|---------------------------------|--------------------------------|
| Data Model   | Tables (rows & columns)         | Document, Key-Value, Graph, etc. |
| Schema       | Fixed schema                    | Flexible / Schema-less         |
| Properties   | ACID (consistency, reliability) | BASE (availability, scalability) |
| Scalability  | Vertical scaling                | Horizontal scaling             |
| Best For     | Banking, ERP, Inventory         | Social Media, IoT, Big Data    |

---

## 🔹 Constraints in MySQL
Constraints ensure **data integrity and validity**.

1. **NOT NULL** → Prevents `NULL` values
2. **DEFAULT** → Assigns a default value
3. **UNIQUE** → Ensures unique values in a column
4. **PRIMARY KEY** → Unique + Not Null (main identifier)
5. **FOREIGN KEY** → Enforces relationship between tables
6. **CHECK** → Ensures values meet a condition (MySQL 8.0+)
7. **AUTO_INCREMENT** → Generates sequential values

---

## 🔹 SQL Command Categories

### 🟢 DDL (Data Definition Language)
- Defines or modifies **database structure**.
- Commands:
  - `CREATE` → Create tables/databases
  - `ALTER` → Modify structure
  - `DROP` → Delete tables/databases
  - `TRUNCATE` → Remove all rows but keep table

📌 Example:
```sql
CREATE TABLE Students (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  age INT
);
🟢 DML (Data Manipulation Language)
Works with data inside tables.

Commands:

INSERT → Add new rows

UPDATE → Modify existing data

DELETE → Remove rows

SELECT → Retrieve data

📌 Example:

sql
Copy
Edit
INSERT INTO Students (id, name, age) VALUES (1, 'Rahul', 21);
SELECT * FROM Students;
✅ Quick Memory Tricks
DDL → Design (structure of database).

DML → Manipulate (data inside tables).

SQL → Structured & strict.


🔹 Common MySQL Keywords
🟢 1. DISTINCT

Removes duplicate values from the result set.

SELECT DISTINCT city FROM Customers;


👉 Returns unique city names only.

🟢 2. LIMIT

Restricts the number of rows returned.

SELECT * FROM Customers LIMIT 5;


👉 Returns only first 5 rows.

🟢 3. ORDER BY

Sorts results in ascending (ASC, default) or descending (DESC).

SELECT name, age FROM Students ORDER BY age DESC;


👉 Returns students sorted by age (highest first).

🟢 4. WHERE

Filters rows based on a condition.

SELECT * FROM Employees WHERE salary > 50000;

🟢 5. GROUP BY

Groups rows having the same values in a column (used with aggregate functions).

SELECT department, COUNT(*)
FROM Employees
GROUP BY department;

🟢 6. HAVING

Filters groups (like WHERE, but for aggregated results).

SELECT department, AVG(salary)
FROM Employees
GROUP BY department
HAVING AVG(salary) > 60000;

🟢 7. BETWEEN

Checks if a value is within a range (inclusive).

SELECT * FROM Products WHERE price BETWEEN 100 AND 500;

🟢 8. IN

Checks if a value matches any in a list.

SELECT * FROM Employees WHERE department IN ('HR', 'IT', 'Finance');

🟢 9. LIKE (with Wildcards)

Used for pattern matching.

% → any sequence of characters.

_ → single character.

SELECT * FROM Customers WHERE name LIKE 'R%';   -- starts with R
SELECT * FROM Customers WHERE name LIKE '%sh';  -- ends with sh

🟢 10. IS NULL / IS NOT NULL

Checks for NULL values.

SELECT * FROM Orders WHERE delivery_date IS NULL;

🟢 11. ALIAS (AS)

Gives temporary names to columns/tables.

SELECT name AS student_name FROM Students;

🟢 12. JOIN (INNER, LEFT, RIGHT, FULL)

Combines rows from multiple tables.

SELECT s.name, d.dept_name
FROM Students s
INNER JOIN Departments d ON s.dept_id = d.dept_id;

🟢 13. UNION / UNION ALL

Combines results of two queries.

UNION removes duplicates, UNION ALL keeps them.

SELECT city FROM Customers
UNION
SELECT city FROM Suppliers;

🟢 14. EXISTS

Checks if a subquery returns rows.

SELECT * FROM Employees e
WHERE EXISTS (SELECT 1 FROM Departments d WHERE d.dept_id = e.dept_id);

🟢 15. CASE (conditional statements)

Works like if-else.

SELECT name,
       CASE
         WHEN marks >= 40 THEN 'Pass'
         ELSE 'Fail'
       END AS result
FROM Students;


✅ Quick Summary of Useful MySQL Keywords

Remove duplicates → DISTINCT

Limit rows → LIMIT

Sorting → ORDER BY

Filtering → WHERE, BETWEEN, IN, LIKE, IS NULL

Grouping & Aggregates → GROUP BY, HAVING

Combining tables → JOIN, UNION

Conditions → CASE, EXISTS

🔹 Not Equal Operators in SQL
🟢 1. <>

This is the standard SQL way to check for inequality.

SELECT * FROM Employees WHERE salary <> 50000;


👉 Returns rows where salary is not 50000.

🟢 2. !=

This also works in MySQL, SQL Server, PostgreSQL, Oracle (modern versions).

SELECT * FROM Employees WHERE salary != 50000;

🔹 Difference between <> and !=

Functionally: No difference in MySQL → both mean "not equal".

Standard SQL prefers <>, but developers often use != (more familiar from programming languages).

🔹 Special Note: NULL Values

In SQL, comparing with NULL using <> or != will not work, because NULL means "unknown".

❌ Wrong:

SELECT * FROM Employees WHERE salary != NULL;   -- won't return results


✅ Correct:

SELECT * FROM Employees WHERE salary IS NOT NULL;

✅ Summary

<> → Standard SQL "not equal"

!= → Works in MySQL and many other DBs

For NULL checks → Use IS NULL / IS NOT NULL

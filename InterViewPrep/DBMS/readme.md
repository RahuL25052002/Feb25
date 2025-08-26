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

```

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










A **CHECK constraint** in SQL (including MySQL) is used to **limit the values** that can be stored in a column based on a logical condition.

----------

## **Definition:**

-   It ensures that **only valid data** (as per your rule) can be inserted or updated in a table.

-   If the condition in the `CHECK` constraint evaluates to **FALSE**, the operation is rejected.


----------

## **Key Points:**

1.  The condition inside a CHECK must return **TRUE** for the row to be accepted.

2.  Can be applied **on a single column** or **across multiple columns**.

3.  Helps maintain **data integrity**.


----------

## **Example 1: CHECK on a single column**

`CREATE  TABLE Employees (
    emp_id INT  PRIMARY KEY,
    emp_name VARCHAR(50),
    age INT  CHECK (age >=  18)
);`

-   Here, `age` must be **18 or above**.

-   If you try:


`INSERT  INTO Employees VALUES (1, 'Rahul', 16);`

It will fail because `age < 18`.

----------

## **Example 2: CHECK with multiple columns**

`CREATE  TABLE Accounts (
    account_id INT  PRIMARY KEY,
    balance DECIMAL(10,2),
    min_balance DECIMAL(10,2), CHECK (balance >= min_balance)
);`

-   Ensures `balance` is **always greater than or equal to** `min_balance`.


----------

## **Important Notes in MySQL:**

-   MySQL **supports CHECK constraints** (since version 8.0.16).
    In earlier versions, CHECK syntax was parsed but **ignored**.

-   If you're using an older MySQL version, you’d need to enforce such checks via **triggers** instead.


----------

## **Why use CHECK constraint?**

-   Prevents invalid data entry (e.g., negative salary, age below 0).

-   Reduces chances of logical errors in your application.

-   Enforces business rules at the **database level**.


## **What is view??**

- View is Hard Disk pointer stored actual address of the table.
- Also known as **Locator** .


## **1) When are DML operations allowed on a view?**

A **view must be "updatable"** for DML operations to work.
MySQL allows DML on a view if:

-   The view is based on **a single table** (not multiple tables with joins).

-   The view does **not contain**:

    -   `DISTINCT`

    -   `GROUP BY` or aggregate functions (`SUM()`, `AVG()`, etc.)

    -   `UNION` or `UNION ALL`

    -   Subqueries in the `SELECT` or `WHERE` clause

    -   `LIMIT` or `OFFSET`

-   The view selects columns directly from the base table (no derived/calculated columns using expressions).


If these conditions are met, DML changes in the view reflect directly in the **underlying base table**.

----------

### **Example: Updatable View**

`CREATE  VIEW emp_view AS  SELECT emp_id, emp_name, salary FROM Employees WHERE salary >  30000;`

Now you can perform:

`UPDATE emp_view SET salary =  60000  WHERE emp_id =  1;`

This will update the `Employees` table directly.

----------

## **2) When are DML operations NOT allowed?**

-   If the view is based on **multiple tables (joins)**.

-   If the view has **aggregations** (e.g., `SUM(salary)`).

-   If the view includes **DISTINCT, GROUP BY, HAVING, UNION** etc.

-   If the view has **calculated columns** or subqueries.


For such cases, MySQL throws an error like:

> _"The target table is not updatable."_

----------

## **3) Special Case: WITH CHECK OPTION**

-   When creating a view with `WITH CHECK OPTION`, MySQL enforces that **DML operations do not violate the view's WHERE condition**.


Example:

`CREATE  VIEW emp_view AS  SELECT emp_id, emp_name, salary FROM Employees WHERE salary >  30000  WITH  CHECK OPTION;`

Now:

`UPDATE emp_view SET salary =  20000  WHERE emp_id =  1; -- ERROR`

Because the new value violates the view’s condition (`salary > 30000`).

----------

## **4) DELETE and INSERT on Views**

-   **DELETE:** Works if the view is updatable.

-   **INSERT:** Works if all NOT NULL columns in the base table are available in the view.


----------

## **Key Takeaway:**

-   **DML on views is possible but only if the view is simple and meets MySQL’s updatable view rules.**

-   Changes via the view **directly affect the base table**.

## **If you Drop the Table the view remain


### **What happens if you drop a base table used by a view?**

1.  **In MySQL (and most RDBMS):**

    -   The view definition is still stored in the database metadata.

    -   But since the view depends on the dropped table, the view becomes **invalid**.

    -   If you try to query it, MySQL will throw an error like:

        `ERROR 1356 (HY000): View  'view_name'  references invalid table(s) or  column(s) or  function(s) or  definer/invoker  of  view lack rights`

    -   So, it exists in name but cannot be used until the base table is recreated (with the same structure) or the view is dropped/altered.

2.  **If you drop the table first:**

    -   The view definition still appears in `information_schema.VIEWS`.

    -   But it becomes non-functional.

3.  **If you drop the view first:**

    -   The base table remains unaffected (views don't store data, so they don't delete table data).


----------

### **Best Practice:**

-   Drop dependent views **before** dropping the underlying tables to avoid broken objects.

-   Or use `DROP VIEW IF EXISTS view_name;` before altering or dropping the table.


----------

### **Key Takeaway:**

-   Dropping a table **does not automatically drop the view**.

-   The view remains in the database **but is invalid and unusable** until the underlying table exists again.





**Normalization** is a **database design technique** used to **organize data efficiently** by reducing redundancy (duplicate data) and ensuring data integrity. It involves structuring tables and their relationships according to certain rules called **normal forms**.

----------

## **Why is Normalization Needed?**

-   To **avoid storing the same data multiple times** (reduces storage cost).

-   To **prevent anomalies** during `INSERT`, `UPDATE`, and `DELETE` operations.

-   To **maintain data consistency** across the database.


----------

## **How Normalization Works:**

-   A large, unorganized table is split into **smaller related tables**.

-   These tables are linked using **keys** (primary and foreign keys).

-   Data duplication is minimized, and dependencies are properly defined.


----------

## **Normal Forms (Stages of Normalization):**

1.  **1NF (First Normal Form):**

    -   No repeating groups or arrays.

    -   Each cell contains a single value (atomic).

2.  **2NF (Second Normal Form):**

    -   Must be in 1NF.

    -   No partial dependency (non-key attributes depend on the entire primary key).

3.  **3NF (Third Normal Form):**

    -   Must be in 2NF.

    -   No transitive dependency (non-key attributes depend only on the primary key, not on other non-key attributes).

4.  **BCNF (Boyce-Codd Normal Form):**

    -   Stronger version of 3NF; handles cases where 3NF is not sufficient.


(Higher normal forms like 4NF, 5NF exist but are used in more complex scenarios.)

----------

## **Benefits of Normalization:**

-   Eliminates redundancy.

-   Improves data consistency and integrity.

-   Makes maintenance easier.


----------

## **Drawbacks (Trade-off):**

-   More tables → More joins needed in queries (can affect performance in some cases).

-   Sometimes denormalization (adding some redundancy back) is done for faster queries.


----------

**In summary:**
Normalization is about **organizing data into multiple related tables with minimal redundancy and maximum integrity**.

## **Example Scenario:**

We have a single unorganized table storing student and course details:


StudentCourses
--------------------------------------------------------
```
| student_id | student_name | course_name | instructor  |

| 1          | Rahul        | DBMS        | Mr. Sharma  |
| 1          | Rahul        | Networks    | Ms. Aisha   |
| 2          | Aisha        | DBMS        | Mr. Sharma  |
```

----------

### **Problems with This Table (Without Normalization):**

1.  **Redundancy:** Rahul’s name is repeated.

2.  **Update anomaly:** If Rahul changes his name, we need to update multiple rows.

3.  **Delete anomaly:** If we delete all Rahul’s courses, his name disappears from the DB.

4.  **Insert anomaly:** Cannot insert a new student until they register for a course.


----------

## **Normalized Version**

### **Step 1: 1NF (Atomic values, remove repeating groups)**

Separate students and courses into different tables.

`### Students Table
 | student_id | student_name |
|------------|--------------|
| 1          | Rahul        |
| 2          | Aisha        |

### Courses Table
| course_id | course_name | instructor  |
|-----------|-------------|-------------|
| C1        | DBMS        | Mr. Sharma  |
| C2        | Networks    | Ms. Aisha   |

### Student_Course Table (Mapping/Relationship)
| student_id | course_id |
|------------|-----------|
| 1          | C1        |
| 1          | C2        |
| 2          | C1        |`

Now each piece of data is stored once, and relationships are maintained via **foreign keys**.

----------

### **Step 2: 2NF and 3NF (Eliminate partial and transitive dependencies)**

Our example already satisfies 2NF and 3NF because:

-   All non-key attributes depend fully on the primary key.

-   No non-key attributes depend on other non-key attributes.


----------


`# Database Normalization Example

  ## What is Normalization?
- Normalization is a database design technique used to organize data efficiently, reduce redundancy, and maintain data integrity. It involves splitting large tables into smaller related tables and defining relationships between them.

--- ## Unnormalized Table
 | student_id | student_name | course_name | instructor  |
|------------|--------------|-------------|-------------|
| 1          | Rahul        | DBMS        | Mr. Sharma  |
| 1          | Rahul        | Networks    | Ms. Aisha   |
| 2          | Aisha        | DBMS        | Mr. Sharma  |

### Problems:
- Redundant data (student name repeated)
- Update anomalies
- Delete anomalies
- Insert anomalies

---

## Normalized Tables

### Students Table
| student_id | student_name |
|------------|--------------|
| 1          | Rahul        |
| 2          | Aisha        |

### Courses Table
| course_id | course_name | instructor  |
|-----------|-------------|-------------|
| C1        | DBMS        | Mr. Sharma  |
| C2        | Networks    | Ms. Aisha   |

### Student_Course Table (Mapping)
| student_id | course_id |
|------------|-----------|
| 1          | C1        |
| 1          | C2        |
| 2          | C1        |

--- ## Benefits of Normalization:
 - Eliminates duplicate data.
 -   Ensures data consistency.
 - Avoids anomalies during insert, update, and delete operations.

--- ## Normal Forms Covered:
 -  **1NF:** Atomic values, no repeating groups.
 -    **2NF:** No partial dependency on part of a composite key.
 -  **3NF:** No transitive dependency; non-key attributes depend only on the primary key.`


 # SQL Triggers

## What is a Trigger?
A **trigger** is a special stored program in SQL that **automatically executes (fires)** when a specified event occurs on a table or view.
It runs **without being explicitly called**, and is tied to a specific table and event.

---

## Types of Triggers in MySQL
MySQL supports the following trigger types:

- **BEFORE INSERT**: Fires before a new row is inserted.
- **AFTER INSERT**: Fires after a new row is inserted.
- **BEFORE UPDATE**: Fires before a row is updated.
- **AFTER UPDATE**: Fires after a row is updated.
- **BEFORE DELETE**: Fires before a row is deleted.
- **AFTER DELETE**: Fires after a row is deleted.

---

## OLD vs NEW in Triggers
- **`NEW.column_name`** → Refers to the new value (for `INSERT` or `UPDATE` triggers).
- **`OLD.column_name`** → Refers to the existing value (for `UPDATE` or `DELETE` triggers).

---

## Example: AFTER INSERT Trigger for Logging

```sql
CREATE TABLE Students (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE Students_Log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    action VARCHAR(50),
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Trigger
DELIMITER $$
CREATE TRIGGER after_student_insert
AFTER INSERT ON Students
FOR EACH ROW
BEGIN
    INSERT INTO Students_Log (student_id, action)
    VALUES (NEW.id, 'Inserted');
END$$
DELIMITER ;
```

---

## Advantages of Triggers
- **Automation:** Executes automatically without manual intervention.
- **Enforces Business Rules:** Ensures certain actions happen on data changes (like validations or audits).
- **Maintains Data Integrity:** Helps keep related tables consistent (e.g., cascading updates).
- **Audit & Logging:** Automatically tracks changes for monitoring purposes.
- **Centralized Logic:** Rules are stored in the database rather than application code.

---

## Disadvantages of Triggers
- **Hidden Logic:** Operations happen automatically, making debugging harder.
- **Performance Overhead:** Too many triggers can slow down DML operations.
- **Complexity:** Managing multiple triggers can become difficult.
- **Limited Scope:** Triggers are tied to one table; cross-table logic may require more effort.
- **Unintended Consequences:** If not carefully written, triggers can lead to unexpected data changes (like infinite loops if triggers call each other indirectly).

---

## Best Practices
- Keep triggers **simple and lightweight**.
- Use them mainly for **auditing, validation, or enforcing constraints**.
- Document all triggers to avoid confusion.


# MySQL Stored Procedures (MySQL-PL) - Complete Guide

## Table of Contents
- [What is MySQL-PL / Stored Procedure?](#what-is-mysql-pl--stored-procedure)
- [Why Use Stored Procedures?](#why-use-stored-procedures)
- [Basic Syntax](#basic-syntax)
- [Examples](#examples)
- [Edge Cases](#edge-cases-to-consider)
- [Advantages & Disadvantages](#advantages-and-disadvantages)
- [Comparison with Normal SQL](#comparison-stored-procedure-vs-normal-sql)
- [Best Practices](#best-practices)

---

## What is MySQL-PL / Stored Procedure?

**MySQL-PL (Procedural Language)** allows writing procedural code (logic like loops, conditions, variables) inside the database server.

A **stored procedure** is a saved set of SQL statements that can be executed later by calling it with a simple command. Instead of sending multiple SQL queries from your application, you can encapsulate complex logic inside the database itself.

**Key Characteristics:**
- Pre-compiled and stored in the database
- Can accept input parameters and return output parameters
- Supports control flow statements (IF, WHILE, LOOP, etc.)
- Can contain multiple SQL statements

---

## Why Use Stored Procedures?

### Benefits
- **🔄 Code Reusability**: Write once and reuse across multiple applications
- **⚡ Performance**: Reduces network round trips; logic runs directly in the database
- **🔒 Security**: Restrict direct table access and expose only specific procedures
- **🛠️ Maintainability**: Centralized logic in database instead of scattered across application code
- **📊 Data Integrity**: Complex business rules can be enforced at the database level

### Use Cases
- Complex data validation and transformation
- Batch processing operations
- Reporting and analytics
- Data migration tasks
- Audit logging

---

## Basic Syntax

### Creating a Stored Procedure

```sql
DELIMITER $$

CREATE PROCEDURE procedure_name (
    IN param1 datatype,
    OUT param2 datatype,
    INOUT param3 datatype
)
BEGIN
    -- SQL statements and procedural logic
    -- Variable declarations
    -- Control flow statements
END $$

DELIMITER ;
```

### Parameter Types
- **`IN`**: Input parameter (read-only within procedure)
- **`OUT`**: Output parameter (write-only, returns value to caller)
- **`INOUT`**: Input/Output parameter (can be read and modified)

### Calling a Stored Procedure
```sql
CALL procedure_name(param1, param2, ...);
```

---

## Examples

### Example 1: Simple Stored Procedure
**Task**: Fetch all students

```sql
DELIMITER $$

CREATE PROCEDURE GetAllStudents()
BEGIN
    SELECT student_id, name, email, marks
    FROM Students
    ORDER BY name;
END $$

DELIMITER ;
```

**Usage:**
```sql
CALL GetAllStudents();
```

### Example 2: Procedure with Input Parameter
**Task**: Fetch students with marks above a given value

```sql
DELIMITER $$

CREATE PROCEDURE GetStudentsAboveMarks(IN min_marks INT)
BEGIN
    SELECT name, marks, grade
    FROM Students
    WHERE marks > min_marks
    ORDER BY marks DESC;
END $$

DELIMITER ;
```

**Usage:**
```sql
CALL GetStudentsAboveMarks(75);
```

### Example 3: Procedure with Output Parameter
**Task**: Count total number of students

```sql
DELIMITER $$

CREATE PROCEDURE CountStudents(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM Students;
END $$

DELIMITER ;
```

**Usage:**
```sql
CALL CountStudents(@total);
SELECT @total AS 'Total Students';
```

### Example 4: Complex Procedure with Variables and Logic
**Task**: Update student grades based on marks

```sql
DELIMITER $$

CREATE PROCEDURE UpdateStudentGrades()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE student_id INT;
    DECLARE marks INT;
    DECLARE new_grade CHAR(1);

    DECLARE student_cursor CURSOR FOR
        SELECT id, marks FROM Students;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN student_cursor;

    grade_loop: LOOP
        FETCH student_cursor INTO student_id, marks;

        IF done THEN
            LEAVE grade_loop;
        END IF;

        -- Determine grade based on marks
        IF marks >= 90 THEN
            SET new_grade = 'A';
        ELSEIF marks >= 80 THEN
            SET new_grade = 'B';
        ELSEIF marks >= 70 THEN
            SET new_grade = 'C';
        ELSEIF marks >= 60 THEN
            SET new_grade = 'D';
        ELSE
            SET new_grade = 'F';
        END IF;

        UPDATE Students
        SET grade = new_grade
        WHERE id = student_id;

    END LOOP;

    CLOSE student_cursor;
END $$

DELIMITER ;
```

### Example 5: Procedure with Error Handling
**Task**: Safe student insertion with validation

```sql
DELIMITER $$

CREATE PROCEDURE InsertStudent(
    IN p_name VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_marks INT,
    OUT p_result VARCHAR(100)
)
BEGIN
    DECLARE email_exists INT DEFAULT 0;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SET p_result = 'Error: Transaction failed';
    END;

    START TRANSACTION;

    -- Check if email already exists
    SELECT COUNT(*) INTO email_exists
    FROM Students
    WHERE email = p_email;

    IF email_exists > 0 THEN
        SET p_result = 'Error: Email already exists';
        ROLLBACK;
    ELSEIF p_marks < 0 OR p_marks > 100 THEN
        SET p_result = 'Error: Invalid marks (0-100)';
        ROLLBACK;
    ELSE
        INSERT INTO Students (name, email, marks)
        VALUES (p_name, p_email, p_marks);

        COMMIT;
        SET p_result = 'Success: Student inserted';
    END IF;
END $$

DELIMITER ;
```

---

## Edge Cases to Consider

### 1. Delimiter Issues
**Problem**: MySQL treats `;` as statement terminator, causing issues with multi-statement procedures.
**Solution**: Use `DELIMITER` to change the statement delimiter temporarily.

```sql
-- ❌ Wrong
CREATE PROCEDURE test()
BEGIN
    SELECT 1;
    SELECT 2;
END;

-- ✅ Correct
DELIMITER $$
CREATE PROCEDURE test()
BEGIN
    SELECT 1;
    SELECT 2;
END $$
DELIMITER ;
```

### 2. NULL Handling
**Problem**: Comparisons with NULL don't work as expected.

```sql
-- ❌ Wrong - this won't work
WHERE column_name = NULL

-- ✅ Correct
WHERE column_name IS NULL
-- or
WHERE column_name IS NOT NULL
```

### 3. Variable Scope
**Problem**: Variable names conflicting with column names.

```sql
-- ❌ Potential issue
DECLARE name VARCHAR(100);
SELECT name FROM Students; -- Which 'name'?

-- ✅ Better approach
DECLARE v_name VARCHAR(100);
DECLARE p_student_id INT;
```

### 4. Transaction Handling
**Problem**: Procedures inside transactions need proper error handling.

```sql
DELIMITER $$
CREATE PROCEDURE SafeTransfer(IN from_id INT, IN to_id INT, IN amount DECIMAL(10,2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL; -- Re-throw the exception
    END;

    START TRANSACTION;
    -- Transfer logic here
    COMMIT;
END $$
DELIMITER ;
```

### 5. Privilege Issues
Ensure users have appropriate privileges:
```sql
-- Grant procedure creation privilege
GRANT CREATE PROCEDURE ON database_name.* TO 'username'@'localhost';

-- Grant execution privilege
GRANT EXECUTE ON PROCEDURE database_name.procedure_name TO 'username'@'localhost';
```

### 6. Recursive Calls
MySQL has limited support for recursion. Use iterative approaches when possible.

---

## Advantages and Disadvantages

### ✅ Advantages

| Benefit | Description |
|---------|-------------|
| **Performance** | Pre-compiled, executes inside DB server, reduces network overhead |
| **Reusability** | Write once, use across multiple applications and contexts |
| **Security** | Encapsulates data access, prevents SQL injection, role-based access |
| **Maintainability** | Centralized business logic, easier to update and manage |
| **Data Integrity** | Complex validation rules enforced at database level |
| **Network Traffic** | Reduces data transfer between application and database |

### ❌ Disadvantages

| Drawback | Description |
|----------|-------------|
| **Debugging** | Limited debugging tools compared to application code |
| **Version Control** | Harder to track changes and manage across environments |
| **Vendor Lock-in** | Database-specific syntax, migration complexity |
| **Scalability** | Can become bottleneck if overused for business logic |
| **Testing** | More complex unit testing compared to application code |
| **Resource Usage** | Heavy procedures can consume database server resources |

---

## Comparison: Stored Procedure vs Normal SQL

| Feature | Normal SQL Queries | Stored Procedures |
|---------|-------------------|------------------|
| **Execution Location** | Sent from application each time | Runs inside database server |
| **Performance** | Slower (network overhead) | Faster (reduced network calls) |
| **Compilation** | Parsed every execution | Pre-compiled and cached |
| **Reusability** | Low (scattered in code) | High (centralized in DB) |
| **Security** | Exposes table structure | Encapsulates data access |
| **Maintenance** | Scattered across application | Centralized in database |
| **Debugging** | Application debugging tools | Limited DB debugging |
| **Version Control** | Easy with application code | Complex database versioning |
| **Portability** | More portable across DBs | Database-specific |

---

## Best Practices

### 🎯 Design Principles

1. **Single Responsibility**: Each procedure should have one clear purpose
2. **Modular Design**: Break complex operations into smaller procedures
3. **Clear Naming**: Use descriptive names (e.g., `GetStudentsByGrade`, `UpdateInventoryLevels`)

### 📝 Coding Standards

```sql
-- Use consistent naming convention
CREATE PROCEDURE sp_GetStudentReport() -- or GetStudentReport()

-- Document parameters clearly
CREATE PROCEDURE UpdateStudentMarks(
    IN p_student_id INT,      -- Student ID to update
    IN p_new_marks INT,       -- New marks value (0-100)
    OUT p_result_message VARCHAR(255) -- Success/error message
)

-- Handle errors gracefully
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    GET DIAGNOSTICS CONDITION 1
        @sqlstate = RETURNED_SQLSTATE,
        @errno = MYSQL_ERRNO,
        @text = MESSAGE_TEXT;
    SET p_result_message = CONCAT('Error: ', @text);
END;
```

### 🔒 Security Guidelines

1. **Input Validation**: Always validate input parameters
2. **Principle of Least Privilege**: Grant minimal necessary permissions
3. **Avoid Dynamic SQL**: When possible, use static SQL to prevent injection

### 🚀 Performance Tips

1. **Use Indexes**: Ensure procedures use appropriate indexes
2. **Limit Result Sets**: Don't return unnecessary data
3. **Batch Operations**: Group related operations when possible
4. **Monitor Performance**: Regular review of procedure execution times

### 🧪 Testing Strategy

```sql
-- Example test procedure
DELIMITER $$
CREATE PROCEDURE test_UpdateStudentMarks()
BEGIN
    DECLARE test_result VARCHAR(255);

    -- Test valid input
    CALL UpdateStudentMarks(1, 85, test_result);
    SELECT 'Valid input test' as test_case, test_result;

    -- Test invalid input
    CALL UpdateStudentMarks(1, 150, test_result);
    SELECT 'Invalid marks test' as test_case, test_result;
END $$
DELIMITER ;
```

### 📋 Maintenance Checklist

- [ ] Regular performance monitoring
- [ ] Update documentation when procedures change
- [ ] Version control for procedure definitions
- [ ] Regular backup of procedure definitions
- [ ] Review and optimize based on usage patterns

---

## Conclusion

Stored procedures are powerful tools for encapsulating database logic, improving performance, and maintaining data integrity. While they come with some limitations, when used appropriately and following best practices, they can significantly enhance your database-driven applications.

**When to Use Stored Procedures:**
- Complex data processing that benefits from reduced network overhead
- Frequently executed operations that can benefit from pre-compilation
- Critical business logic that needs to be enforced at the database level
- Operations requiring strong data consistency and transaction control

**When to Avoid:**
- Simple CRUD operations that can be handled efficiently by the application
- Logic that needs frequent changes and rapid deployment
- Applications requiring high portability across different database systems








# MySQL Cursors - Complete Guide

## Table of Contents
- [What is a Cursor?](#what-is-a-cursor)
- [Why Do We Need Cursors?](#why-do-we-need-cursors)
- [How Cursors Work](#how-cursors-work)
- [Cursor Lifecycle](#cursor-lifecycle)
- [Basic Syntax](#basic-syntax)
- [Detailed Examples](#detailed-examples)
- [Cursor Types](#cursor-types)
- [Performance Considerations](#performance-considerations)
- [Best Practices](#best-practices)
- [Alternatives to Cursors](#alternatives-to-cursors)

---

## What is a Cursor?

A **cursor** is a database object that allows you to **process query results row by row** instead of all at once. Think of it as a "pointer" that moves through the result set one record at a time.

### 🎯 Simple Analogy
Imagine you have a book (result set) and a bookmark (cursor):
- The bookmark points to one page (row) at a time
- You can move the bookmark forward to read the next page
- You process each page individually rather than trying to read the entire book at once

### Real-World Example
```sql
-- Without cursor: Gets ALL students at once
SELECT * FROM Students WHERE grade = 'A';

-- With cursor: Process each student one by one
-- Useful when you need to perform individual operations on each row
```

---

## Why Do We Need Cursors?

### 🤔 The Problem
Regular SQL operates on **entire result sets** at once:

```sql
-- This updates ALL students at once
UPDATE Students SET status = 'graduated' WHERE grade = 'A';
```

But sometimes you need to:
- Process each row differently based on its data
- Perform complex calculations row by row
- Handle each record with different business logic
- Avoid memory issues with large datasets

### 💡 The Solution: Cursors
Cursors allow **row-by-row processing**:

```sql
-- Process each student individually
-- Different logic for each student based on their specific data
FOR EACH student IN (SELECT * FROM Students WHERE grade = 'A')
DO
    -- Custom logic for THIS specific student
    -- Maybe different actions based on student's age, marks, etc.
END FOR
```

### When to Use Cursors

| ✅ Use Cursors When | ❌ Avoid Cursors When |
|---------------------|----------------------|
| Row-specific business logic needed | Simple bulk operations |
| Complex calculations per row | Standard aggregations (SUM, COUNT) |
| Different actions per row | Simple UPDATE/DELETE operations |
| Sequential processing required | Set-based operations work fine |
| Working with external systems | Performance is critical |

---

## How Cursors Work

### 🔄 The Cursor Process

```
1. DECLARE → Create cursor definition
2. OPEN    → Execute query and populate cursor
3. FETCH   → Get one row from cursor
4. PROCESS → Do something with that row
5. REPEAT  → Steps 3-4 until no more rows
6. CLOSE   → Release cursor resources
```

### Visual Representation

```
Query Result Set:
┌─────────────────────────────────┐
│ ID │ Name    │ Marks │ Grade   │
├────┼─────────┼───────┼─────────┤
│ 1  │ Alice   │ 95    │ A       │ ← Cursor starts here
│ 2  │ Bob     │ 87    │ B       │
│ 3  │ Charlie │ 92    │ A       │
│ 4  │ Diana   │ 78    │ C       │
└────┴─────────┴───────┴─────────┘

Cursor Processing:
Step 1: Fetch Row 1 (Alice) → Process → Move to next
Step 2: Fetch Row 2 (Bob)   → Process → Move to next
Step 3: Fetch Row 3 (Charlie) → Process → Move to next
Step 4: Fetch Row 4 (Diana) → Process → Done!
```

---

## Cursor Lifecycle

### 1. Declaration Phase
```sql
DECLARE cursor_name CURSOR FOR SELECT_statement;
```
- Defines what data the cursor will contain
- **No data is fetched yet** - just the definition

### 2. Handler Declaration
```sql
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
```
- Defines what happens when no more rows are available

### 3. Opening Phase
```sql
OPEN cursor_name;
```
- **Executes the SELECT statement**
- **Populates the cursor** with results
- Positions cursor **before the first row**

### 4. Fetching Phase
```sql
FETCH cursor_name INTO variable1, variable2, ...;
```
- **Gets the current row** data into variables
- **Moves cursor to next row**
- If no more rows, triggers the handler

### 5. Processing Phase
```sql
-- Your custom logic here using the fetched variables
IF condition THEN
    -- Do something
END IF;
```

### 6. Closing Phase
```sql
CLOSE cursor_name;
```
- **Releases resources**
- **Frees memory**
- Cursor becomes unusable until reopened

---

## Basic Syntax

### Standard Cursor Template
```sql
DELIMITER $$

CREATE PROCEDURE ProcessWithCursor()
BEGIN
    -- 1. Declare variables to hold row data
    DECLARE v_id INT;
    DECLARE v_name VARCHAR(100);
    DECLARE v_marks INT;

    -- 2. Declare control variable
    DECLARE done INT DEFAULT FALSE;

    -- 3. Declare the cursor
    DECLARE student_cursor CURSOR FOR
        SELECT id, name, marks FROM Students WHERE marks > 80;

    -- 4. Declare handler for end of cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- 5. Open cursor
    OPEN student_cursor;

    -- 6. Loop through cursor
    cursor_loop: LOOP
        -- Fetch next row
        FETCH student_cursor INTO v_id, v_name, v_marks;

        -- Exit if no more rows
        IF done THEN
            LEAVE cursor_loop;
        END IF;

        -- 7. Process the current row
        -- Your custom logic here
        INSERT INTO honor_roll (student_id, student_name, marks)
        VALUES (v_id, v_name, v_marks);

    END LOOP cursor_loop;

    -- 8. Close cursor
    CLOSE student_cursor;
END $$

DELIMITER ;
```

---

## Detailed Examples

### Example 1: Simple Row-by-Row Processing
**Task**: Give bonus marks to students based on their current performance

```sql
DELIMITER $$

CREATE PROCEDURE GiveBonusMarks()
BEGIN
    DECLARE v_student_id INT;
    DECLARE v_current_marks INT;
    DECLARE v_bonus INT DEFAULT 0;
    DECLARE done INT DEFAULT FALSE;

    -- Cursor for students who need bonus evaluation
    DECLARE bonus_cursor CURSOR FOR
        SELECT student_id, marks
        FROM Students
        WHERE marks BETWEEN 70 AND 95;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN bonus_cursor;

    bonus_loop: LOOP
        FETCH bonus_cursor INTO v_student_id, v_current_marks;

        IF done THEN
            LEAVE bonus_loop;
        END IF;

        -- Different bonus based on current marks
        CASE
            WHEN v_current_marks >= 90 THEN SET v_bonus = 3;
            WHEN v_current_marks >= 85 THEN SET v_bonus = 4;
            WHEN v_current_marks >= 80 THEN SET v_bonus = 5;
            ELSE SET v_bonus = 2;
        END CASE;

        -- Apply bonus (but don't exceed 100)
        UPDATE Students
        SET marks = LEAST(marks + v_bonus, 100)
        WHERE student_id = v_student_id;

        -- Log the bonus given
        INSERT INTO bonus_log (student_id, bonus_given, date_given)
        VALUES (v_student_id, v_bonus, NOW());

    END LOOP bonus_loop;

    CLOSE bonus_cursor;

    SELECT 'Bonus marks applied successfully' AS result;
END $$

DELIMITER ;
```

### Example 2: Complex Business Logic
**Task**: Generate personalized report cards with different calculations per student

```sql
DELIMITER $$

CREATE PROCEDURE GenerateReportCards()
BEGIN
    DECLARE v_student_id INT;
    DECLARE v_name VARCHAR(100);
    DECLARE v_math_score INT;
    DECLARE v_science_score INT;
    DECLARE v_english_score INT;
    DECLARE v_total_score INT;
    DECLARE v_average DECIMAL(5,2);
    DECLARE v_grade CHAR(1);
    DECLARE v_remarks TEXT;
    DECLARE done INT DEFAULT FALSE;

    DECLARE report_cursor CURSOR FOR
        SELECT student_id, name, math_score, science_score, english_score
        FROM Students
        WHERE active = 1;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Clear previous reports
    DELETE FROM report_cards WHERE report_date = CURDATE();

    OPEN report_cursor;

    report_loop: LOOP
        FETCH report_cursor INTO v_student_id, v_name, v_math_score, v_science_score, v_english_score;

        IF done THEN
            LEAVE report_loop;
        END IF;

        -- Calculate total and average
        SET v_total_score = v_math_score + v_science_score + v_english_score;
        SET v_average = v_total_score / 3;

        -- Determine grade
        CASE
            WHEN v_average >= 90 THEN SET v_grade = 'A';
            WHEN v_average >= 80 THEN SET v_grade = 'B';
            WHEN v_average >= 70 THEN SET v_grade = 'C';
            WHEN v_average >= 60 THEN SET v_grade = 'D';
            ELSE SET v_grade = 'F';
        END CASE;

        -- Generate personalized remarks
        SET v_remarks = '';

        -- Check individual subject performance
        IF v_math_score < 60 THEN
            SET v_remarks = CONCAT(v_remarks, 'Needs improvement in Mathematics. ');
        END IF;

        IF v_science_score < 60 THEN
            SET v_remarks = CONCAT(v_remarks, 'Focus more on Science concepts. ');
        END IF;

        IF v_english_score < 60 THEN
            SET v_remarks = CONCAT(v_remarks, 'Practice English communication. ');
        END IF;

        -- Positive remarks for good performance
        IF v_average >= 85 THEN
            SET v_remarks = CONCAT(v_remarks, 'Excellent performance! Keep it up. ');
        ELSEIF v_average >= 75 THEN
            SET v_remarks = CONCAT(v_remarks, 'Good work! Can do even better. ');
        END IF;

        -- Insert report card
        INSERT INTO report_cards (
            student_id, student_name, math_score, science_score, english_score,
            total_score, average_score, grade, remarks, report_date
        ) VALUES (
            v_student_id, v_name, v_math_score, v_science_score, v_english_score,
            v_total_score, v_average, v_grade, v_remarks, CURDATE()
        );

    END LOOP report_loop;

    CLOSE report_cursor;

    -- Return summary
    SELECT
        COUNT(*) AS total_reports,
        SUM(CASE WHEN grade = 'A' THEN 1 ELSE 0 END) AS a_grades,
        SUM(CASE WHEN grade = 'F' THEN 1 ELSE 0 END) AS failed_students
    FROM report_cards
    WHERE report_date = CURDATE();

END $$

DELIMITER ;
```

### Example 3: Cursor with Multiple Cursors (Nested)
**Task**: Process students by class, then process each student's subjects

```sql
DELIMITER $$

CREATE PROCEDURE ProcessStudentsByClass()
BEGIN
    -- Variables for outer cursor (classes)
    DECLARE v_class_id INT;
    DECLARE v_class_name VARCHAR(50);
    DECLARE done_classes INT DEFAULT FALSE;

    -- Variables for inner cursor (students)
    DECLARE v_student_id INT;
    DECLARE v_student_name VARCHAR(100);
    DECLARE done_students INT DEFAULT FALSE;

    -- Outer cursor: Get all classes
    DECLARE class_cursor CURSOR FOR
        SELECT class_id, class_name FROM Classes WHERE active = 1;

    -- Inner cursor: Get students for current class
    DECLARE student_cursor CURSOR FOR
        SELECT student_id, student_name
        FROM Students
        WHERE class_id = v_class_id;

    -- Handlers
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done_classes = TRUE;

    OPEN class_cursor;

    class_loop: LOOP
        FETCH class_cursor INTO v_class_id, v_class_name;

        IF done_classes THEN
            LEAVE class_loop;
        END IF;

        -- Reset student cursor flag
        SET done_students = FALSE;

        -- Process students in this class
        OPEN student_cursor;

        student_loop: LOOP
            -- Temporarily change handler scope
            BEGIN
                DECLARE CONTINUE HANDLER FOR NOT FOUND SET done_students = TRUE;

                FETCH student_cursor INTO v_student_id, v_student_name;

                IF done_students THEN
                    LEAVE student_loop;
                END IF;

                -- Process individual student
                INSERT INTO student_processing_log
                VALUES (v_student_id, v_class_id, v_class_name, NOW());

            END;
        END LOOP student_loop;

        CLOSE student_cursor;

    END LOOP class_loop;

    CLOSE class_cursor;

END $$

DELIMITER ;
```

---

## Cursor Types

### 1. Forward-Only Cursor (MySQL Default)
```sql
-- Can only move forward through result set
DECLARE cursor_name CURSOR FOR SELECT ...;
```

### 2. Read-Only Cursor (MySQL Default)
```sql
-- Cannot modify data through cursor
-- Use separate UPDATE statements
```

### 3. Static vs Dynamic
```sql
-- MySQL cursors are static - snapshot at OPEN time
-- Changes to underlying data after OPEN are not reflected
```

---

## Performance Considerations

### ⚠️ Performance Impact

| Aspect | Impact | Reason |
|--------|--------|--------|
| **Memory Usage** | HIGH | Stores entire result set |
| **CPU Usage** | HIGH | Row-by-row processing overhead |
| **Lock Duration** | HIGH | Longer transaction times |
| **Scalability** | LOW | Doesn't scale with large datasets |

### 📊 Performance Comparison

```sql
-- ❌ Slow: Cursor approach
DECLARE cursor_cursor CURSOR FOR SELECT id FROM Students;
-- Process 10,000 rows = 10,000 fetch operations

-- ✅ Fast: Set-based approach
UPDATE Students SET processed = 1 WHERE active = 1;
-- Process 10,000 rows = 1 operation
```

### 🚀 Optimization Tips

1. **Limit Result Set**
   ```sql
   -- Add WHERE clauses to reduce rows
   DECLARE cursor_name CURSOR FOR
       SELECT * FROM Students
       WHERE created_date >= '2023-01-01'  -- Limit scope
       LIMIT 1000;                         -- Batch processing
   ```

2. **Use Appropriate Indexes**
   ```sql
   -- Ensure cursor query uses indexes
   CREATE INDEX idx_student_date ON Students(created_date);
   ```

3. **Batch Processing**
   ```sql
   -- Process in smaller chunks
   DECLARE batch_cursor CURSOR FOR
       SELECT * FROM Students
       WHERE processed = 0
       ORDER BY id
       LIMIT 500;  -- Process 500 at a time
   ```

---

## Best Practices

### ✅ Do's

1. **Always Close Cursors**
   ```sql
   CLOSE cursor_name;  -- Prevents memory leaks
   ```

2. **Use Proper Error Handling**
   ```sql
   DECLARE EXIT HANDLER FOR SQLEXCEPTION
   BEGIN
       CLOSE cursor_name;  -- Clean up on error
       RESIGNAL;
   END;
   ```

3. **Limit Cursor Scope**
   ```sql
   -- Only fetch columns you need
   DECLARE cursor_name CURSOR FOR
       SELECT id, name FROM Students  -- Not SELECT *
       WHERE condition;
   ```

4. **Use Meaningful Variable Names**
   ```sql
   DECLARE v_student_id INT;      -- Clear naming
   DECLARE v_current_marks INT;   -- Descriptive
   ```

### ❌ Don'ts

1. **Don't Use for Simple Operations**
   ```sql
   -- ❌ Bad: Using cursor for simple update
   DECLARE cursor FOR SELECT id FROM Students;
   LOOP
       UPDATE Students SET active = 1 WHERE id = v_id;
   END LOOP;

   -- ✅ Good: Direct update
   UPDATE Students SET active = 1;
   ```

2. **Don't Forget Error Handling**
   ```sql
   -- ❌ Bad: No error handling
   OPEN cursor_name;
   -- What if this fails?

   -- ✅ Good: With error handling
   DECLARE EXIT HANDLER FOR SQLEXCEPTION
   BEGIN
       -- Handle error
   END;
   ```

3. **Don't Use Cursors in High-Traffic Systems**
   ```sql
   -- ❌ Bad: Cursor in frequently called procedure
   CREATE PROCEDURE GetUserData()  -- Called 1000x/minute
   BEGIN
       DECLARE cursor...  -- Performance killer
   END;
   ```

---

## Alternatives to Cursors

### 1. Set-Based Operations
```sql
-- Instead of cursor to update grades
-- ❌ Cursor approach:
DECLARE grade_cursor CURSOR FOR SELECT id, marks FROM Students;
LOOP
    IF marks >= 90 THEN SET grade = 'A';
    ELSEIF marks >= 80 THEN SET grade = 'B';
    -- etc...
    UPDATE Students SET grade = calculated_grade WHERE id = current_id;
END LOOP;

-- ✅ Set-based approach:
UPDATE Students
SET grade = CASE
    WHEN marks >= 90 THEN 'A'
    WHEN marks >= 80 THEN 'B'
    WHEN marks >= 70 THEN 'C'
    WHEN marks >= 60 THEN 'D'
    ELSE 'F'
END;
```

### 2. Common Table Expressions (CTEs)
```sql
-- For complex calculations
WITH StudentStats AS (
    SELECT
        id,
        name,
        marks,
        AVG(marks) OVER() as class_average,
        marks - AVG(marks) OVER() as deviation
    FROM Students
)
SELECT * FROM StudentStats WHERE deviation > 10;
```

### 3. Window Functions
```sql
-- For ranking and analytics
SELECT
    id,
    name,
    marks,
    ROW_NUMBER() OVER(ORDER BY marks DESC) as rank,
    LAG(marks) OVER(ORDER BY marks DESC) as prev_marks
FROM Students;
```

### 4. Temporary Tables
```sql
-- For complex multi-step processing
CREATE TEMPORARY TABLE temp_calculations AS
SELECT id, complex_calculation(marks) as result FROM Students;

UPDATE Students s
JOIN temp_calculations t ON s.id = t.id
SET s.processed_value = t.result;
```

---

## Summary

### When Cursors Are Actually Needed
- Complex row-by-row business logic that cannot be expressed in SQL
- Integration with external systems requiring individual row processing
- Sequential processing where order matters and each row affects the next
- Legacy system integration where set-based operations aren't possible

### Key Takeaways
1. **Cursors are powerful but expensive** - use sparingly
2. **Always prefer set-based operations** when possible
3. **Proper resource management** (OPEN/CLOSE) is crucial
4. **Error handling** prevents resource leaks
5. **Consider alternatives** before implementing cursors

### The Golden Rule
> "Use cursors only when you absolutely cannot achieve the same result with set-based SQL operations."

Cursors should be your **last resort**, not your first choice! 🎯

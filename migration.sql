USE employees_db;
DROP TABLE IF EXISTS employees;
SELECT * FROM employees;
create table employees (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    age INT NOT NULL,
    date_joined VARCHAR(10),
    PRIMARY KEY (id)
);


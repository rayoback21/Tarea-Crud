CREATE TABLE IF NOT EXISTS manager (
    id SERIAL,
    nickname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phonenumber VARCHAR(20),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS company (
    id SERIAL,
    company_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    manager_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (manager_id) REFERENCES manager(id)
    );

-- Database/init.sql

\c user

-- Schema für die Customer-Datenbank
CREATE SCHEMA customer;

CREATE TABLE customer.user_info (
                                    user_id SERIAL PRIMARY KEY,
                                    username VARCHAR(50) UNIQUE NOT NULL,
                                    password VARCHAR(50) NOT NULL,
                                    email VARCHAR(255) UNIQUE NOT NULL,
                                    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    last_login TIMESTAMP
);

-- Schema für die Mother-Datenbank
CREATE SCHEMA mother;

-- Erstellen der mother_db Tabelle im Schema mother
CREATE TABLE mother.mother_db (
                                  mother_id SERIAL PRIMARY KEY,
                                  description VARCHAR(255),
                                  created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Schema für die Station1-Datenbank
CREATE SCHEMA station1;

CREATE TABLE station1.station (
                                  station_id SERIAL PRIMARY KEY,
                                  address VARCHAR(100) NOT NULL,
                                  plz INT NOT NULL,
                                  num_transaction SERIAL,
                                  fuel_type VARCHAR(20) NOT NULL,
                                  customer_id INT NOT NULL,
                                  FOREIGN KEY (customer_id) REFERENCES customer.user_info (user_id)
);

-- Schema für die Station2-Datenbank
CREATE SCHEMA station2;

CREATE TABLE station2.station (
                                  station_id SERIAL PRIMARY KEY,
                                  address VARCHAR(100) NOT NULL,
                                  plz INT NOT NULL,
                                  num_transaction SERIAL,
                                  fuel_type VARCHAR(20) NOT NULL,
                                  customer_id INT NOT NULL,
                                  FOREIGN KEY (customer_id) REFERENCES customer.user_info (user_id)
);

-- Schema für die Station3-Datenbank
CREATE SCHEMA station3;

CREATE TABLE station3.station (
                                  station_id SERIAL PRIMARY KEY,
                                  address VARCHAR(100) NOT NULL,
                                  plz INT NOT NULL,
                                  num_transaction SERIAL,
                                  fuel_type VARCHAR(20) NOT NULL,
                                  customer_id INT NOT NULL,
                                  FOREIGN KEY (customer_id) REFERENCES customer.user_info (user_id)
);

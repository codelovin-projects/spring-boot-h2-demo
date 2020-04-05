DROP TABLE IF EXISTS person;
 
CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO person (first_name, last_name, city) VALUES
  ('Santosh', 'Raju', 'Chennai'),
  ('Bill', 'Gates', 'New York'),
  ('Luna', 'Smith', 'Mumbai');
  
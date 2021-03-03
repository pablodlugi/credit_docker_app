CREATE DATABASE IF NOT EXISTS product;
CREATE DATABASE IF NOT EXISTS credit;
CREATE DATABASE IF NOT EXISTS customer;

GRANT ALL ON `product`.* TO 'root'@'%';
GRANT ALL ON `customer`.* TO 'root'@'%';
GRANT ALL ON `credit`.* TO 'root'@'%';
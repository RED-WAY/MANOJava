CREATE DATABASE manosecurity;
USE manosecurity;

CREATE TABLE machine (
        idMachine INT PRIMARY KEY AUTO_INCREMENT,
        manoCode VARCHAR (60),
        machineName VARCHAR (30)
);
CREATE TABLE dynamicHardware (
        idDynamicHardware INT PRIMARY KEY AUTO_INCREMENT,
        cpu INT,
        ram INT,
        dtAdded DATETIME DEFAULT CURRENT_TIMESTAMP,
        fkMachine INT
);
CREATE TABLE operation (
        idOperation INT PRIMARY KEY AUTO_INCREMENT,
        operationName VARCHAR (100) NOT NULL UNIQUE,
        operationType CHAR (7), CONSTRAINT chkOperationType CHECK
        (operationType = "web" or operationType = "desktop")
);
CREATE TABLE operationKilled (
        idOperationRunning INT PRIMARY KEY AUTO_INCREMENT,
        dtAdded DATETIME DEFAULT CURRENT_TIMESTAMP,
        fkMachine INT,
        fkOperation INT
);


create database hospitaldb;

USE hospitaldb;


-- Create the Patients table
CREATE TABLE patients (
    patientId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    dateOfBirth DATE,
    gender VARCHAR(10),
    contactNumber VARCHAR(15),
    address VARCHAR(100)
);


-- Create the Doctors table
CREATE TABLE doctors (
    doctorId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    specialization VARCHAR(50),
    contactNumber VARCHAR(15)
);


-- Create the Appointments table
CREATE TABLE appointments (
    appointmentId INT PRIMARY KEY AUTO_INCREMENT,
    patientId INT,
    doctorId INT,
    appointmentDate DATE,
    description TEXT,
    FOREIGN KEY (patientId) REFERENCES patients(patientId),
    FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)
);


-- Insert 5 random patients
INSERT INTO patients (firstName, lastName, dateOfBirth, gender, contactNumber, address)
VALUES 
('John', 'Doe', '1985-03-22', 'M', '1234567890', '123 Maple Street'),
('Emily', 'Clark', '1990-07-15', 'F', '9876543210', '456 Oak Avenue'),
('Michael', 'Smith', '1982-12-10', 'M', '5556667777', '789 Pine Road'),
('Sophia', 'Johnson', '1995-09-25', 'F', '4445556666', '321 Cedar Lane'),
('David', 'Williams', '1978-01-05', 'M', '9998887777', '654 Walnut Drive');



-- Insert 5 random doctors
INSERT INTO doctors (firstName, lastName, specialization, contactNumber)
VALUES 
('Alice', 'Taylor', 'Cardiology', '1239874560'),
('James', 'Brown', 'Dermatology', '9876541230'),
('Olivia', 'Davis', 'Neurology', '7896541230'),
('Liam', 'Wilson', 'Orthopedics', '6547893210'),
('Isabella', 'Martinez', 'Pediatrics', '8523697410');










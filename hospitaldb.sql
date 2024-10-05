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






























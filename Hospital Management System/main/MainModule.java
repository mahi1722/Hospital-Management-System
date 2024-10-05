package main;

import dao.HospitalServiceImpl;
import entity.Appointment;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    private static HospitalServiceImpl hospitalService = new HospitalServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Schedule an Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View Appointments for Patient");
            System.out.println("4. View Appointments for Doctor");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    scheduleAppointment(sc);
                    break;
                case 2:
                    viewAppointmentById(sc);
                    break;
                case 3:
                    viewAppointmentsForPatient(sc);
                    break;
                case 4:
                    viewAppointmentsForDoctor(sc);
                    break;
                case 5:
                    updateAppointment(sc);
                    break;
                case 6:
                    cancelAppointment(sc);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        sc.close();
    }

    // Method to schedule a new appointment
    private static void scheduleAppointment(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
        String appointmentDate = sc.nextLine();
        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Appointment appointment = new Appointment(0, patientId, doctorId, appointmentDate, description);
        boolean isScheduled = hospitalService.scheduleAppointment(appointment);
        if (isScheduled) {
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Failed to schedule appointment.");
        }
    }

    // Method to view an appointment by ID
    private static void viewAppointmentById(Scanner sc) {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = sc.nextInt();
        Appointment appointment = hospitalService.getAppointmentById(appointmentId);
        if (appointment != null) {
            System.out.println(appointment);
        } else {
            System.out.println("Appointment not found.");
        }
    }

    // Method to view appointments for a specific patient
    private static void viewAppointmentsForPatient(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        List<Appointment> appointments = hospitalService.getAppointmentsForPatient(patientId);
        if (!appointments.isEmpty()) {
            appointments.forEach(System.out::println);
        } else {
            System.out.println("No appointments found for the patient.");
        }
    }

    // Method to view appointments for a specific doctor
    private static void viewAppointmentsForDoctor(Scanner sc) {
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        List<Appointment> appointments = hospitalService.getAppointmentsForDoctor(doctorId);
        if (!appointments.isEmpty()) {
            appointments.forEach(System.out::println);
        } else {
            System.out.println("No appointments found for the doctor.");
        }
    }

    // Method to update an existing appointment
    private static void updateAppointment(Scanner sc) {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = sc.nextInt();
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
        String appointmentDate = sc.nextLine();
        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Appointment appointment = new Appointment(appointmentId, patientId, doctorId, appointmentDate, description);
        boolean isUpdated = hospitalService.updateAppointment(appointment);
        if (isUpdated) {
            System.out.println("Appointment updated successfully.");
        } else {
            System.out.println("Failed to update appointment.");
        }
    }

    // Method to cancel an appointment by ID
    private static void cancelAppointment(Scanner sc) {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = sc.nextInt();
        boolean isCanceled = hospitalService.cancelAppointment(appointmentId);
        if (isCanceled) {
            System.out.println("Appointment canceled successfully.");
        } else {
            System.out.println("Failed to cancel appointment.");
        }
    }
}

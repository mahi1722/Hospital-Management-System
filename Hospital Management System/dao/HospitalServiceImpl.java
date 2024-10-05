package dao;

import entity.Appointment;
import util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM appointments WHERE appointmentId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                appointment = new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM appointments WHERE patientId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM appointments WHERE doctorId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {
        boolean isScheduled = false;
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO appointments (patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getDescription());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isScheduled = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isScheduled;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        boolean isUpdated = false;
        try (Connection connection = getConnection()) {
            String query = "UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getDescription());
            ps.setInt(5, appointment.getAppointmentId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        boolean isCanceled = false;
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM appointments WHERE appointmentId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, appointmentId);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                isCanceled = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCanceled;
    }
}

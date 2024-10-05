package entity;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;

    // Default Constructor
    public Patient() {}

    // Parametrized Constructor
    public Patient(int patientId, String firstName, String lastName, String dateOfBirth, String gender, String contactNumber, String address) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    // Getters and Setters
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    // Repeat for other variables...

    @Override
    public String toString() {
        return "Patient{" +
               "patientId=" + patientId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", dateOfBirth='" + dateOfBirth + '\'' +
               ", gender='" + gender + '\'' +
               ", contactNumber='" + contactNumber + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}

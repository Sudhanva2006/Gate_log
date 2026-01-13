package gatelog;

public class StudentExit {

    private String usn;
    private String studentName;
    private String department;
    private int year;
    private String reason;
    private String approvedBy;

    // Constructor used by Faculty UI
    public StudentExit(String usn, String studentName, String department,
                       int year, String reason, String approvedBy) {
        this.usn = usn;
        this.studentName = studentName;
        this.department = department;
        this.year = year;
        this.reason = reason;
        this.approvedBy = approvedBy;
    }

    // Constructor used when loading from DB
    public StudentExit(String usn, String studentName, String department,
                       int year, String reason, String approvedBy, boolean dummy) {
        this(usn, studentName, department, year, reason, approvedBy);
    }

    // ===== GETTERS (ALL POSSIBLE NAMES) =====

    public String getUsn() {
        return usn;
    }

    // Used by AdminUI
    public String getName() {
        return studentName;
    }

    // Used by DAO
    public String getStudentName() {
        return studentName;
    }

    // Used by AdminUI & DAO
    public String getDepartment() {
        return department;
    }

    // Alias safety
    public String getDept() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public String getReason() {
        return reason;
    }

    public String getApprovedBy() {
        return approvedBy;
    }
}

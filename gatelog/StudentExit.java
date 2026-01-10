package gatelog;

public class StudentExit {

    private String usn;
    private String studentName;
    private String department;
    private int year;
    private String reason;
    private String approvedBy;
    private boolean approved;

    public StudentExit(String usn, String studentName, String department, int year, String reason) {
        this.usn = usn;
        this.studentName = studentName;
        this.department = department;
        this.year = year;
        this.reason = reason;
        this.approved = false;
    }

    public void approveExit(String facultyName) {
        this.approvedBy = facultyName;
        this.approved = true;
    }

    public void displayExitStatus() {
        System.out.println(usn + " | " + studentName + " | " + department + " | Year " + year);
        System.out.println("Reason: " + reason);
        System.out.println("Status: " + (approved ? "APPROVED by " + approvedBy : "PENDING"));
    }

    public boolean isApproved() {
        return approved;
    }

    public String getUsn() {
        return usn;
    }
public String getStudentName() {
    return studentName;
}

public String getDepartment() {
    return department;
}

public int getYear() {
    return year;
}

public String getReason() {
    return reason;
}

}

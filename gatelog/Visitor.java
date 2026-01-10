package gatelog;

public class Visitor {

    private String name;
    private String phone;
    private String purpose;
    private String inTime;
    private String outTime;

    public Visitor(String name, String phone, String purpose, String inTime) {
        this.name = name;
        this.phone = phone;
        this.purpose = purpose;
        this.inTime = inTime;
        this.outTime = "Not Exited";
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public void displayVisitor() {
        System.out.println(name + " | " + phone + " | " + purpose + " | " + inTime + " | " + outTime);
    }
    public String getName() {
    return name;
}

public String getPhone() {
    return phone;
}

public String getPurpose() {
    return purpose;
}

public String getInTime() {
    return inTime;
}

public String getOutTime() {
    return outTime;
}

}

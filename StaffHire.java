// StaffHire class
//Creating StaffHire class 
public class StaffHire {
    // Attributes
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    // Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }

    // Getter and Setter methods
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAppointedBy() {
        return appointedBy;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    public boolean isJoined() {
        return joined;
    }

    // Method to change the joined status
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    // Display method
     public String display() {
        return "Vacancy Number: " + vacancyNumber + "\n" +
               "Designation: " + designation + "\n" +
               "Job Type: " + jobType + "\n" +
               "Staff Name: " + staffName + "\n" +
               "Joining Date: " + joiningDate + "\n" +
               "Qualification: " + qualification + "\n" +
               "Appointed By: " + appointedBy + "\n" +
               "Joined: " + (joined ? "Yes" : "No");
    }
}


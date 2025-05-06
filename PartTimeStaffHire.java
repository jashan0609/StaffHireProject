// PartTimeStaffHire class (subclass of StaffHire) using inheritance 
class PartTimeStaffHire extends StaffHire {
    // Additional attributes
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, int workingHour, double wagesPerHour, String shifts) {
        // Call to superclass constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // Terminated status is initially false
    }

    // Getter and Setter methods for workingHour
    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    // Getter and Setter methods for wagesPerHour
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }

    // Getter and Setter methods for shifts
    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        if (isJoined()) {
            this.shifts = shifts;
            System.out.println("Shifts updated successfully.");
        } else {
            System.out.println("Cannot set shifts. Staff has not joined yet.");
        }
    }

    // Getter method for terminated
    public boolean isTerminated() {
        return terminated;
    }

    // Method to terminate the staff
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            // Clear staff details
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Staff has been terminated.");
        }
    }

    // Override display method
    @Override
   public String display() {
        return super.display() + "\n" +
               "Working Hours: " + workingHour + "\n" +
               "Wages Per Hour: $" + wagesPerHour + "\n" +
               "Shifts: " + shifts + "\n" +
               "Terminated: " + (terminated ? "Yes" : "No") + "\n" +
               "Daily Income: $" + (workingHour * wagesPerHour);
    }
}
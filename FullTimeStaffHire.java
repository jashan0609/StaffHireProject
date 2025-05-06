// FullTimeStaffHire class (subclass of StaffHire) using inheritance 
public class FullTimeStaffHire extends StaffHire {
    // Additional attributes
    private double salary;
    private int weeklyFractionalHours;

    // Constructor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, double salary, int weeklyFractionalHours) {
        // Call to superclass constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter and Setter methods for salary
    public double getSalary() {
        return salary;
    }
    // Setter method for salary using if else conditional statements

    public void setSalary(double salary) {
        if (isJoined()) {
            this.salary = salary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Cannot set salary. No staff has been appointed yet.");
        }
    }

    // Getter and Setter methods for weeklyFractionalHours
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Override display method
    @Override
    public String display() {
        return super.display() + "\n" +
               "Salary: $" + salary + "\n" +
               "Weekly Hours: " + weeklyFractionalHours;
    }
    }



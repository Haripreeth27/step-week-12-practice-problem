/**
 * Category C · Practice Problems
 * Problem 1: Campus Staff Salary
 * 
 * TASK:
 * The college pays every staff member a base salary. Teachers get a bonus of 5000 and lab assistants
 * a bonus of 2000; other staff get no bonus.
 * 
 * Create a Staff class with name and baseSalary, and Teacher and LabAssistant classes that extend it
 * and override the bonus. Store everyone in one Staff[] array, print each person's details in a single loop,
 * then the grand total.
 * 
 * INPUT / OUTPUT:
 * Input: The number of staff, then each person's type, name and base salary.
 * Output: name (type): base b, bonus x, total t for each person, then the grand total.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the number of staff members, processing each record once.
 * - Space Complexity: O(n) memory to store n staff instances.
 */
public class Question1 {

    public static class Staff {
        protected String name;
        protected double baseSalary;

        public Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public double getBonus() {
            return 0.0;
        }

        public double getTotalSalary() {
            return baseSalary + getBonus();
        }

        public String getDesignation() {
            return "Staff";
        }

        public String getDetails() {
            return String.format("%s (%s): base %.1f, bonus %.1f, total %.1f",
                name, getDesignation(), baseSalary, getBonus(), getTotalSalary());
        }
    }

    public static class Teacher extends Staff {
        public Teacher(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        public double getBonus() {
            return 5000.0;
        }

        @Override
        public String getDesignation() {
            return "Teacher";
        }
    }

    public static class LabAssistant extends Staff {
        public LabAssistant(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        public double getBonus() {
            return 2000.0;
        }

        @Override
        public String getDesignation() {
            return "LabAssistant";
        }
    }

    public static void printStaffPayroll(Staff[] staffList) {
        if (staffList == null || staffList.length == 0) {
            System.out.println("Grand Total Salary: 0.0");
            return;
        }

        double grandTotal = 0.0;
        for (Staff member : staffList) {
            System.out.println(member.getDetails());
            grandTotal += member.getTotalSalary();
        }
        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        Staff[] staffMembers = {
            new Teacher("Rahul", 30000),
            new LabAssistant("Priya", 20000),
            new Staff("Amit", 25000),
            new Teacher("Sneha", 35000),
            new LabAssistant("Karan", 18000)
        };

        printStaffPayroll(staffMembers);

        System.out.println("\n--- Custom Test Case ---");
        Staff[] customStaff = {
            new Teacher("Dr. Sharma", 50000),
            new LabAssistant("Vikas", 22000),
            new Staff("Ramesh", 20000)
        };
        printStaffPayroll(customStaff);
    }
}

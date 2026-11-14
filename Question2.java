import java.util.ArrayList;
import java.util.List;

/**
 * Category C · Practice Problems
 * Problem 2: Class Report Card
 * 
 * TASK:
 * A class teacher wants report cards: total, average and grade for each student, listed from the
 * highest total to the lowest. Marks outside 0 to 100 are typing mistakes and that student is left out.
 * 
 * Write a Student class with private name and three marks, set only through boolean setMarks(int a,
 * int b, int c) which accepts marks from 0 to 100. Grade by average: 80 and above A, 70 B, 60 C, 40 D,
 * below 40 F. Give Student a readable text form. Sort accepted students with bubble sort that stops
 * early when a pass makes no swap, and print the number of passes.
 * 
 * COMPLEXITY:
 * - Best Case: O(k) where k is accepted students, when list is already sorted descending (1 pass, 0 swaps).
 * - Worst Case: O(k^2) when list is in reverse order, taking k-1 passes.
 * - Space Complexity: O(k) memory for the accepted student list.
 */
public class Question2 {

    public static class Student {
        private String name;
        private int mark1;
        private int mark2;
        private int mark3;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                return false;
            }
            this.mark1 = a;
            this.mark2 = b;
            this.mark3 = c;
            return true;
        }

        public int getTotal() {
            return mark1 + mark2 + mark3;
        }

        public double getAverage() {
            return getTotal() / 3.0;
        }

        public char getGrade() {
            double avg = getAverage();
            if (avg >= 80.0) return 'A';
            if (avg >= 70.0) return 'B';
            if (avg >= 60.0) return 'C';
            if (avg >= 40.0) return 'D';
            return 'F';
        }

        @Override
        public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
        }
    }

    public static class RawInput {
        String name;
        int m1, m2, m3;

        public RawInput(String name, int m1, int m2, int m3) {
            this.name = name;
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        }
    }

    /**
     * Filters, sorts, and prints report cards.
     */
    public static void generateReportCard(List<RawInput> inputList) {
        List<Student> accepted = new ArrayList<>();

        // Validate and filter
        for (RawInput r : inputList) {
            Student s = new Student(r.name);
            if (s.setMarks(r.m1, r.m2, r.m3)) {
                accepted.add(s);
            } else {
                System.out.println(r.name + " skipped: marks must be 0 to 100");
            }
        }

        // Bubble sort descending by total marks with early termination
        int passes = 0;
        int m = accepted.size();
        for (int i = 0; i < m - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < m - 1 - i; j++) {
                if (accepted.get(j).getTotal() < accepted.get(j + 1).getTotal()) {
                    Student temp = accepted.get(j);
                    accepted.set(j, accepted.get(j + 1));
                    accepted.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        // Print ranked report cards
        for (int i = 0; i < accepted.size(); i++) {
            System.out.println((i + 1) + ". " + accepted.get(i));
        }
        System.out.println("Sorted in " + passes + " passes");
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        List<RawInput> students = List.of(
            new RawInput("Asha", 80, 90, 70),
            new RawInput("Ravi", 60, 65, 70),
            new RawInput("Neha", 95, 85, 105),
            new RawInput("Kiran", 45, 50, 40),
            new RawInput("Pooja", 88, 72, 81)
        );

        generateReportCard(students);

        System.out.println("\n--- Custom Test Case (Already Sorted) ---");
        List<RawInput> alreadySorted = List.of(
            new RawInput("Arjun", 90, 95, 92),
            new RawInput("Meera", 75, 80, 78),
            new RawInput("Deepak", 50, 55, 60)
        );
        generateReportCard(alreadySorted);
    }
}

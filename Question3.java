/**
 * Category C · Practice Problems
 * Problem 3: Library Return Desk
 * 
 * TASK:
 * At the library desk, returned books go on a small pile and the top book is always shelved first.
 * Students who want to borrow wait in a line and are served in the order they arrived.
 * 
 * Build the pile as a stack on an array of size 3 (RETURN adds a book, SHELVE removes the top book)
 * and the line as a queue on an array of size 3 that reuses free places (WAIT adds a student, SERVE
 * removes the front student). Print a clear message for every command, including when the pile or the
 * line is empty or full.
 * 
 * COMPLEXITY:
 * - RETURN / SHELVE (Stack Operations): O(1) time complexity.
 * - WAIT / SERVE (Queue Operations): O(1) time complexity with circular array arithmetic.
 * - Space Complexity: O(1) fixed space (size 3 each for stack and queue).
 */
public class Question3 {

    /**
     * Stack implementation on an array of fixed capacity 3 for returned books.
     */
    public static class BookPile {
        private String[] stack = new String[3];
        private int top = -1;

        public void returnBook(String book) {
            if (top == 2) {
                System.out.println(book + " rejected: pile is full");
            } else {
                stack[++top] = book;
                System.out.println(book + " placed on pile");
            }
        }

        public void shelveBook() {
            if (top == -1) {
                System.out.println("pile is empty");
            } else {
                String shelved = stack[top--];
                System.out.println("shelved " + shelved);
            }
        }
    }

    /**
     * Circular Queue implementation on an array of fixed capacity 3 for student line.
     */
    public static class StudentLine {
        private String[] queue = new String[3];
        private int front = 0;
        private int rear = -1;
        private int size = 0;

        public void waitStudent(String student) {
            if (size == 3) {
                System.out.println(student + " rejected: line is full");
            } else {
                rear = (rear + 1) % 3;
                queue[rear] = student;
                size++;
                System.out.println(student + " joined the line");
            }
        }

        public void serveStudent() {
            if (size == 0) {
                System.out.println("no one waiting");
            } else {
                String served = queue[front];
                front = (front + 1) % 3;
                size--;
                System.out.println("served " + served);
            }
        }
    }

    /**
     * Parses and executes a command string on pile and line.
     */
    public static void processCommand(String cmd, BookPile pile, StudentLine line) {
        cmd = cmd.trim();
        if (cmd.startsWith("RETURN")) {
            String[] parts = cmd.split("\\s+");
            if (parts.length > 1) {
                pile.returnBook(parts[1]);
            }
        } else if (cmd.equals("SHELVE")) {
            pile.shelveBook();
        } else if (cmd.startsWith("WAIT")) {
            String[] parts = cmd.split("\\s+");
            if (parts.length > 1) {
                line.waitStudent(parts[1]);
            }
        } else if (cmd.equals("SERVE")) {
            line.serveStudent();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        BookPile pile = new BookPile();
        StudentLine line = new StudentLine();

        String[] commands = {
            "RETURN B1", "RETURN B2", "RETURN B3", "RETURN B4",
            "WAIT Asha", "WAIT Ravi", "SHELVE", "SERVE",
            "SHELVE", "SHELVE", "SHELVE", "SERVE", "SERVE"
        };

        for (String cmd : commands) {
            processCommand(cmd, pile, line);
        }

        System.out.println("\n--- Custom Test Case (Queue Wraparound) ---");
        BookPile pile2 = new BookPile();
        StudentLine line2 = new StudentLine();

        line2.waitStudent("Student1");
        line2.waitStudent("Student2");
        line2.waitStudent("Student3");
        line2.waitStudent("Student4"); // Should reject: line is full
        line2.serveStudent();          // Frees front slot 0
        line2.waitStudent("Student5"); // Should wrap around into slot 0
        line2.serveStudent();
        line2.serveStudent();
        line2.serveStudent();
        line2.serveStudent();          // Empty
    }
}

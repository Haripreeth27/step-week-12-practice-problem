/**
 * Category C · Practice Problems
 * Problem 5: Weekly Rainfall Analysis
 * 
 * TASK:
 * Rainfall is recorded for seven days. Report the total, the average to two decimals, the wettest day
 * (counting from 1) with its rainfall, and the number of dry days.
 * 
 * Store the readings in a double[] array of size 7 and compute everything with loops.
 * 
 * INPUT / OUTPUT:
 * Input: Rainfall in mm for days 1 to 7.
 * Output: Each day's rainfall, then the total, average, wettest day and dry days.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(1) (fixed 7 iterations).
 * - Space Complexity: O(1) auxiliary space beyond the 7-element double array.
 */
public class Question5 {

    public static void analyzeRainfall(double[] rainfall) {
        if (rainfall == null || rainfall.length != 7) {
            System.out.println("Invalid input: exactly 7 days of readings required.");
            return;
        }

        // Print daily rainfall
        StringBuilder sb = new StringBuilder("Rainfall (mm):");
        double total = 0.0;
        int wettestDay = 1;
        double maxRain = rainfall[0];
        int dryDays = 0;

        for (int i = 0; i < 7; i++) {
            double val = rainfall[i];
            sb.append(String.format(" %.1f", val));
            total += val;

            if (val > maxRain) {
                maxRain = val;
                wettestDay = i + 1; // 1-based day index
            }

            if (val == 0.0) {
                dryDays++;
            }
        }

        double average = total / 7.0;

        System.out.println(sb.toString());
        System.out.printf("Total Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", average);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n", wettestDay, maxRain);
        System.out.printf("Total Dry Days: %d%n", dryDays);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        // 12 0 25 18 0 30 15
        double[] week1 = {12.0, 0.0, 25.0, 18.0, 0.0, 30.0, 15.0};
        analyzeRainfall(week1);

        System.out.println("\n--- Custom Test Case (Monsoon Week) ---");
        // No dry days
        double[] week2 = {45.5, 60.0, 32.0, 85.0, 50.0, 15.5, 20.0};
        analyzeRainfall(week2);
    }
}

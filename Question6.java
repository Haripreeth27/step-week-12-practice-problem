import java.util.ArrayList;
import java.util.List;

/**
 * Category C · Practice Problems
 * Problem 6: Hostel Electricity Bill
 * 
 * TASK:
 * Each hostel room pays for electricity in slabs, plus a fixed meter charge. Work out every room's
 * bill and the total for the block.
 * 
 * The first 100 units cost 3 each, the next 100 units cost 5 each, and every unit above 200 costs 8.
 * Add a fixed meter charge of 50 to every bill. A negative reading is invalid: print a message and do
 * not bill that room.
 * 
 * INPUT / OUTPUT:
 * Input: The number of rooms, then each room number and reading.
 * Output: Each room's bill, then the number of rooms billed and the total.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the number of rooms.
 * - Space Complexity: O(n) memory to store room inputs.
 */
public class Question6 {

    public static class RoomReading {
        String roomNumber;
        int units;

        public RoomReading(String roomNumber, int units) {
            this.roomNumber = roomNumber;
            this.units = units;
        }
    }

    /**
     * Calculates electricity bill based on 3-tier slabs and fixed meter charge of 50.
     * Tier 1 (1 - 100): 3 per unit
     * Tier 2 (101 - 200): 5 per unit
     * Tier 3 (> 200): 8 per unit
     * Fixed Meter Charge: 50
     *
     * @param units number of consumed electricity units
     * @return total bill
     */
    public static int calculateBill(int units) {
        int bill = 50; // Fixed meter charge

        if (units <= 100) {
            bill += units * 3;
        } else if (units <= 200) {
            bill += (100 * 3) + (units - 100) * 5;
        } else {
            bill += (100 * 3) + (100 * 5) + (units - 200) * 8;
        }

        return bill;
    }

    public static void generateBlockElectricityBills(List<RoomReading> readings) {
        if (readings == null || readings.isEmpty()) {
            System.out.println("Rooms billed 0, total 0");
            return;
        }

        int roomsBilled = 0;
        int totalBlockBill = 0;

        for (RoomReading r : readings) {
            if (r.units < 0) {
                System.out.printf("%s: invalid reading%n", r.roomNumber);
            } else {
                int bill = calculateBill(r.units);
                roomsBilled++;
                totalBlockBill += bill;
                System.out.printf("%s: %d units, bill %d%n", r.roomNumber, r.units, bill);
            }
        }

        System.out.printf("Rooms billed %d, total %d%n", roomsBilled, totalBlockBill);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        List<RoomReading> rooms = List.of(
            new RoomReading("A101", 80),
            new RoomReading("A102", 150),
            new RoomReading("B201", 260),
            new RoomReading("B202", -12),
            new RoomReading("C301", 200)
        );

        generateBlockElectricityBills(rooms);

        System.out.println("\n--- Custom Test Case ---");
        List<RoomReading> customRooms = List.of(
            new RoomReading("D101", 50),   // 50*3 + 50 = 200
            new RoomReading("D102", 0),    // 0*3 + 50 = 50
            new RoomReading("D103", -5),   // invalid reading
            new RoomReading("D104", 300)   // 300 + 500 + 800 + 50 = 1650
        );
        generateBlockElectricityBills(customRooms);
    }
}

# STEP Week 12 — Category C · Practice Problems

This repository contains the complete Java solutions for the **STEP Sem-3 Week 12 Practice Problems (Category C)** provided by CodInClub | Powered by BridgeLabz.

---

## Problems & Solutions Overview

| Question | Problem Title | Topic / Concept | Key Classes / Interfaces | File |
| :--- | :--- | :--- | :--- | :--- |
| **Question 1** | Campus Staff Salary | OOP Polymorphism & Method Overriding | `Staff`, `Teacher`, `LabAssistant` | [`Question1.java`](Question1.java) |
| **Question 2** | Class Report Card | Encapsulation & Bubble Sort with Early Stop | `Student`, `RawInput` | [`Question2.java`](Question2.java) |
| **Question 3** | Library Return Desk | Fixed-size Stack & Circular Queue | `BookPile`, `StudentLine` | [`Question3.java`](Question3.java) |
| **Question 4** | Payment Processing | Interface Implementation & Polymorphism | `PaymentMode`, `CashPayment`, `CardPayment`, `UpiPayment` | [`Question4.java`](Question4.java) |
| **Question 5** | Weekly Rainfall Analysis | 1D Array Statistics & Loop Aggregations | `analyzeRainfall(double[])` | [`Question5.java`](Question5.java) |
| **Question 6** | Hostel Electricity Bill | Slab Calculation & Input Validation | `RoomReading`, `calculateBill(int)` | [`Question6.java`](Question6.java) |

---

## Detailed Problem Statements & Specifications

### Problem 1: Campus Staff Salary
- **Task:** The college pays every staff member a base salary. Teachers get a bonus of 5000 and lab assistants a bonus of 2000; other staff get no bonus. Create a `Staff` class with `name` and `baseSalary`, and `Teacher` and `LabAssistant` classes that extend it and override the bonus. Store everyone in one `Staff[]` array, print each person's details in a single loop, then the grand total.
- **Constraints:** $1 \le \text{number of staff} \le 100$, $0 \le \text{base salary} \le 10^6$.
- **Complexity:** $O(n)$ time to loop through staff and calculate grand total; $O(n)$ space.
- **Sample Input:**
  ```
  5
  Teacher Rahul 30000
  LabAssistant Priya 20000
  Staff Amit 25000
  Teacher Sneha 35000
  LabAssistant Karan 18000
  ```
- **Sample Output:**
  ```
  Rahul (Teacher): base 30000.0, bonus 5000.0, total 35000.0
  Priya (LabAssistant): base 20000.0, bonus 2000.0, total 22000.0
  Amit (Staff): base 25000.0, bonus 0.0, total 25000.0
  Sneha (Teacher): base 35000.0, bonus 5000.0, total 40000.0
  Karan (LabAssistant): base 18000.0, bonus 2000.0, total 20000.0
  Grand Total Salary: 142000.0
  ```

---

### Problem 2: Class Report Card
- **Task:** Report cards: total, average and grade for each student, listed from highest total to lowest. Marks outside 0 to 100 are typing mistakes and left out. `Student` class has private name and three marks, set only through `boolean setMarks(int a, int b, int c)`. Grade by average: $\ge 80$ A, $70$ B, $60$ C, $40$ D, $< 40$ F. Sort accepted students with bubble sort that stops early when a pass makes no swap, and print the number of passes.
- **Constraints:** $1 \le n \le 50$.
- **Complexity:** Best case $O(k)$ (1 pass when already sorted), Worst case $O(k^2)$ ($k-1$ passes).
- **Sample Input:**
  ```
  5
  Asha 80 90 70
  Ravi 60 65 70
  Neha 95 85 105
  Kiran 45 50 40
  Pooja 88 72 81
  ```
- **Sample Output:**
  ```
  Neha skipped: marks must be 0 to 100
  1. Pooja total=241 avg=80.33 grade=A
  2. Asha total=240 avg=80.00 grade=A
  3. Ravi total=195 avg=65.00 grade=C
  4. Kiran total=135 avg=45.00 grade=D
  Sorted in 3 passes
  ```

---

### Problem 3: Library Return Desk
- **Task:** Returned books go on a small pile (stack of size 3: `RETURN` adds book, `SHELVE` removes top book). Students borrow in a line (queue on circular array of size 3: `WAIT` adds student, `SERVE` removes front student). Print clear messages including when pile/line is empty or full.
- **Constraints:** $1 \le \text{number of commands} \le 100$.
- **Complexity:** $O(1)$ for every stack and queue operation.
- **Sample Commands:**
  `RETURN B1, RETURN B2, RETURN B3, RETURN B4, WAIT Asha, WAIT Ravi, SHELVE, SERVE, SHELVE, SHELVE, SHELVE, SERVE, SERVE`
- **Sample Output:**
  ```
  B1 placed on pile
  B2 placed on pile
  B3 placed on pile
  B4 rejected: pile is full
  Asha joined the line
  Ravi joined the line
  shelved B3
  served Asha
  shelved B2
  shelved B1
  pile is empty
  served Ravi
  no one waiting
  ```

---

### Problem 4: Payment Processing
- **Task:** Shop accepts cash, card and UPI payments. Card payments carry a 2% fee; cash and UPI carry none. Define interface `PaymentMode` with `double processPayment(double amount)` and implement in `CashPayment`, `CardPayment` and `UpiPayment`. Store in `PaymentMode[]` array, print each payment details and total processed.
- **Constraints:** $1 \le \text{number of payments} \le 100$, $1 \le \text{amount} \le 10^6$.
- **Complexity:** $O(n)$ time complexity to process all payments.
- **Sample Input:**
  ```
  4
  Cash 1000
  Card 2000
  UPI 1500
  Card 3000
  ```
- **Sample Output:**
  ```
  Cash: amount 1000.0, fee 0.0, processed 1000.0
  Card: amount 2000.0, fee 40.0, processed 2040.0
  UPI: amount 1500.0, fee 0.0, processed 1500.0
  Card: amount 3000.0, fee 60.0, processed 3060.0
  Total Amount Processed: 7600.0
  ```

---

### Problem 5: Weekly Rainfall Analysis
- **Task:** Rainfall recorded for 7 days. Report total, average to two decimals, wettest day (1-based index) with rainfall, and number of dry days (days with 0.0 mm). Use a `double[7]` array and compute with loops.
- **Constraints:** $0 \le \text{rainfall} \le 500$ mm.
- **Complexity:** $O(1)$ time (7 days), $O(1)$ space.
- **Sample Input:**
  `12 0 25 18 0 30 15`
- **Sample Output:**
  ```
  Rainfall (mm): 12.0 0.0 25.0 18.0 0.0 30.0 15.0
  Total Rainfall: 100.0 mm
  Average Rainfall: 14.29 mm
  Wettest Day: Day 6 (30.0 mm)
  Total Dry Days: 2
  ```

---

### Problem 6: Hostel Electricity Bill
- **Task:** Hostel rooms pay electricity in slabs plus fixed meter charge of 50. First 100 units cost 3 each, next 100 cost 5 each, units above 200 cost 8 each. Negative readings are invalid (print message and skip billing). Print each room's bill, rooms billed count, and block total.
- **Constraints:** $1 \le \text{rooms} \le 100$, readings are whole numbers.
- **Complexity:** $O(n)$ time to process $n$ rooms.
- **Sample Input:**
  ```
  5
  A101 80
  A102 150
  B201 260
  B202 -12
  C301 200
  ```
- **Sample Output:**
  ```
  A101: 80 units, bill 290
  A102: 150 units, bill 600
  B201: 260 units, bill 1330
  B202: invalid reading
  C301: 200 units, bill 850
  Rooms billed 4, total 3070
  ```

---

## How to Compile and Run

```bash
cd step-week-12-practice-problem

# Question 1: Campus Staff Salary
javac Question1.java && java Question1

# Question 2: Class Report Card
javac Question2.java && java Question2

# Question 3: Library Return Desk
javac Question3.java && java Question3

# Question 4: Payment Processing
javac Question4.java && java Question4

# Question 5: Weekly Rainfall Analysis
javac Question5.java && java Question5

# Question 6: Hostel Electricity Bill
javac Question6.java && java Question6
```

package mini_app;

    import java.io.*;
import java.util.*;


public class DailyExpenseTracker {
    private static final int MAX_DAYS = 31;
    private static final Scanner sc = new Scanner(System.in);

    // index 1..31 used; index 0 unused
    private static final ArrayList<Double>[] dayExpenses = new ArrayList[MAX_DAYS + 1];
    private static double dailyBudget = 1000.0; // default daily budget

    private static final String SAVE_FILE = "expenses.csv";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // initialize array lists
        for (int i = 0; i <= MAX_DAYS; i++) {
            dayExpenses[i] = new ArrayList<>();
        }

        System.out.println("=== Daily Expense Tracker ===");
        loadFromCSVOnStart();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": setBudget(); break;
                case "2": addExpense(); break;
                case "3": viewDay(); break;
                case "4": removeLastExpense(); break;
                case "5": monthlySummary(); break;
                case "6": listOverOrWithinBudget(); break;
                case "7": saveToCSV(); break;
                case "8": loadFromCSV(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Set daily budget (current: " + format(dailyBudget) + ")");
        System.out.println("2. Add expense");
        System.out.println("3. View a day's expenses");
        System.out.println("4. Remove last expense from a day");
        System.out.println("5. Monthly summary (total, avg, min, max)");
        System.out.println("6. List days: Over Budget / Within Budget");
        System.out.println("7. Save expenses to CSV (" + SAVE_FILE + ")");
        System.out.println("8. Load expenses from CSV (" + SAVE_FILE + ")");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static void setBudget() {
        System.out.print("Enter new daily budget amount: ");
        try {
            double b = Double.parseDouble(sc.nextLine().trim());
            if (b < 0) {
                System.out.println("Budget must be non-negative.");
                return;
            }
            dailyBudget = b;
            System.out.println("Daily budget set to " + format(dailyBudget));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private static void addExpense() {
        try {
            System.out.print("Enter day number (1 - " + MAX_DAYS + "): ");
            int day = Integer.parseInt(sc.nextLine().trim());
            if (day < 1 || day > MAX_DAYS) {
                System.out.println("Day must be between 1 and " + MAX_DAYS);
                return;
            }
            System.out.print("Enter expense amount: ");
            double amount = Double.parseDouble(sc.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }
            // optional description not stored (keeps CSV simple); could be added later
            dayExpenses[day].add(amount);
            System.out.println("Added " + format(amount) + " to day " + day + ".");
            System.out.println("Day " + day + " total: " + format(dayTotal(day)));
            if (dayTotal(day) > dailyBudget) {
                System.out.println("Warning: Day " + day + " is OVER budget (" + format(dailyBudget) + ")");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Operation cancelled.");
        }
    }

    private static void viewDay() {
        try {
            System.out.print("Enter day number to view (1 - " + MAX_DAYS + "): ");
            int day = Integer.parseInt(sc.nextLine().trim());
            if (day < 1 || day > MAX_DAYS) {
                System.out.println("Invalid day.");
                return;
            }
            ArrayList<Double> list = dayExpenses[day];
            if (list.isEmpty()) {
                System.out.println("No expenses recorded for day " + day + ".");
                return;
            }
            System.out.println("Expenses for day " + day + ":");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("  %d) %s%n", i + 1, format(list.get(i)));
            }
            System.out.println("Total for day " + day + ": " + format(dayTotal(day)));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void removeLastExpense() {
        try {
            System.out.print("Enter day number to remove last expense from: ");
            int day = Integer.parseInt(sc.nextLine().trim());
            if (day < 1 || day > MAX_DAYS) {
                System.out.println("Invalid day.");
                return;
            }
            ArrayList<Double> list = dayExpenses[day];
            if (list.isEmpty()) {
                System.out.println("No expenses to remove for day " + day + ".");
                return;
            }
            double removed = list.remove(list.size() - 1);
            System.out.println("Removed " + format(removed) + " from day " + day + ".");
            System.out.println("New total: " + format(dayTotal(day)));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void monthlySummary() {
        double total = 0.0;
        int daysWithExpenses = 0;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (int d = 1; d <= MAX_DAYS; d++) {
            double t = dayTotal(d);
            if (t > 0) {
                daysWithExpenses++;
                total += t;
                if (t < min) min = t;
                if (t > max) max = t;
            }
        }

        System.out.println("\nMonthly Summary:");
        System.out.println("Daily budget: " + format(dailyBudget));
        System.out.println("Total for month (sum of days): " + format(total));
        if (daysWithExpenses == 0) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        double avg = total / daysWithExpenses; // average of days that had expenses
        System.out.println("Days with expenses: " + daysWithExpenses + " out of " + MAX_DAYS);
        System.out.println("Average per active day: " + format(avg));
        System.out.println("Minimum day total: " + format(min));
        System.out.println("Maximum day total: " + format(max));
    }

    private static void listOverOrWithinBudget() {
        System.out.println("\nDays OVER budget (dailyBudget = " + format(dailyBudget) + "):");
        boolean anyOver = false;
        for (int d = 1; d <= MAX_DAYS; d++) {
            double t = dayTotal(d);
            if (t > dailyBudget) {
                System.out.printf("  Day %d : %s%n", d, format(t));
                anyOver = true;
            }
        }
        if (!anyOver) System.out.println("  (none)");

        System.out.println("\nDays WITHIN budget (including zero):");
        boolean anyWithin = false;
        for (int d = 1; d <= MAX_DAYS; d++) {
            double t = dayTotal(d);
            if (t <= dailyBudget) {
                System.out.printf("  Day %d : %s%n", d, format(t));
                anyWithin = true;
            }
        }
        if (!anyWithin) System.out.println("  (none)");
    }

    // Helper: calculate total for a day
    private static double dayTotal(int day) {
        double s = 0.0;
        for (double v : dayExpenses[day]) s += v;
        return s;
    }

    // Simple CSV save: each line => day,amount1;amount2;amount3
    private static void saveToCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(SAVE_FILE))) {
            for (int d = 1; d <= MAX_DAYS; d++) {
                ArrayList<Double> list = dayExpenses[d];
                if (list.isEmpty()) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(d).append(",");
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) sb.append(";");
                    sb.append(list.get(i));
                }
                pw.println(sb.toString());
            }
            System.out.println("Saved expenses to " + SAVE_FILE);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load CSV that was saved by saveToCSV()
    private static void loadFromCSV() {
        File f = new File(SAVE_FILE);
        if (!f.exists()) {
            System.out.println("No save file found (" + SAVE_FILE + ").");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            // clear existing
            for (int d = 1; d <= MAX_DAYS; d++) dayExpenses[d].clear();

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                // format: day,amt1;amt2;amt3
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;
                int day = Integer.parseInt(parts[0].trim());
                String[] amts = parts[1].split(";");
                for (String a : amts) {
                    try {
                        double v = Double.parseDouble(a.trim());
                        dayExpenses[day].add(v);
                    } catch (NumberFormatException ignored) {}
                }
            }
            System.out.println("Loaded expenses from " + SAVE_FILE);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load: " + e.getMessage());
        }
    }

    // Attempt to auto-load on start but don't warn if not present
    private static void loadFromCSVOnStart() {
        File f = new File(SAVE_FILE);
        if (f.exists()) {
            loadFromCSV();
        } else {
            System.out.println("(Tip: use option 7 to save and 8 to load from file.)");
        }
    }

    private static String format(double v) {
        return String.format("₹%.2f", v); // using ₹ symbol — change to $ or blank if you prefer
    }
}



package mini_app;

   import java.io.*;
import java.util.*;

abstract class Employee {
    // Encapsulated fields
    private String name;
    private int empId;
    private String email;

    public Employee(int empId, String name, String email) {
        this.empId = empId;
        setName(name);
        setEmail(email);
    }

    // Abstract method (abstraction) to be implemented by subclasses
    public abstract double calculateSalary();

    // Common getters/setters with basic validation
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        if (empId <= 0) throw new IllegalArgumentException("Employee ID must be positive.");
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name.trim();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            this.email = "no-email@example.com";
        } else {
            this.email = email.trim();
        }
    }

    // Common toString for display
    @Override
    public String toString() {
        return String.format("%d | %s | %s", empId, name, email);
    }

    // For CSV persistence: type,empId,name,email, fieldSpecific...
    public abstract String toCSV();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;     // base pay
    private double monthlyBonus;      // any fixed monthly bonus
    private double deductions;        // monthly deductions (taxes, etc.)

    public FullTimeEmployee(int empId, String name, String email,
                            double monthlySalary, double monthlyBonus, double deductions) {
        super(empId, name, email);
        setMonthlySalary(monthlySalary);
        setMonthlyBonus(monthlyBonus);
        setDeductions(deductions);
    }

    @Override
    public double calculateSalary() {
        // Simple formula: base + bonus - deductions
        double gross = monthlySalary + monthlyBonus;
        double net = gross - deductions;
        return Math.max(net, 0.0);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        if (monthlyBonus < 0) monthlyBonus = 0;
        this.monthlyBonus = monthlyBonus;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        if (deductions < 0) deductions = 0;
        this.deductions = deductions;
    }

    @Override
    public String toString() {
        return "FullTime | " + super.toString() +
                String.format(" | Salary: %.2f | Bonus: %.2f | Deductions: %.2f", monthlySalary, monthlyBonus, deductions);
    }

    @Override
    public String toCSV() {
        return String.format("FT,%d,%s,%s,%.2f,%.2f,%.2f",
                getEmpId(), escapeCSV(getName()), escapeCSV(getEmail()),
                monthlySalary, monthlyBonus, deductions);
    }

    private String escapeCSV(String s) {
        return s.replace(",", " "); // naive escape
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked; // in a pay period

    public PartTimeEmployee(int empId, String name, String email, double hourlyRate, double hoursWorked) {
        super(empId, name, email);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    @Override
    public double calculateSalary() {
        double gross = hourlyRate * hoursWorked;
        // straightforward: no deductions here (could be added)
        return Math.max(gross, 0.0);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly rate cannot be negative.");
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) hoursWorked = 0;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "PartTime | " + super.toString() +
                String.format(" | Rate: %.2f | Hours: %.2f", hourlyRate, hoursWorked);
    }

    @Override
    public String toCSV() {
        return String.format("PT,%d,%s,%s,%.2f,%.2f",
                getEmpId(), escapeCSV(getName()), escapeCSV(getEmail()),
                hourlyRate, hoursWorked);
    }

    private String escapeCSV(String s) {
        return s.replace(",", " ");
    }
}

public class PayrollSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();
    private static final String CSV_FILE = "employees.csv";

    public static void main(String[] args) {
        System.out.println("=== Employee Payroll System (Abstraction & Encapsulation) ===");
        // load existing file if present
        loadFromCSV();

        // seed sample data if empty
        if (employees.isEmpty()) seedSampleData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": addEmployee(); break;
                case "2": listEmployees(); break;
                case "3": showPayroll(); break;
                case "4": removeEmployee(); break;
                case "5": saveToCSV(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Exiting. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Employee (Full-time / Part-time)");
        System.out.println("2. List Employees");
        System.out.println("3. Show Payroll (calculate salaries)");
        System.out.println("4. Remove Employee by ID");
        System.out.println("5. Save employees to CSV");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter employee type (FT for full-time, PT for part-time): ");
            String type = scanner.nextLine().trim().toUpperCase();
            System.out.print("Enter employee ID (integer): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter email: ");
            String email = scanner.nextLine().trim();

            if (type.equals("FT")) {
                System.out.print("Enter monthly salary: ");
                double sal = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Enter monthly bonus (0 if none): ");
                double bonus = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Enter deductions: ");
                double ded = Double.parseDouble(scanner.nextLine().trim());
                Employee e = new FullTimeEmployee(id, name, email, sal, bonus, ded);
                employees.add(e);
                System.out.println("Full-time employee added.");
            } else if (type.equals("PT")) {
                System.out.print("Enter hourly rate: ");
                double rate = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Enter hours worked (for pay period): ");
                double hrs = Double.parseDouble(scanner.nextLine().trim());
                Employee e = new PartTimeEmployee(id, name, email, rate, hrs);
                employees.add(e);
                System.out.println("Part-time employee added.");
            } else {
                System.out.println("Unknown type. Use FT or PT.");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number. Operation cancelled.");
        } catch (IllegalArgumentException iae) {
            System.out.println("Error: " + iae.getMessage());
        }
    }

    private static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to show.");
            return;
        }
        System.out.println("\nEmployees:");
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private static void showPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees to calculate.");
            return;
        }
        System.out.println("\nPayroll Summary:");
        double total = 0.0;
        for (Employee e : employees) {
            double salary = e.calculateSalary();
            total += salary;
            System.out.printf("%s => Salary: %.2f%n", e.toString(), salary);
        }
        System.out.printf("Total payroll for period: %.2f%n", total);
    }

    private static void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            boolean removed = employees.removeIf(emp -> emp.getEmpId() == id);
            if (removed) System.out.println("Employee removed.");
            else System.out.println("Employee ID not found.");
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid ID.");
        }
    }

    private static void saveToCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (Employee e : employees) {
                pw.println(e.toCSV());
            }
            System.out.println("Saved to " + CSV_FILE);
        } catch (IOException ioe) {
            System.out.println("Error saving file: " + ioe.getMessage());
        }
    }

    private static void loadFromCSV() {
        File f = new File(CSV_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // CSV formats:
                // FT,empId,name,email,salary,bonus,deductions
                // PT,empId,name,email,hourlyRate,hoursWorked
                String[] parts = line.split(",", 7);
                if (parts.length < 1) continue;
                String type = parts[0];
                if (type.equals("FT") && parts.length >= 7) {
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String email = parts[3];
                    double salary = Double.parseDouble(parts[4]);
                    double bonus = Double.parseDouble(parts[5]);
                    double ded = Double.parseDouble(parts[6]);
                    employees.add(new FullTimeEmployee(id, name, email, salary, bonus, ded));
                } else if (type.equals("PT") && parts.length >= 6) {
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String email = parts[3];
                    double rate = Double.parseDouble(parts[4]);
                    double hrs = Double.parseDouble(parts[5]);
                    employees.add(new PartTimeEmployee(id, name, email, rate, hrs));
                }
            }
            if (!employees.isEmpty()) {
                System.out.println("Loaded " + employees.size() + " employees from " + CSV_FILE);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load CSV: " + e.getMessage());
        }
    }

    private static void seedSampleData() {
        employees.add(new FullTimeEmployee(1001, "Asha Patel", "asha.patel@example.com", 40000, 2000, 6000));
        employees.add(new PartTimeEmployee(2001, "Ravi Kumar", "ravi.k@example.com", 200, 90)); // hourly 200, 90 hours
        employees.add(new FullTimeEmployee(1002, "Meera Singh", "meera.s@example.com", 32000, 1000, 4000));
        System.out.println("Sample data added. Use option 2 to view employees.");
    }
}
 


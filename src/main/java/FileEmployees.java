import java.io.*;
import java.util.Scanner;

public class FileEmployees {

    static String[] readEmployees(String fileName) throws FileNotFoundException {
        int lines = countLines(fileName);
        String[] employeesLines = new String[lines];
        Scanner scanner = new Scanner(new File(fileName));
        for (int i = 0; i < employeesLines.length; i++) {
            employeesLines[i] = scanner.nextLine();
        }
        return employeesLines;
    }

    static void saveEmployees(Employee[] employees, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        double avgSalary = EmployeeUnits.getAvgSalary(employees);
        double minSalary = EmployeeUnits.getMinSalary(employees);
        double maxSalary = EmployeeUnits.getMaxSalary(employees);
        int numberOfItDepartmentEmployees = EmployeeUnits.countEmployeeByItDepartments(employees);
        int numberOfSupportDepartmentEmployees = EmployeeUnits.countEmployeeBySupportDepartments(employees);
        int numberOfManagementDepartmentEmployees = EmployeeUnits.countEmployeeByManagementDepartments(employees);
        writer.write("Średnia wypłata: " + avgSalary + "\n");
        writer.write("Minimalna wypłata: " + minSalary + "\n");
        writer.write("Maksymalna wypłata: " + maxSalary + "\n");
        writer.write("Liczba pracowników IT: " + numberOfItDepartmentEmployees + "\n");
        writer.write("Liczba pracowników Support: " + numberOfSupportDepartmentEmployees + "\n");
        writer.write("Liczba pracowników Management: " + numberOfManagementDepartmentEmployees + "\n");
        writer.close();
        }

    private static int countLines(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = 0;

        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        scanner.close();
        return lines;
    }
}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final String inFileName = "employees.csv";
        final String outFileName = "stats.txt";

        String[] stringsEmployees = FileEmployees.readEmployees(inFileName);
        Employee[] employees = EmployeeUnits.parseEmployees(stringsEmployees);
        FileEmployees.saveEmployees(employees, outFileName);
    }
}

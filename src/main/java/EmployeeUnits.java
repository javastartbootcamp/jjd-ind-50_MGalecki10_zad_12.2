public class EmployeeUnits {
    static final String IT_DEPARTMENT = "IT";
    static final String SUPPORT_DEPARTMENT = "Support";
    static final String MANAGEMENT_DEPARTMENT = "Management";

    static Employee[] parseEmployees(String[] readEmployees) {
        Employee[] employees = new Employee[readEmployees.length];
        for (int i = 0; i < readEmployees.length; i++) {
            String[] split = readEmployees[i].split(";");
            String firstName = split[0];
            String lastName = split[1];
            String id = split[2];
            String department = split[3];
            double salary = Double.parseDouble(split[4]);
            employees[i] = new Employee(firstName, lastName, id, department, salary);
        }
        return employees;
    }

    static double getAvgSalary(Employee[] employees) {
        double sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary / employees.length;
    }

    static double getMinSalary(Employee[] employees) {
        double minValue = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minValue) {
                minValue = employee.getSalary();
            }
        }
        return minValue;
    }

    static double getMaxSalary(Employee[] employees) {
        double maxValue = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() >= maxValue) {
                maxValue = employee.getSalary();
            }
        }
        return maxValue;
    }

    static int countEmployeeByItDepartments(Employee[] employees) {
        int employeeItDepartmentCounter = 0;
        for (Employee employee : employees) {
            if (IT_DEPARTMENT.equals(employee.getDepartment())) {
                employeeItDepartmentCounter += 1;
            }
        }
        return employeeItDepartmentCounter;
    }

    static int countEmployeeBySupportDepartments(Employee[] employees) {
        int employeeSupportDepartmentCounter = 0;
        for (Employee employee : employees) {
            if (SUPPORT_DEPARTMENT.equals(employee.getDepartment())) {
                employeeSupportDepartmentCounter += 1;
            }
        }
        return employeeSupportDepartmentCounter;
    }

    static int countEmployeeByManagementDepartments(Employee[] employees) {
        int employeeManagementDepartmentCounter = 0;
        for (Employee employee : employees) {
            if (MANAGEMENT_DEPARTMENT.equals(employee.getDepartment())) {
                employeeManagementDepartmentCounter += 1;
            }
        }
        return employeeManagementDepartmentCounter;
    }
}

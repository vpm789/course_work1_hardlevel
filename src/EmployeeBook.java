import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String name, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Штат полный, прием новых работников не ведется");
        }
        Employee newEmployee = new Employee(name, department, salary);
        employees[size++] = newEmployee;
    }

    public int getCurrentSize() {
        return size;
    }

    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getId() + " " + employee.getName() + " отдел:" + employee.getDepartment() +
                    " " + employee.getSalary());
        }
    }

    public double sumSalary() {
        double sumSalary = 0;
        for (int i = 0; i < size; i++) {
            sumSalary = sumSalary + employees[i].getSalary();
        }
        System.out.println("Сумма зарплат в месяц: " + sumSalary + " рублей");
        return sumSalary;
    }

    public double getEmployeeMinSalary() {
        Employee employeeMinSalary = null;
        double minSalary = 0;
        for (int i = 0; i < size; i++) {
            if (minSalary == 0 || employees[i].getSalary() < minSalary) {
                employeeMinSalary = employees[i];
                minSalary = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeMinSalary.getName());
        return employeeMinSalary.getSalary();
    }

    public double getEmployeeMaxSalary() {
        Employee employeeMaxSalary = null;
        double maxSalary = 0;
        for (int i = 0; i < size; i++) {
            if (maxSalary == 0 || employees[i].getSalary() > maxSalary) {
                employeeMaxSalary = employees[i];
                maxSalary = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeMaxSalary.getName());
        return employeeMaxSalary.getSalary();
    }

    public void avgSalary() {
        double sumSalary = sumSalary();
        double avgSalary = sumSalary / size;
        System.out.printf("Среднее значение зарплат %.2f рублей", avgSalary);
    }

    public void indexSalary(int index) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(Math.round(employee.getSalary() * (1 + ((double) index / 100))));
            }
        }
    }

    public void getEmployeeMinSalaryDepart(int department) {
        String employeeName = "";
        double minSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalary == 0 || employee.getSalary() < minSalary) {
                    employeeName = employee.getName();
                    minSalary = employee.getSalary();
                }
            }
        }
        if (employeeName.equals("") == false) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " + employeeName);
        } else {
            System.out.println("Отдел " + department + " не найден");
        }
    }

    public void getEmployeeMaxSalaryDepart(int department) {
        String employeeName = "";
        double maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalary == 0 || employee.getSalary() > maxSalary) {
                    employeeName = employee.getName();
                    maxSalary = employee.getSalary();
                }
            }
        }
        if (employeeName.equals("") == false) {
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " + employeeName);
        }
    }

    public void avgSalaryDepart(int department) {
        double avgSalary = 0;
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            }
        }
        if (counter != 0) {
            avgSalary = (double) sumSalaryDepart(department) / counter;
            System.out.printf("Средняя зарплата по отделу " + department + ": %.2f", avgSalary);
        }
    }

    public double sumSalaryDepart(int department) {
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        if (sumSalary != 0) {
            System.out.println("Сумма затрат на зарплату по отделу " + department + ": " + sumSalary);
            return sumSalary;
        } else {
            return sumSalary;
        }
    }

    public void indexSalaryDepart(int department, int index) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(Math.round(employee.getSalary() * (1 + ((double) index / 100))));
            }
        }
    }

    public void getEmployeesDepart(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Сотрудники отдела " + department + ": "
                        + employee.getId() + " " + employee.getName() + " " + employee.getSalary());
            }
        }
    }

    public void getEmployeesLessSalary(int salaryLevel) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryLevel) {
                System.out.println("Сотрудник c зарплатой менее " + salaryLevel + " рублей: " + employee.getId()
                        + " " + employee.getName() + " " + employee.getSalary());
            }
        }
    }

    public void getEmployeesMoreSalary(int salaryLevel) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > salaryLevel) {
                System.out.println("Сотрудник c зарплатой более " + salaryLevel + " рублей: " + employee.getId()
                        + " " + employee.getName() + " " + employee.getSalary());
            }
        }
    }


}

import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    private double sumSalary;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String name, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Штат полный, прием новых сотрудников не ведется");
        }
        Employee newEmployee = new Employee(name, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                size++;
                return;
            }
        }
    }

    public void removeEmployee(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == employeeId) {
                System.out.println("Сотрудник " + employees[i].getId() + " " + employees[i].getName() + " удален(а)");
                employees[i] = null;
                size--;
                return;
            }
        }
    }

    public int getCurrentSize() {
        return size;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void sumSalary() {
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        System.out.println("Сумма зарплат в месяц: " + sumSalary + " рублей");
        this.sumSalary = sumSalary;
    }

    public double getEmployeeMinSalary() {
        Employee employeeMinSalary = null;
        double minSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary == 0 || employee.getSalary() < minSalary) {
                    employeeMinSalary = employee;
                    minSalary = employee.getSalary();
                }
            }
        }
        if (employeeMinSalary != null) {
            System.out.println("Сотрудник с минимальной зарплатой: " + employeeMinSalary.getName());
            return employeeMinSalary.getSalary();
        } else {
            System.out.println("Сотрудники не найдены");
            return 0;
        }
    }

    public double getEmployeeMaxSalary() {
        Employee employeeMaxSalary = null;
        double maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary == 0 || employee.getSalary() > maxSalary) {
                    employeeMaxSalary = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        if (employeeMaxSalary != null) {
            System.out.println("Сотрудник с максимальной зарплатой: " + employeeMaxSalary.getName());
            return employeeMaxSalary.getSalary();
        } else {
            System.out.println("Сотрудники не найдены");
            return 0;
        }
    }

    public void avgSalary() {
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
        if (!employeeName.equals("")) {
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
        if (!employeeName.equals("")) {
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
                System.out.println("Сотрудник c зарплатой менее " + salaryLevel + " рублей: " + employee);
            }
        }
    }

    public void getEmployeesMoreSalary(int salaryLevel) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > salaryLevel) {
                System.out.println("Сотрудник c зарплатой более " + salaryLevel + " рублей: " + employee);
            }
        }
    }

    public void changeSalary(String employeeName, double newSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(employeeName)) {
                employee.setSalary(newSalary);
                return;
            }
        }
        System.out.println("Сотрудник " + employeeName + " не найден.");
    }

    public void changeDepartment(String employeeName, int newDepartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(employeeName)) {
                employee.setDepartment(newDepartment);
                return;
            }
        }
        System.out.println("Сотрудник " + employeeName + " не найден.");
    }

}

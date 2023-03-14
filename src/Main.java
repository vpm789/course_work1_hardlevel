import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов Иван Петрович", 5, 154000);
        employeeBook.addEmployee("Жамнов Сергей Юрьевич", 5, 110000);
        employeeBook.addEmployee("Петрова Ольга Ивановна", 3, 120800);
        employeeBook.addEmployee("Трофимов Илья Владимирович", 3, 134000);
        employeeBook.addEmployee("Реева Марина Михайловна", 3, 70000);
        employeeBook.addEmployee("Сидорова Александра Сергеевна", 9, 170000);
        employeeBook.addEmployee("Маринина Татьяна Владимировна", 9, 95000);
        employeeBook.printAllEmployees();
        employeeBook.removeEmployee(0);
        employeeBook.addEmployee("Владимирова Галина Ивановна", 7, 75000);
        double minSalary = employeeBook.getEmployeeMinSalary();
        double maxSalary = employeeBook.getEmployeeMaxSalary();
        maxSalary -= minSalary;
        int randomSalary = (int) ((int) (Math.random() * ++maxSalary) + minSalary);
        employeeBook.sumSalary();
        employeeBook.avgSalary();

        System.out.println();
        System.out.println("======================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите процент индексации зарплаты:");
        int index = sc.nextInt();
        employeeBook.indexSalary(index);
        System.out.println("Введите номер отдела:");
        int department = sc.nextInt();
        employeeBook.getEmployeeMinSalaryDepart(department);
        employeeBook.getEmployeeMaxSalaryDepart(department);
        employeeBook.sumSalaryDepart(department);
        employeeBook.avgSalaryDepart(department);
        System.out.println();
        employeeBook.indexSalaryDepart(department, index);
        employeeBook.getEmployeesDepart(department);
        sc.close();
        employeeBook.changeSalary("Владимирова Галина Ивановна", 750000);
        employeeBook.changeDepartment("Владимирова Галина Ивановна", 14);
        employeeBook.getEmployeesLessSalary(randomSalary);
        employeeBook.getEmployeesMoreSalary(randomSalary);
        employeeBook.printEmployeeDepart();
    }
}

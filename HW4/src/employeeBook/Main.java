package employeeBook;

/*
Создать класс справочник сотрудников,
который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
    Табельный номер
    Номер телефона
    Имя
    Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "111", "Lavrentiy", 10);
        Employee employee2 = new Employee(2, "222", "Klementiy", 7);
        Employee employee3 = new Employee(3, "333", "Anufriy", 25);
        Employee employee4 = new Employee(1, "111", "Lavrentiy", 10);
        Employee employee5 = new Employee(1, "555", "Lavrentiy", 12);

        List<Employee> newBook = new ArrayList<>();
        EmployeeBook employeeBook = new EmployeeBook(newBook);
        employeeBook.addEmployee(employee1);
        for (Employee employee : employeeBook.getBook()) {
            System.out.println(employee.toString());
        }
        System.out.println("=================================================");

        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);
        for (Employee employee : employeeBook.getBook()) {
            System.out.println(employee.toString());
        }
        System.out.println("=================================================");
        employeeBook.addEmployee(employee4);
        for (Employee employee : employeeBook.getBook()) {
            System.out.println(employee.toString());
        }
        System.out.println("=================================================");
        employeeBook.addEmployee(employee5);
        for (Employee employee : employeeBook.getBook()) {
            System.out.println(employee.toString());
        }
        System.out.println("=================================================");
    }
}
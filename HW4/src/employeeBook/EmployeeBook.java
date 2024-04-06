package employeeBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeBook {
    List <Employee> book;

    public EmployeeBook(List<Employee> book) {
        this.book = book;
    }

    public void addEmployee (Employee employee) {
        Integer tabelNum = employee.getTabelNum();
        if (containsTabelNum(tabelNum)) {
            Employee employeeFromBook = findEmployeeByTabelNum(tabelNum);
            if (employee.getName().equals(employeeFromBook.getName())) {
                if (!employee.getExperience().equals(employeeFromBook.getExperience())) {
                    employeeFromBook.setExperience(employee.getExperience());
                }
                employeeFromBook.mergePhones(employeeFromBook.getPhone(), employee.getPhone());
            }
            else System.out.println("Сотрудник с таким табельным номером уже существует");
        }
        else book.add(employee);
    }

    public List <Employee> findEmployeeByExperience (Integer experience) {
        List <Employee> res = new ArrayList<>();
        for (Employee employee : book) {
            if (experience.equals(employee.getExperience())) {
                res.add(employee);
            }
        }
        return res;
    }

    public Employee findEmployeeByTabelNum (Integer tabelNum) {
        for (Employee employee : book) {
            if (tabelNum.equals(employee.getTabelNum())) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getBook() {
        return book;
    }

    public List<String> getPonesByName (String name) {
        for (Employee employee : book) {
            if (name.equals(employee.getName())) {
                return employee.getPhone();
            }
        }
        return Collections.emptyList();
    }

    private Boolean containsTabelNum (Integer tabelNum) {
        for (Employee employee : book) {
            if (tabelNum.equals(employee.getTabelNum())) {
                return true;
            }
        }
        return false;
    }

}

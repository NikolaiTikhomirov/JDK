package employeeBook;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer tabelNum;
    private List<String> phone;
    private String name;
    private Integer experience;

    public Employee(Integer tabelNum, List<String> phone, String name, Integer experience) {
        this.tabelNum = tabelNum;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public Employee(Integer tabelNum, String phone, String name, Integer experience) {
        this.tabelNum = tabelNum;
        this.phone = new ArrayList<>();
        addPhone(phone);
        this.name = name;
        this.experience = experience;
    }

    public Integer getTabelNum() {
        return tabelNum;
    }

    public List<String> getPhone() {
        return phone;
    }

    public String getPhonesToString() {
        StringBuilder phones = new StringBuilder();
        for (String s : phone) {
            phones.append(s + ", ");
        }
        phones.delete(phones.length() - 2, phones.length());
        return phones.toString();
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void addPhone (String phone) {
        this.phone.add(phone);
    }

    public Boolean findPhone (String phone) {
        for (String s : this.phone) {
            if (s.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public List <String> mergePhones (List <String> phones1, List <String> phones2) {
        List <String> res = phones1;
        for (String s : phones2) {
            if (!res.contains(s)) {
                res.add(s);
            }
        }
        return res;
    }

    public String toString () {
        return "[tabel: " + tabelNum + " name: " + name + " phones: " + getPhonesToString() + " experience: " + experience + "]";
    }
}

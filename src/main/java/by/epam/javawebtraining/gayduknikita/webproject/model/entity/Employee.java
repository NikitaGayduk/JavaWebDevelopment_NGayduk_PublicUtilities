package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Objects;

/**
 * @author NikitaGayduk
 * @date 25.04.2019
 */
public class Employee extends Entity {
    private String employeeSurname;
    private String employeeName;
    private String employeePatronymic;
    private Profession profession;

    public Employee() {
    }

    public Employee(int id, String employeeSurname, String employeeName, String employeePatronymic, Profession profession) {
        super(id);
        this.employeeSurname = employeeSurname;
        this.employeeName = employeeName;
        this.employeePatronymic = employeePatronymic;
        this.profession = profession;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePatronymic() {
        return employeePatronymic;
    }

    public void setEmployeePatronymic(String employeePatronymic) {
        this.employeePatronymic = employeePatronymic;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeSurname, employee.employeeSurname) &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeePatronymic, employee.employeePatronymic) &&
                profession == employee.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeSurname, employeeName, employeePatronymic, profession);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeSurname='" + employeeSurname + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePatronymic='" + employeePatronymic + '\'' +
                ", profession=" + profession +
                "} " + super.toString();
    }
}

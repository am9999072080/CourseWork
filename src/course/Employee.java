package course;

public class Employee {
    private String name;
    private String surname;
    private String middleName;

    private int department;
    private int salary;

    private int id;
    static int counter = 1;


    public Employee(String surname, String name, String middleName, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;

    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {

        return middleName;
    }

    public int getDepartment() {

        return department;
    }

    public int getSalary() {

        return salary;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public void setMiddleName(String middleName) {

        this.middleName = middleName;
    }

    public void setDepartment(int department) {

        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }


    @Override
    public String toString() {
        return id + "․ "
                + surname + " "
                + name + " "
                + middleName + ", Отдел №-"
                + department + ", "
                + salary + "$";
    }
}

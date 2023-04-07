import course.Employee;
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", 1, 2_000);
        Employee employee2 = new Employee("Сергеев", "Сергей", "Сергеевич", 2, 2_200);
        Employee employee3 = new Employee("Алексеев", "Алексей", "Алексеевич", 3, 2_500);
        Employee employee4 = new Employee("Александров", "Александр", "Александрович", 4, 1000);
        Employee employee5 = new Employee("Иванов", "Иван", "Иванович", 5, 2_400);

        Employee[] vaults = new Employee[5];
        vaults[0] = employee1;
        vaults[1] = employee2;
        vaults[2] = employee3;
        vaults[3] = employee4;
        vaults[4] = employee5;

        for (Employee vault : vaults) {
            System.out.println(vault);
        }
        System.out.println();
        System.out.println(sum(vaults) + "$" + " -Сумма затрат в месяц");

        System.out.println(aver(vaults) + "$" + " -Средняя зарплата в месяц");

        System.out.println(min(vaults) + " -Сотрудник с минимальной зарплатой");

        System.out.println(max(vaults) + " -Сотрудник с максимальной зарплатой");
        System.out.println();
        printFio(vaults);

        int percent = 10; //Значение на величину аргумента в %
        for (Employee vault : vaults) {
            vault.setSalary(vault.getSalary() * percent / 100 + vault.getSalary()); //Проиндексирование зарплаты
            System.out.println(vault);
        }
        System.out.println();
        int i = 0;
        for (Employee vault : vaults) {
            i++;
            if (aver(vaults) > vault.getSalary()) {
                System.out.println(vault + " -Сотрудник с зарплатой меньше числа ");
            } else {

                System.out.println(vault + " -Сотрудник с зарплатой больше (или равно) числа ");
            }
        }

    }

    public static int sum(Employee[] vaults) {
        int totalAmount = 0;
        for (Employee vault : vaults) {
            totalAmount += vault.getSalary();   //Сумма затрат в месяц
        }
        return totalAmount;
    }

    public static double aver(Employee[] vaults) {
        int i = 0;
        double sum = 0;
        double average;
        for (Employee vault : vaults) {
            i++;
            sum += vault.getSalary();
        }
        average = sum / i; // Среднее значение зарплат
        return average;
    }

    public static Employee max(Employee[] vaults) {
        Employee maximumSpend = vaults[0];
        for (Employee vault : vaults) {
            if (vault.getSalary() > maximumSpend.getSalary()) {
                maximumSpend = vault;   //Сотрудника с максимальной зарплатой
            }
        }
        return maximumSpend;
    }

    public static Employee min(Employee[] vaults) {
        Employee minimumSpend = max(vaults);
        for (Employee vault : vaults) {
            if (vault.getSalary() < minimumSpend.getSalary()) {
                minimumSpend = vault;   //сотрудник с минимальной зарплатой
            }
        }
        return minimumSpend;
    }

    public static void printFio(Employee[] vaults) {
        for (Employee vault : vaults) {
            System.out.println(vault.getName() + " " + vault.getMiddleName() + " " + vault.getSurname());
        }
        System.out.println();
    }
}


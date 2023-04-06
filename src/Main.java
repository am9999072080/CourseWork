import course.Employee;
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", 1, 2_000);
        Employee employee2 = new Employee("Сергеев", "Сергей", "Сергеевич", 2, 2_200);
        Employee employee3 = new Employee("Алексеев", "Алексей", "Алексеевич", 3, 2_500);
        Employee employee4 = new Employee("Александров", "Александр", "Александрович", 4, 2_300);
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
        System.out.println("Сумма затрат в месяц: " + sum(vaults) + "$");
        System.out.println();
        System.out.println("Средняя зарплата в месяц: " + aver(vaults) + "$");
        System.out.println();
        System.out.println("Сотрудника с минимальной зарплатой: " + min(vaults) + "$");
        System.out.println();
        System.out.println("Сотрудника с максимальной зарплатой: " + max(vaults) + "$");
        System.out.println();
        printFio(vaults);
    }

    public static int sum(Employee[] vaults) {
        int totalAmount = 0;
        for (Employee vault : vaults) {
            totalAmount += vault.getSalary();
        }
        return totalAmount;
    }

    public static double aver(Employee[] vaults) {
        double sum = 0;
        double average = 0;
        for (Employee vault : vaults) {//использовал цикл for each.
            sum += vault.getSalary();
        }
        average = sum / vaults.length;
        return average;
    }

    public static Employee max(Employee[] vaults) {
        Employee maximumSpend = vaults[0];
        for (Employee vault : vaults) {
            if (vault.getSalary() > maximumSpend.getSalary()) {
                maximumSpend = vault;
            }
        }
        return maximumSpend;
    }

    public static Employee min(Employee[] vaults) {
        Employee minimumSpend = max(vaults);
        for (Employee vault : vaults) {
            if (vault.getSalary() < minimumSpend.getSalary()) {
                minimumSpend = vault;
            }
        }
        return minimumSpend;
    }

    public static void printFio(Employee[] vaults) {
        for (Employee vault : vaults) {
            System.out.println(vault.getName() + " " + vault.getMiddleName() + " " + vault.getSurname());
        }
    }
}
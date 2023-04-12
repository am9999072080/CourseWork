import course.Employee;
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов", "Иван", "Иванович", 1, 2_000);
        Employee employee2 = new Employee("Сергеев", "Сергей", "Сергеевич", 2, 2_200);
        Employee employee3 = new Employee("Алексеев", "Алексей", "Алексеевич", 3, 2_500);
        Employee employee4 = new Employee("Александров", "Александр", "Александрович", 4, 1000);
        Employee employee5 = new Employee("Иванов", "Иван", "Иванович", 5, 2_400);

        Employee[] vaults = new Employee[10];
        vaults[0] = employee1;
        vaults[1] = employee2;
        vaults[2] = employee3;
        vaults[3] = employee4;
        vaults[4] = employee5;

        int percent = 10;
        int salary = 2500;

        list(vaults);
        System.out.println();
        printFio(vaults);
        wageIndexation(vaults, percent);//"после индексации заработной платы"

        list(vaults);

        minSalary(vaults, salary);
        maxSalary(vaults, salary);
    }

    private static void list(Employee[] vaults) {
        for (Employee vault : vaults) {
            if (vault != null) {
                System.out.println(vault);
            }
        }

        System.out.println();
        System.out.println(min(vaults) + " -Сотрудник с минимальной зарплатой");
        System.out.println(max(vaults) + " -Сотрудник с максимальной зарплатой");
        System.out.println(sum(vaults) + "$" + " -Сумма затрат в месяц");
        System.out.println(aver(vaults) + "$" + " -Средняя зарплата в месяц");
    }


    public static int sum(Employee[] vaults) {
        int totalAmount = 0;

        for (Employee vault : vaults) {
            if (vault != null) {
                totalAmount += vault.getSalary();   //Сумма затрат в месяц
            }
        }
        return totalAmount;
    }

    public static double aver(Employee[] vaults) {
        double sum = 0;
        double average;
        for (Employee vault : vaults) {
            if (vault != null) {
                sum += vault.getSalary();
            }
        }
        average = sum / Employee.count; // Среднее значение зарплат
        return average;
    }

    public static Employee max(Employee[] vaults) {
        Employee maximumSpend = vaults[0];
        for (Employee vault : vaults) {
            if (vault != null) {
                if (vault.getSalary() > maximumSpend.getSalary()) {
                    maximumSpend = vault;   //Сотрудника с максимальной зарплатой
                }
            }
        }
        return maximumSpend;
    }
    public static Employee min(Employee[] vaults) {
        Employee minimumSpend = max(vaults);
        for (Employee vault : vaults) {
            if (vault != null) {
                if (vault.getSalary() < minimumSpend.getSalary()) {
                    minimumSpend = vault;   //сотрудник с минимальной зарплатой
                }
            }
        }
        return minimumSpend;
    }

    public static void printFio(Employee[] vaults) {
        for (Employee vault : vaults) {
            if (vault != null) {
                System.out.println(vault.getId() + "." + vault.getName() + " " + vault.getMiddleName() + " " + vault.getSurname());
            }
        }
        System.out.println();
        System.out.println("Перерасчет заработной платы (в связи с проведенной индексацией на 10%-ов):");
    }


    public static void minSalary(Employee[] vaults, int salary) {

        System.out.println();
        System.out.println("Сотрудники с зарплатой меньше числа");
        for (Employee vault : vaults) {
            if (vault != null && vault.getSalary() < salary) {
                System.out.println(vault);

            }
        }
    }

    public static void maxSalary(Employee[] vaults, int salary) {
        System.out.println();
        System.out.println("Сотрудники с зарплатой больше числа");
        for (Employee vault : vaults) {
            if (vault != null && vault.getSalary() > salary) {
                System.out.println(vault);
            }
        }
    }

    public static void wageIndexation(Employee[] vaults, int percent) {
        for (Employee vault : vaults) {
            if (vault != null) {
                vault.setSalary(vault.getSalary() * percent / 100 + vault.getSalary()); //Проиндексирование зарплаты
            }
        }
    }
}
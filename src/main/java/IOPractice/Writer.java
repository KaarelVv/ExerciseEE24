package IOPractice;

/*
Create a program that reads data from a CSV file using Java I/O and streams.
Use lambda expressions and collections to perform operations on the data, such as sorting, filtering, and transforming.
For example, read a CSV file containing information about employees, use streams to filter out employees who are no longer active,
sort employees by their salary, and calculate the average age of the remaining employees using lambda expressions and collections.
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Writer {

    public static void main(String[] args) throws IOException {




        List<Employee> employees = new ArrayList<>();

        Employee newEmployee1 = new Employee("Mary", 27, 65000, true);
        Employee newEmployee2 = new Employee("David", 36, 80000, true);
        Employee newEmployee3 = new Employee("John", 39, 70000, true);
        Employee newEmployee4 = new Employee("Micheal", 55, 90000, false);
        Employee newEmployee5 = new Employee("Peter", 75, 62000, false);
        Employee newEmployee6 = new Employee("Jane", 25, 50000, true);
        employees.add(newEmployee1);
        employees.add(newEmployee2);
        employees.add(newEmployee3);
        employees.add(newEmployee4);
        employees.add(newEmployee5);
        employees.add(newEmployee6);

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Java IO location\\employees.csv"));

        for (Employee workers:employees){  //This enhanced for loop writes all added employees to the file
            writer.write("\n" + workers);
        }
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java IO location\\employees.csv"));
        String line;
        while ((line = reader.readLine()) != null) { //This while loop reads all added lines in the file
            System.out.println(line); // and outputs it to the console
        }reader.close();

        System.out.println("\nFiltering out active employees\n");
        List<Employee> activeEmployees = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
        for (Employee employee : activeEmployees) {
            System.out.println(employee); //Printing active workers to the console
        }

          System.out.println("\nPrinting the average age of employees");
        double averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);
        System.out.println(Math.round(averageAge*10)/10.0); //Rounding up to one decimal

        System.out.println("\nAnd the average salary is");
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println(Math.round(averageSalary));



    }

}

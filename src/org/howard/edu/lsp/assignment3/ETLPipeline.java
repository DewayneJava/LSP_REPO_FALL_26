package org.howard.edu.lsp.assignment3;
import java.io.*;
import java.util.*;
public class ETLPipeline {
    public static void main(String[] args) {
        File employees = new File("data/employees.csv");
        File transformed = new File("data/transformed_employees.csv");
        CSVProcessor csv = new CSVProcessor();
        EmployeeProcessor processor = new EmployeeProcessor();
        List<Employee> transformedEmployees = new ArrayList<>();
        int read = 0;
        int skipped = 0;
        try {
            List<String[]> rows = csv.readCSV(employees);

            boolean header = true;
            for(String fields[] : rows) {
                if (header) {
                    header = false;
                    continue;

                }
                read++;

                Employee employee = processor.createEmployee(fields);
                if (employee == null) {
                    skipped++;
                    continue;
                }
                if (!processor.isValid(employee)) {
                    skipped++;
                    continue;
                }
                processor.process(employee);
                transformedEmployees.add(employee);
            }
            csv.writeCSV(transformed, transformedEmployees);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Rows read:" + read);
        System.out.println("Rows transformed:" + transformedEmployees.size());
        System.out.println("Rows skipped:" + skipped);
        System.out.println("Output file: data/transformed_employees.csv");
    }
}
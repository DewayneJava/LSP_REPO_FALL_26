package org.howard.edu.lsp.assignment3;
import java.io.*;
import java.util.*;

public class CSVProcessor {
    public List<String[]> readCSV(File file) throws IOException {
        List<String[]> rows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            rows.add(line.split(","));

        }
        br.close();
        return rows;
    }
    public void writeCSV(File file,List<Employee> employees) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");

        bw.newLine();

        for (Employee employee : employees) {
            bw.write(employee.toCSV());
            bw.newLine();
        }
        bw.close();

    }
}
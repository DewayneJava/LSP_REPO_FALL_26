package org.howard.edu.lsp.assignment2;
import java.util.*;
import java.io.*;


public class ETLPipeline {
    public static void main(String[] args) {

       File employees = new File("../../../../../data/employees.csv");
       String line;
       String splitBy = ",";
       List<String[]> output = new ArrayList<>();
       int index = 0;
       int skipped = 0;
       double hours = 0;
       double rate = 0;
       try (BufferedReader br = new BufferedReader(new FileReader(employees))) {
           while ((line = br.readLine()) != null) {
               line = line.trim();
               String[] fields = line.split(splitBy);
               if (fields.length != 5) {
                   skipped++;
                   continue;
               }
               // checks for header
               if (index == 0) {
                   output.add(fields);
                   index++;
                   continue;
               }
               try {
                   fields[1] = fields[1].toUpperCase();
               }
               catch (ArrayIndexOutOfBoundsException e) {
                   skipped++;
               }
               try {
                   Integer.parseInt(fields[0]);
               }
               catch (NumberFormatException e) {
                   skipped++;
                   continue;
               }
               try {
                    hours = Double.parseDouble(fields[3]);
                    rate = Double.parseDouble(fields[4]);
                   if (hours < 0 || rate < 0) {
                       skipped++;
                       continue;
                   }
               }
               catch (NumberFormatException e) {
                   skipped++;
                   continue;
               }
               String[] calcs = Arrays.copyOf(fields,fields.length + 3);
               double gross_pay = 0.0;
              if (hours > 40) {
                  gross_pay += (hours-40) * 1.5 * rate;
                  gross_pay += 40 * rate;
              }
              else {
                  gross_pay += hours * rate;
              }
              if (fields[2].equals("IT")) {
                  gross_pay *= 1.05;
              }
              gross_pay = Math.round(gross_pay * Math.pow(10, 2)) / Math.pow(10, 2);
              calcs[5] = Double.toString(gross_pay);
              if (gross_pay < 500) {
                  calcs[6] = "Low";
              }
              else if (gross_pay < 1000) {
                  calcs[6] = "Standard";
              }
              else if (gross_pay < 2000) {
                  calcs[6] = "High";
              }
              else {
                  calcs[6] = "Executive";
              }
              if (hours < 30) {
                  calcs[7] = "Part-Time";
              }
              else {
                  calcs[7] = "Full-Time";
              }
              output.add(calcs);
              index++;
               }
           }
        catch (IOException e) {
           System.out.println(e.getMessage());
        }
        for (String[] entry: output) {
           System.out.println(Arrays.toString(entry));
        }
        System.out.println(Integer.toString(skipped));
    }
    // 101,ALICE JOHNSON,HR,40.00,25.00,1000.00,High,Full-Time
    //102,BOB SMITH,IT,45.00,30.00,1496.25,High,Full-Time
    //107,EVAN LEE,Sales,20.00,18.50,370.00,Low,Part-Time
    //108,FATIMA BROWN,IT,40.00,50.00,2100.00,Executive,Full-Time
    //109,GEORGE WHITE,Finance,50.00,40.00,2200.00,Executive,Full-Time
    //110,HELEN DAVIS,IT,30.00,80.00,2520.00,Executive,Full-Time
    //113,KEVIN YOUNG,Marketing,30.00,16.67,499.98,Low,Full-Time
}

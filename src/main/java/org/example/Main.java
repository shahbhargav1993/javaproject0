package org.example;

import org.example.Exception.PatientRecordException;
import org.example.Model.PatientRecord;
import org.example.Service.PatientRecordService;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientRecordService patientRecordService = new PatientRecordService();

        System.out.println("Welcome to ABC Hospital");
        System.out.println("How may I assist you today");


        while (true) {
            System.out.println("Add Patient Records");
            System.out.println("View Patient Records");
            System.out.println("Search Patient Records");
            System.out.println("Exit Patient Records");

            String input = sc.nextLine();
            log.info("Go to main method and recheck the program");
            try {
                if ("add".equalsIgnoreCase(input)) {
                    // Adding a patient record
                    System.out.println("Enter Patient ID:");
                    String patientId = sc.nextLine();
                    System.out.println("Enter Full Name:");
                    String fullName = sc.nextLine();
                    System.out.println("Enter Age:");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Diagnosis:");
                    String diagnosis = sc.nextLine();

                    // Adding the patient record
                    patientRecordService.addPatientRecord(patientId, fullName, age, diagnosis);
                    System.out.println("Patient record added successfully!");
                } else if ("view".equalsIgnoreCase(input)) {
                    // Viewing all patient records
                    List<PatientRecord> allPatientRecords = patientRecordService.getAllPatientRecord();
                    System.out.println("All Patient Records:");
                    for (PatientRecord patientRecord : allPatientRecords) {
                        System.out.println(patientRecord);
                    }
                } else if ("search".equalsIgnoreCase(input)) {
                    // Searching for a patient record
                    System.out.println("Enter Patient ID  or fullName to search:");
                    String searchPatientId = sc.nextLine();
                    boolean found = false;

                } else if ("exit".equalsIgnoreCase(input)) {
                        // Searching for a patient record
                        System.out.println("Thank you, Have a nice day!");

                } else {
                    System.out.println("Invalid command. Please enter 'add', 'view', 'search', 'exit'");

                }
            } catch (PatientRecordException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("FieldName: " + e.getFieldName());
            }
        }
    }
}
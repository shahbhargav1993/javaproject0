package org.example.Service;

import org.example.Exception.PatientRecordException;
import org.example.Main;
import org.example.Model.PatientRecord;

import java.util.ArrayList;
import java.util.List;


/** service class */
public class PatientRecordService {
    /**list to store patient record*/
    private List <PatientRecord> patientrecords;
    /**constructor initialize the patient record */
    public PatientRecordService() {
                patientrecords = new ArrayList<>();
            }


    /**
     * I will ask user for pateitnID, fullName, age, diagnosis..
     */
    public void addPatientRecord(String patientID, String fullName, int age, String diagnosis) throws PatientRecordException {
        Main.log.info("Attempting to add a patient record: " + patientID + "," + fullName + "," + age + "." + diagnosis);

        //validate the user/patientrecord information
        if (age < 1) {
            Main.log.warn("Throwing Patient record exception due to misformatted age:" + age);
            throw new PatientRecordException("Age must be 1 when adding patient age in the system","age");
        } else if (patientID.trim().isEmpty()) {
            Main.log.warn("throwing patient record exception due to misformatted patientID:" + patientID);
            throw new PatientRecordException("patientID is blank" , "patientID");

        } else if (fullName.trim().isEmpty()) {
            Main.log.warn("throwing patient record exception due to misformatted fullName:" + fullName);
            throw new PatientRecordException("fullName is blank" , "fullName");

        } else if (diagnosis.trim().isEmpty()) {
            Main.log.warn("throwing patient record exception due to misformatted diagnosis:" + diagnosis);
            throw new PatientRecordException("diagnosis is blank", "diagnosis");
        }

        //creating new patientrecord  and adding to the list.
        PatientRecord patientRecord = new PatientRecord(patientID, fullName, age, diagnosis);
        patientrecords.add(patientRecord);
    }


    /** get all patient record **/
    public List<PatientRecord> getAllPatientRecord(){
        Main.log.info("Now retrieving all patient records: "+patientrecords);
        return patientrecords;
    }

    /**
     * below method getpatientrecordbyID , taking string parameter patientID,
     * for loop iteration, it saves the values in temporary variable currentpatientrecord.
     * if condition match, patientid of the current patient record/database,is equal to the specified patientid, then this
     * method return the current patiend record , if it does not match it gives null. basically, we are checking patient id from the patient record
     * database.
     * **/
    public PatientRecord getPatientRecordbyID(String patientID){
        for(int i=0;i <patientrecords.size();i++){
            PatientRecord currentPatientRecord = patientrecords.get(i);
            if (currentPatientRecord.getPatientID().equals(patientID)) {
                return currentPatientRecord;
            }
        }
        return null;
    }
}

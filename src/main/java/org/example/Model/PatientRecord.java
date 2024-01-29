package org.example.Model;

public class PatientRecord {
    private String patientID;
    private String fullName;
    private int age;
    private String diagnosis;

     //create constructor for PatientRecord
    public PatientRecord(String patientID,String fullName,int age,String diagnosis) {
        this.patientID = patientID;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    //getters and setters

    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public String getfullName() {
        return fullName;
    }
    public void setfullName(String fullName){
        this.fullName = fullName;
    }

    public int getage() {
        return age;
    }
    public void setage(int age){
        this.age = age;
    }

    public String getdiagnosis() {
        return diagnosis;
    }
    public void setdiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }


    @Override
    public String toString() {
       return "PatientRecord {" +
            "patientID='" + patientID + '\'' +
            ",fullName='" + fullName + '\'' +
            ",age='" + age + '\'' +
            ",diagnosis='" + diagnosis + '\'' +
               '}';
    }
}

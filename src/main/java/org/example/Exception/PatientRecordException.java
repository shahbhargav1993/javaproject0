package org.example.Exception;
public class PatientRecordException extends Exception {
    /**
     * field name attributes identifying which field caused the exception.
     * */
    public String fieldName;

    public PatientRecordException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
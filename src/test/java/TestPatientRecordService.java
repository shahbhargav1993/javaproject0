import org.example.Exception.PatientRecordException;
import org.example.Model.PatientRecord;
import org.example.Service.PatientRecordService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
public class TestPatientRecordService {
    PatientRecordService patientRecordService;

    @Before
    public void setUp() {
        patientRecordService = new PatientRecordService();
    }

    @Test
    public void patientRecordServiceEmptyAtStart() {
        List<PatientRecord> patientRecords = patientRecordService.getAllPatientRecord();
        Assert.assertTrue(patientRecords.isEmpty());
    }

    @Test
    public void patientRecordServiceAddPatientRecord() {
        String patientId = "PID123";
        String fullName = "John Doe";
        int age = 30;
        String diagnosis = "Fever";

        try {
            patientRecordService.addPatientRecord(patientId, fullName, age, diagnosis);
        } catch (PatientRecordException e) {
            e.printStackTrace();
            Assert.fail("PatientRecordException incorrectly thrown");
        }

        List<PatientRecord> patientRecords = patientRecordService.getAllPatientRecord();

        Assert.assertEquals(1, patientRecords.size());
        PatientRecord addedPatientRecord = patientRecords.get(0);

        Assert.assertEquals(patientId, addedPatientRecord.getPatientID());
        Assert.assertEquals(fullName, addedPatientRecord.getfullName());
        Assert.assertEquals(age, addedPatientRecord.getage());
        Assert.assertEquals(diagnosis, addedPatientRecord.getdiagnosis());
    }

    @Test
    public void addPatientRecordInvalidAge() {
        String patientId = "PID123";
        String fullName = "John Doe";
        int age = -1;
        String diagnosis = "Fever";

        try {
            patientRecordService.addPatientRecord(patientId, fullName, age, diagnosis);
            Assert.fail();
        } catch (PatientRecordException e) {
            // Expected behavior
        }
    }

    @Test
    public void getPatientRecordById() {
        String patientId = "PID123";
        String fullName = "John Doe";
        int age = 30;
        String diagnosis = "Fever";

        try {
            patientRecordService.addPatientRecord(patientId, fullName, age, diagnosis);
        } catch (PatientRecordException e) {
            e.printStackTrace();
            Assert.fail("PatientRecordException incorrectly thrown");
        }

        PatientRecord retrievedPatientRecord = patientRecordService.getPatientRecordbyID(patientId);

        Assert.assertNotNull(retrievedPatientRecord);
        Assert.assertEquals(patientId, retrievedPatientRecord.getPatientID());
        Assert.assertEquals(fullName, retrievedPatientRecord.getfullName());
        Assert.assertEquals(age, retrievedPatientRecord.getage());
        Assert.assertEquals(diagnosis, retrievedPatientRecord.getdiagnosis());
    }

    @Test
    public void getPatientRecordByInvalidId() {
        String patientId = "NonExistentID";
        PatientRecord retrievedPatientRecord = patientRecordService.getPatientRecordbyID(patientId);

        Assert.assertNull(retrievedPatientRecord);
    }
}

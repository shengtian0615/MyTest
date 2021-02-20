package com.wehealth.model.domain.nalon;

public class AnalysisRestingEcgsRequestPatient {

    private boolean isAgeAvailable;
    private float patientAge;
    private int patientGender;
    private boolean isChestPain;
    private boolean isAfterPCI;
    private boolean isHealthCheck;

    public boolean isAgeAvailable() {
        return isAgeAvailable;
    }

    public void setAgeAvailable(boolean ageAvailable) {
        isAgeAvailable = ageAvailable;
    }

    public float getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(float patientAge) {
        this.patientAge = patientAge;
    }

    public int getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender = patientGender;
    }

    public boolean isChestPain() {
        return isChestPain;
    }

    public void setChestPain(boolean chestPain) {
        isChestPain = chestPain;
    }

    public boolean isAfterPCI() {
        return isAfterPCI;
    }

    public void setAfterPCI(boolean afterPCI) {
        isAfterPCI = afterPCI;
    }

    public boolean isHealthCheck() {
        return isHealthCheck;
    }

    public void setHealthCheck(boolean healthCheck) {
        isHealthCheck = healthCheck;
    }
}

package com.crime.crimecrud.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private CrimeType crimeType;
    private  EmergencyLevel emergencyLevel;
    private  String suspectDescription;
    private  CaseStatus caseStatus;
    private  String crimeLocation;
    private Date timeOfOccurence;

    public Crime() {
    }

    public Crime(long id, CrimeType crimeType, EmergencyLevel emergencyLevel, String suspectDescription, CaseStatus caseStatus, String crimeLocation, Date timeOfOccurence) {
        this.id = id;
        this.crimeType = crimeType;
        this.emergencyLevel = emergencyLevel;
        this.suspectDescription = suspectDescription;
        this.caseStatus = caseStatus;
        this.crimeLocation = crimeLocation;
        this.timeOfOccurence = timeOfOccurence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }

    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public String getSuspectDescription() {
        return suspectDescription;
    }

    public void setSuspectDescription(String suspectDescription) {
        this.suspectDescription = suspectDescription;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCrimeLocation() {
        return crimeLocation;
    }

    public void setCrimeLocation(String crimeLocation) {
        this.crimeLocation = crimeLocation;
    }

    public Date getTimeOfOccurence() {
        return timeOfOccurence;
    }

    public void setTimeOfOccurence(Date timeOfOccurence) {
        this.timeOfOccurence = timeOfOccurence;
    }
}

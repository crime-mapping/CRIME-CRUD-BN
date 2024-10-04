package com.crime.crimecrud.repositories;

import com.crime.crimecrud.models.CaseStatus;
import com.crime.crimecrud.models.Crime;
import com.crime.crimecrud.models.CrimeType;
import com.crime.crimecrud.models.EmergencyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
    List<Crime> findByEmergencyLevel(EmergencyLevel emergencyLevel);

    List<Crime> findByCaseStatus(CaseStatus caseStatus);

    List<Crime> findByCrimeType(CrimeType crimeType);

    List<Crime> findByTimeOfOccurenceBetween(Date startDate, Date endDate);

    List<Crime> findByCrimeLocationContaining(String location);
}
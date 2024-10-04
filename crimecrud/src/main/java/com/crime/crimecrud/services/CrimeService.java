package com.crime.crimecrud.services;

import com.crime.crimecrud.models.CaseStatus;
import com.crime.crimecrud.models.Crime;
import com.crime.crimecrud.models.CrimeType;
import com.crime.crimecrud.models.EmergencyLevel;
import com.crime.crimecrud.repositories.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public List<Crime> getAllCrimes() {
        return crimeRepository.findAll();
    }

    public Crime getCrimeById(long id) {
        return crimeRepository.findById(id).orElse(null);
    }

    public Crime createCrime(Crime crime) {
        return crimeRepository.save(crime);
    }

    public Crime updateCrime(long id, Crime crime) {
        if (crimeRepository.existsById(id)) {
            crime.setId(id);
            return crimeRepository.save(crime);
        }
        return null;
    }

    public void deleteCrime(long id) {
        crimeRepository.deleteById(id);
    }

    public List<Crime> getCrimesByType(CrimeType crimeType) {
        return crimeRepository.findByCrimeType(crimeType);
    }

    public List<Crime> getCrimesByEmergencyLevel(EmergencyLevel emergencyLevel) {
        return crimeRepository.findByEmergencyLevel(emergencyLevel);
    }

    public List<Crime> getCrimesByCaseStatus(CaseStatus caseStatus) {
        return crimeRepository.findByCaseStatus(caseStatus);
    }

    public List<Crime> getCrimesByLocation(String location) {
        return crimeRepository.findByCrimeLocationContaining(location);
    }
    public List<Crime> getCrimesByDateRange(Date startDate, Date endDate) {
        return crimeRepository.findByTimeOfOccurenceBetween(startDate, endDate);
    }
}
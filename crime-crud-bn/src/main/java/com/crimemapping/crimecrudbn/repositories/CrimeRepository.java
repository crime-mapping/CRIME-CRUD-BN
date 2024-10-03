package com.crimemapping.crimecrudbn.repositories;

import com.crimemapping.crimecrudbn.models.CaseStatus;
import com.crimemapping.crimecrudbn.models.Crime;
import com.crimemapping.crimecrudbn.models.CrimeType;
import com.crimemapping.crimecrudbn.models.EmergencyLevel;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
    List<Crime> findByEmergencyLevel(EmergencyLevel emergencyLevel);

    List<Crime> findByCaseStatus(CaseStatus caseStatus);

    List<Crime> findByCrimeType(CrimeType crimeType);

    List<Crime> findByTimeOfOccurenceBetween(DateTimeLiteralExpression.DateTime startDate, DateTimeLiteralExpression.DateTime endDate);

    List<Crime> findByCrimeLocationContaining(String location);
}

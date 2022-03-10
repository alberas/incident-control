package com.alberi.incidentcontrol.repository;

import com.alberi.incidentcontrol.model.Incident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {

}

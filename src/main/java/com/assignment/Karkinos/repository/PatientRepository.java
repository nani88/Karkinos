package com.assignment.Karkinos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Karkinos.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	public List<Patient> findByName(String name);

}

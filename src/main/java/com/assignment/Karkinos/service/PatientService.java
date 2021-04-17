package com.assignment.Karkinos.service;

import java.util.List;

import com.assignment.Karkinos.entity.Patient;

public interface PatientService {
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(Integer id);
	
	public List<Patient> getPatientByName(String name);
	
	public Patient addPatient(Patient patient);
	
	public Patient editPatient(Patient patient);
	
	public void deletePatient(Integer id);

}

package com.assignment.Karkinos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Karkinos.entity.Patient;
import com.assignment.Karkinos.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientrepo;

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patients=patientrepo.findAll();
		if(patients.isEmpty()) {
			patients=null;
		}
		return patients;
	}

	@Override
	public Patient getPatientById(Integer id) {
		return patientrepo.findById(id).orElse(null);
	}

	@Override
	public List<Patient> getPatientByName(String name) {
		List<Patient> patientsbyName=patientrepo.findByName(name);
		if(patientsbyName.isEmpty()) {
			patientsbyName=null;
		}
		return patientsbyName;
	}

	@Override
	public Patient addPatient(Patient patient) {
		return patientrepo.save(patient);
	}

	@Override
	public Patient editPatient(Patient patient) {
		Patient updatePatient=new Patient();
		updatePatient.setId(patient.getId());
		updatePatient.setName(patient.getName());
		updatePatient.setGender(patient.getGender());
		updatePatient.setMobile(patient.getMobile());
		
		return patientrepo.save(updatePatient);
	}

	@Override
	public void deletePatient(Integer id) {
		patientrepo.deleteById(id);
	}

}

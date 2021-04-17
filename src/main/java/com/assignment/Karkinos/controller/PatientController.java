package com.assignment.Karkinos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.Karkinos.entity.Patient;
import com.assignment.Karkinos.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	PatientService patientservice;
	
	@GetMapping("/index")
	public String getPatientsList(Model model) {
		model.addAttribute("patients", patientservice.getAllPatients());
		return "index";
	}
	
	@GetMapping("/viewPatient/{id}")
	public String getPatientID(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("patients", patientservice.getPatientById(id));
		return "view-patient";
	}
	
	@GetMapping("/addPatientForm")
	public String showAddPatientForm(Patient patient) {
		return "add-patient";
	}
	
	@GetMapping("/findPatient")
	public String findPatient(@RequestParam(value="name",required=false) String name,Model model) {
		model.addAttribute("patients", patientservice.getPatientByName(name));
		return "find-patient";
	}
	
	@GetMapping("/editPatientForm/{id}")
	public String showEditPatientForm(@PathVariable("id") Integer id, Model model) {
		Patient editpatient=patientservice.getPatientById(id);
		if(null!=editpatient) {
			model.addAttribute("patient", editpatient);
			return "update-patient";
		}
		else {
			return "Invalid patient";
		}
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid Patient patient,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-patient";
		}
		patientservice.addPatient(patient);
		return "redirect:/index";
	}
	
	@PostMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") Integer id,@Valid Patient patient,BindingResult result, Model model) {
		if (result.hasErrors()) {
            patient.setId(id);
            return "update-patient";
        }
		patientservice.editPatient(patient);
		return "redirect:/index";
	}
	
	@GetMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable("id") Integer id, Model model) {
		patientservice.deletePatient(id);
		return "redirect:/index";
	}
}

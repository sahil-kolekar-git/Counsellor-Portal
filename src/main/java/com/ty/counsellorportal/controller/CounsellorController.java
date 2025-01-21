package com.ty.counsellorportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.counsellorportal.dto.CounsellorDTO;
import com.ty.counsellorportal.dto.CounsellorLoginDTO;
import com.ty.counsellorportal.dto.CounsellorResponseDTO;
import com.ty.counsellorportal.entity.Counsellor;
import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.service.CounsellorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/counsellor")
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	@PostMapping("/register")
	public ResponseEntity<String> registerCounsellor(@RequestBody CounsellorDTO counsellorDTO) {

		boolean register = counsellorService.registerCounsellor(counsellorDTO);

		if (register) {
			return new ResponseEntity<String>("Registred Successfully", HttpStatus.CREATED);
		} else {

			return ResponseEntity.badRequest().body("Something went wrong");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginCounsellor(@RequestBody CounsellorLoginDTO counsellorLoginDTO) {

		boolean login = counsellorService.loginCounsellor(counsellorLoginDTO);

		if (login)
			return new ResponseEntity<String>("Logged In Successfully", HttpStatus.OK);
		else
			return ResponseEntity.badRequest().body("Invalid Credentials");

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CounsellorResponseDTO> putMethodName(@PathVariable Integer id,
			@RequestBody CounsellorDTO counsellorDTO) {

		CounsellorResponseDTO updateCounsellor = counsellorService.updateCounsellor(id, counsellorDTO);

		return new ResponseEntity<CounsellorResponseDTO>(updateCounsellor, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCounsellor(@PathVariable Integer id) {
		return new ResponseEntity<String>(counsellorService.deleteCounsellor(id), HttpStatus.OK);
	}

	@GetMapping("/enquiry/{id}")
	public ResponseEntity<List<Enquiry>> getEnquiries(@PathVariable Integer id) {

		List<Enquiry> enquiries = counsellorService.getEnquiries(id);

		return ResponseEntity.ok(enquiries);
	}

}

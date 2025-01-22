package com.ty.counsellorportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.counsellorportal.dto.EnquiryDTO;
import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.enums.ClassMode;
import com.ty.counsellorportal.enums.Course;
import com.ty.counsellorportal.enums.Status;
import com.ty.counsellorportal.service.EnquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService service;

	@PostMapping("/add")
	public ResponseEntity<String> addEnquiry(@RequestParam Integer id, @RequestBody EnquiryDTO enquiryDTO) {

		boolean added = service.addEnquiry(id, enquiryDTO);
		if (added)
			return new ResponseEntity<String>("Enquiry Added", HttpStatus.CREATED);
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("phone/{id}/{phone}")
	public ResponseEntity<EnquiryDTO> updatePhone(@PathVariable Integer id, @PathVariable Long phone) {

		EnquiryDTO dto = service.updatePhone(id, phone);

		return ResponseEntity.ok(dto);
	}

	@PutMapping("classmode/{id}/{classMode}")
	public ResponseEntity<EnquiryDTO> updateClassMode(@PathVariable Integer id, @PathVariable ClassMode classMode) {

		EnquiryDTO dto = service.updateClassMode(id, classMode);

		return ResponseEntity.ok(dto);
	}

	@PutMapping("course/{id}/{course}")
	public ResponseEntity<EnquiryDTO> updateCourse(@PathVariable Integer id, @PathVariable Course course) {

		EnquiryDTO dto = service.updateCourse(id, course);

		return ResponseEntity.ok(dto);
	}

	@PutMapping("status/{id}/{status}")
	public ResponseEntity<EnquiryDTO> updateStatus(@PathVariable Integer id, @PathVariable Status status) {

		return ResponseEntity.ok(service.updateStatus(id, status));

	}

}

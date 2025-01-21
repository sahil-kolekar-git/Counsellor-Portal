package com.ty.counsellorportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.service.EnquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService service;

	@PostMapping("/add")
	public String addEnquiry(@RequestBody Enquiry enquiry) {

		return "";
	}

}

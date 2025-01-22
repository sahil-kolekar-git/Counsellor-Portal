package com.ty.counsellorportal.service;

import com.ty.counsellorportal.dto.EnquiryDTO;
import com.ty.counsellorportal.enums.ClassMode;
import com.ty.counsellorportal.enums.Course;
import com.ty.counsellorportal.enums.Status;

public interface EnquiryService {

	boolean addEnquiry(Integer id, EnquiryDTO dtoEnquiryDTO);

	EnquiryDTO updatePhone(Integer id, Long phone);

	EnquiryDTO updateClassMode(Integer id, ClassMode classMode);

	EnquiryDTO updateCourse(Integer id, Course course);

	EnquiryDTO updateStatus(Integer id, Status status);
}

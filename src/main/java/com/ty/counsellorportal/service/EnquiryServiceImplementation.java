package com.ty.counsellorportal.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.counsellorportal.dto.EnquiryDTO;
import com.ty.counsellorportal.entity.Counsellor;
import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.exception.CounsellorNotFoundException;
import com.ty.counsellorportal.repository.CounsellorRepository;
import com.ty.counsellorportal.repository.EnquiryRepository;

@Service
public class EnquiryServiceImplementation implements EnquiryService {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public boolean addEnquiry(Integer id, EnquiryDTO dtoEnquiryDTO) {

		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor Not Found"));

		Enquiry enquiry = new Enquiry();

		enquiry.setCounsellor(counsellor);

		BeanUtils.copyProperties(dtoEnquiryDTO, enquiry);

		return enquiryRepository.save(enquiry) != null;

	}
}

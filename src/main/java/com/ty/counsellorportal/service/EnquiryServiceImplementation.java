package com.ty.counsellorportal.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.counsellorportal.dto.EnquiryDTO;
import com.ty.counsellorportal.entity.Counsellor;
import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.enums.ClassMode;
import com.ty.counsellorportal.enums.Course;
import com.ty.counsellorportal.enums.Status;
import com.ty.counsellorportal.exception.CounsellorNotFoundException;
import com.ty.counsellorportal.exception.DuplicateEnquiryException;
import com.ty.counsellorportal.exception.EnquiryNotFoundException;
import com.ty.counsellorportal.repository.CounsellorRepository;
import com.ty.counsellorportal.repository.EnquiryRepository;

@Service
public class EnquiryServiceImplementation implements EnquiryService {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public boolean addEnquiry(Integer id, EnquiryDTO enquiryDTO) {

		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor Not Found"));

		Optional<Enquiry> opt = enquiryRepository.findByPhone(enquiryDTO.getPhone());

		if (opt.isPresent()) {
			throw new DuplicateEnquiryException("Phone number already registred");
		}

		Enquiry enquiry = new Enquiry();

		enquiry.setCounsellor(counsellor);

		BeanUtils.copyProperties(enquiryDTO, enquiry);

		return enquiryRepository.save(enquiry) != null;

	}

	@Override
	public EnquiryDTO updatePhone(Integer id, Long phone) {

		Optional<Enquiry> opt = enquiryRepository.findByPhone(phone);
		if (opt.isPresent()) {
			throw new DuplicateEnquiryException("Enquiry already added");

		} else {
			Enquiry enquiry = enquiryRepository.findById(id)
					.orElseThrow(() -> new EnquiryNotFoundException("Enquiry not added"));

			enquiry.setPhone(phone);

			Enquiry update = enquiryRepository.save(enquiry);

			EnquiryDTO enquiryDTO = new EnquiryDTO();
			BeanUtils.copyProperties(update, enquiryDTO);

			return enquiryDTO;
		}
	}

	@Override
	public EnquiryDTO updateClassMode(Integer id, ClassMode classMode) {

		Enquiry enquiry = enquiryRepository.findById(id)
				.orElseThrow(() -> new EnquiryNotFoundException("Enquiry not added"));

		enquiry.setClassMode(classMode);

		enquiryRepository.save(enquiry);

		EnquiryDTO dto = new EnquiryDTO();
		BeanUtils.copyProperties(enquiry, dto);
		return dto;
	}

	@Override
	public EnquiryDTO updateCourse(Integer id, Course course) {

		Enquiry enquiry = enquiryRepository.findById(id)
				.orElseThrow(() -> new EnquiryNotFoundException("Enquiry not added"));

		enquiry.setCourse(course);

		enquiryRepository.save(enquiry);

		EnquiryDTO enquiryDTO = new EnquiryDTO();

		BeanUtils.copyProperties(enquiry, enquiryDTO);

		return enquiryDTO;
	}

	@Override
	public EnquiryDTO updateStatus(Integer id, Status status) {

		Enquiry enquiry = enquiryRepository.findById(id)
				.orElseThrow(() -> new EnquiryNotFoundException("Enquiry not added"));

		enquiry.setStatus(status);

		enquiryRepository.save(enquiry);

		EnquiryDTO enquiryDTO = new EnquiryDTO();

		BeanUtils.copyProperties(enquiry, enquiryDTO);
		return enquiryDTO;
	}
}

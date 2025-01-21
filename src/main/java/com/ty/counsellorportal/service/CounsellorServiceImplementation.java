package com.ty.counsellorportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.counsellorportal.dto.CounsellorDTO;
import com.ty.counsellorportal.dto.CounsellorLoginDTO;
import com.ty.counsellorportal.dto.CounsellorResponseDTO;
import com.ty.counsellorportal.entity.Counsellor;
import com.ty.counsellorportal.entity.Enquiry;
import com.ty.counsellorportal.exception.CounsellorNotFoundException;
import com.ty.counsellorportal.exception.DuplicateEmailException;
import com.ty.counsellorportal.repository.CounsellorRepository;

@Service
public class CounsellorServiceImplementation implements CounsellorService {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public boolean registerCounsellor(CounsellorDTO counsellorDTO) {

		Optional<Counsellor> opt = counsellorRepository.findByEmail(counsellorDTO.getEmail());

		if (opt.isPresent()) {
			throw new DuplicateEmailException("Counsellor Already Registred");
		} else {
			Counsellor counsellor = new Counsellor();
			BeanUtils.copyProperties(counsellorDTO, counsellor); // to copy the properties from one object to another
			return counsellorRepository.save(counsellor) != null;
		}
	}

	@Override
	public boolean loginCounsellor(CounsellorLoginDTO counsellorLoginDTO) {

		Counsellor counsellor = counsellorRepository.findByEmail(counsellorLoginDTO.getEmail())
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor Not Registred"));

		if (counsellorLoginDTO.getPassword().equals(counsellor.getPassword()))
			return true;
		else
			return false;

	}

	@Override
	public CounsellorResponseDTO updateCounsellor(Integer id, CounsellorDTO counsellorDTO) {

		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor Not Registred"));

		Optional<Counsellor> opt = counsellorRepository.findByEmail(counsellorDTO.getEmail());
		if (opt.isPresent()) {
			throw new DuplicateEmailException("Counsellor Already Registred");
		}

		if (counsellorDTO.getName() != null)
			counsellor.setName(counsellorDTO.getName());
		if (counsellorDTO.getEmail() != null)
			counsellor.setEmail(counsellorDTO.getEmail());
		if (counsellorDTO.getPhone() != null)
			counsellor.setPhone(counsellorDTO.getPhone());
		if (counsellorDTO.getPassword() != null)
			counsellor.setPassword(counsellorDTO.getPassword());

		Counsellor updated = counsellorRepository.save(counsellor);
		CounsellorResponseDTO counsellorResponseDTO = new CounsellorResponseDTO();

		BeanUtils.copyProperties(updated, counsellorResponseDTO);

		return counsellorResponseDTO;
	}

	@Override
	public String deleteCounsellor(Integer id) {

		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Cousellor Not Registred"));

		counsellorRepository.delete(counsellor);
		return "Deleted";
	}

	@Override
	public List<Enquiry> getEnquiries(Integer id) {

		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor Not Registred"));

		return counsellor.getEnquiries();
	}

}

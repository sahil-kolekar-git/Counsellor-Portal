package com.ty.counsellorportal.service;

import java.util.List;

import com.ty.counsellorportal.dto.CounsellorDTO;
import com.ty.counsellorportal.dto.CounsellorLoginDTO;
import com.ty.counsellorportal.dto.CounsellorResponseDTO;
import com.ty.counsellorportal.entity.Enquiry;

public interface CounsellorService {

	boolean registerCounsellor(CounsellorDTO counsellorDTO);

	boolean loginCounsellor(CounsellorLoginDTO counsellorLoginDTO);

	CounsellorResponseDTO updateCounsellor(Integer id, CounsellorDTO counsellorDTO);

	String deleteCounsellor(Integer id);

	List<Enquiry> getEnquiries(Integer id);
}

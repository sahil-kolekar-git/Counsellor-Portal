package com.ty.counsellorportal.dto;

import com.ty.counsellorportal.enums.ClassMode;
import com.ty.counsellorportal.enums.Course;
import com.ty.counsellorportal.enums.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnquiryDTO {

	private String name;

	private Long phone;

	@Enumerated(EnumType.STRING)
	private ClassMode classMode = ClassMode.OFFLINE;

	@Enumerated(EnumType.STRING)
	private Course course;

	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;
}

package com.ty.counsellorportal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ty.counsellorportal.enums.ClassMode;
import com.ty.counsellorportal.enums.Course;
import com.ty.counsellorportal.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "enquiry_info")
@Data
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Long phone;

	@Enumerated(EnumType.STRING)
	private ClassMode classMode = ClassMode.OFFLINE;

	@Enumerated(EnumType.STRING)
	private Course course;

	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;

	@ManyToOne
	@JoinColumn
	private Counsellor counsellor;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime dateTime;

	@UpdateTimestamp
	private LocalDateTime updatedDataTime;
}

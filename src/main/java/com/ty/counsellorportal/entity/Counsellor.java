package com.ty.counsellorportal.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "counsellor_info")
@Data
public class Counsellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	private Long phone;

	@OneToMany(mappedBy = "counsellor")
	private List<Enquiry> enquiries;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime dateTime;

	@UpdateTimestamp
	private LocalDateTime updatedDataTime;
}

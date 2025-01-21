package com.ty.counsellorportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.counsellorportal.entity.Counsellor;

public interface CounsellorRepository extends JpaRepository<Counsellor, Integer> {

	Optional<Counsellor> findByEmail(String email);

}

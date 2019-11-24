package com.in.opalina.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.in.opalina.dao.UserRepository;
import com.in.opalina.model.User;

public class FilterRecords {

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Autowired UserRepository userRepository; public <T> Page<T>
	 * searchUserWithPaging(Map<String, String> all) {
	 * 
	 * Sort sort = Sort.by( Sort.Order.asc("designation"), Sort.Order.desc("age"));
	 * 
	 * Pageable pageable = null; pageable = PageRequest.of(0, 25,
	 * Sort.by("id").ascending()); return
	 * userRepository.findAll(getSpecification(all), pageable);
	 * 
	 * }
	 */

}

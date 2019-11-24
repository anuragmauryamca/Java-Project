package com.in.opalina.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.in.opalina.model.User;

public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>,JpaRepository<User,Long> {

	/*
	 * public List<User> findByFirstName(String first_name);
	 * 
	 * public List<User> findByEmail(String email);
	 */

	public Page<User> findAll(Pageable pageable);
	public List<User> findAll();

}
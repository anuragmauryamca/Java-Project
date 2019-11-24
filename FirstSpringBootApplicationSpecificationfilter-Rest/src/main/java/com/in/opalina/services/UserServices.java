package com.in.opalina.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.ws.Response;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in.opalina.dao.EmployeeRepository;
import com.in.opalina.dao.UserRepository;
import com.in.opalina.model.Employee;
import com.in.opalina.model.User;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmployeeRepository employee;

	public void createUser(User user) {

		userRepository.save(user);

	}
	public void createEmp(Employee emp) {

		employee.save(emp);

	}


	public List<User> findByUserName(String first_name) {
		return null;

		/*
		 * List<User> user = userRepository.findByFirstName(first_name); return user;
		 */

	}

	public List<User> findByUserEmail(String email) {
		return null;
		/*
		 * List<User> user = userRepository.findByEmail(email); return user;
		 */

	}

	@SuppressWarnings("unchecked")
	public Page<User> findAllUser() {

		Pageable pageable = null;
		pageable = PageRequest.of(2, 1, Sort.by("firstName").ascending());

		return (Page<User>) userRepository.findAll(pageable);

	}

	public List<User> findByCriteria(String object) {
		return null;
	}

	public List<User> searchUsers(Map<String, String> all) {

		if (all.isEmpty()) {
			return userRepository.findAll();
		} else {

			return userRepository.findAll(new Specification<User>() {

				@Override
				public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

					List<Predicate> predicates = new ArrayList<Predicate>();
					int a = 0;
					Predicate[] v = new Predicate[all.size()];
					for (Map.Entry<String, String> entry : all.entrySet()) {
						if (all != null) {
							v[a++] = criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue());
						}
					}

					predicates.add(criteriaBuilder.and(v));

					return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

				}
			});

		}
	}
/**
 * 
 * @param all
 * @return
 * Calling get Specification Class it will return the filter object  given Key and Value
 */
	public Page<User> searchCriteria(Map<String, String> all) {
		/*
		 * Sort sort = Sort.by( Sort.Order.asc("designation"), Sort.Order.desc("age"));
		 */
		Pageable pageable = null;
		pageable = PageRequest.of(0, 25, Sort.by("id").ascending());
		FilterUtil<User> filter = new FilterUtil<User>();
		Specification<User> spec = filter.getSpecification(all);
		return userRepository.findAll(spec, pageable);

	}

}

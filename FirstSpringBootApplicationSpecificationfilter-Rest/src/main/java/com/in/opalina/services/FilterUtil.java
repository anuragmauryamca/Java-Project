package com.in.opalina.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.in.opalina.model.User;
/**
 * 
 * @author 
 *
 * @param <T>
 * The FilterUtil Class is define a Filter of any object with one parameter and Multiple Parameter
 * also Paging 
 * 
 */
public class FilterUtil<T> {
	
	public  Specification<T> getSpecification(Map<String, String> all)
	{
		return new Specification<T>(){

			@SuppressWarnings("unused")
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
		};
		
	}

}
